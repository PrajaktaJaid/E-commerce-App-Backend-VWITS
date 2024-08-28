package com.vwits.coupon.service.dto.response;

public class CouponResponse {
	private int id;
	private String couponCode;
	private int discount;

	public CouponResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CouponResponse(int id, String couponCode, int discount) {
		super();
		this.id = id;
		this.couponCode = couponCode;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
