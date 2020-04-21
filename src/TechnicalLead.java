import java.util.ArrayList;
import java.util.Iterator;

public class TechnicalLead extends TechnicalEmployee {
    public int headCount;
    SoftwareEngineer softwareEngineer;
    ArrayList<SoftwareEngineer> directReports = new ArrayList<>();

    public TechnicalLead(String name) {
        super(name);
        baseSalary *= 1.3;
        headCount = 4;
        manager = this;
    }

    public boolean hasHeadCount() {
        return this.directReports.size()<headCount; 
    }

    public boolean addReport(SoftwareEngineer e) {
        this.softwareEngineer = e;
        if (this.hasHeadCount()) {
            try {
                directReports.add(this.softwareEngineer);
            } catch (Exception exception) {
                exception.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean approveCheckin(SoftwareEngineer engineer) {
        return engineer.getManager() == this && engineer.codeAccess;
    }

    public boolean requestBonus(Employee e, double bonus) {
        //approved by businesslead supporting this technicallead
        //find out who supports this technicallead
        //through software engineer object

        return true;
    }

    public String getTeamStatus() {
        String teamStatus;
        StringBuilder temp = new StringBuilder();
        String concatString;
        if (!(this.directReports.isEmpty())) {
            teamStatus = employeeStatus() + " and is managing";
            Iterator<SoftwareEngineer> listIterator = directReports.iterator();
            while (listIterator.hasNext()) {
                //String append
                SoftwareEngineer currentSoftwareEngineer = listIterator.next();
                temp.append("\n").append(currentSoftwareEngineer.getEmployeeID()).append(" ")
                        .append(currentSoftwareEngineer.name).append(" has ")
                        .append(currentSoftwareEngineer.getSuccesfulCheckins())
                        .append(" succssful checkins");
            }
            concatString = teamStatus.concat(temp.toString());
        } else {
            teamStatus = employeeStatus() + " and no direct reports yet";
            return teamStatus;
        }
        return concatString;
    }
}
