package pl.galusgaming.fakturaworld.services;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class ConnectService {
    public static final Dotenv dotenv = Dotenv.load();
    public static final String DRIVER = "org.mariadb.jdbc.Driver";
    public static final String DB_URL = dotenv.get("DB_URL");
    public static final String DB_USER = dotenv.get("DB_USER");
    public static final String DB_PASS = dotenv.get("DB_PASS");
    private static Connection conn;
    private ConnectService() {
        // private constructor zapobiega utworzeniu instancji tej klasy
    }
    public static Connection getConn() {
        if (conn == null) {
            try {
                Class.forName(ConnectService.DRIVER);
            } catch (ClassNotFoundException e) {
                System.err.println("Brak sterownika JDBC");
                e.printStackTrace();
            }
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                System.out.println("Connected to database");
            } catch (SQLException e) {
                System.err.println("Problem z otwarciem polaczenia");
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConn() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.err.println("Problem z zamknieciem polaczenia");
                e.printStackTrace();
            }
        }
    }
}