package persistencia.Repository;

import persistencia.DAO.ServicioDao;
import entidades.Servicio;
import java.util.List;

public class ServicioRepository {

    private ServicioDao servicioDao;

    public ServicioRepository(ServicioDao servicioDao) {
        this.servicioDao = servicioDao;
    }

    public void add(Servicio servicio) {
        servicioDao.crear(servicio);
    }

    public Servicio buscar(int idServicio) {
        return servicioDao.buscar((long) idServicio);
    }

    public void actualizar(Servicio servicio) {
        servicioDao.actualizar(servicio);
    }

    public void delete(Servicio servicio) {
        servicioDao.borrar(servicio);
    }

    public List<Servicio> listarTodos() {
        return servicioDao.leerTodos();
    }
}
