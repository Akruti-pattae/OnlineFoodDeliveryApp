package com.tap.servlet;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.Cart;
import com.food.model.cartitem;


@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private com.food.dao.OrderDAO orderDAO;

    @Override
    public void init() {
        orderDAO = new daoimplementation.OrderDAOImpl();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        com.food.model.User user = (com.food.model.User) session.getAttribute("loggedInUser");

        if (cart != null && user != null && !cart.getItems().isEmpty()) {
            // Extract checkout form data
            String paymentMethod = request.getParameter("paymentMethod");

            com.food.model.Order order = new com.food.model.Order();
            order.setUserId(user.getUserID());
            order.setRestaurantId((int) session.getAttribute("restaurantId"));
            order.setOrderDate(new Date());
            order.setPaymentMode(paymentMethod);
            order.setStatus("Pending");

            // Add cart items to the order and calculate total amount
            int totalAmount = 0;
            for (cartitem item : cart.getItems().values()) {
                totalAmount += item.getPrice() * item.getQuantity();
                // Assuming Order has a method to handle the addition of order items
                // order.addOrderItem(item);
            }
            order.setTotalAmount(totalAmount);

            // Save the order to the database
            orderDAO.addOrder(order);

            // Clear the cart and redirect to the order confirmation page
            session.removeAttribute("cart");
            session.setAttribute("order", order);
            response.sendRedirect("orderconfirmjsp.jsp");
        } else {
            response.sendRedirect("cart.jsp"); // Redirect to the cart page if the cart is empty or user is not logged in
        }
    }
}