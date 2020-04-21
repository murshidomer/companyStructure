import java.util.ArrayList;
import java.util.Iterator;

public class BusinessLead extends BusinessEmployee {
    public int headcount;
    Accountant accountant;
    ArrayList<Accountant> directReports = new ArrayList<>();

    public BusinessLead(String name) {
        super(name);
        baseSalary = salary * 2;
        headcount = 10;
//        this.setManager(this);
        manager = this;
    }


    public boolean hasHeadCount() {
        return this.directReports.size() < headcount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        this.accountant = e;
        if (this.hasHeadCount()) {
            try {
                directReports.add(this.accountant);
                bonusBudget = 1.1 * e.baseSalary;
                e.supportTeam(supportTeam);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus < this.budget) {
            //how does the employee get the bonus?
            this.budget -= bonus;
            return true;
        } else return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        if (!this.directReports.isEmpty()) {
            for (Accountant currentAccountant : directReports) {
                //any accountants supporting technical lead that is the manager of the employee passed in
                if (currentAccountant.getTeamSupported() == e.getManager() &&
                        currentAccountant.budget > bonus) {
                    currentAccountant.budget -= bonus;
                    return true;
                }
            }
        }
        return false;
    }

    public String getTeamStatus() {
        String teamStatus;
        StringBuilder temp = new StringBuilder();
        String concatString;
        if (!(this.directReports.isEmpty())) {
            teamStatus = employeeStatus() + " and is managing";
            Iterator<Accountant> listIterator = directReports.iterator();
            while (listIterator.hasNext()) {
                //String append
                Accountant currentAccountant = listIterator.next();
                temp.append("\n").append(currentAccountant.getEmployeeID()).append(" ")
                        .append(currentAccountant.name).append(" supports ")
                        .append(currentAccountant.getTeamSupported());
//                        .append(" successful checkins");
            }
            concatString = teamStatus.concat(temp.toString());
        } else {
            teamStatus = employeeStatus() + " and no direct reports yet";
            return teamStatus;
        }
        return concatString;
    }

}

