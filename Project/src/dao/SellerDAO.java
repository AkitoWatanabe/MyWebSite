package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.LoginInfo;

public class SellerDAO {
	//ログイン処理
	public LoginInfo findByLoginInfo(String seller_id_name, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM seller WHERE id_name = ? and seller_password = ? ";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, seller_id_name);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String sellerIdName = rs.getString("id_name");
            int classificationId = rs.getInt("classification_id");
            int sellerId = rs.getInt("id");

            return new LoginInfo(sellerIdName, classificationId,sellerId);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
	//ID重複確認
	public String findByLoginId(String seller_id_name) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM seller WHERE id_name = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, seller_id_name);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String sellerIdName = rs.getString("id_name");
            return sellerIdName;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
	//新規登録
	public void setSellerdata(String sellerIdName, String mail, String password, String sellerName, int zipCode,
			String address, int phone) {
		Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "insert into seller ("
            		+ "id_name"
            		+ ",seller_mail"
            		+ ",seller_password"
            		+ ",seller_name"
            		+ ",seller_post_code"
            		+ ",seller_address"
            		+ ",seller_phone_number"
            		+ ",classification_id"
            		+ ")"
            		+ "values (?,?,?,?,?,?,?,3);";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sellerIdName);
            pstmt.setString(2,mail);
            pstmt.setString(3, password);
            pstmt.setString(4, sellerName);
            pstmt.setInt(5,zipCode);
            pstmt.setString(6, address);
            pstmt.setInt(7, phone);
            pstmt.executeUpdate();

        } catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

	}
	//ユーザ削除
		public LoginInfo deleteUser(String id_name) {
			Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "delete from seller where id_name = ?;";

	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id_name);
	            pstmt.executeUpdate();

	        } catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} finally {
	            // データベース切断
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
			return null;
		}

}
