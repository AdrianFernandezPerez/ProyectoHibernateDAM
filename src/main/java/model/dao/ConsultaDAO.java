package model.dao;

import model.entity.Cliente;
import model.entity.Mecanico;
import model.entity.Reparacion;
import view.MecanicoView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ConsultaDAO {
    private EntityManagerFactory emf;
    private EntityManager manager;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        manager = emf.createEntityManager();
    }

    public ConsultaDAO() {
        initHibernate();
    }

    /*
    * Metodo que devuelve una lista de reparaciones sin finalizar
     */
    public List<Reparacion> findSinFinalizar() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select r from Reparacion r where r.fechaFin is null");
            List<Reparacion> list= query.getResultList();
            manager.getTransaction().commit();
            return list;
        }catch (Exception exception){
            System.out.println("Error al listar las reparaciones sin finalizar " + exception);
        }
            return null;
    }

    /*
    * Metodo que devuelve los clientes que tienen asignados un coche
     */
    public List<Cliente> findClientesConCoche() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select c from Cliente c inner join Coche co on c.idCliente = co.cliente.idCliente");
            List<Cliente> list= query.getResultList();
            manager.getTransaction().commit();
            return list;
        } catch (Exception exception) {
            System.out.println("Error al listar los clientes con coche " + exception);
        }
        return null;
    }

    public List<Mecanico> findMecanicosConReparaciones() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select m from Mecanico m where m.reparaciones.size > 0");
            List<Mecanico> list= query.getResultList();
            manager.getTransaction().commit();
            return list;
        } catch (Exception exception) {
            System.out.println("Error al listar los mecanicos con reparaciones " + exception);
        }
        return null;
    }
}
