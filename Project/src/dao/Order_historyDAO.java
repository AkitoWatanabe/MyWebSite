package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import base.DBManager;

public class Order_historyDAO {
//注文履歴登録
	public int setOrderHistory(int delivery_method_id,int total,String id_name,int classification_id, int payment_option_id) {
		Connection conn = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            st = conn.prepareStatement(
            		"insert into order_history("
            		+"delivery_method_id"
            		+",total_price"
           			+",buy_date"
           			+",buy_user"
           			+",classification_id"
           			+",payment_option_id"
           			+ ")values(?,?,now(),?,?,?);"
           			//第二引数に記述することでキーを返す
    				,Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, delivery_method_id);
            st.setInt(2,total);
            st.setString(3, id_name);
            st.setInt(4, classification_id);
            st.setInt(5,payment_option_id);
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
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
		return autoIncKey;
	}
}
