package persistencia.DAO;

import persistencia.Dao.IDao;
import entidades.Contrato;  // Asegúrate de importar la clase Contrato adecuada
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class ContratoDao implements IDao<Contrato, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public ContratoDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void crear(Contrato model) {
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
    public Contrato buscar(Long idModel) {
        Contrato contrato;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            contrato = entityManager.find(Contrato.class, idModel);
        }
        return contrato;
    }

    @Override
    public void actualizar(Contrato model) {
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
    public void borrar(Contrato model) {
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
    public List<Contrato> leerTodos() {
        List<Contrato> contratos;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Query query = entityManager.createQuery("FROM Contrato", Contrato.class);
            contratos = query.getResultList();
        }
        return contratos;
    }
}
