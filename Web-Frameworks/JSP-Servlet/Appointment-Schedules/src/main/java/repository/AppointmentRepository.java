package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import models.AppointmentDTO;

public class AppointmentRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppointmentPU");

    public int addAppointment(AppointmentDTO appointment) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(appointment);
            em.getTransaction().commit();
            return appointment.getId();
        }
    }

    public int deleteAppointment(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            AppointmentDTO appointment = em.find(AppointmentDTO.class, id);
            em.remove(appointment);
            em.getTransaction().commit();
            return appointment.getId();
        }
    }

    public int editAppointment(AppointmentDTO appointment) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(appointment);
            em.getTransaction().commit();
            return appointment.getId();
        }
    }

    public int cancelAppointment(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            AppointmentDTO appointment = em.find(AppointmentDTO.class, id);
            appointment.setStatus("Cancelled");
            em.getTransaction().commit();
            return appointment.getId();
        }
    }


    public int openAppointment(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            AppointmentDTO appointment = em.find(AppointmentDTO.class, id);
            appointment.setStatus("Scheduled");
            em.getTransaction().commit();
            return appointment.getId();
        }
    }

    public int completedAppointment(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            AppointmentDTO appointment = em.find(AppointmentDTO.class, id);
            appointment.setStatus("Completed");
            em.getTransaction().commit();
            return appointment.getId();
        }
    }

    public AppointmentDTO findAppointmentById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(AppointmentDTO.class, id);
        }
    }

}
