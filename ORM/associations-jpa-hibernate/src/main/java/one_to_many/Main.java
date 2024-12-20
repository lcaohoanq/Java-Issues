package one_to_many;

import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create departments
        Department department1 = new Department("HR");
        Department department2 = new Department("IT");

        // Create employees
        Employee employee1 = new Employee("John Doe");
        Employee employee2 = new Employee("Jane Doe");
        Employee employee3 = new Employee("Alice Smith");
        Employee employee4 = new Employee("Bob Brown");

        // Assign employees to departments
        department1.addEmployee(employee1);
        department1.addEmployee(employee2);
        department2.addEmployee(employee3);
        department2.addEmployee(employee4);

        // Persist departments (and employees via cascade)
        em.persist(department1);
        em.persist(department2);

        em.getTransaction().commit();

        // Fetch and print data
        TypedQuery<Department> query = em.createQuery("SELECT d FROM Department d", Department.class);
        for (Department department : query.getResultList()) {
            System.out.println("Department: " + department.getName());
            for (Employee employee : department.getEmployees()) {
                System.out.println("  Employee: " + employee.getName());
            }
        }

        em.close();
        emf.close();
    }

}
