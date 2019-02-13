package beans;

public class User {

	private int user_id;
	private String user_id_name;
	private String user_mail;
	private String user_password;
	private String user_name;
	private int user_post_code;
	private String user_address;
	private int user_phone_number;
	private int user_card;
	private int classification_id;

	public User(String user_id_name, int classification_id) {
		this.user_id_name = user_id_name;
		this.classification_id = classification_id;
	}

	public int getClassification_id() {
		return classification_id;
	}
	public void setClassification_id(int classification_id) {
		this.classification_id = classification_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_id_name() {
		return user_id_name;
	}
	public void setUser_id_name(String user_id_name) {
		this.user_id_name = user_id_name;
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


}
