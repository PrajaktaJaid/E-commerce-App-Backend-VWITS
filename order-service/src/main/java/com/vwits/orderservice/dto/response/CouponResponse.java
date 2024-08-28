package com.vwits.orderservice.dto.response;

public class CouponResponse {

	private String couponCode;
	private int discount;
	public CouponResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CouponResponse(String couponCode, int discount) {
		super();
		this.couponCode = couponCode;
		this.discount = discount;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
