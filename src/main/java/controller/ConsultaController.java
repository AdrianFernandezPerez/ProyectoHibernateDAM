package controller;

import model.dao.ConsultaDAO;
import model.dao.MecanicoDAO;
import model.dao.ReparacionDAO;
import model.entity.Cliente;
import model.entity.Mecanico;
import model.entity.Reparacion;
import view.ConsultaView;
import view.MecanicoView;

import java.util.List;

public class ConsultaController {
    private ConsultaDAO consultaDAO;
    private ConsultaView consultaView;


    public ConsultaController() {
        consultaDAO = new ConsultaDAO();
        consultaView = new ConsultaView();
    }


    public void mostrarMenuConsultas(){
        int opcion = consultaView.muestraMenuConsultas();
        int id;
        switch (opcion){
            case 1: viewClientesConCoche();
                 break;
            case 2: viewReparacionesSinFinalizar();
                break;
            case 3: viewMecanicosConReparaciones();
                break;
            case 8: return;

        }
    }

    /*
    Metodo que muestra las reparaciones sin finalizar
     */
    public void viewReparacionesSinFinalizar() {
        List<Reparacion>reparaciones = consultaDAO.findSinFinalizar();
        consultaView.viewReparacionesSinFinalizar(reparaciones);
    }

    /*
    Metodo que muestra los clientes con coche
    */
    public void viewClientesConCoche() {
        List<Cliente>clientes = consultaDAO.findClientesConCoche();
        consultaView.viewClientesConCoche(clientes);
    }

    /*
    Metodo que muestra los mecanicos con reparaciones
     */
    private void viewMecanicosConReparaciones() {
        List<Mecanico>mecanicos = consultaDAO.findMecanicosConReparaciones();
        consultaView.viewMecanicosConReparaciones(mecanicos);
    }

}
