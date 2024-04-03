package com.food.model;

public class OrderItem {

	
		private int orderItemId;
		private int orderId;
		private int menuId;
		private String name;
		private int quantity;
		private int price;
		public OrderItem() {
			super();
		}
		public OrderItem(int orderItemId, int orderId, int menuId, String name, int quantity, int price) {
			super();
			this.orderItemId = orderItemId;
			this.orderId = orderId;
			this.menuId = menuId;
			this.name = name;
			this.quantity = quantity;
			this.price = price;
		}
		public int getOrderItemId() {
			return orderItemId;
		}
		public void setOrderItemId(int orderItemId) {
			this.orderItemId = orderItemId;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getMenuId() {
			return menuId;
		}
		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuId=" + menuId + ", name="
					+ name + ", quantity=" + quantity + ", price=" + price + "]";
		}
		
		
		
		
		
}
