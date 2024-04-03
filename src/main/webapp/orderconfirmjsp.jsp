<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.model.Cart,com.food.model.cartitem" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<link rel="stylesheet" href="orderconfirm.css"> <!-- Assuming you have a CSS file named style.css for styling -->
</head>
<body>
<h1>Confirm</h1>
    <div class="container">
        <h2>Order Confirmation</h2>
        <%
        Cart cart = (Cart) session.getAttribute("cart");
                    if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
        %>
        <p>Thank you for your order! Here are the details:</p>
        <div class="order-details">
            <p><strong>Delivery Address:</strong> <%= request.getParameter("address") %></p>
            <p><strong>Payment Method:</strong> <%= request.getParameter("paymentMethod") %></p>
            <!-- Display Cart Details -->
            <p><strong>Cart Details:</strong></p>
            <ul>
                <% for (cartitem item : cart.getItems().values()) {
                    if (item != null) { %>
                        <li><%= item.getName() %> - <%= item.getQuantity() %> - <%= item.getPrice() %></li>
                    <% } 
                } %>
            </ul>
        </div>
        <p>Your order has been successfully placed.</p>
        <% } else { %>
        <p>You haven't ordered anything yet. Thank you!</p>
        <% } %>
        <a href="home.jsp">Back to Home</a> <!-- Assuming index.jsp is your home page -->
    </div>
</body>
</html>