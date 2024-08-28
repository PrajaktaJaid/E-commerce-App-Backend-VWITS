package com.vwits.orderservice.service;

import java.util.List;

import com.vwits.orderservice.dto.request.OrderRequest;
import com.vwits.orderservice.dto.response.OrderResponse;
import com.vwits.orderservice.service.exception.OrderNotFound;

public interface OrderService {
	List<OrderResponse> fetchOrderDetailsAlongWithCouponDetails();
	OrderResponse updateStatus(int orderId,String updateStatus) throws OrderNotFound;
	OrderResponse placedOrder(OrderRequest orderRequest);
}
