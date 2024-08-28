package com.vwits.orderservice.dto.request;

public class OrderRequest {

	private String item;
	private int price;
	private String status;
	private String couponCode;

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderRequest(String item, int price, String status,String couponCode) {
		super();
		this.item = item;
		this.price = price;
		this.status = status;
	}

	
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
