package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.Delivery_method;

public class DeliveryMethodDAO {
	//番号から配送情報を取得
	public Delivery_method findByMethod(int delivery_method_id){
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM delivery_method WHERE delivery_method_id = ?;");
			st.setInt(1, delivery_method_id);

			ResultSet rs = st.executeQuery();

			Delivery_method delivery_method = new Delivery_method();
			if (rs.next()) {
				delivery_method.setDelivery_method_name(rs.getString("delivery_method_name"));
				delivery_method.setDelivery_method_price(rs.getInt("delivery_method_price"));
			}

			return delivery_method;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				throw new SQLException(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}
}
