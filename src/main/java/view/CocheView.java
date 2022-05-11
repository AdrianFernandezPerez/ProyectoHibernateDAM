package view;

import controller.CocheController;
import controller.ClienteController;
import controller.MecanicoController;
import model.entity.Cliente;
import model.entity.Coche;
import model.entity.Domicilio;
import model.entity.Mecanico;

import java.util.List;

public class CocheView extends View{



    public int muestraMenuCoches(){
        System.out.println("╔══════════════╗");
        System.out.println("║Menú de Coches║");
        System.out.println("╚══════════════╝");
        System.out.println("███ 1. Añadir Coche");
        System.out.println("███ 2. Modificar Coche");
        System.out.println("███ 3. Buscar Coche");
        System.out.println("███ 4. Mostrar Coches");
        System.out.println("███ 5. Borrar Coche");
        System.out.println("███ 6. Volver al inicio");
        int opcion = pideInt("Ingresa una opcion: ");
        return opcion;
    }

    /*
Método que pide y devuelve un id del coche
*/
    public int seleccionarCoche() {
        int id = pideInt("Introduce el id del coche: ");
        return id;
    }

    /*
    Método que muestra todos los coches
*/
    public void viewCoches(List <Coche> coches) {
        System.out.println("╔══════════════════════════ \n");
        coches.forEach(coche ->{

            System.out.println("║ Id: "+coche.getIdVehiculo()+ "\n║ Marca: "+coche.getMarca()+"\n║ Modelo: "+
                    coche.getModelo() + "\n║ Carroceria: "+coche.getCarroceria() + "\n║ Cilindrada: "+coche.getCc()+
                    "\n║ Cliente: "+coche.getCliente().getIdCliente()+"\n");

        });
        System.out.println("╚══════════════════════════");
    }

    /*
    Metodo que muestra los datos de un coche
     */
    public void viewCoche(Coche coche) {
        System.out.println("╔══════════════════════════ \n");
        System.out.println("║ Id: "+coche.getIdVehiculo()+ "\n║ Marca: "+coche.getMarca()+"\n║ Modelo: "+
                coche.getModelo() + "\n║ Carroceria: "+coche.getCarroceria() + "\n║ Cilindrada: "+coche.getCc()+
                "\n║ Cliente: "+coche.getCliente().toString()+"\n");
        System.out.println("╚══════════════════════════");

    }

    /*
    Método que pide los datos para insertar un coche
     */
    public void anhadirCoche(Coche c, Cliente cliente) {
        String marca = pideString("Introduce la marca: ");
        String modelo = pideString("Introduce el modelo: ");
        String carroceria = pideString("Introduce la carroceria: ");
        int cc = pideInt("Introduce la cilindrada: ");
        c.setMarca(marca);
        c.setModelo(modelo);
        c.setCarroceria(carroceria);
        c.setCc(cc);
        c.setCliente(cliente);
    }

}
