package com.tap.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.food.model.Cart;

import com.food.model.Menu;
import com.food.model.cartitem;

import daoimplementation.MenuDAOImpl;

@WebServlet("/ccart")
public class CartServlet extends HttpServlet {
	private Cart cart;
	static HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Cart Servlet");

		session = request.getSession();
		cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		System.out.println(cart);
		
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			addItemToCart(request, cart);
		} else if ("update".equals(action)) {
			updateCartItem(request, cart);
		} else if ("remove".equals(action)) {
			removeItemFromCart(request, cart);
		}
		response.sendRedirect("cart.jsp");
		//request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	private static void addItemToCart(HttpServletRequest request, Cart cart) {
		System.out.println("additem");
		int itemId = Integer.parseInt(request.getParameter("OrderItemId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		MenuDAOImpl menuDAO = new MenuDAOImpl();
		Menu menuItem = menuDAO.getMenu(itemId);
		HttpSession session = request.getSession();
		session.setAttribute("restaurantId", menuItem.getRestaurantId());

		if (menuItem != null) {
			cartitem item = new cartitem(menuItem.getMenuId(), menuItem.getRestaurantId(), menuItem.getItemName(),
					quantity, menuItem.getPrice());
			cart.additem(item);
		}
	}

	private static void updateCartItem(HttpServletRequest request, Cart cart) {
	    int itemId = Integer.parseInt(request.getParameter("itemId")); // Corrected parameter name
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    cart.updateItem(itemId, quantity);
	}

	
	private static void removeItemFromCart(HttpServletRequest request, Cart cart) {
	    int itemId = Integer.parseInt(request.getParameter("itemId")); // Corrected parameter name
	    cart.removeitem(itemId);
	}

}