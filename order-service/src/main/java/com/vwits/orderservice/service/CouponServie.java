package com.vwits.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vwits.orderservice.dto.response.CouponResponse;

@FeignClient(name = "api-gateway")
public interface CouponServie {
	@GetMapping("coupon-service/coupon/{couponCode}")
	public CouponResponse getCouponDetailsById(@PathVariable String couponCode); 

}
