package com.tap.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.model.User;

import daoimplementation.UserDAOImpl;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        // Retrieve user details from the request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("PhoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String role = "user"; // Assuming the default role is "customer"
      
        // Create a User object with the retrieved details
        User user = new User(username, password, phoneNumber, email, address,role);

        // Instantiate UserDAOImpl to access the database
        UserDAOImpl userDAO = new UserDAOImpl();
         
        // Add the user to the database
        userDAO.addUser(user);

        // Redirect the user to a confirmation page or login page
       response.sendRedirect("register.jsp");
      //  request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}