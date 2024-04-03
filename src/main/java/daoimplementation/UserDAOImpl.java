package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.UserDAO;
import com.food.model.User;

public class UserDAOImpl implements UserDAO {
    private Connection connection;
    private PreparedStatement stmt;

    public UserDAOImpl() {
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
    public void addUser(User user) {
        try {
            String query = "INSERT INTO user ( username, Password, PhoneNumber, Email, Address,role) VALUES (?, ?, ?, ?, ?,?)";
            stmt = connection.prepareStatement(query);
          
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getAddress());
            stmt.setString(6,"Customer");
           
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            String query = "UPDATE user SET username=?, Password=?, PhoneNumber=?, Email=?, Address=?, Role=?, CreatedDate=?, LastLoginDate=? WHERE UserID=?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getRole());
            stmt.setDate(7, java.sql.Date.valueOf(user.getCreatedDate()));
            stmt.setDate(8, java.sql.Date.valueOf(user.getLastLoginDate()));
            stmt.setInt(9, user.getUserID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int UserID) {
        try {
            String query = "DELETE FROM user WHERE UserID=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, UserID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";
            stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("UserID");
                String name = rs.getString("username");
                String password = rs.getString("Password");
                String phone = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String role = rs.getString("Role");
                LocalDate createdDate = rs.getDate("CreatedDate").toLocalDate();
                LocalDate lastLoginDate = rs.getDate("LastLoginDate").toLocalDate();
                User user = new User(userID, name, password, phone, email, address, role, createdDate, lastLoginDate);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(int userID) {
        User user = null;
        try {
            String query = "SELECT * FROM user WHERE UserID=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("username");
                String password = rs.getString("Password");
                String phone = rs.getString("PhoneNumber");
                String email = rs.getString("Email");
                String address = rs.getString("Address");
                String role = rs.getString("Role");
                LocalDate createdDate = rs.getDate("CreatedDate").toLocalDate();
                LocalDate lastLoginDate = rs.getDate("LastLoginDate").toLocalDate();
                user = new User(userID, name, password, phone, email, address, role, createdDate, lastLoginDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    

	public User getusername(String username) {
		 User user = null;
	        try {
	            String query = "SELECT * FROM user WHERE Username=?";
	            stmt = connection.prepareStatement(query);
	            stmt.setString(1, username);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                int userID = rs.getInt("UserID");
	                String password = rs.getString("Password");
	                String phone = rs.getString("PhoneNumber");
	                String email = rs.getString("Email");
	                String address = rs.getString("Address");
	                String role = rs.getString("Role");
	                LocalDate createdDate = rs.getDate("CreatedDate").toLocalDate();
	                LocalDate lastLoginDate = rs.getDate("LastLoginDate").toLocalDate();
	                user = new User(userID, username, password, phone, email, address, role, createdDate, lastLoginDate);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;

}
}
