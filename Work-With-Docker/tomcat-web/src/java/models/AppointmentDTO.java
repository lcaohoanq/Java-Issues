package models;

import java.util.Date;


public class AppointmentDTO {

    private int id;
    private int userId;
    private Date appointmentDate;
    private Date appointmentTime;
    private String purpose;
    private String status;

    public AppointmentDTO(int id, int userId, Date appointmentDate, Date appointmentTime, String purpose, String status) {
        this.id = id;
        this.userId = userId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.purpose = purpose;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getStatus() {
        return status;
    }


}
