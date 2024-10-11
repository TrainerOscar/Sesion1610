package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Crear el EntityManagerFactory con la configuración "sesion16" (nombre de la unidad de persistencia)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sesion16");
        EntityManager em = emf.createEntityManager();

        try {
            // Iniciar la transacción
            em.getTransaction().begin();

            // Crear un nuevo estudiante
            Student student = new Student();
            student.setCif("12345");
            student.setFirstName("John");
            student.setLastName("Doe");
            student.setEmail("johndoe@example.com");

            // Persistir el nuevo estudiante
            em.persist(student);

            // Crear una nueva ciudad
            City city = new City();
            city.setName("New York");
            city.setState(true);

            // Persistir la nueva ciudad
            em.persist(city);

            // Commit de la transacción
            em.getTransaction().commit();

            // Consulta: obtener todos los estudiantes
            List<Student> students = em.createNamedQuery("Student.findAll", Student.class).getResultList();
            System.out.println("Lista de estudiantes:");
            for (Student s : students) {
                System.out.println(s);
            }

            // Consulta: obtener todas las ciudades
            List<City> cities = em.createNamedQuery("City.findAll", City.class).getResultList();
            System.out.println("Lista de ciudades:");
            for (City c : cities) {
                System.out.println(c);
            }

        } catch (Exception e) {
            // Si algo sale mal, revertir la transacción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar el EntityManager y el EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
