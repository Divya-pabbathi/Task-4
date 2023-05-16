package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBasePool {
    public static Connection conn=null;

    private static final Logger logger= LogManager.getLogger(DataBasePool.class);

    public Connection link() throws SQLException {

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "94415@Dd40095");
            
            return conn;
        } catch (Exception e) {

            logger.info("Database connection failed");
           // return null;
        }
        return conn;

    }

}

