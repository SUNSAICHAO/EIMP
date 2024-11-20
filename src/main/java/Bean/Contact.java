package Bean;

public class Contact {
    private String clientName;
    private String contactName;
    private String contactContents;
    private String contactStart;
    private String contactEnd;
    private String StaffName;

    public Contact() {
    }

    public Contact(String clientName, String contactName, String contactContents, String contactStart, String contactEnd, String StaffName) {
        this.clientName = clientName;
        this.contactName = contactName;
        this.contactContents = contactContents;
        this.contactStart = contactStart;
        this.contactEnd = contactEnd;
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
     * @return contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取
     * @return contactContents
     */
    public String getContactContents() {
        return contactContents;
    }

    /**
     * 设置
     * @param contactContents
     */
    public void setContactContents(String contactContents) {
        this.contactContents = contactContents;
    }

    /**
     * 获取
     * @return contactStart
     */
    public String getContactStart() {
        return contactStart;
    }

    /**
     * 设置
     * @param contactStart
     */
    public void setContactStart(String contactStart) {
        this.contactStart = contactStart;
    }

    /**
     * 获取
     * @return contactEnd
     */
    public String getContactEnd() {
        return contactEnd;
    }

    /**
     * 设置
     * @param contactEnd
     */
    public void setContactEnd(String contactEnd) {
        this.contactEnd = contactEnd;
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
        return "Contact{clientName = " + clientName + ", contactName = " + contactName + ", contactContents = " + contactContents + ", contactStart = " + contactStart + ", contactEnd = " + contactEnd + ", StaffName = " + StaffName + "}";
    }
}
