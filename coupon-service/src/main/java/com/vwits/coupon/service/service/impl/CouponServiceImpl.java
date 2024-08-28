package com.vwits.coupon.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vwits.coupon.service.dto.request.CouponRequest;
import com.vwits.coupon.service.dto.response.CouponResponse;
import com.vwits.coupon.service.entity.Coupon;
import com.vwits.coupon.service.repository.CouponRepository;
import com.vwits.coupon.service.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

	@Override
	public CouponResponse createCoupon(CouponRequest couponRequest) {
		Coupon map = modelMapper.map(couponRequest, Coupon.class);
		Coupon save = couponRepository.save(map);
		CouponResponse response = modelMapper.map(save,CouponResponse.class);
		return response;

	}

	@Override
	public List<CouponResponse> getAllCoupons() {
		List<CouponResponse> collect = couponRepository.findAll().stream().map(this::convertCouponToResponse).collect(Collectors.toList());
		return collect;
	}
	@Override
	public CouponResponse findByCouponCode(String couponCode) {
		Coupon byCouponCode = couponRepository.findByCouponCode(couponCode);
		CouponResponse couponResponse = modelMapper.map(byCouponCode, CouponResponse.class);
		return couponResponse;
	}
	public CouponResponse convertCouponToResponse(Coupon coupon){
		return modelMapper.map(coupon, CouponResponse.class);
	}
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	
}
