package org.example;

import java.sql.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.*;


public class EmployeeDatabase
{
    private Connection conn;
    public Statement statement;
    private PreparedStatement insertEmployeeStmt1;
    private PreparedStatement insertEmployeeStmt2;
    private PreparedStatement insertEmployeeStmt3;
    private PreparedStatement updateEmployeeStmt1;
    private PreparedStatement updateEmployeeStmt2;
    private PreparedStatement updateEmployeeStmt3;
    private PreparedStatement deleteEmployeeStmt1;
    private PreparedStatement deleteEmployeeStmt2;
    private PreparedStatement deleteEmployeeStmt3;
    private static final Logger logger= LogManager.getLogger(EmployeeDatabase.class);
    DataBasePool dataBasePool=new DataBasePool();

    public void addEmployee(PermanentEmployee permanentEmployee,Connection conn) throws SQLException
    {
        try
        {
            PreparedStatement insertEmployeeStmt1=conn.prepareStatement("INSERT INTO PermanentEmployee (id, name, age, salary, bonus) VALUES (?, ?, ?, ?, ?)");
            insertEmployeeStmt1.setInt(1, permanentEmployee.getId());
            insertEmployeeStmt1.setString(2, permanentEmployee.getName());
            insertEmployeeStmt1.setInt(3, permanentEmployee.getAge());
            insertEmployeeStmt1.setInt(4, permanentEmployee.getSalary());
            insertEmployeeStmt1.setInt(5, permanentEmployee.getBonus());
            insertEmployeeStmt1.executeUpdate();
            logger.info("Employee added");


        }
        catch (Exception e)
        {
            logger.warn("Duplicate id found");
        }
    }
    public void addEmployee(PartTimeEmployee partTimeEmployee,Connection conn) throws SQLException
    {
        try {

            PreparedStatement insertEmployeeStmt3=conn.prepareStatement("INSERT INTO PartTimeEmployee (id, name, age, salary, hoursWorked) VALUES (?, ?, ?, ?, ?)");
            insertEmployeeStmt3.setInt(1, partTimeEmployee.getId());
            insertEmployeeStmt3.setString(2, partTimeEmployee.getName());
            insertEmployeeStmt3.setInt(3, partTimeEmployee.getAge());
            insertEmployeeStmt3.setInt(4, partTimeEmployee.getSalary());
            insertEmployeeStmt3.setInt(5, partTimeEmployee.getHoursWorked());
            insertEmployeeStmt3.executeUpdate();
            logger.info("Employee added");
        }
        catch(Exception e)

        {
            logger.warn("Duplicate id found");

        }
    }
    public void addEmployee(ContractEmployee contractEmployee,Connection conn) throws SQLException
    {
        try {

            PreparedStatement insertEmployeeStmt2=conn.prepareStatement("INSERT INTO ContractEmployee (id, name, age, salary, contractPeriod) VALUES (?, ?, ?, ?, ?)");
            insertEmployeeStmt2.setInt(1, contractEmployee.getId());
            insertEmployeeStmt2.setString(2, contractEmployee.getName());
            insertEmployeeStmt2.setInt(3, contractEmployee.getAge());
            insertEmployeeStmt2.setInt(4, contractEmployee.getSalary());
            insertEmployeeStmt2.setInt(5, contractEmployee.getContractPeriod());
            insertEmployeeStmt2.executeUpdate();
            logger.info("Employee added");
        }
        catch(Exception e)
        {
            logger.warn("Duplicate id found");
        }
    }
    public void updateEmployee(PermanentEmployee permanentEmployee,Connection conn) throws SQLException {
        try {

            PreparedStatement updateEmployeeStmt1 = conn.prepareStatement("UPDATE PermanentEmployee SET name = ?, age = ?, salary = ?, bonus = ? WHERE id = ?");
            updateEmployeeStmt1.setString(1, permanentEmployee.getName());
            updateEmployeeStmt1.setInt(2, permanentEmployee.getAge());
            updateEmployeeStmt1.setInt(3, permanentEmployee.getSalary());
            updateEmployeeStmt1.setInt(4, permanentEmployee.getBonus());
            updateEmployeeStmt1.setInt(5, permanentEmployee.getId());
            updateEmployeeStmt1.executeUpdate();
            logger.info("Employee updated");
        } catch (Exception e) {
            logger.warn("Employee with such id is not found");
        }
    }
    public void updateEmployee(PartTimeEmployee partTimeEmployee,Connection conn) throws SQLException {
        try {

            PreparedStatement updateEmployeeStmt3 = conn.prepareStatement("UPDATE PartTimeEmployee SET name = ?, age = ?, salary = ?, hoursWorked = ? WHERE id = ?");
            updateEmployeeStmt3.setString(1, partTimeEmployee.getName());
            updateEmployeeStmt3.setInt(2, partTimeEmployee.getAge());
            updateEmployeeStmt3.setInt(3, partTimeEmployee.getSalary());
            updateEmployeeStmt3.setInt(4, partTimeEmployee.getHoursWorked());
            updateEmployeeStmt3.setInt(5, partTimeEmployee.getId());
            updateEmployeeStmt3.executeUpdate();
            logger.info("Employee updated");
        } catch (Exception e) {
            logger.warn("Employee with such id is not found");
        }
    }


    public void updateEmployee(ContractEmployee contractEmployee,Connection conn) throws SQLException {
        try {
            PreparedStatement updateEmployeeStmt2 = conn.prepareStatement("UPDATE ContractEmployee SET name = ?, age = ?, salary = ?, contractPeriod = ? WHERE id = ?");
            updateEmployeeStmt2.setString(1, contractEmployee.getName());
            updateEmployeeStmt2.setInt(2, contractEmployee.getAge());
            updateEmployeeStmt2.setInt(3, contractEmployee.getSalary());
            updateEmployeeStmt2.setInt(4, contractEmployee.getContractPeriod());
            updateEmployeeStmt2.setInt(5, contractEmployee.getId());
            updateEmployeeStmt2.executeUpdate();
            logger.info("Employee updated");
        } catch (Exception e) {
            logger.warn("Employee with such id is not found");
        }
    }
    public void deleteEmployee1(int id,Connection conn) throws SQLException
    {
        try {

            PreparedStatement deleteEmployeeStmt1=conn.prepareStatement("DELETE FROM PermanentEmployee WHERE id = ?");
            deleteEmployeeStmt1.setInt(1, id);
            int rows=deleteEmployeeStmt1.executeUpdate();
            if(rows>0) {
                logger.info("Employee deleted");
            }else{
                logger.info("Employee id not found");
            }
        }

        catch(Exception e)
        {
            logger.info("Employee id not found");

        }
    }
    public void deleteEmployee3(int id,Connection conn) throws SQLException
    {
        try {
            PreparedStatement deleteEmployeeStmt3=conn.prepareStatement("DELETE FROM PartTimeEmployee WHERE id = ?");
            deleteEmployeeStmt3.setInt(1, id);
            int rows1=deleteEmployeeStmt3.executeUpdate();
            if(rows1>0) {
                logger.info("Employee deleted");
            }else{
                logger.info("Employee id not found");
            }
        }catch(Exception e)
        {
            logger.info("Employee id not found");

        }

    }
    public void deleteEmployee2(int id,Connection conn) throws SQLException
    {
        try
        {
            PreparedStatement deleteEmployeeStmt2=conn.prepareStatement("DELETE FROM ContractEmployee WHERE id = ?");
            deleteEmployeeStmt2.setInt(1, id);
            int rows2=deleteEmployeeStmt2.executeUpdate();
            if(rows2>0) {
                logger.info("Employee deleted");
            }else{
                logger.info("Employee id not found");
            }
        }
        catch(Exception e)
        {
            logger.info("Employee id not found");

        }
    }
    public void permanentJson(Connection conn) throws SQLException
    {

        String sqlquery = "SELECT id, name, age, salary, bonus FROM PermanentEmployee";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlquery);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("age", resultSet.getInt("age"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("bonus",resultSet.getInt("bonus"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }

    public void parttimeJson(Connection conn) throws SQLException
    {

        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, age, salary, hoursWorked  FROM PartTimeEmployee";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("age", resultSet.getInt("age"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("hoursWorked",resultSet.getInt("hoursWorked"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }
    public void contractJson(Connection conn) throws SQLException {
        String SELECT_EMPLOYEES_QUERY = "SELECT id, name, age, salary, contractPeriod  FROM ContractEmployee";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_EMPLOYEES_QUERY);
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next())
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", resultSet.getInt("id"));
            jsonObject.put("name", resultSet.getString("name"));
            jsonObject.put("age", resultSet.getInt("age"));
            jsonObject.put("salary", resultSet.getInt("salary"));
            jsonObject.put("contractPeriod",resultSet.getInt("contractPeriod"));
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray);
    }


}

