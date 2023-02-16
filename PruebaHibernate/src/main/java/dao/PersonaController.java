package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import persistence.Persona;
import java.util.List;

public class PersonaController {

    public PersonaController() {
    }

    public void crearPersona(Persona persona) {

        /* Permite interactuar con la base de datos, realizar operaciones CRUD */
        EntityManager entityManager = HibernateUtil.getEntityManager();

        /* Permite gestionar las transacciones en la base de datos */
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            /* Se inicia la transacción llamando al método "begin()" de la clase EntityTransaction. */
            transaction.begin();

            /* Si la entidad existe en la base de datos, la función merge actualiza los valores de la entidad con los valores de la entidad enviada como parámetro. */
            entityManager.merge(persona);

            /* Se confirma la transacción llamando al método "commit()" de la clase EntityTransaction. */
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public List<Persona> listarPersonas() {

        /* Permite interactuar con la base de datos, realizar operaciones CRUD */
        EntityManager entityManager = HibernateUtil.getEntityManager();

        /* Permite gestionar las transacciones en la base de datos */
        EntityTransaction transaction = entityManager.getTransaction();

        List<Persona> personas = null;

        try {
            transaction.begin();
            personas = entityManager.createQuery("from Persona", Persona.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return personas;
    }

    public void eliminarPersona(int id) {

        /* Permite interactuar con la base de datos, realizar operaciones CRUD */
        EntityManager entityManager = HibernateUtil.getEntityManager();

        /* Permite gestionar las transacciones en la base de datos */
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            /* Se inicia la transacción llamando al método "begin()" de la clase EntityTransaction. */
            transaction.begin();

            /* Se recupera la entidad a partir de su identificador */
            Persona persona = entityManager.find(Persona.class, id);

            /* Se elimina la entidad invocando el método "remove" en el objeto EntityManager */
            entityManager.remove(persona);

            /* Se confirma la transacción llamando al método "commit()" de la clase EntityTransaction. */
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void actualizarPersona(int id, String nombres, String apellido) {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            /* Recupera el objeto a partir de su ID */
            Persona persona = entityManager.find(Persona.class, id);

            /* Verifica si existe una persona con el ID dado */
            if (persona == null) {
                System.out.println("No se encontró ninguna persona con el ID " + id);
                return;
            }

            /* Actualiza los atributos del objeto */
            persona.setNombres(nombres);
            persona.setApellidos(apellido);

            /* Actualiza el objeto en la base de datos */
            entityManager.merge(persona);

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }


}
