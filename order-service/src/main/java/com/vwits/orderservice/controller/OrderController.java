package com.vwits.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vwits.orderservice.dto.request.OrderRequest;
import com.vwits.orderservice.dto.request.UpdateStatuRequest;
import com.vwits.orderservice.dto.response.OrderResponse;
import com.vwits.orderservice.service.OrderService;
import com.vwits.orderservice.service.exception.OrderNotFound;

@RestController
@RequestMapping("/order")
public class OrderController {
	@PostMapping("/place")
	public ResponseEntity<OrderResponse> placeNewOrder(@RequestBody OrderRequest orderRequest) {
		System.out.println("Helloooo");
		OrderResponse placedOrder = orderService.placedOrder(orderRequest);
		return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);

	}
	@GetMapping("/viewAll")
	public ResponseEntity<List<OrderResponse>> viewAllOrders() {
		List<OrderResponse> orderResponses = orderService.fetchOrderDetailsAlongWithCouponDetails();
		return new ResponseEntity<>(orderResponses, HttpStatus.OK);
	}
	@PutMapping("/{orderId}/updateStatus")
	public ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable int orderId,@RequestParam String status) throws OrderNotFound{
		System.out.println(status);
		OrderResponse updateStatus = orderService.updateStatus(orderId, status);	
		return new ResponseEntity<>(updateStatus, HttpStatus.OK);
	}

	@Autowired
	private OrderService orderService;
}
