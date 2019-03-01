package beans;

public class PaymentOption {
	private int payment_option_id;
	private String payment_option_name;
	private int payment_option_price;

	public int getPayment_option_id() {
		return payment_option_id;
	}
	public void setPayment_option_id(int payment_option_id) {
		this.payment_option_id = payment_option_id;
	}
	public String getPayment_option_name() {
		return payment_option_name;
	}
	public void setPayment_option_name(String payment_option_name) {
		this.payment_option_name = payment_option_name;
	}
	public int getPayment_option_price() {
		return payment_option_price;
	}
	public void setPayment_option_price(int payment_option_price) {
		this.payment_option_price = payment_option_price;
	}

}
