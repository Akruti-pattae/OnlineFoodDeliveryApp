package com.food.dao;

import java.util.List;

import com.food.model.OrderItem;



public interface OrderItemDAO {
	void addOrderItem(OrderItem orderItem);

	 OrderItem getOrderItem(int  orderItemId);

	void updateOrderItem(OrderItem  OrderItem);

	void deleteOrderItem(int  orderItemId);

	List <OrderItem> getAllOrderItemsByRestaurant(int orderId);
}
