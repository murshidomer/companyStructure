public class TechnicalEmployee extends Employee {
    int checkins;

    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + name + " has " + checkins + " successful check ins";
    }

    public TechnicalEmployee(String name) {
        super(name);
        baseSalary = 75000;
    }
}
