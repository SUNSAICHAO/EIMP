package Bean;

public class Cs {
    private String clientName;
    private String clientOpinion;
    private String StaffName;

    public Cs() {
    }

    public Cs(String clientName, String clientOpinion, String StaffName) {
        this.clientName = clientName;
        this.clientOpinion = clientOpinion;
        this.StaffName = StaffName;
    }

    /**
     * 获取
     * @return clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取
     * @return clientOpinion
     */
    public String getClientOpinion() {
        return clientOpinion;
    }

    /**
     * 设置
     * @param clientOpinion
     */
    public void setClientOpinion(String clientOpinion) {
        this.clientOpinion = clientOpinion;
    }

    /**
     * 获取
     * @return StaffName
     */
    public String getStaffName() {
        return StaffName;
    }

    /**
     * 设置
     * @param StaffName
     */
    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public String toString() {
        return "Cs{clientName = " + clientName + ", clientOpinion = " + clientOpinion + ", StaffName = " + StaffName + "}";
    }
}
