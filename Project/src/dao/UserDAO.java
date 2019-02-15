package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.LoginInfo;

public class UserDAO {
	//ログイン処理
	public LoginInfo findByLoginInfo(String user_id_name, String password) {
		Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "SELECT * FROM user WHERE id_name = ? and user_password = ? ";

	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, user_id_name);
	            pStmt.setString(2, password);
	            ResultSet rs = pStmt.executeQuery();

	             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
	            if (!rs.next()) {
	                return null;
	            }

	            String userIdName = rs.getString("id_name");
	            int classificationId = rs.getInt("classification_id");
	            return new LoginInfo(userIdName, classificationId);

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
		public String findByLoginId(String user_id_name) {
	        Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "SELECT * FROM user WHERE id_name = ?";

	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, user_id_name);
	            ResultSet rs = pStmt.executeQuery();

	             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
	            if (!rs.next()) {
	                return null;
	            }

	            String userIdName = rs.getString("id_name");
	            return userIdName;

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
		public void setUserdata(String userIdName, String mail, String password, String userName, int zipCode,
				String address, int phone) {
			Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "insert into user ("
	            		+ "id_name"
	            		+ ",user_mail"
	            		+ ",user_password"
	            		+ ",user_name"
	            		+ ",user_post_code"
	            		+ ",user_address"
	            		+ ",user_phone_number"
	            		+ ",classification_id"
	            		+ ")"
	            		+ "values (?,?,?,?,?,?,?,1);";

	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, userIdName);
	            pstmt.setString(2,mail);
	            pstmt.setString(3, password);
	            pstmt.setString(4, userName);
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
	            String sql = "delete from user where id_name = ?;";

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
