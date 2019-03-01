package beans;

import java.sql.Date;

public class Order_history {
	private int order_id;
	private int item_id;
	private int delivery_mothod_id;
	private int total_price;
	private Date buy_date;
	private String buy_user;
	private int payment_option_id;


	public int getPayment_option_id() {
		return payment_option_id;
	}
	public void setPayment_option_id(int payment_option_id) {
		this.payment_option_id = payment_option_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getDelivery_mothod_id() {
		return delivery_mothod_id;
	}
	public void setDelivery_mothod_id(int delivery_mothod_id) {
		this.delivery_mothod_id = delivery_mothod_id;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
	public String getBuy_user() {
		return buy_user;
	}
	public void setBuy_user(String buy_user) {
		this.buy_user = buy_user;
	}

}
