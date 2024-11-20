package Bean;

public class Staff {
    private String staffName;
    private String staffSex;
    private String staffAge;
    private String staffEducation;
    private String staffDepartment;
    private String staffDate;
    private String staffDuty;
    private String staffWage;


    public Staff() {
    }

    public Staff(String staffName, String staffSex, String staffAge, String staffEducation, String staffDepartment, String staffDate, String staffDuty, String staffWage) {
        this.staffName = staffName;
        this.staffSex = staffSex;
        this.staffAge = staffAge;
        this.staffEducation = staffEducation;
        this.staffDepartment = staffDepartment;
        this.staffDate = staffDate;
        this.staffDuty = staffDuty;
        this.staffWage = staffWage;
    }

    /**
     * 获取
     * @return staffName
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置
     * @param staffName
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取
     * @return staffSex
     */
    public String getStaffSex() {
        return staffSex;
    }

    /**
     * 设置
     * @param staffSex
     */
    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    /**
     * 获取
     * @return staffAge
     */
    public String getStaffAge() {
        return staffAge;
    }

    /**
     * 设置
     * @param staffAge
     */
    public void setStaffAge(String staffAge) {
        this.staffAge = staffAge;
    }

    /**
     * 获取
     * @return staffEducation
     */
    public String getStaffEducation() {
        return staffEducation;
    }

    /**
     * 设置
     * @param staffEducation
     */
    public void setStaffEducation(String staffEducation) {
        this.staffEducation = staffEducation;
    }

    /**
     * 获取
     * @return staffDepartment
     */
    public String getStaffDepartment() {
        return staffDepartment;
    }

    /**
     * 设置
     * @param staffDepartment
     */
    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    /**
     * 获取
     * @return staffDate
     */
    public String getStaffDate() {
        return staffDate;
    }

    /**
     * 设置
     * @param staffDate
     */
    public void setStaffDate(String staffDate) {
        this.staffDate = staffDate;
    }

    /**
     * 获取
     * @return staffDuty
     */
    public String getStaffDuty() {
        return staffDuty;
    }

    /**
     * 设置
     * @param staffDuty
     */
    public void setStaffDuty(String staffDuty) {
        this.staffDuty = staffDuty;
    }

    /**
     * 获取
     * @return staffWage
     */
    public String getStaffWage() {
        return staffWage;
    }

    /**
     * 设置
     * @param staffWage
     */
    public void setStaffWage(String staffWage) {
        this.staffWage = staffWage;
    }

    public String toString() {
        return "Staff{staffName = " + staffName + ", staffSex = " + staffSex + ", staffAge = " + staffAge + ", staffEducation = " + staffEducation + ", staffDepartment = " + staffDepartment + ", staffDate = " + staffDate + ", staffDuty = " + staffDuty + ", staffWage = " + staffWage + "}";
    }
}
