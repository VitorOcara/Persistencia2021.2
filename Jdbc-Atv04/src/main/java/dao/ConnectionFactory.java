package dao;

import config.AppConfig;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(AppConfig.PROPS.getProperty("jdbc.url"),
//                AppConfig.PROPS.getProperty("jdbc.usuario"), AppConfig.PROPS.getProperty("jdbc.senha"));
        return DriverManager.getConnection("jdbc:postgresql://localhost/persist", "postgres", "1310");

    }
}
