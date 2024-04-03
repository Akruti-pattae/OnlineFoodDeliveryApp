<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page
    import="java.util.Map,com.food.model.Cart,com.food.model.cartitem"%>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="cart.css">
</head>
<body>
    <h1>Your Shopping Cart</h1>
    <div class="cart-items">
        <%
        

                Cart cart = (Cart) session.getAttribute("cart");
                if (cart != null && !cart.getItems().isEmpty()) {
                    for (cartitem item : cart.getItems().values()) {
        %>
        <div class="cart-item">
            <h3><%=item.getName()%></h3>
            <p>&#x20B9;<%=item.getPrice()%></p>
            <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%=item.getOrderitemid()%>">
                <label>Quantity: <input type="number" name="quantity" value="<%=item.getQuantity()%>" min="1">
                 <input type="submit" name="action" value="update" class="update-btn">
                <input type="submit" name="action" value="remove" class="remove-btn">
            </form>
        </div>
        <%
                }
            } else {
        %>
        <p>Your cart is empty.</p>
        <%
            }
        %>
        <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="btn">Add More Items</a>
        
        <!-- Proceed to Checkout Button -->
        <%
            if (session.getAttribute("cart") != null) {
        %>
        
        
        
        <%
            }
        %>

        <!-- Checkout Button -->
        <form action="checkout.jsp" method="post">
            <input type="submit" value="Checkout" class="btn checkout-btn">
        </form>
    </div>
</body>
</html>
