package com.vwits.coupon.service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouponConfiguration {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
