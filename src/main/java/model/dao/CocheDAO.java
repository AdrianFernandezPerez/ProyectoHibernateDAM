package model.dao;

import model.entity.Coche;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CocheDAO implements InterfaceDAO<Coche>{
    private EntityManagerFactory emf;
    private EntityManager manager;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        manager = emf.createEntityManager();
    }

    public CocheDAO() {
        initHibernate();
    }

    /*
     * Metodo que inserta un coche
     */
    @Override
    public void create(Coche coche) {
        try {
            manager.getTransaction().begin();
            manager.persist(coche);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al crear el coche" + exception);
        }
    }

    /*
     * Metodo que devuelve todos los coches
     */
    @Override
    public List<Coche> findAll() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select c from Coche c");
            List<Coche> list= query.getResultList();
            manager.getTransaction().commit();
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar los coches" + exception);
        }
        return null;
    }

    /*
     * Metodo que busca un coche por su id
     */
    @Override
    public Coche find(int idCoche) {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select c from Coche c where c.idVehiculo= :idCoche");
            query.setParameter("idCoche",idCoche);
            manager.getTransaction().commit();
            Coche c = (Coche) query.getSingleResult();
            return c;
        }catch (Exception exception){
            System.out.println("Error en listado del coche " + exception);

        }
        return null;
    }


    /*
     * Metodo que actualiza los datos de un coche
     */
    @Override
    public void update(Coche cocheAntiguo) {
        try {
            manager.getTransaction().begin();
            manager.merge(cocheAntiguo);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al actualizar el coche" + exception);
        }
    }

    /*
     * Metodo que elimina un coche por su id
     */
    @Override
    public void delete(int idCoche) {
        try{
            manager.getTransaction().begin();
            Query q=manager.createQuery("delete from Coche c where c.idVehiculo= :idVehiculo");
            q.setParameter("idVehiculo",idCoche);
            int del= q.executeUpdate();
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al borrar el coche" + exception);
        }
    }
}
