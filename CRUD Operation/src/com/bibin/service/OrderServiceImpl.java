package com.bibin.service;

import java.util.List;

import com.bibin.dto.Order;
import com.bibin.repo.OrderRepoImpl;



public class OrderServiceImpl implements OrderService {
      
        OrderRepoImpl repo=new OrderRepoImpl();
	

	@Override
	public void saveOrder(Order order) {
		repo.saveOrderRepo(order);
		
	}

	@Override
	public Order selectOrderById(int orderId) {
		Order order = repo.selectOrderByIdRepo(orderId);
		return order;
	}

	@Override
	public List<Order> selectAllOrders() {
	List<Order> orderList =	repo.selectAllOrdersRepo();
		return orderList;
	}

	@Override
	public void deleteOrderById(int orderId) {
	     repo.deleteOrderByIdRepo(orderId);
		
	}

	@Override
	public Order updateOrder(Order order) {
		Order order1 = repo.updateOrderRepo(order);
		return order1;
	}

	@Override
	public List<Order> selectOrderByPriceCondition() {
	    List<Order> orderList =   repo.selectOrdersByPriceRepo();
		return orderList;
	}

	

	public Order testGet(int orderId) {
		
		return repo.testLoadRepo(orderId);
	}

	public Order testLoad(int orderId) {
		return repo.testGetRepo(orderId);
	}

	
	}


