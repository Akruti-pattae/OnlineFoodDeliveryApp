package com.food.model;

import java.time.LocalDate;

public class User {
	
		private int UserID;
		private String Name;
		private String Password;
		private String Phone;
		private String Email;
		private String Address;
		private String Role;
		private LocalDate  CreatedDate;
		private LocalDate LastLoginDate;
		public User() {
			super();
		}
		
		
		



		public User(String name, String password, String phone, String email, String address, String role) {
			super();
			Name = name;
			Password = password;
			Phone = phone;
			Email = email;
			Address = address;
			Role = role;
		}






		public User(int userID, String name, String password, String phone, String email, String address, String role,
				LocalDate createdDate, LocalDate lastLoginDate) {
			super();
			UserID = userID;
			Name = name;
			Password = password;
			Phone = phone;
			Email = email;
			Address = address;
			Role = role;
			CreatedDate = createdDate;
			LastLoginDate = lastLoginDate;
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
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getPhone() {
			return Phone;
		}
		public void setPhone(String phone) {
			Phone = phone;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public String getRole() {
			return Role;
		}
		public void setRole(String role) {
			Role = role;
		}
		public LocalDate getCreatedDate() {
			return CreatedDate;
		}
		public void setCreatedDate(LocalDate createdDate) {
			CreatedDate = createdDate;
		}
		public LocalDate getLastLoginDate() {
			return LastLoginDate;
		}
		public void setLastLoginDate(LocalDate lastLoginDate) {
			LastLoginDate = lastLoginDate;
		}
		@Override
		public String toString() {
			return "User [UserID=" + UserID + ", Name=" + Name + ", Password=" + Password + ", Phone=" + Phone
					+ ", Email=" + Email + ", Address=" + Address + ", Role=" + Role + ", CreatedDate=" + CreatedDate
					+ ", LastLoginDate=" + LastLoginDate + "]";
		}
		
		
		
		
}
