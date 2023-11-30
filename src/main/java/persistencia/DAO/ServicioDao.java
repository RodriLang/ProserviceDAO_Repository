package persistencia.DAO;

import persistencia.Dao.IDao;
import entidades.Servicio;  // Asegúrate de importar la clase Servicio adecuada
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class ServicioDao implements IDao<Servicio, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public ServicioDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void crear(Servicio model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(model);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Servicio buscar(Long idModel) {
        Servicio servicio;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            servicio = entityManager.find(Servicio.class, idModel);
        }
        return servicio;
    }

    @Override
    public void actualizar(Servicio model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(model);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void borrar(Servicio model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(model) ? model : entityManager.merge(model));
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Servicio> leerTodos() {
        List<Servicio> servicios;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Query query = entityManager.createQuery("FROM Servicio", Servicio.class);
            servicios = query.getResultList();
        }
        return servicios;
    }
}