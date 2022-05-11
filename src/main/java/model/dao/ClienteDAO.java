package model.dao;

import com.mysql.cj.jdbc.exceptions.SQLError;
import model.entity.Cliente;
import view.ClienteView;

import javax.persistence.*;
import java.util.List;


public class ClienteDAO implements InterfaceDAO<Cliente>{
    private EntityManagerFactory emf;
    private EntityManager manager;
    private ClienteView clienteView;

    private void initHibernate() {
        emf = Persistence.createEntityManagerFactory("default");
        manager = emf.createEntityManager();
        clienteView = new ClienteView();
    }

    public ClienteDAO() {
        initHibernate();
    }

    /*
    * Metodo que inserta un cliente
     */
    @Override
    public void create(Cliente cliente) {

        try {
            manager.getTransaction().begin();
            manager.persist(cliente);
            manager.getTransaction().commit();
            clienteView.muestraMensaje("-------Cliente añadido-------");
        } catch (Exception exception){
            System.out.println("Error al crear el cliente" + exception);
        }
    }


    /*
    * Metodo que lista todos los clientes
     */
    @Override
    public List<Cliente> findAll() {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select c from Cliente c");
            manager.getTransaction().commit();
            List<Cliente> list= query.getResultList();
            return list;
        }catch (Exception exception){
            System.out.println("Error al mostrar los clientes" + exception);
        }
        return null;
    }

    /*
    * Metodo que busca un cliente por su id
     */
    @Override
    public Cliente find(int idCliente) {
        try {
            manager.getTransaction().begin();
            Query query = manager.createQuery("select c from Cliente c where c.idCliente= :idCliente");
            query.setParameter("idCliente",idCliente);
            manager.getTransaction().commit();
            Cliente c = (Cliente) query.getSingleResult();
            return c;
        }catch (Exception exception){
            System.out.println("Error en listado del cliente " + exception);
        }
        return null;
    }




    /*
    * Metodo que actualiza los datos de un cliente
     */
    @Override
    public void update(Cliente clienteAntiguo) {
        try {
            manager.getTransaction().begin();
            manager.merge(clienteAntiguo);
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al actualizar el cliente" + exception);
        }
    }

    /*
    * Metodo que elimina un cliente por su id
     */
    @Override
    public void delete(int idCliente) {
        try{
            manager.getTransaction().begin();
            Query q=manager.createQuery("delete from Cliente c where c.idCliente= :idCliente");
            q.setParameter("idCliente",idCliente);
            int del= q.executeUpdate();
            manager.getTransaction().commit();
        }catch (Exception exception){
            System.out.println("Error al borrar el cliente" + exception);
        }
    }


}
