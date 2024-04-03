package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderDAO;
import com.food.model.Order;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public OrderDAOImpl() {
        String url = "jdbc:mysql://localhost:3306/online_food_delivery_app";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrder(Order order) {
        try {
            String query = "INSERT INTO orders (OrderId, UserId, RestaurantId, TotalPrice, OrderDate, PaymentMode, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, order.getOrderId());
            stmt.setInt(2, order.getUserId());
            stmt.setInt(3, order.getRestaurantId());
            stmt.setInt(4, order.getTotalPrice());
            stmt.setObject(5, order.getOrderDate());
            stmt.setString(6, order.getPaymentMode());
            stmt.setString(7, order.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getMenu(int orderId) {
        Order order = null;
        try {
            String query = "SELECT * FROM orders WHERE OrderId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("UserId");
                int restaurantId = rs.getInt("RestaurantId");
                int totalPrice = rs.getInt("TotalPrice");
                LocalDate orderDate = rs.getObject("OrderDate", LocalDate.class);
                String paymentMode = rs.getString("PaymentMode");
                String status = rs.getString("Status");
                order = new Order(orderId, userId, restaurantId, totalPrice, orderDate, paymentMode, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        try {
            String query = "UPDATE orders SET UserId=?, RestaurantId=?, TotalPrice=?, OrderDate=?, PaymentMode=?, Status=? WHERE OrderId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setInt(3, order.getTotalPrice());
            stmt.setObject(4, order.getOrderDate());
            stmt.setString(5, order.getPaymentMode());
            stmt.setString(6, order.getStatus());
            stmt.setInt(7, order.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try {
            String query = "DELETE FROM orders WHERE OrderId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrdersByUser(int userId) {
        List<Order> orders = new ArrayList<>();
        try {
            String query = "SELECT * FROM orders WHERE UserId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("OrderId");
                int restaurantId = rs.getInt("RestaurantId");
                int totalPrice = rs.getInt("TotalPrice");
                LocalDate orderDate = rs.getObject("OrderDate", LocalDate.class);
                String paymentMode = rs.getString("PaymentMode");
                String status = rs.getString("Status");
                Order order = new Order(orderId, userId, restaurantId, totalPrice, orderDate, paymentMode, status);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
