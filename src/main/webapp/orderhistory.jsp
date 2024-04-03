<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.food.model.OrderHistory, com.food.model.User,java.util.List,com.food.dao.OrderHistoryDAO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <link rel="stylesheet" type="text/css" href="orderhistory.css">
</head>
<body>
    <h2>Order History</h2>
  <%
        // Get the order history list from the session
        List<OrderHistory> orderHistoryList = (List<OrderHistory>) session.getAttribute("orderHistoryList");
        if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
            // Iterate over the order history list
            for (OrderHistory orderHistory : orderHistoryList) {
    %>
                <div class="order-details">
                    <p><strong>Order ID:</strong> <%= orderHistory.getOrderId() %></p>
                    <p><strong>Restaurant Name:</strong> <%= orderHistory.getRestaurantName() %></p>
                    <p><strong>Price:</strong> <%= orderHistory.getPrice() %></p>
                    <p><strong>Status:</strong> <%= orderHistory.getStatus() %></p>
                </div>
    <%
            }
        } else {
            // If order history list is empty or null, display a message
    %>
            <p>No order history available.</p>
    <%
        }
    %>
</body>
</html>