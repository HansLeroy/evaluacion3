package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import MODEL.User;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/login_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private static final String SELECT_USER_SQL = "SELECT * FROM users WHERE username = ? AND password = ?";

    public boolean validate(User user) {
        boolean isValid = false;

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            isValid = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}