package com.food.model;

public class  OrderHistory {

	
		private int orderHistoryId;
		private int userId;
		private int restaurantId;
		private int orderId;
		private int price;
		private String status;
		public OrderHistory() {
			super();
		}
		public OrderHistory(int orderHistoryId, int userId, int restaurantId, int orderId, int price, String status) {
			super();
			this.orderHistoryId = orderHistoryId;
			this.userId = userId;
			this.restaurantId = restaurantId;
			this.orderId = orderId;
			this.price = price;
			this.status = status;
		}
		public int getOrderHistoryId() {
			return orderHistoryId;
		}
		public void setOrderHistoryId(int orderHistoryId) {
			this.orderHistoryId = orderHistoryId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "OrderHistory [orderHistoryId=" + orderHistoryId + ", userId=" + userId + ", restaurantId="
					+ restaurantId + ", orderId=" + orderId + ", price=" + price + ", status=" + status + "]";
		}
		
		public String getRestaurantName()
		{
		return null;
		
	}
}
	