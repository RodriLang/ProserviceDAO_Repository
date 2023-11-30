package persistencia.Repository;

import persistencia.DAO.ContratoDao;
import entidades.Contrato;
import java.util.List;

public class ContratoRepository {

    private ContratoDao contratoDao;

    public ContratoRepository(ContratoDao contratoDao) {
        this.contratoDao = contratoDao;
    }

    public void add(Contrato contrato) {
        contratoDao.crear(contrato);
    }

    public Contrato buscar(int idContrato) {
        return contratoDao.buscar((long) idContrato);
    }

    public void actualizar(Contrato contrato) {
        contratoDao.actualizar(contrato);
    }

    public void delete(Contrato contrato) {
        contratoDao.borrar(contrato);
    }

    public List<Contrato> listarTodos() {
        return contratoDao.leerTodos();
    }
}
