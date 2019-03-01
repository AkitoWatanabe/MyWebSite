package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.PaymentOption;

public class PaymentOptionDAO {
	//番号から配送情報を取得
		public PaymentOption findByPaymentOption(int payment_option_id){
			Connection con = null;
			PreparedStatement st = null;
			try {
				con = DBManager.getConnection();

				st = con.prepareStatement("SELECT * FROM payment_option WHERE payment_option_id = ?;");
				st.setInt(1, payment_option_id);

				ResultSet rs = st.executeQuery();

				PaymentOption payment_option = new PaymentOption();
				if (rs.next()) {
					payment_option.setPayment_option_name(rs.getString("payment_option_name"));
					payment_option.setPayment_option_price(rs.getInt("payment_option_price"));
					payment_option.setPayment_option_id(rs.getInt("payment_option_id"));
				}

				return payment_option;
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
