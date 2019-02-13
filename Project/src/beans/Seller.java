package beans;

public class Seller {
	private int seller_id;
	private String seller_id_name;
	private String seller_mail;
	private String seller_password;
	private String seller_name;
	private int seller_post_code;
	private String seller_address;
	private int seller_phone_number;
	private int classification_id;


	public Seller(String seller_id_name, int classification_id) {
		this.seller_id_name = seller_id_name;
		this.classification_id = classification_id;
	}

	public int getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(int classification_id) {
		this.classification_id = classification_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public String getSeller_id_name() {
		return seller_id_name;
	}
	public void setSeller_id_name(String seller_id_name) {
		this.seller_id_name = seller_id_name;
	}
	public String getSeller_mail() {
		return seller_mail;
	}
	public void setSeller_mail(String seller_mail) {
		this.seller_mail = seller_mail;
	}
	public String getSeller_password() {
		return seller_password;
	}
	public void setSeller_password(String seller_password) {
		this.seller_password = seller_password;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public int getSeller_post_code() {
		return seller_post_code;
	}
	public void setSeller_post_code(int seller_post_code) {
		this.seller_post_code = seller_post_code;
	}
	public String getSeller_address() {
		return seller_address;
	}
	public void setSeller_address(String seller_address) {
		this.seller_address = seller_address;
	}
	public int getSeller_phone_number() {
		return seller_phone_number;
	}
	public void setSeller_phone_number(int seller_phone_number) {
		this.seller_phone_number = seller_phone_number;
	}

}
