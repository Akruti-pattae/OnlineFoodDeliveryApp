package com.tap.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.Cart;

import daoimplementation.OrderDAOImpl;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // You can process the checkout here, such as saving the order to the database, 
        // sending confirmation emails, etc.
        
        // After processing the order, you might want to clear the cart
        if (cart != null) {
        OrderDAOImpl orderDAO=new OrderDAOImpl();
            cart.clear(); 
            // Clear the cart after the order is placed
            
            response.sendRedirect("orderconfirmjsp.jsp");
        
        }
        
        else {
        	
        	response.sendRedirect("cart.jsp?error=empty_cart");
        }
        // You can redirect the user to a confirmation page or any other appropriate page
        
    }

    
}