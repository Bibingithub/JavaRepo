package com.bibin.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.bibin.dto.Order;
import com.bibin.util.SessionUtil;



public class OrderRepoImpl implements OrderRepo{

	@Override
	public void saveOrderRepo(Order order) {
	
		Session session = SessionUtil.getSession();
		Transaction txt = session.beginTransaction();
		session.save(order);
		txt.commit();
		
	}

	@Override
	public Order selectOrderByIdRepo(int orderId) {
		Session session = SessionUtil.getSession();
		Transaction txt = session.beginTransaction();
		
		Order order = session.get(Order.class,orderId);
		txt.commit();
		return order;
	}

	@Override
	public List<Order> selectAllOrdersRepo() {
		Session session = SessionUtil.getSession();
		Query<Order> query = session.createQuery("from Order");
		List<Order> orderList = query.list();
		return orderList;
	}

	@Override
	public void deleteOrderByIdRepo(int orderId) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Order order = new Order();
		order.setOrderId(orderId);
		session.delete(order);
		tx.commit();
		
	}

	@Override
	public Order updateOrderRepo(Order order) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(order);
		Order updateOrderRecordFromDB = session.get(Order.class, order.getOrderId());
		return updateOrderRecordFromDB;
	}

	@Override
	public List<Order> selectOrdersByPriceRepo() {
		
		Session session = SessionUtil.getSession();
		Criteria criteria = session.createCriteria(Order.class);
		Criterion condition = Restrictions.gt("orderPrice", 5000.0);
	List<Order> orderList = criteria.list();
		return orderList;
	}

	@Override
	public Order testLoadRepo(int orderId) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Order loadOrder=session.load(Order.class, new Integer(orderId));
		tx.commit();
		return loadOrder;
	}

	@Override
	public Order testGetRepo(int orderId) {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Order GetOrder=session.get(Order.class, new Integer(orderId));
		tx.commit();
		return GetOrder;
	}
	@SuppressWarnings("deprecation")
	public void priceHQLQuery() {
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query<Order> q = session.createQuery("from Order order by orderPrice desc");
		System.out.println();
	List<Order> result = q.getResultList();
	System.out.println(result.get(0));
		tx.commit();
		SessionUtil.closeSession(session);
		
		
	}
	public static void main(String[] args) {
		OrderRepoImpl obj=new OrderRepoImpl();
		obj.priceHQLQuery();
	}

	

}
