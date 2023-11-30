package persistencia.Repository;

import persistencia.DAO.PrestadorDao;
import entidades.Prestador; 
import java.util.List;

public class PrestadorRepository {

    private PrestadorDao prestadorDao;

    public PrestadorRepository(PrestadorDao prestadorDao) {
        this.prestadorDao = prestadorDao;
    }

    public void add(Prestador prestador) {
        System.err.println("Crear prestador en PrestadorRepository");
        prestadorDao.crear(prestador);
    }

    public Prestador buscar(int idPrestador) {
        return prestadorDao.buscar((long) idPrestador);
    }

    public void actualizar(Prestador prestador) {
        prestadorDao.actualizar(prestador);
    }

    public void delete(Prestador prestador) {
        prestadorDao.borrar(prestador);
    }

    public List<Prestador> listarTodos() {
        return prestadorDao.leerTodos();
    }
}
