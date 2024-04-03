package com.food.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Restaurant {

	
		private int RestaurantID;
		private int UserID;
		private String Name;
		private long PhoneNumber;
		private String Address;
		private float Rating;
		private boolean IsActive;
		private String ImagePath;
		private String CuisineType;
		public Restaurant() {
			super();
		}
		public Restaurant(int restaurantID, int userID, String name, long phoneNumber, String address, float rating,
				boolean isActive, String imagePath, String cuisineType) {
			super();
			RestaurantID = restaurantID;
			UserID = userID;
			Name = name;
			PhoneNumber = phoneNumber;
			Address = address;
			Rating = rating;
			IsActive = isActive;
			ImagePath = imagePath;
			CuisineType = cuisineType;
		}
		public int getRestaurantID() {
			return RestaurantID;
		}
		public void setRestaurantID(int restaurantID) {
			RestaurantID = restaurantID;
		}
		public int getUserID() {
			return UserID;
		}
		public void setUserID(int userID) {
			UserID = userID;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public long getPhoneNumber() {
			return PhoneNumber;
		}
		public void setPhoneNumber(long phoneNumber) {
			PhoneNumber = phoneNumber;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public float getRating() {
			return Rating;
		}
		public void setRating(float rating) {
			Rating = rating;
		}
		public boolean isIsActive() {
			return IsActive;
		}
		public void setIsActive(boolean isActive) {
			IsActive = isActive;
		}
		public String getImagePath() {
			return ImagePath;
		}
		public void setImagePath(String imagePath) {
			ImagePath = imagePath;
		}
		public String getCuisineType() {
			return CuisineType;
		}
		public void setCuisineType(String cuisineType) {
			CuisineType = cuisineType;
		}
		@Override
		public String toString() {
			return "Restaurant [RestaurantID=" + RestaurantID + ", UserID=" + UserID + ", Name=" + Name
					+ ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", Rating=" + Rating + ", IsActive="
					+ IsActive + ", ImagePath=" + ImagePath + ", CuisineType=" + CuisineType + "]";
		}
		
		
		public void setMenu(List<Menu>menus) {
		
	}
	
}