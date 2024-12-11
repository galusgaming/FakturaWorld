package pl.galusgaming.fakturaworld.services;

import java.sql.*;

public class LoginService {
    public static boolean auth(String login, String passwd) {

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            Connection connection = ConnectService.getConn();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, login);
            statement.setString(2, passwd);

            ResultSet resultSet = statement.executeQuery();
            boolean userExists = resultSet.next();

            statement.close(); // Zamykamy zasoby po użyciu
            return userExists;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
