package com.vwits.coupon.service.dto.request;

public class CouponRequest {
	private String couponCode;
	private int discount;

	public CouponRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CouponRequest(String couponCode, int discount) {
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
