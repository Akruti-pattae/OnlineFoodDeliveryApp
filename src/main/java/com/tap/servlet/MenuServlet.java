package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.MenuDAO;
import com.food.model.Menu;
import daoimplementation.MenuDAOImpl;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

        session.setAttribute("restaurantId", restaurantId);
        
        MenuDAO menuDao = new MenuDAOImpl();
        List<Menu> menus = menuDao.getAllMenusByRestaurant(restaurantId);
        
        // Set the retrieved menus as an attribute in the request
        request.setAttribute("menus", menus);

        // Forward the request to the menu.jsp page for rendering
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}
