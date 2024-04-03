package com.tap.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.UserDAO;
import com.food.model.User;

import daoimplementation.UserDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpl(); // Instantiate your UserDAO implementation here
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        // Get user details based on the entered username
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        User user = userDAOImpl.getusername(username);
        
        System.out.println(user.getPassword());

        if (user != null && user.getPassword().equals(password)) {
        	 // Create a session
            HttpSession session = request.getSession();
            
            // Set user attribute in the session
            session.setAttribute("user", user);// Redirect to the login success page if the password matches
            response.sendRedirect("home.jsp");
        } else {
            // Redirect back to the login page with an error message if username or password is incorrect
            response.sendRedirect("login.jsp?error=true");
        }
    }
}