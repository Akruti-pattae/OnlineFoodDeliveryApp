<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.food.model.User, com.food.model.Restaurant,com.food.model.Cart, java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Online Food Application</title>
    <link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
<header>
    <h1>Welcome to Online Food Application</h1>
</header>

<nav>
<%
    HttpSession se = request.getSession();
    User user = (User)se.getAttribute("user");
    if (user != null) {
%>
        <a href="#">Home</a>
        <a href="cart.jsp">View Cart</a>
        <a href="orderhistory.jsp">Order History</a>
        <a href="logout.jsp">Logout</a>
<%
    } else {
%>
        <a href="login.jsp">Login</a>
        <a href="registration.jsp">Register</a>
<%
    }
%>
</nav>

<div class="content">
    <div class="welcome-message">
        <h2>Welcome to our online food application!</h2>
        <p>Explore a variety of cuisines and place your orders seamlessly.</p>
    </div>
</div>

<%-- Display restaurant list if user is logged in or after login --%>
<%
    if (user != null) {
        List<Restaurant> restaurants = (List<Restaurant>) se.getAttribute("restaurants");
        if (restaurants != null && !restaurants.isEmpty()) {
%>
    <div class="restaurant-list">
        <h2>Available Restaurants:</h2>
        <ul>
            <c:forEach var="restaurant" items="${restaurants}">
                <li>
                    <h3>${restaurant.name}</h3>
                    <p>Phone Number: ${restaurant.phoneNumber}</p>
                    <p>Address: ${restaurant.address}</p>
                    <p>Rating: ${restaurant.rating}</p>
                    <p>Cuisine Type: ${restaurant.cuisineType}</p>
                    <div class="restaurant-image">
                        <img src="${restaurant.imagePath}" alt="${restaurant.name}">
                    </div>
                    <button><a href="menu?restaurantId=${restaurant.restaurantID}">Menu</a></button> 
                </li>
            </c:forEach>
        </ul>
    </div>
<%
        }
    }
%>

<%-- Display form elements only if user is not logged in --%>
<%
    if (user == null) {
%>
    <!-- Form tag with action attribute -->
    <form action="Home" method="post">
        <!-- Your form elements go here -->
        
    </form>
<%
    }
%>

</body>
</html>
