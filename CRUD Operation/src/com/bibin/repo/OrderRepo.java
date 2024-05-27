package com.bibin.repo;

import java.util.List;

import com.bibin.dto.Order;



public interface OrderRepo {
	public void saveOrderRepo(Order order);
	public Order selectOrderByIdRepo(int orderId);
	public List<Order> selectAllOrdersRepo();
	public void deleteOrderByIdRepo(int orderId);
	public Order updateOrderRepo(Order order);
	public List<Order> selectOrdersByPriceRepo();
	public Order testLoadRepo(int orderId);
	public Order testGetRepo(int orderId);
}