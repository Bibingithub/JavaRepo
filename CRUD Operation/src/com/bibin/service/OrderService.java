package com.bibin.service;

import java.util.List;

import com.bibin.dto.Order;



public interface OrderService {
	
	public void saveOrder(Order order);
	public Order selectOrderById(int orderId);
	public List<Order> selectAllOrders();
	public void deleteOrderById(int orderId);
	public Order updateOrder(Order order);
	public List<Order> selectOrderByPriceCondition();
	public Order testLoad(int orderId);
	public Order testGet(int orderId);

}
