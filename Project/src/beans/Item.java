package beans;

import java.sql.Date;

public class Item {
	private int item_id;
	private String item_name;
	private int item_price;
	private int sale_price;
	private Date sale_start;
	private Date sale_end;
	private int surface_stock;
	private int real_stock;
	private String seller_id;
	private String item_detail;
	private String file_name;


	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getSale_price() {
		return sale_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	public Date getSale_start() {
		return sale_start;
	}
	public void setSale_start(Date sale_start) {
		this.sale_start = sale_start;
	}
	public Date getSale_end() {
		return sale_end;
	}
	public void setSale_end(Date sale_end) {
		this.sale_end = sale_end;
	}
	public int getSurface_stock() {
		return surface_stock;
	}
	public void setSurface_stock(int surface_stock) {
		this.surface_stock = surface_stock;
	}
	public int getReal_stock() {
		return real_stock;
	}
	public void setReal_stock(int real_stock) {
		this.real_stock = real_stock;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getItem_detail() {
		return item_detail;
	}
	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

}
