public class SoftwareEngineer extends TechnicalEmployee {
    boolean codeAccess;

    public SoftwareEngineer(String name) {
        super(name);
        codeAccess = false;
        checkins = 0;
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean codeAccess) {
        this.codeAccess = codeAccess;
    }

    public int getSuccesfulCheckins() {
        return checkins;
    }

    public boolean checkinCode() {
        boolean approvalStatus = this.getCodeAccess();
        manager = this.getManager();
        if (approvalStatus) {
            setCodeAccess(true);
            checkins++;
            return true;
        } else {
            setCodeAccess(false);
            return false;
        }
    }
}
