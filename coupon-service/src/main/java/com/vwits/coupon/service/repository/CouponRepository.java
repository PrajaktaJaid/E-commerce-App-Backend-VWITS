package com.vwits.coupon.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.vwits.coupon.service.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	Coupon findByCouponCode(String couponCode);
}
