package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // Import HttpSession class

import com.food.dao.MenuDAO;
import com.food.dao.RestaurantDAO;
import com.food.dao.UserDAO;
import com.food.model.Restaurant;

import daoimplementation.MenuDAOImpl;
import daoimplementation.RestaurantDAOImpl;
import daoimplementation.UserDAOImpl;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    private UserDAO userDAO;
    private RestaurantDAO restaurantDAO;
    private MenuDAO menuDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImpl();
        restaurantDAO = new RestaurantDAOImpl();
        menuDAO=new MenuDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        
        // Check if username and password are provided  
        // Redirect to home page with session
        HttpSession session = request.getSession(); // Retrieve session
        //session.setAttribute("username", username); // Set username in session

        // Fetch restaurant data and set it in session
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
        session.setAttribute("restaurants", restaurants);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
