import java.util.Objects;

public class Employee {
    public String name;
    public double baseSalary;
    public static int employeeID=0 ;
    Employee manager;

    public Employee(String name) {
        this.name = name;
//        employeeID++;
    }

    public static void setEmployeeID(int employeeID) {
        Employee.employeeID = employeeID;
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        employeeID++;
        return employeeID;
    }

    public Employee getManager() {
        return manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", EmployeeID=" + employeeID +
                '}';
    }

    public String employeeStatus() {
        String s = null;
        return s;
    }

}
