package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.RestaurantDAO;
import com.food.model.Restaurant;

public  class RestaurantDAOImpl implements RestaurantDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public RestaurantDAOImpl() {
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
    public void addRestaurant(Restaurant restaurant) {
        try {
            String query = "INSERT INTO restaurant (RestaurantID, UserID, Name, PhoneNumber, Address, Rating, IsActive, ImagePath, CuisineType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, restaurant.getRestaurantID());
            stmt.setInt(2, restaurant.getUserID());
            stmt.setString(3, restaurant.getName());
            stmt.setLong(4, restaurant.getPhoneNumber());
            stmt.setString(5, restaurant.getAddress());
            stmt.setFloat(6, restaurant.getRating());
            stmt.setBoolean(7, restaurant.isIsActive());
            stmt.setString(8, restaurant.getImagePath());
            stmt.setString(9, restaurant.getCuisineType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantID) {
        Restaurant restaurant = null;
        try {
            String query = "SELECT * FROM restaurant WHERE RestaurantID=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, restaurantID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("UserID");
                String name = rs.getString("Name");
                long phoneNumber = rs.getLong("PhoneNumber");
                String address = rs.getString("Address");
                float rating = rs.getFloat("Rating");
                boolean isActive = rs.getBoolean("IsActive");
                String imagePath = rs.getString("ImagePath");
                String cuisineType = rs.getString("CuisineType");
                restaurant = new Restaurant(restaurantID, userID, name, phoneNumber, address, rating, isActive, imagePath, cuisineType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        try {
            String query = "UPDATE restaurant SET UserID=?, Name=?, PhoneNumber=?, Address=?, Rating=?, IsActive=?, ImagePath=?, CuisineType=? WHERE RestaurantID=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, restaurant.getUserID());
            stmt.setString(2, restaurant.getName());
            stmt.setLong(3, restaurant.getPhoneNumber());
            stmt.setString(4, restaurant.getAddress());
            stmt.setFloat(5, restaurant.getRating());
            stmt.setBoolean(6, restaurant.isIsActive());
            stmt.setString(7, restaurant.getImagePath());
            stmt.setString(8, restaurant.getCuisineType());
            stmt.setInt(9, restaurant.getRestaurantID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRestaurant(int restaurantID) {
        try {
            String query = "DELETE FROM restaurant WHERE RestaurantID=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, restaurantID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            String query = "SELECT * FROM restaurant";
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int restaurantID = rs.getInt("RestaurantID");
                int userID = rs.getInt("AdminUserID");
                String name = rs.getString("Name");
                long phoneNumber = rs.getLong("PhoneNumber");
                String address = rs.getString("Address");
                float rating = rs.getFloat("Rating");
                boolean isActive = rs.getBoolean("IsActive");
                String imagePath = rs.getString("ImagePath");
                String cuisineType = rs.getString("CuisineType");
                Restaurant restaurant = new Restaurant(restaurantID, userID, name, phoneNumber, address, rating, isActive, imagePath, cuisineType);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public List<Restaurant> getAllRestaurants1() {
    	String query = "SELECT * FROM restaurant";
        List<Restaurant> restaurants = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int restaurantID = resultSet.getInt("RestaurantID");
                int userID = resultSet.getInt("AdminUserID");
                String name = resultSet.getString("username");
                long phoneNumber = resultSet.getLong("PhoneNumber");
                String address = resultSet.getString("Address");
                float rating = resultSet.getFloat("Rating");
                boolean isActive = resultSet.getBoolean("IsActive");
                String imagePath = resultSet.getString("ImagePath");
                String cuisineType = resultSet.getString("CuisineType");
                // Create a Restaurant object with the retrieved data
                Restaurant restaurant = new Restaurant(restaurantID, userID, name, phoneNumber, address, rating, isActive, imagePath, cuisineType);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return restaurants;
  
	
    }

	@Override
	public List<Restaurant> getAllRestaurantsbyusername() {
		// TODO Auto-generated method stub
		return null;
	}
}
