package org.example;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger= LogManager.getLogger(App.class);
    public static void main(String[] args) throws SQLException {
        DataBasePool dataBasePool = new DataBasePool();
        DatabaseOperations databaseOperations = new DatabaseOperations();
        Scanner scanner = new Scanner(System.in);

        boolean bool = true;

        Connection conn = dataBasePool.link();
       try{
           if(conn!=null){
               logger.info("Database connected");
           }
       }catch(Exception e){
           logger.info("Database not Connected");
       }
        while (bool) {
            System.out.println("Enter your option");
            int options = scanner.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Inserting Elements into Database");
                    DatabaseOperations.add(conn);
                    break;
                case 2:
                    System.out.println("Updating Elements in the Database");
                    DatabaseOperations.update(conn);
                    break;
                case 3:
                    System.out.println("Deletion of Elements from Database");
                    DatabaseOperations.delete(conn);
                    break;
            }
            System.out.println("Enter true if you want to continue");
            bool = scanner.nextBoolean();
        }

        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        employeeDatabase.permanentJson(conn);
        employeeDatabase.parttimeJson(conn);
        employeeDatabase.contractJson(conn);
    }


}










