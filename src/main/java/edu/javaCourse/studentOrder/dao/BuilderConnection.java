package edu.javaCourse.studentOrder.dao;

import edu.javaCourse.studentOrder.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BuilderConnection {
    public static  Connection getConnect() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    Config.getProperties(Config.DB_URL),
                    Config.getProperties(Config.DB_LOGIN),
                    Config.getProperties(Config.DB_PASSWORD));
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
