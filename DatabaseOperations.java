package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseOperations {
    private static final Logger logger= LogManager.getLogger(DatabaseOperations.class);
    public static void add(Connection conn) throws SQLException {
        //final Logger logger = Logger.getLogger("Main2");
        Scanner scanner = new Scanner(System.in);
        DataBasePool dataBasePool=new DataBasePool();
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("---------------------------");
        System.out.println("Enter Employee details");
        System.out.println("---------------------------");
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employee name");
        String name = scanner.nextLine();
        System.out.println("Enter employee age");
        int age = scanner.nextInt();
        System.out.println("Enter employee salary");
        int salary = scanner.nextInt();
        System.out.println("choose the type of an employee");
        System.out.println("1.Permanent employee 2.part time employee 3.Contract employee");
        int select = scanner.nextInt();
        switch (select)
        {
            case 1:
                System.out.println("Enter bonus amount");
                int bonus = scanner.nextInt();
                PermanentEmployee permanentEmployee = new PermanentEmployee(id,name,age,salary,bonus);
                try
                {
                    employeeDatabase.addEmployee(permanentEmployee,conn);
                }
                catch (SQLException e)
                {
                    e.printStackTrace();

                }
                break;
            case 2:
                System.out.println("Enter hoursworked");
                int hoursWorked = scanner.nextInt();
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id,name,age,salary,hoursWorked);
                try
                {
                    employeeDatabase.addEmployee(partTimeEmployee,conn);
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
                break;
            case 3:
                System.out.println("Enter contract period");
                int contractperiod = scanner.nextInt();
                ContractEmployee contractEmployee = new ContractEmployee(id,name,age,salary,contractperiod);
                try
                {
                    employeeDatabase.addEmployee(contractEmployee,conn);
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
                break;
        }
    }


    public static void delete(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("Choose which type of an employee you are going to delete");
        System.out.println("1.Permanent employee 2.part time employee 3.contract employee");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                System.out.println("Enter the employee id to delete");
                int empId = scanner.nextInt();
                employeeDatabase.deleteEmployee1(empId,conn);
                break;
            case 2:
                System.out.println("Enter the employee id to delete");
                empId = scanner.nextInt();
                employeeDatabase.deleteEmployee3(empId,conn);
                break;
            case 3:
                System.out.println("Enter the employee id to delete");
                empId = scanner.nextInt();
                employeeDatabase.deleteEmployee2(empId,conn);

                break;
            default:
                break;

        }


    }

    public static void update(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase employeeDatabase = new EmployeeDatabase();
        System.out.println("---------------------------");
        System.out.println("Enter Employee details to modify");
        System.out.println("---------------------------");
        System.out.println("Enter employee id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter employee name");
        String name = scanner.nextLine();
        System.out.println("Enter employee age");
        int age = scanner.nextInt();
        System.out.println("Enter employee salary");
        int salary = scanner.nextInt();
        System.out.println("choose the type of an employee to modify");
        System.out.println("1.Permanent employee 2.part time employee 3.contract employee");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                System.out.println("Enter bonus amount");
                int bonus = scanner.nextInt();
                PermanentEmployee permanentEmployee = new PermanentEmployee(id, name, age, salary, bonus);
                employeeDatabase.updateEmployee(permanentEmployee,conn);
                break;
            case 2:
                System.out.println("Enter hours worked");
                int hoursWorked = scanner.nextInt();
                PartTimeEmployee partTimeEmployee = new PartTimeEmployee(id, name, age, salary, hoursWorked);
                employeeDatabase.updateEmployee(partTimeEmployee,conn);

                break;
            case 3:
                System.out.println("Enter contract period");
                int contractperiod = scanner.nextInt();
                ContractEmployee contractEmployee = new ContractEmployee(id, name, age, salary, contractperiod);
                employeeDatabase.updateEmployee(contractEmployee,conn);


                break;
            default:
                break;
        }
    }

}
