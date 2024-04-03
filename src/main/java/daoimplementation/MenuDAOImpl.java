package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.MenuDAO;
import com.food.model.Menu;

public class MenuDAOImpl implements MenuDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public MenuDAOImpl() {
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
    public void addMenu(Menu menu) {
        try {
            String query = "INSERT INTO menu (MenuId, RestaurantId, ItemName, Description, Price, Rating, IsAvailable, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
           // stmt.setInt(1, menu.getMenuId());
            stmt.setInt(2, menu.getRestaurantId());
            stmt.setString(3, menu.getItemName());
            stmt.setString(4, menu.getDescription());
            stmt.setInt(5, menu.getPrice());
            stmt.setFloat(6, menu.getRating());
            stmt.setBoolean(7, menu.isAvailable());
            stmt.setString(8, menu.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuId) {
        Menu menu = null;
        try {
            String query = "SELECT * FROM menu WHERE MenuId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, menuId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int restaurantId = rs.getInt("RestaurantId");
                String itemName = rs.getString("ItemName");
                String description = rs.getString("Description");
                int price = rs.getInt("Price");
                float rating = rs.getFloat("Rating");
                boolean isAvailable = rs.getBoolean("IsAvailable");
                String imagePath = rs.getString("ImagePath");
                menu = new Menu(menuId, restaurantId, itemName, description, price, rating, isAvailable, imagePath);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public void updateMenu(Menu menu) {
        try {
            String query = "UPDATE menu SET RestaurantId=?, ItemName=?, Description=?, Price=?, Rating=?, IsAvailable=?, ImagePath=? WHERE MenuId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getItemName());
            stmt.setString(3, menu.getDescription());
            stmt.setInt(4, menu.getPrice());
            stmt.setFloat(5, menu.getRating());
            stmt.setBoolean(6, menu.isAvailable());
            stmt.setString(7, menu.getImagePath());
            stmt.setInt(8, menu.getMenuId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {
        try {
            String query = "DELETE FROM menu WHERE MenuId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, menuId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenusByRestaurant(int restaurantId) {
        List<Menu> menus = new ArrayList<>();
        try {
            String query = "SELECT * FROM menu WHERE RestaurantId=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, restaurantId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int menuId = rs.getInt("MenuId");
                String itemName = rs.getString("ItemName");
                String description = rs.getString("Description");
                int price = rs.getInt("Price");
                float rating = rs.getFloat("Rating");
                boolean isAvailable = rs.getBoolean("IsAvailable");
                String imagePath = rs.getString("ImagePath");
                Menu menu = new Menu(menuId, restaurantId, itemName, description, price, rating, isAvailable, imagePath);
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }
}
