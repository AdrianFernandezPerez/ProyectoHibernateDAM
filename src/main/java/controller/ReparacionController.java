package controller;

import model.dao.CocheDAO;
import model.dao.MecanicoDAO;
import model.dao.ReparacionDAO;
import model.entity.Cliente;
import model.entity.Coche;
import model.entity.Mecanico;
import model.entity.Reparacion;
import view.CocheView;
import view.MecanicoView;
import view.ReparacionView;

import java.util.Date;
import java.util.List;

public class ReparacionController {
    private ReparacionView reparacionview;
    private ReparacionDAO reparacionDAO;
    private CocheView cocheView;
    private CocheDAO cocheDAO;

    public void mostrarMenuReparaciones(){
        int opcion = reparacionview.muestraMenuReparaciones();
        int id;
        switch (opcion){
            case 1: create(); break;
            case 2: update(); break;
            case 3: findOne(); break;
            case 4: findAll(); break;
            case 5: delete(); break;
            case 6: finalizarReparacion(); break;
            case 7: return;

 /*           case 8:
                //Volver al menu principal
                vista.muestraMenu();
                break;

            case 0:
                salir = true;
 */

        }
    }


    public ReparacionController() {
        reparacionDAO = new ReparacionDAO();
        reparacionview = new ReparacionView();
        cocheDAO = new CocheDAO();
        cocheView = new CocheView();
    }

    /*
    Funcion que crea una reparacion
    */
    public void create() {
        Reparacion r = new Reparacion();
        int idVehiculo = cocheView.seleccionarCoche();
        Coche coche = cocheDAO.find(idVehiculo);
        reparacionview.anhadirReparacion(r, coche);
        reparacionDAO.create(r);
        reparacionview.muestraMensaje("-------Coche añadido-------");
    }



    /*
    Funcion que actualiza una reparacion
    */
    public void update() {
        int id = reparacionview.seleccionarReparacion();
        Reparacion reparacionAntigua = reparacionDAO.find(id);
        int idVehiculo = cocheView.seleccionarCoche();
        Coche coche = cocheDAO.find(idVehiculo);
        if (reparacionAntigua != null && coche != null) {
            reparacionview.anhadirReparacion(reparacionAntigua, coche);
            reparacionDAO.update(reparacionAntigua);
            reparacionview.muestraMensaje("-------Reparacion modificada-------");
        } else {
            reparacionview.muestraMensaje("-------Reparacion o Coche no encontrado-------");
        }

    }

    /*
    Funcion que busca una reparacion
     */
    public void findOne(){
        int id = reparacionview.seleccionarReparacion();
        Reparacion r = reparacionDAO.find(id);
        if (r != null) {
            reparacionview.viewReparacion(r);
        } else {
            reparacionview.muestraMensaje("-------Reparacion no encontrada-------");
        }
    }

    /*
    Funcion que muestra todas las reparaciones
     */
    public void findAll(){
        List<Reparacion> reparaciones = reparacionDAO.findAll();
        reparacionview.viewReparaciones(reparaciones);
    }

    /*
    Funcion que elimina una reparacion
     */
    public void delete() {
        int id =reparacionview.seleccionarReparacion();
        reparacionDAO.delete(id);
        reparacionview.muestraMensaje("-------Reparacion borrada-------");
    }

    /*
     Funcion que finaliza una reparacion
     */
    public void finalizarReparacion() {
        int id = reparacionview.seleccionarReparacion();
        Date fechaFin = reparacionview.asignarFechaFin();
        reparacionDAO.finalizarReparacion(id, fechaFin);
        reparacionview.muestraMensaje("-------Reparacion finalizada-------");
    }

}
