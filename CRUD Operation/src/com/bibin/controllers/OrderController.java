package com.bibin.controllers;

import java.util.List;
import java.util.Scanner;

import com.bibin.dto.Order;
import com.bibin.service.OrderServiceImpl;



public class OrderController {
	static Scanner sc = new Scanner(System.in);
	static OrderServiceImpl service = new OrderServiceImpl();
	public static void main(String[] args) {

	

		System.out.println("Enter your choice of operation");
		System.out.println("1.Create an order");
		System.out.println("2.select an order by id");
		System.out.println("3.delete an order by id");
		System.out.println("4.select all orders");
		System.out.println("5.update an order by id");
		System.out.println("6.select orders price greater then 5000");
		System.out.println("7.testLoad Metod");
		System.out.println("8.testGet Method");

		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			createAnOrder();
			break;
		case 2:
			selectAnOrder();
			break;
		case 3:
			deleteAnOrder();
			break;
		case 4:
			selectAllOrders();
			break;
		case 5:
			updateAnOrder();
			break;
		case 6:
			selectOrdersPriceGreateThan5000();
			break;
		case 7:
			toTestLoad();
			break;
		case 8:
			toTestGet();
			break;

		}
	}

	private static void toTestGet() {
		 System.out.println("Enter order id");
		  int orderId=sc.nextInt();
		  Order order=service.testGet(orderId);
		  System.out.println("Get method object"+order);
		
		
	}

	private static void toTestLoad() {
		 System.out.println("Enter order id");
		  int orderId=sc.nextInt();
		  Order order=service.testLoad(orderId);
		  System.out.println("Load method object"+order);
		
		
	}

	private static void selectOrdersPriceGreateThan5000() {
	  List<Order> orderList =   service.selectOrderByPriceCondition();
	  for(Order ord : orderList)
		  System.out.println(ord);
		
	}

	private static void updateAnOrder() {
		System.out.println("Find all the records in Order Table");
		 selectAllOrders();
		System.out.println("Select one record from the above list to update");
		int orderIdForUpdate = sc.nextInt();
		Order order = service.selectOrderById(orderIdForUpdate);
		System.out.println("find order details here update order");
		System.out.println(order);
		System.out.println("Enter update type for order");
		String updateOrderType = sc.next();
		System.out.println("Enter updated value for price");
		double updatedPrice = sc.nextDouble();
		order.setOrderType(updateOrderType);
		order.setOrderPrice(updatedPrice);
		Order orderUpdated = service.updateOrder(order);
		System.out.println("Find updated order from db");
		System.out.println(orderUpdated);
	}

	private static void selectAllOrders() {
		  List<Order> ordersList =   service.selectAllOrders();
          for(Order order : ordersList) {
        	  System.out.println(order);
          }
         }

	private static void deleteAnOrder() {
		System.out.println("Enter the order id to delete");
		int orderId = sc.nextInt();
		service.deleteOrderById(orderId);

	}

	private static void selectAnOrder() {
		System.out.println("Enter the orderId you want to retrive");
        int orderId = sc.nextInt();
        Order order = service.selectOrderById(orderId);
        System.out.println(order);
	}

	private static void createAnOrder() {
		System.out.println("Enter order details ");
		Order order = new Order();
		System.out.println("Enter ordertype");
		String orderType = sc.next();
		order.setOrderType(orderType);
		System.out.println("Enter orderprice");
		double orderPrice = sc.nextDouble();
		order.setOrderPrice(orderPrice);

		service.saveOrder(order);

	}


}
