package com.food.model;

public class cartitem {
private int orderitemid;
private int restaurantrid;
private String name;
private int quantity;
private double price;
public cartitem() {
	super();
}
public cartitem(int orderitemid, int restaurantrid, String name, int quantity, double price) {
	super();
	this.orderitemid = orderitemid;
	this.restaurantrid = restaurantrid;
	this.name = name;
	this.quantity = quantity;
	this.price = price;
}
public int getOrderitemid() {
	return orderitemid;
}
public void setOrderitemid(int orderitemid) {
	this.orderitemid = orderitemid;
}
public int getRestaurantrid() {
	return restaurantrid;
}
public void setRestaurantrid(int restaurantrid) {
	this.restaurantrid = restaurantrid;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "cartitem [orderitemid=" + orderitemid + ", restaurantrid=" + restaurantrid + ", name=" + name
			+ ", quantity=" + quantity + ", price=" + price + "]";
}





}
