package persistencia.Repository;

import persistencia.DAO.ConsumidorDao;
import entidades.Consumidor;
import java.util.List;

public class ConsumidorRepository {

    private ConsumidorDao consumidorDao;

    public ConsumidorRepository(ConsumidorDao consumidorDao) {
        this.consumidorDao = consumidorDao;
    }

    public void add(Consumidor consumidor) {
        consumidorDao.crear(consumidor);
    }

    public Consumidor buscar(int idConsumidor) {
        return consumidorDao.buscar((long) idConsumidor);
    }

    public void actualizar(Consumidor consumidor) {
        consumidorDao.actualizar(consumidor);
    }

    public void delete(Consumidor consumidor) {
        consumidorDao.borrar(consumidor);
    }

    public List<Consumidor> listarTodos() {
        return consumidorDao.leerTodos();
    }
}
