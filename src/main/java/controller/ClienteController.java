package controller;

import model.dao.ClienteDAO;
import model.entity.Cliente;
import model.entity.Domicilio;
import model.entity.Mecanico;
import org.hibernate.exception.ConstraintViolationException;
import view.ClienteView;

import javax.persistence.PersistenceException;
import java.util.List;

public class ClienteController {
    private ClienteView clienteView;
    private ClienteDAO clienteDAO;

    public void mostrarMenuClientes() {
        int opcion = clienteView.muestraMenuClientes();
        int id;
        switch (opcion) {
            case 1:
                create();
                break;
            case 2:
                update();
                break;
            case 3:
                findOne();
                break;
            case 4:
                findAll();
                break;
            case 5:
                delete();
                break;
            case 6:
                return;
        }
    }


    public ClienteController() {
        clienteDAO = new ClienteDAO();
        clienteView = new ClienteView();
    }

    /*
        Funcion que crea un cliente
    */
    public void create() {
        Cliente c = new Cliente();
        Domicilio d = new Domicilio();
        clienteView.anhadirCliente(c, d);
        clienteDAO.create(c);
    }

    /*
        Funcion que actualiza un cliente
    */
    public void update() {
        int id = clienteView.seleccionarCliente();
        Cliente clienteAntiguo = clienteDAO.find(id);
        if (clienteAntiguo != null) {
            Domicilio domicilio = new Domicilio();
            clienteView.anhadirCliente(clienteAntiguo, domicilio);
            clienteDAO.update(clienteAntiguo);
            clienteView.muestraMensaje("-------Cliente modificado-------");
        } else {
            clienteView.muestraMensaje("-------Cliente no encontrado-------");
        }
    }

    /*
        Funcion que busca un cliente
     */
    public void findOne() {
        int id = clienteView.seleccionarCliente();
        try {
            Cliente c = clienteDAO.find(id);
            if(c.getIdCliente()==id){
                clienteView.viewCliente(c);
            }
        }   catch (Exception e) {
            clienteView.muestraMensaje("-------Cliente no encontrado-------" +e.getMessage());
        }


    }

    /*
        Funcion que muestra todos los clientes
     */
    public void findAll() {
        List<Cliente> clientes = clienteDAO.findAll();
        clienteView.viewClientes(clientes);
    }

    /*
        Funcion que elimina un cliente
     */
    public void delete() {
        int id = clienteView.seleccionarCliente();
        try {
            clienteDAO.delete(id);
            clienteView.muestraMensaje("-------Cliente borrado-------");
        }   catch (Exception e) {
            clienteView.muestraMensaje("-------El cliente no se pudo borrar-------" +e.getMessage());
        }

    }
}
