package model.dao;

import model.entity.Mecanico;
import model.entity.Reparacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class ReparacionDAO implements InterfaceDAO<Reparacion>{
    private EntityManagerFactory emf;
    private EntityManager manager;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        manager = emf.createEntityManager();
    }

    public ReparacionDAO() {
        initHibernate();
    }

    /*
     * Metodo que inserta una reparacion
     */
    @Override
    public void create(Reparacion reparacion) {
        try {
            manager.getTransaction().begin();
            manager.persist(reparacion);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al crear la reparacion" + exception);
        }
    }

    /*
     * Metodo que devuelve todos las reparaciones
     */
    @Override
    public List<Reparacion> findAll() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select r from Reparacion r");
            manager.getTransaction().commit();
            List<Reparacion> list= query.getResultList();
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar las reparaciones" + exception);
        }
        return null;
    }

    /*
     * Metodo que busca una reparacion por su id
     */
    @Override
    public Reparacion find(int idReparacion) {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select r from Reparacion r where r.idReparacion= :idReparacion");
            query.setParameter("idReparacion",idReparacion);
            manager.getTransaction().commit();
            Reparacion r = (Reparacion) query.getSingleResult();
            return r;
        }catch (Exception exception){
            System.out.println("Error en listado de la reparacion " + exception);
        }
        return null;
    }


    /*
     * Metodo que actualiza los datos de una reparacion
     */
    @Override
    public void update(Reparacion reparacionAntigua) {
        try {
            manager.getTransaction().begin();
            manager.merge(reparacionAntigua);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al actualizar la reparacion" + exception);
        }
    }

    /*
     * Metodo que elimina una reparacion por su id
     */
    @Override
    public void delete(int idReparacion) {
        try{
            manager.getTransaction().begin();
            Query q=manager.createQuery("delete from Reparacion r where r.idReparacion= :idReparacion");
            q.setParameter("idReparacion",idReparacion);
            int del= q.executeUpdate();
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al borrar la reparacion" + exception);
        }
    }

    /*
    * Metodo que devuelve una reparacion segun su id
     */
    public Reparacion devolverReparacion(int idReparacion) {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select r from Reparacion r where r.idReparacion= :idReparacion");
            query.setParameter("idReparacion",idReparacion);
            manager.getTransaction().commit();
            Reparacion reparacion = (Reparacion) query.getSingleResult();
            return reparacion;
        }catch (Exception exception){
            System.out.println("Error al devolver la reparacion " + exception);
            return null;
        }
    }

    /*
    Metodo que asigna la fecha final de una reparacion y que elimina
    la reparacion de la lista de reparaciones de los mecanicos que la
    tengan asignada
     */
    public void finalizarReparacion(int id, Date fechaFin) {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("update Reparacion r set r.fechaFin = :fechaFin where r.idReparacion = :idReparacion");
            query.setParameter("fechaFin", fechaFin);
            query.setParameter("idReparacion",id);
            int up= query.executeUpdate();
            manager.getTransaction().commit();
            MecanicoDAO mecanico = new MecanicoDAO();
            Reparacion reparacion = devolverReparacion(id);
            manager.getTransaction().begin();
            List<Mecanico> mecanicos = mecanico.findAll();
            //recorrer mecanicos
            for (Mecanico mecanico1 : mecanicos) {
                mecanico.deleteReparacion(mecanico1, reparacion);
            }
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al finalizar la reparacion" + exception);
        }
    }
}
