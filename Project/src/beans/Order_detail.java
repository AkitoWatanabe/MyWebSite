package beans;

public class Order_detail {
	private int order_detail_id;
	private int order_id;
	private int item_id;
	private int item_number;
	private int delivery_method_id;


	public int getOrder_detail_id() {
		return order_detail_id;
	}
	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
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
	public int getItem_number() {
		return item_number;
	}
	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}
	public int getDelivery_method_id() {
		return delivery_method_id;
	}
	public void setDelivery_method_id(int delivery_method_id) {
		this.delivery_method_id = delivery_method_id;
	}

}
