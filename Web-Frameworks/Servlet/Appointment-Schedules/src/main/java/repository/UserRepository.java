package repository;

import models.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");

    public UserDTO findUserById(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(UserDTO.class, id);
        }
    }

    public int registerUser(UserDTO user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user.getId();
        }
    }

    public UserDTO findUserByUsername(String username) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT u FROM UserDTO u WHERE u.username = :username",
                    UserDTO.class)
                .setParameter("username", username)
                .getSingleResult();
        }
    }

}

