package view;

import controller.ClienteController;
import model.dao.ClienteDAO;
import model.entity.Cliente;
import model.entity.Domicilio;
import model.entity.Mecanico;

import java.util.List;

public class ClienteView extends View {

    public int muestraMenuClientes(){
        System.out.println("╔════════════════╗");
        System.out.println("║Menú de Clientes║");
        System.out.println("╚════════════════╝");
        System.out.println("███ 1. Añadir Cliente");
        System.out.println("███ 2. Modificar Cliente");
        System.out.println("███ 3. Buscar Cliente");
        System.out.println("███ 4. Mostrar Clientes");
        System.out.println("███ 5. Borrar Cliente");
        System.out.println("███ 6. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
Método que pide los datos para insertar un cliente
 */
    public void anhadirCliente(Cliente c, Domicilio d) {
        String nombre = pideString("Introduce el nombre: ");
        String email = pideString("Introduce el email: ");
        int telefono = pideInt("Introduce el telefono: ");
        String provincia = pideString("Introduce la provincia: ");
        int codigoPostal = pideInt("Introduce el codigo postal: ");
        String direccion = pideString("Introduce la direccion: ");
        String pais = pideString("Introduce el pais: ");
        String localidad = pideString("Introduce la localidad: ");
        c.setNombre(nombre);
        c.setEmail(email);
        c.setTelefono(telefono);
        d.setProvincia(provincia);
        d.setCodigoPostal(codigoPostal);
        d.setDireccion(direccion);
        d.setPais(pais);
        d.setLocalidad(localidad);
        c.setDomicilio(d);
    }

    /*
Método que pide y devuelve un id del cliente
 */
    public int seleccionarCliente() {
        int id = pideInt("Introduce el id del cliente: ");
        return id;
    }

    /*
        Método que muestra todos los clientes
    */
    public void viewClientes(List <Cliente> clientes) {
        System.out.println("╔══════════════════════════ \n");
        clientes.forEach(cliente ->{

            System.out.println("║ Nombre: "+cliente.getNombre()+ "\n║ Domicilio: "+cliente.getDomicilio()+"\n║ Correo: "+
                    cliente.getEmail() + "\n║ Telefono: "+cliente.getTelefono() + "\n");

        });
        System.out.println("╚══════════════════════════");
    }

    /*
    Metodo que muestra un cliente
     */
    public void viewCliente(Cliente cliente) {
        System.out.println("╔══════════════════════════ \n");
        System.out.println("║ Nombre: "+cliente.getNombre()+ "\n║ Domicilio: "+cliente.getDomicilio()+"\n║ Correo: "+
                cliente.getEmail() + "\n║ Telefono: "+cliente.getTelefono() + "\n");
        System.out.println("╚══════════════════════════");

    }




}