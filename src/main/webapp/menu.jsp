<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.food.model.Menu,java.util.List"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Details</title>
    <style>
        .menu-item {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            overflow: hidden;
        }
        .menu-item h3 {
            margin-top: 0;
        }
        .menu-item p {
            margin: 5px 0;
        }
        .menu-item img {
            display: block;
            margin: 0 auto;
            max-height: 100px;
        }
        .menu-item form {
            margin-top: 10px;
        }
        .menu-item form button {
            margin-right: 10px;
        }
        .menu-item .cart-button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h2>Menu Details</h2>
    <div class="menu-list">
        <% 
        List<Menu> menus = (List<Menu>) request.getAttribute("menus");
        for (Menu menu : menus) { %>
            <div class="menu-item">
                <h3><%= menu.getItemName() %></h3>
                <p>Description: <%= menu.getDescription() %></p>
                <p>Price: <%= menu.getPrice() %></p>
                <p>Rating: <%= menu.getRating() %></p>
                <!-- Assuming imagePath is the URL to the image -->
                <img src="<%= menu.getImagePath() %>" alt="<%= menu.getItemName() %>">
                <!-- Form for quantity and cart button -->
                <form id="menuForm" action="ccart" method="post">
                    <!-- Quantity input -->
                    <input id="quantityInput<%= menu.getMenuId() %>" type="number" name="quantity" value="1" min="1" max="10" required>
                    <!-- Hidden input for menu ID -->
                    <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                    <!-- Cart button -->
                    <button class="cart-button" type="submit" name="action" value="addToCart">Add to Cart</button>
                </form>
            </div>
        <% } %>
    </div>
</body>
</html>
