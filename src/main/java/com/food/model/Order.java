package com.food.model;

import java.time.LocalDate;
import java.util.Date;

public class Order {

	
	
		private int orderId;
		private int userId;
		private int RestaurantId;
		private int totalPrice;
		private LocalDate orderDate;
		private String paymentMode;
		private String status;
		public Order() {
			super();
		}
		public Order(int orderId, int userId, int restaurantId, int totalPrice, LocalDate orderDate, String paymentMode,
				String status) {
			super();
			this.orderId = orderId;
			this.userId = userId;
			RestaurantId = restaurantId;
			this.totalPrice = totalPrice;
			this.orderDate = orderDate;
			this.paymentMode = paymentMode;
			this.status = status;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getRestaurantId() {
			return RestaurantId;
		}
		public void setRestaurantId(int restaurantId) {
			RestaurantId = restaurantId;
		}
		public int getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}
		public LocalDate getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}
		public String getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", userId=" + userId + ", RestaurantId=" + RestaurantId
					+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", paymentMode=" + paymentMode
					+ ", status=" + status + "]";
		}
		public void setTotalAmount(double totalAmount) {
			// TODO Auto-generated method stub
			
		}
		public void setOrderDate(Date date) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
	}
