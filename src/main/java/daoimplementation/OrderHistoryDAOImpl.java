package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderHistoryDAO;
import com.food.model.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public OrderHistoryDAOImpl() {
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
    public void addOrderHistory(OrderHistory orderHistory) {
        try {
            String query = "INSERT INTO order_history (OrderHistoryId, UserId, RestaurantId, OrderId, Price, Status) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderHistory.getOrderHistoryId());
            stmt.setInt(2, orderHistory.getUserId());
            stmt.setInt(3, orderHistory.getRestaurantId());
            stmt.setInt(4, orderHistory.getOrderId());
            stmt.setInt(5, orderHistory.getPrice());
            stmt.setString(6, orderHistory.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        OrderHistory orderHistory = null;
        try {
            String query = "SELECT * FROM order_history WHERE OrderHistoryId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderHistoryId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("UserId");
                int restaurantId = rs.getInt("RestaurantId");
                int orderId = rs.getInt("OrderId");
                int price = rs.getInt("Price");
                String status = rs.getString("Status");
                orderHistory = new OrderHistory(orderHistoryId, userId, restaurantId, orderId, price, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public void updateOrderHistory(OrderHistory orderHistory) {
        try {
            String query = "UPDATE order_history SET UserId=?, RestaurantId=?, OrderId=?, Price=?, Status=? WHERE OrderHistoryId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderHistory.getUserId());
            stmt.setInt(2, orderHistory.getRestaurantId());
            stmt.setInt(3, orderHistory.getOrderId());
            stmt.setInt(4, orderHistory.getPrice());
            stmt.setString(5, orderHistory.getStatus());
            stmt.setInt(6, orderHistory.getOrderHistoryId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderHistory(int orderHistoryId) {
        try {
            String query = "DELETE FROM order_history WHERE OrderHistoryId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderHistoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> getAllOrderHistorysByUser(int userId) {
        List<OrderHistory> orderHistories = new ArrayList<>();
        try {
            String query = "SELECT * FROM order_history WHERE UserId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderHistoryId = rs.getInt("OrderHistoryId");
                int restaurantId = rs.getInt("RestaurantId");
                int orderId = rs.getInt("OrderId");
                int price = rs.getInt("Price");
                String status = rs.getString("Status");
                OrderHistory orderHistory = new OrderHistory(orderHistoryId, userId, restaurantId, orderId, price, status);
                orderHistories.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistories;
    }
}
