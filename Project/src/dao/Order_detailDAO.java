package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;
import beans.CartBeans;

public class Order_detailDAO {
	//注文詳細登録
	public void setOderDetail(CartBeans cart,int order_id, int payment_option_id) {
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"insert into order_detail("
					+"order_id"
					+",item_id"
					+",item_number"
					+",payment_option_id"
					+")values(?,?,?,?);");
			st.setInt(1, order_id);
			st.setInt(2, cart.getItem().getItem_id());
			st.setInt(3, cart.getNumber());
			st.setInt(4, cart.getNumber());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

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
	}
}
