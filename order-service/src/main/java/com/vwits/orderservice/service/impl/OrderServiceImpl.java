package com.vwits.orderservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vwits.orderservice.dto.request.OrderRequest;
import com.vwits.orderservice.dto.response.CouponResponse;
import com.vwits.orderservice.dto.response.OrderResponse;
import com.vwits.orderservice.entity.Order;
import com.vwits.orderservice.repository.OrderRepository;
import com.vwits.orderservice.service.CouponServie;
import com.vwits.orderservice.service.OrderService;
import com.vwits.orderservice.service.exception.OrderNotFound;
@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public List<OrderResponse> fetchOrderDetailsAlongWithCouponDetails() {
		List<OrderResponse> orderResponses = new ArrayList<>();
		List<OrderResponse> collect = orderRepository.findAll().stream().map(this::convertOrderToResponse).collect(Collectors.toList());
		for(OrderResponse result:collect) {
			CouponResponse couponDetailsById = couponServie.getCouponDetailsById(result.getCouponCode());
			result.setDiscount(couponDetailsById.getDiscount());
			orderResponses.add(result);
		}
		return orderResponses;
	}

	@Override
	public OrderResponse updateStatus(int orderId,String updateStatus) throws OrderNotFound {
		Optional<Order> optional = orderRepository.findById(orderId);
		if(optional.isPresent()) {
			Order order = optional.get();
			order.setStatus(updateStatus);
			Order save = orderRepository.save(order);
			return modelMapper.map(save, OrderResponse.class);
		}
		throw new OrderNotFound("Order not found with id " +orderId);
	}

	@Override
	public OrderResponse placedOrder(OrderRequest orderRequest) {
		Order map = modelMapper.map(orderRequest,Order.class);
		Order save = orderRepository.save(map);
		OrderResponse map2 = modelMapper.map(save, OrderResponse.class);
		return map2;
		// TODO Auto-generated method stub
		
	}
	public OrderResponse convertOrderToResponse(Order order) {
		return modelMapper.map(order, OrderResponse.class);
	}
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CouponServie couponServie;

}
