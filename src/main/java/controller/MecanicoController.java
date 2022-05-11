package controller;

import model.dao.MecanicoDAO;
import model.dao.ReparacionDAO;
import model.entity.Mecanico;
import model.entity.Reparacion;
import view.MecanicoView;

import java.util.List;
public class MecanicoController {
    private MecanicoView mecanicoView;
    private MecanicoDAO mecanicoDAO;
    private ReparacionDAO reparacionDAO;


    public MecanicoController() {
        mecanicoDAO = new MecanicoDAO();
        reparacionDAO = new ReparacionDAO();
        mecanicoView = new MecanicoView();
    }



    public void mostrarMenuMecanicos(){
        int opcion = mecanicoView.muestraMenuMecanicos();
        int id;
        switch (opcion){
            case 1: create(); break;
            case 2: update(); break;
            case 3: findOne(); break;
            case 4: findAll(); break;
            case 5: delete(); break;
            case 6: addReparacion(); break;
            case 7: deleteReparacion(); break;
            case 8: viewReparaciones(); break;
            case 9: return;
        }
    }



    /*
    Funcion que crea un mecanico
     */
    public void create() {
        Mecanico m = new Mecanico();
        mecanicoView.anhadirMecanico(m);
        mecanicoDAO.create(m);
        mecanicoView.muestraMensaje("-------Mecanico añadido-------");
    }

    /*
    Funcion que actualiza un mecanico
     */
    public void update() {
        int id = mecanicoView.seleccionarMecanico();
        Mecanico mecanicoAntiguo = mecanicoDAO.find(id);
        if(mecanicoAntiguo != null){
            mecanicoView.anhadirMecanico(mecanicoAntiguo);
            mecanicoDAO.update(mecanicoAntiguo);
        } else {
            mecanicoView.muestraMensaje("-------Mecanico no encontrado-------");
        }

    }

    /*
    Funcion que busca un mecanico
     */
    public void findOne(){
        int id = mecanicoView.seleccionarMecanico();
        Mecanico m = mecanicoDAO.find(id);
        if(m != null){
            mecanicoView.viewMecanico(m);
        } else {
            mecanicoView.muestraMensaje("-------Mecanico no encontrado-------");
        }
    }

    /*
    Funcion que muestra todos los mecanicos
     */
    public void findAll(){
        List<Mecanico> mecanicos = mecanicoDAO.findAll();
        mecanicoView.viewMecanicos(mecanicos);
    }

    /*
    Funcion que elimina un mecanico
     */
    public void delete() {
        int id =mecanicoView.seleccionarMecanico();
        mecanicoDAO.delete(id);
        mecanicoView.muestraMensaje("-------Mecanico borrado-------");
    }

    /*
    Funcion que añade una reparacion a un mecanico
     */
    public void addReparacion(){
        int idMecanico = mecanicoView.seleccionarMecanico();
        int idReparacion = mecanicoView.seleccionarReparacion();
        Mecanico mecanico = mecanicoDAO.devolverMecanico(idMecanico);
        Reparacion reparacion = reparacionDAO.devolverReparacion(idReparacion);
        if (mecanico != null && reparacion != null){
            mecanicoDAO.addReparacion(mecanico, reparacion);
        } else {
            mecanicoView.muestraMensaje("-------Mecanico o reparacion no encontrado-------");
        }

    }

    /*
    Funcion que elimina una reparacion de un mecanico
     */
    private void deleteReparacion() {
        int idMecanico = mecanicoView.seleccionarMecanico();
        int idReparacion = mecanicoView.seleccionarReparacion();
        Mecanico mecanico = mecanicoDAO.devolverMecanico(idMecanico);
        Reparacion reparacion = reparacionDAO.devolverReparacion(idReparacion);
        if (mecanico != null && reparacion != null){
            mecanicoDAO.deleteReparacion(mecanico, reparacion);
        } else {
            mecanicoView.muestraMensaje("-------Mecanico o reparacion no encontrado-------");
        }
    }

    /*
    Funcion que muestra las reparaciones de un mecanico
     */
    public void viewReparaciones() {
        int id =mecanicoView.seleccionarMecanico();
        Mecanico mecanico = mecanicoDAO.devolverMecanico(id);
        if (mecanico != null){
            List<Reparacion> reparaciones = mecanicoDAO.devolverReparaciones(mecanico);
            if (!reparaciones.isEmpty()){
            mecanicoView.viewReparaciones(reparaciones);
            } else {
                mecanicoView.muestraMensaje("-------Mecanico no tiene reparaciones-------");
            }
        } else {
            mecanicoView.muestraMensaje("-------Mecanico no encontrado-------");
        }


    }

    
}
