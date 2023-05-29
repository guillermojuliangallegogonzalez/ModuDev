package calendario;

import java.time.ZonedDateTime;

public class CalendarioActivity {
    private ZonedDateTime date;
    private String clientName;
    private Integer serviceNo;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CalendarioActivity(ZonedDateTime date, String clientName, Integer serviceNo) {
        this.date = date;
        this.clientName = clientName;
        this.serviceNo = serviceNo;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(Integer serviceNo) {
        this.serviceNo = serviceNo;
    }

    @Override
    public String toString() {
        return "CalenderActivity{" +
                "date=" + date +
                ", clientName='" + clientName + '\'' +
                ", serviceNo=" + serviceNo +
                '}';
    }
}
