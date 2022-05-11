package view;

import controller.CocheController;
import controller.ReparacionController;
import model.entity.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReparacionView extends View {

    public int muestraMenuReparaciones(){
        System.out.println("╔════════════════════╗");
        System.out.println("║Menú de Reparaciones║");
        System.out.println("╚════════════════════╝");
        System.out.println("███ 1. Añadir Reparacion");
        System.out.println("███ 2. Modificar Reparacion");
        System.out.println("███ 3. Buscar Reparacion");
        System.out.println("███ 4. Mostrar Reparaciones");
        System.out.println("███ 5. Borrar Reparacion");
        System.out.println("███ 6. Reparacion Finalizada");
        System.out.println("███ 7. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
Método que pide y devuelve un id de una reparacion
*/
    public int seleccionarReparacion() {
        int id = pideInt("Introduce el id de la reparación: ");
        return id;
    }


    /*
    Método que pide los datos para insertar una reparacion
     */
    public void anhadirReparacion(Reparacion r, Coche c) {
        String descripcion = pideString("Introduce la descripcion: ");
        Date date = new Date();
        Date fechaInicio = date;
        r.setDescripcion(descripcion);
        r.setFechaInicio(fechaInicio);
        r.setVehiculo(c);
    }

    /*
Método que muestra todas las reparaciones
*/
    public void viewReparaciones(List <Reparacion> reparaciones) {
        System.out.println("╔══════════════════════════ \n");
        reparaciones.forEach(reparacion ->{

            System.out.println("║ Id del Vehiculo: "+reparacion.getVehiculo().getIdVehiculo()+ "\n║ Id de la reparacion" +
                    ": "+reparacion.getIdReparacion()+
                    "\n║ Descripcion: "+reparacion.getDescripcion() + "\n║ Fecha Inicio" +
                    ": "+reparacion.getFechaInicio()+ "\n║ Fecha Fin" +
                    ": "+reparacion.getFechaFin()+"\n");

        });
    }

    /*
    Método que muestra una reparacion
     */
    public void viewReparacion(Reparacion reparacion) {
        System.out.println("║ Id del Vehiculo: "+reparacion.getVehiculo().getIdVehiculo()+ "\n║ Id de la reparacion" +
                ": "+reparacion.getIdReparacion()+
                "\n║ Descripcion: "+reparacion.getDescripcion() + "\n║ Fecha Inicio" +
                ": "+reparacion.getFechaInicio()+ "\n║ Fecha Fin" +
                ": "+reparacion.getFechaFin()+"\n");

    }

    /*
    Metodo que asigna a una variable fecha la fecha actual
     */
    public Date asignarFechaFin() {
        Date date = new Date();
        Date fechaFin = date;
        return fechaFin;
    }

}
