package one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create employees
        EmployeeV2 employee1 = new EmployeeV2("John Doe");
        EmployeeV2 employee2 = new EmployeeV2("Jane Doe");

        // Create parking spots
        ParkingSpot parkingSpot1 = new ParkingSpot("A1");
        ParkingSpot parkingSpot2 = new ParkingSpot("B1");

        // Assign parking spots to employees
        employee1.setParkingSpot(parkingSpot1);
        employee2.setParkingSpot(parkingSpot2);

        // Persist employees (and parking spots via cascade)
        em.persist(employee1);
        em.persist(employee2);

        em.getTransaction().commit();

        // Fetch and print data
        TypedQuery<EmployeeV2> query = em.createQuery("SELECT e FROM EmployeeV2 e", EmployeeV2.class);
        for (EmployeeV2 employee : query.getResultList()) {
            System.out.println("Employee: " + employee.getName());
            System.out.println("  Parking Spot: " + employee.getParkingSpot().getSpotNumber());
        }

        em.close();
        emf.close();
    }
}
