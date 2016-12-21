package ru.kpfu.itis.Alina.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created by Admin on 28.10.2016.
 */
public class Database {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password = "barnan25";


    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver)
                    Class.forName("org.postgresql.Driver").newInstance());
            Connection con = DriverManager.getConnection(url, login, password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
