package pl.graza.dao;

import pl.graza.model.Tool;
import pl.graza.model.ToolType;
import pl.graza.model.User;
import java.sql.*;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<User> getUser(String login) {

        User user = new User();

        String selectSQL = "SELECT * FROM users WHERE login=?";

        try (Connection dbConnection = DbConnection.getInstance().getDBConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, login);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                Long userId = rs.getLong("id");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");

                return Optional.of(new User(userId, userLogin, userPassword));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }
}
