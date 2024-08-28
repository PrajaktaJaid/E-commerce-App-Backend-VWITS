package com.vwits.coupon.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_coupon")
public class Coupon {
	@Id
	@GeneratedValue
	private int id;
	@Column(unique = true)
	private String couponCode;
	@Column
	private int discount;

	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupon(String couponCode, int discount) {
		super();
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
