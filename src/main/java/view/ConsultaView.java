package view;

import model.entity.Cliente;
import model.entity.Mecanico;
import model.entity.Reparacion;

import java.util.List;

public class ConsultaView extends View {

    public int muestraMenuConsultas() {
        System.out.println("╔═════════════════╗");
        System.out.println("║Menú de Consultas║");
        System.out.println("╚═════════════════╝");
        System.out.println("███ 1. Clientes con coche");
        System.out.println("███ 2. Reparaciones por terminar");
        System.out.println("███ 3. Mecanicos con reparaciones");
        System.out.println("███ 4. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
    Método que muestra todas las reparaciones sin finalizar
*/
    public void viewReparacionesSinFinalizar(List<Reparacion> reparaciones) {
        System.out.println("╔══════════════════════════");
        reparaciones.forEach(reparacion -> {
            System.out.println("║ ID Reparacion: " + reparacion.getIdReparacion() +
                    "\n║ Descripcion: " + reparacion.getDescripcion() + "\n║ Fecha Inicio" +
                    ": " + reparacion.getFechaInicio() + "\n║ Fecha Fin" +
                    ": " + reparacion.getFechaFin() + "\n");
        });
        System.out.println("╚══════════════════════════");
    }

    /*
    Método que muestra los clientes con coche
    */
    public void viewClientesConCoche(List<Cliente> clientes) {
        System.out.println("╔══════════════════════════ \n");
        clientes.forEach(cliente ->{

            System.out.println("║ Nombre: "+cliente.getNombre()+ "\n║ Domicilio: "+cliente.getDomicilio()+"\n║ Correo: "+
                    cliente.getEmail() + "\n║ Telefono: "+cliente.getTelefono() + "\n║ Coche: "+cliente.getCoche() + "\n");

        });
        System.out.println("╚══════════════════════════");
    }

    public void viewMecanicosConReparaciones(List<Mecanico> mecanicos) {
        System.out.println("╔══════════════════════════ \n");
        mecanicos.forEach(mecanico ->{

            System.out.println("║ Nombre: "+mecanico.getNombre()+ "\n║ Apellido: "+mecanico.getApellido()+
                    "\n║ Telefono: "+mecanico.getTelefono()+ "\n║ Reparaciones: "+mecanico.getReparaciones()+ "\n");

        });
        System.out.println("╚══════════════════════════");
    }
}