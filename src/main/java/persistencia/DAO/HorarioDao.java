package persistencia.DAO;

import persistencia.Dao.IDao;
import entidades.Horario;  // Asegúrate de importar la clase Horario adecuada
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.util.List;

public class HorarioDao implements IDao<Horario, Long> {

    private final EntityManagerFactory entityManagerFactory;

    public HorarioDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void crear(Horario model) {
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
    public Horario buscar(Long idModel) {
        Horario horario;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            horario = entityManager.find(Horario.class, idModel);
        }
        return horario;
    }

    @Override
    public void actualizar(Horario model) {
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
    public void borrar(Horario model) {
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
    public List<Horario> leerTodos() {
        List<Horario> horarios;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            Query query = entityManager.createQuery("FROM Horario", Horario.class);
            horarios = query.getResultList();
        }
        return horarios;
    }
}
