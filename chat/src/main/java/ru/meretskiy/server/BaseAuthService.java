package ru.meretskiy.server;

import java.sql.*;

public class BaseAuthService implements AuthService {

    private static Connection connection;
    private static Statement statement;

    @Override
    public void start() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat/chatAuthBase.db");
            statement = connection.createStatement();

            System.out.println("Service of authentication is run");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public synchronized String getNick(String login, String pass) {
        String sqlSelect = String.format(
                "SELECT nick FROM clients WHERE (login = '%s') " +
                        "AND (password = '%s');", login, pass);
        try {
            ResultSet rs = statement.executeQuery(sqlSelect);
            return rs.getString("nick");
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public synchronized String changeNick(String nick, String newNick) {
        String sqlUpdate = String.format("UPDATE clients SET nick = '%s' WHERE nick = '%s';", newNick, nick);
        try {
            statement.executeUpdate(sqlUpdate);
            return newNick;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
