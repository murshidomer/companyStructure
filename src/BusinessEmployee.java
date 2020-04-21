public class BusinessEmployee extends Employee {
    public static double bonusBudget;
    public double budget;
    public double salary;

    public BusinessEmployee(String name) {
        super(name);
        salary = 50000;
    }

    public Double getBonusBudget() {
        return bonusBudget;
    }

    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + name + " with a budget of " + budget;
    }
}
