package org.example;

public class ContractEmployee extends Employee
{
    private int contractPeriod;
    public ContractEmployee(int id, String name, int age, int salary, int contractPeriod)
    {
        super(id, name, age, salary);
        this.contractPeriod = contractPeriod;
    }
    public int getContractPeriod()
    {
        return contractPeriod;
    }
    public void setContractPeriod(int contractPeriod)
    {
        this.contractPeriod = contractPeriod;
    }

}
