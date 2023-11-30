package persistencia.DAO;

import entidades.Consumidor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class ConsumidorDao implements IDao<Consumidor, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public ConsumidorDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void crear(Consumidor model) {
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
    public Consumidor buscar(Long idModel) {
        Consumidor consumidor;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            consumidor = entityManager.find(Consumidor.class, idModel);
        }
        return consumidor;
    }

    @Override
    public void actualizar(Consumidor model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = (EntityTransaction) entityManager.getTransaction();

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
    public void borrar(Consumidor model) {
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
    public List<Consumidor> leerTodos() {
        List<Consumidor> consumidores;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Query query = entityManager.createQuery("FROM Consumidor", Consumidor.class);
            consumidores = query.getResultList();
        }
        return consumidores;
    }
}

