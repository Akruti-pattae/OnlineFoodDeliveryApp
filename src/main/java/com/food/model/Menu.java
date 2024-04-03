package com.food.model;

public class Menu {

	
		private int menuId;
		private int RestaurantId;
		private String itemName;
		private String Description;
		private int price;
		private float rating;
		private boolean isAvailable;
		private String imagePath;
		public Menu() {
			super();
		}
		public Menu(int menuId, int restaurantId, String itemName, String description, int price, float rating,
				boolean isAvailable, String imagePath) {
			super();
			this.menuId = menuId;
			RestaurantId = restaurantId;
			this.itemName = itemName;
			Description = description;
			this.price = price;
			this.rating = rating;
			this.isAvailable = isAvailable;
			this.imagePath = imagePath;
		}
		public int getMenuId() {
			return menuId;
		}
		public void setMenuId(int menuId) {
			this.menuId = menuId;
		}
		public int getRestaurantId() {
			return RestaurantId;
		}
		public void setRestaurantId(int restaurantId) {
			RestaurantId = restaurantId;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public float getRating() {
			return rating;
		}
		public void setRating(float rating) {
			this.rating = rating;
		}
		public boolean isAvailable() {
			return isAvailable;
		}
		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		@Override
		public String toString() {
			return "Menu [menuId=" + menuId + ", RestaurantId=" + RestaurantId + ", itemName=" + itemName
					+ ", Description=" + Description + ", price=" + price + ", rating=" + rating + ", isAvailable="
					+ isAvailable + ", imagePath=" + imagePath + "]";
		}
		
		
		
		
		
	}
	
