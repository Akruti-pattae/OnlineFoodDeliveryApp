package com.tap.servlet;




import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.OrderHistoryDAO;
//import com.food.daoimplementation.OrderHistoryDAOImp;
import com.food.model.OrderHistory;
import com.food.model.User;

import daoimplementation.OrderHistoryDAOImpl;

@WebServlet("/OrderHistoryServlet")
public class OrderhistoryServlet extends HttpServlet {
    private OrderHistoryDAO orderHistoryDAO;

    @Override
    public void init() {
        orderHistoryDAO = new OrderHistoryDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            int userId = user.getUserID();
            List<OrderHistory> orderHistoryList = orderHistoryDAO.getAllOrderHistorysByUser(userId);
            
            for (OrderHistory orderHistory : orderHistoryList) {
				System.out.println(orderHistory);
			}
            
            // Store order history list in the session
            session.setAttribute("orderHistoryList", orderHistoryList);
            
            
            // Forward the request to orderHistory.jsp to display the order history
         //   request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
            response.sendRedirect("orderhistory.jsp");
        } else {
            // Redirect to the login page if the user is not logged in
            response.sendRedirect("home.jsp");
        }
    }

    // doPost method can be implemented if needed
}