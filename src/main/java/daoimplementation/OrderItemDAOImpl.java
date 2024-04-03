package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public OrderItemDAOImpl() {
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
    public void addOrderItem(OrderItem orderItem) {
        try {
            String query = "INSERT INTO order_item (OrderItemId, OrderId, MenuId, Name, Quantity, Price) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderItem.getOrderItemId());
            stmt.setInt(2, orderItem.getOrderId());
            stmt.setInt(3, orderItem.getMenuId());
            stmt.setString(4, orderItem.getName());
            stmt.setInt(5, orderItem.getQuantity());
            stmt.setInt(6, orderItem.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {
        OrderItem orderItem = null;
        try {
            String query = "SELECT * FROM order_item WHERE OrderItemId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderItemId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("OrderId");
                int menuId = rs.getInt("MenuId");
                String name = rs.getString("Name");
                int quantity = rs.getInt("Quantity");
                int price = rs.getInt("Price");
                orderItem = new OrderItem(orderItemId, orderId, menuId, name, quantity, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        try {
            String query = "UPDATE order_item SET OrderId=?, MenuId=?, Name=?, Quantity=?, Price=? WHERE OrderItemId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderItem.getOrderId());
            stmt.setInt(2, orderItem.getMenuId());
            stmt.setString(3, orderItem.getName());
            stmt.setInt(4, orderItem.getQuantity());
            stmt.setInt(5, orderItem.getPrice());
            stmt.setInt(6, orderItem.getOrderItemId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int orderItemId) {
        try {
            String query = "DELETE FROM order_item WHERE OrderItemId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderItemId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getAllOrderItemsByRestaurant(int orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            String query = "SELECT * FROM order_item WHERE OrderId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderItemId = rs.getInt("OrderItemId");
                int menuId = rs.getInt("MenuId");
                String name = rs.getString("Name");
                int quantity = rs.getInt("Quantity");
                int price = rs.getInt("Price");
                OrderItem orderItem = new OrderItem(orderItemId, orderId, menuId, name, quantity, price);
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }
}
