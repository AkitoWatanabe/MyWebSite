package beans;

public class LoginInfo {
	//Userテーブル
	private int user_id;
	private String user_mail;
	private String user_password;
	private String user_name;
	private int user_post_code;
	private String user_address;
	private int user_phone_number;
	private int user_card;

	//Sellerテーブル
	private int seller_id;
	private String seller_mail;
	private String seller_password;
	private String seller_name;
	private int seller_post_code;
	private String seller_address;
	private int seller_phone_number;
	//共通
	private String id_name;
	private int classification_id;


	public LoginInfo(String id_name, int classification_id) {
		this.setId_name(id_name);
		this.classification_id = classification_id;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_post_code() {
		return user_post_code;
	}
	public void setUser_post_code(int user_post_code) {
		this.user_post_code = user_post_code;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public int getUser_phone_number() {
		return user_phone_number;
	}
	public void setUser_phone_number(int user_phone_number) {
		this.user_phone_number = user_phone_number;
	}
	public int getUser_card() {
		return user_card;
	}
	public void setUser_card(int user_card) {
		this.user_card = user_card;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
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
	public String getId_name() {
		return id_name;
	}

	public void setId_name(String id_name) {
		this.id_name = id_name;
	}

	public int getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(int classification_id) {
		this.classification_id = classification_id;
	}



}
