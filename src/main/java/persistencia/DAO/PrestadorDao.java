package persistencia.DAO;

import persistencia.Dao.IDao;
import entidades.Prestador;  // Asegúrate de importar la clase Prestador adecuada
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class PrestadorDao implements IDao<Prestador, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public PrestadorDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void crear(Prestador model) {
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
    public Prestador buscar(Long idModel) {
        Prestador prestador;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            prestador = entityManager.find(Prestador.class, idModel);
        }
        return prestador;
    }

    @Override
    public void actualizar(Prestador model) {
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
    public void borrar(Prestador model) {
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
    public List<Prestador> leerTodos() {
        List<Prestador> prestadores;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Query query = entityManager.createQuery("FROM Prestador", Prestador.class);
            prestadores = query.getResultList();
        }
        return prestadores;
    }
}

