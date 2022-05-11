package view;
import controller.ClienteController;
import controller.MecanicoController;
import model.dao.MecanicoDAO;
import model.entity.Cliente;
import model.entity.Domicilio;
import model.entity.Mecanico;
import model.entity.Reparacion;

import java.util.List;
public class MecanicoView extends View{
    public int muestraMenuMecanicos(){
        System.out.println("╔═════════════════╗");
        System.out.println("║Menú de Mecanicos║");
        System.out.println("╚═════════════════╝");
        System.out.println("███ 1. Añadir Mecanico");
        System.out.println("███ 2. Modificar Mecanico");
        System.out.println("███ 3. Buscar Mecanico");
        System.out.println("███ 4. Mostrar Mecanicos");
        System.out.println("███ 5. Borrar Mecanico");
        System.out.println("███ 6. Asignar Reparacion");
        System.out.println("███ 7. Eliminar Reparacion");
        System.out.println("███ 8. Mostrar Reparaciones Asignadas");
        System.out.println("███ 9. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
    Método que pide los datos para insertar un mecanico
     */
    public void anhadirMecanico(Mecanico m) {
        String nombre = pideString("Introduce el nombre: ");
        String apellido = pideString("Introduce el apellido: ");
        int telefono = pideInt("Introduce el telefono: ");
        m.setNombre(nombre);
        m.setApellido(apellido);
        m.setTelefono(telefono);
    }

    /*
    Método que pide y devuelve un id de mecanico
     */
    public int seleccionarMecanico() {
        int id = pideInt("Introduce el id del mecanico: ");
        return id;
    }

    /*
        Método que pide y devuelve un id de reparacion
    */
    public int seleccionarReparacion() {
        int id = pideInt("Introduce el id de la reparacion: ");
        return id;
    }

    /*
    Método que muestra todos los mecanicos
     */
    public void viewMecanicos(List <Mecanico> mecanicos) {
        System.out.println("╔══════════════════════════ \n");
        mecanicos.forEach(mecanico ->{

            System.out.println("║ Nombre: "+mecanico.getNombre()+ "\n║ Apellido: "+mecanico.getApellido()+
                    "\n║ Telefono: "+mecanico.getTelefono() + "\n");

        });
        System.out.println("╚══════════════════════════");
    }

    /*
    Método que muestra los datos de un mecanico
     */
    public void viewMecanico(Mecanico mecanico) {
        System.out.println("╔══════════════════════════ \n");
        System.out.println("║ Nombre: "+mecanico.getNombre()+ "\n║ Apellido: "+mecanico.getApellido()+
                    "\n║ Telefono: "+mecanico.getTelefono() + "\n");
        System.out.println("╚══════════════════════════");

    }

    public void viewReparaciones(List<Reparacion> reparaciones) {
        for (Reparacion r: reparaciones) {
            {
                System.out.println("╔══════════════════════════ \n");
                System.out.println("║ Id de la reparacion: "+ r.getIdReparacion() + "\n║ Id del Vehiculo: "
                        +r.getVehiculo().getIdVehiculo()+ "\n║ Descripcion: "+r.getDescripcion()+
                        "\n║ Fecha Inicio: "+r.getFechaInicio()+
                        "\n║ Fecha Fin: "+r.getFechaFin()+"\n");
                System.out.println("╚══════════════════════════");
            }
        }
    }

}
