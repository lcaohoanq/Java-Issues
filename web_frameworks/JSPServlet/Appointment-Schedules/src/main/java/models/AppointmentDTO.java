package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Appointments")
public class AppointmentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "appointmentDate")
    private Timestamp appointmentDate;

    @Column(name = "appointmentTime")
    private Date appointmentTime;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "status")
    private String status;

    public AppointmentDTO(int userId, Timestamp appointmentDate, Date appointmentTime, String purpose) {
        this.userId = userId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.purpose = purpose;
    }

}
