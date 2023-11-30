package persistencia.Repository;

import persistencia.DAO.HorarioDao;
import entidades.Horario;
import java.util.List;

public class HorarioRepository {

    private HorarioDao horarioDao;

    public HorarioRepository(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }

    public void add(Horario horario) {
        horarioDao.crear(horario);
    }

    public Horario buscar(int idHorario) {
        return horarioDao.buscar((long) idHorario);
    }

    public void actualizar(Horario horario) {
        horarioDao.actualizar(horario);
    }

    public void delete(Horario horario) {
        horarioDao.borrar(horario);
    }

    public List<Horario> listarTodos() {
        return horarioDao.leerTodos();
    }
}

