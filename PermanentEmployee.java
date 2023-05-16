package org.example;

class PermanentEmployee extends Employee {
    int bonus;

    public PermanentEmployee(int id, String name, int age, int salary, int bonus) {
        super(id, name, age, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
