package com.vwits.coupon.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.coupon.service.dto.request.CouponRequest;
import com.vwits.coupon.service.dto.response.CouponResponse;
import com.vwits.coupon.service.service.CouponService;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@PostMapping("/create")
	public ResponseEntity<CouponResponse> createCoupon(@RequestBody CouponRequest couponRequest) {
		try {
			
			CouponResponse coupon = couponService.createCoupon(couponRequest);
			return new ResponseEntity<>(coupon,HttpStatus.CREATED);
		} catch (DataIntegrityViolationException ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<CouponResponse>> viewAllCoupons() {
		List<CouponResponse> coupResponses = couponService.getAllCoupons();
		return new ResponseEntity<>(coupResponses, HttpStatus.OK);
	}
	@GetMapping("/{couponCode}")
	public ResponseEntity<CouponResponse> getCouponResponce(@PathVariable String couponCode){
		CouponResponse byCouponCode = couponService.findByCouponCode(couponCode);
		return new ResponseEntity<>(byCouponCode,HttpStatus.OK);
	}

	@Autowired
	private CouponService couponService;
}
