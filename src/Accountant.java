public class Accountant extends BusinessEmployee{
    TechnicalLead lead;
    TechnicalLead technicalLead;
    public Accountant(String name) {
        super(name);
        bonusBudget = 0;
        lead = null;
    }

    public TechnicalLead getTeamSupported() {
        if (lead ==null) return null;
        else return this.lead;
    }

    public void supportTeam(TechnicalLead lead) {
        int reporteesSize;
        double commission, totalBaseSalaries;
        this.lead = lead;
//        Iterator<SoftwareEngineer> reportees = lead.directReports.listIterator();
        reporteesSize = lead.directReports.size();
        totalBaseSalaries = baseSalary * reporteesSize;
        commission = (totalBaseSalaries * 10/100);
        bonusBudget = totalBaseSalaries + commission;
    }


    public boolean approveBonus(double bonus) {
        if (this.getTeamSupported()==null) return false;
        return !(bonus > bonusBudget);
    }

    @Override
    public String employeeStatus() {
        return getEmployeeID() + " " + name + " with a budget of " + budget + " is supporting "
                + getTeamSupported();
    }
}
