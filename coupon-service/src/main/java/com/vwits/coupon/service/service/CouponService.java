package com.vwits.coupon.service.service;

import java.util.List;

import com.vwits.coupon.service.dto.request.CouponRequest;
import com.vwits.coupon.service.dto.response.CouponResponse;

public interface CouponService {
	CouponResponse createCoupon(CouponRequest couponRequest);

	List<CouponResponse> getAllCoupons();
	
	CouponResponse findByCouponCode(String couponCode);
}
