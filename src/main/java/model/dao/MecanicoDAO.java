package model.dao;


import model.entity.Mecanico;
import model.entity.Reparacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MecanicoDAO implements InterfaceDAO<Mecanico>{
    private EntityManagerFactory emf;
    private EntityManager manager;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        manager = emf.createEntityManager();
    }

    public MecanicoDAO() {
        initHibernate();
    }

    /*
     * Metodo que inserta un mecanico
     */
    @Override
    public void create(Mecanico mecanico) {
        try {
            manager.getTransaction().begin();
            manager.persist(mecanico);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al crear el mecanico" + exception);

        }
    }


    /*
     * Metodo que busca un mecanico por su id
     */
    @Override
    public Mecanico find(int idMecanico) {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select m from Mecanico m where m.idMecanico= :idMecanico");
            query.setParameter("idMecanico",idMecanico);
            manager.getTransaction().commit();
            Mecanico m= (Mecanico) query.getSingleResult();
            return m;
        }catch (Exception exception){
            System.out.println("Error en listado del mecanico " + exception);
        }
        return null;
    }

    /*
     * Metodo que devuelve un objeto mecanido segun su id
     */
    public Mecanico devolverMecanico(int idMecanico){
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select m from Mecanico m where m.idMecanico= :idMecanico");
            query.setParameter("idMecanico",idMecanico);
            manager.getTransaction().commit();
            Mecanico mecanico = (Mecanico) query.getSingleResult();
            return mecanico;
        }catch (Exception exception){
            System.out.println("Error al devolver el mecanico " + exception);
            return null;
        }
    }


    /*
     * Metodo que actualiza los datos de un mecanico
     */
    public void update(Mecanico mecanicoAntiguo) {
        try {
            manager.getTransaction().begin();
            manager.merge(mecanicoAntiguo);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al actualizar el mecanico" + exception);
        }
    }

    /*
     * Metodo que elimina un mecanico por su id
     */
    @Override
    public void delete(int idMecanico) {
        try{
            manager.getTransaction().begin();
            Query q=manager.createQuery("delete from Mecanico m where m.idMecanico= :idMecanico");
            q.setParameter("idMecanico",idMecanico);
            int del= q.executeUpdate();
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al borrar el mecanico" + exception);
        }
    }

    /*
    Metodo para añadir reparaciones a un mecanico
     */
    public void addReparacion(Mecanico mecanico, Reparacion reparacion){
        try{
            manager.getTransaction().begin();
            mecanico.setReparaciones(reparacion);
            manager.getTransaction().commit();
        } catch (Exception exception){
            System.out.println("Error al añadir una reparacion" + exception);

        }
    }

    /*
    Metodo para eliminar una reparacion de un mecanico
     */
    public void deleteReparacion(Mecanico mecanico, Reparacion reparacion){
        try{
            manager.getTransaction().begin();
            mecanico.deleteReparacion(reparacion);
            manager.getTransaction().commit();

        } catch (Exception exception){
            System.out.println("Error al eliminar una reparacion" + exception);
        }
    }

    /*
    Metodo que devuelve las reparaciones de un mecanico
     */
    public List<Reparacion> devolverReparaciones(Mecanico mecanico) {
        try{
            manager.getTransaction().begin();
            List<Reparacion> reparaciones = mecanico.getReparaciones();
            manager.getTransaction().commit();
            return reparaciones;
        }catch (Exception exception){
            System.out.println("Error al devolver las reparaciones del mecanico" + exception);
        }
        return null;
    }

    /*
    Metodo que devuelve todos los mecanicos existentes
     */
    @Override
    public List<Mecanico> findAll() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select m from Mecanico m");
            List<Mecanico> list= query.getResultList();
            manager.getTransaction().commit();
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar los mecanicos" + exception);
        }
        return null;
    }



}
