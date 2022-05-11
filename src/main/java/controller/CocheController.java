package controller;

import model.dao.ClienteDAO;
import model.dao.CocheDAO;
import model.entity.Cliente;
import model.entity.Coche;
import model.entity.Domicilio;
import view.ClienteView;
import view.CocheView;

import java.util.List;

public class CocheController {
    private CocheView cocheView;
    private ClienteView clienteView;
    private ClienteDAO clienteDAO;
    private CocheDAO cocheDAO;

    public void mostrarMenuCoches() {
        int opcion = cocheView.muestraMenuCoches();
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


    public CocheController() {
        cocheDAO = new CocheDAO();
        cocheView = new CocheView();
        clienteDAO = new ClienteDAO();
        clienteView = new ClienteView();
    }

    /*
Funcion que crea un coche
 */
    public void create() {
        Coche c = new Coche();
        int idCliente = clienteView.seleccionarCliente();
        Cliente cliente = clienteDAO.find(idCliente);
        cocheView.anhadirCoche(c, cliente);
        cocheDAO.create(c);
        clienteView.muestraMensaje("-------Coche añadido-------");
    }

    /*
Funcion que actualiza un coche
 */
    public void update() {
        int id = cocheView.seleccionarCoche();
        Coche cocheAntiguo = cocheDAO.find(id);
        int idCliente = clienteView.seleccionarCliente();
        Cliente cliente = clienteDAO.find(idCliente);
        cocheView.anhadirCoche(cocheAntiguo, cliente);
        cocheDAO.update(cocheAntiguo);
        cocheView.muestraMensaje("-------Coche modificado-------");
    }

    /*
        Funcion que busca un coche
     */
    public void findOne() {
        int id = cocheView.seleccionarCoche();
        Coche c = cocheDAO.find(id);
        if(c != null) {
            cocheView.viewCoche(c);
        } else {
            System.out.println("-------Coche no encontrado-------");
        }
    }

    /*
        Funcion que muestra todos los coches
     */
    public void findAll() {
        List<Coche> coches = cocheDAO.findAll();
        cocheView.viewCoches(coches);
    }

    /*
        Funcion que elimina un coche
     */
    public void delete() {
        int id = cocheView.seleccionarCoche();
        cocheDAO.delete(id);
        cocheView.muestraMensaje("-------Coche borrado-------");
    }
}
