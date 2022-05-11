package controller;

import view.*;

public class mainController extends View{
    private VistaMenu vista = new VistaMenu();
    private View view = new View();
    private boolean salir = false;
    private int opcion;
    private MecanicoController mecanicoController = new MecanicoController();
    private ClienteController clienteController = new ClienteController();
    private CocheController cocheController = new CocheController();
    private ReparacionController reparacionController = new ReparacionController();
    private ConsultaController consultaController = new ConsultaController();

    public void controlaMenu(){
        do {
            vista.muestraMenu();
            opcion =pideInt("Ingresa una opcion: ");
            switch (opcion){
                case 1:
                    //Menu clientes
                    clienteController.mostrarMenuClientes();
                    break;

                case 2:
                    //Menu Coches
                    cocheController.mostrarMenuCoches();
                    break;

                case 3:
                    //Menu Reparaciones
                    reparacionController.mostrarMenuReparaciones();
                    break;

                case 4:
                    //Menu mecanicos
                    mecanicoController.mostrarMenuMecanicos();
                    break;

                case 5:
                    //Menu consultas JPQL
                    consultaController.mostrarMenuConsultas();
                    break;

                case 6:
                    //Volver al menu principal
                    vista.muestraMenu();
                    break;

                case 0:
                    salir = true;
                    view.muestraMensaje("¡Vuelva pronto!");
            }
        }while (!salir);

    }
    }


