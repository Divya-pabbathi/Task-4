package org.example;

public class PartTimeEmployee extends Employee
{
    private int hoursWorked;
    public PartTimeEmployee(int id, String name, int age, int salary, int hoursWorked)
    {
        super(id, name, age, salary);
        this.hoursWorked = hoursWorked;
    }
    public int getHoursWorked()
    {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }


}
