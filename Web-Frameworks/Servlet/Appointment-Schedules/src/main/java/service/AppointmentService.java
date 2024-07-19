package service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import models.AppointmentDTO;
import repository.AppointmentRepository;

public class AppointmentService {

    private final AppointmentRepository appointmentRepository = new AppointmentRepository();

    public int addAppointment(AppointmentDTO appointment) {
        return appointmentRepository.addAppointment(appointment);
    }

    public int deleteAppointment(int id) {
        return appointmentRepository.deleteAppointment(id);
    }

    public int editAppointment(AppointmentDTO appointment) {
        return appointmentRepository.editAppointment(appointment);
    }

    public int cancelAppointment(int id) {
        return appointmentRepository.cancelAppointment(id);
    }

    public int openAppointment(int id) {
        return appointmentRepository.openAppointment(id);
    }

    public int completedAppointment(int id) {
        return appointmentRepository.completedAppointment(id);
    }

    public AppointmentDTO findAppointmentById(int id) {
        return appointmentRepository.findAppointmentById(id);
    }


    public static void main(String[] args) {
        try{
            AppointmentService appointmentService = new AppointmentService();
            System.out.println(appointmentService.addAppointment(new AppointmentDTO(1, new Timestamp(10), new Time(10), "Test")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
