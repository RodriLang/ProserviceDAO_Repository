
package main;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import persistencia.DAO.ConsumidorDao;
import persistencia.DAO.ContratoDao;
import persistencia.DAO.HorarioDao;
import persistencia.DAO.PrestadorDao;
import persistencia.DAO.ServicioDao;
import persistencia.Repository.ConsumidorRepository;
import persistencia.Repository.ContratoRepository;
import persistencia.Repository.HorarioRepository;
import persistencia.Repository.PrestadorRepository;
import persistencia.Repository.ServicioRepository;


public class Main {

 
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contrataciones");
        ConsumidorDao consumidorDao = new ConsumidorDao(emf);
        PrestadorDao prestadorDao = new PrestadorDao(emf);
        ContratoDao contratoDao = new ContratoDao(emf);
        ServicioDao servicioDao = new ServicioDao(emf);
        HorarioDao horarioDao = new HorarioDao(emf);
        ConsumidorRepository consumidorRepository = new ConsumidorRepository(consumidorDao);
        PrestadorRepository prestadorRepository = new PrestadorRepository(prestadorDao);
        ContratoRepository contratoRepository = new ContratoRepository(contratoDao);
        ServicioRepository servicioRepository = new ServicioRepository(servicioDao);
        HorarioRepository horarioRepository = new HorarioRepository(horarioDao);
        
    }

}
