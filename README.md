# <center> Proyecto con Hibernate </center>
Proyecto Java con Hibernate de la asignatura Acceso a Datos del curso DAM

# SUPUESTO
El proyecto consiste en una aplicación java que se encarga de gestionar un taller de reparación de vehículos.

# DIAGRAMA DE CLASES Y CFM

->Diagrama de clases<-

![Captura](https://user-images.githubusercontent.com/78510935/167899482-285400a4-2032-4272-a410-b36cd9060ddd.PNG)


->Crow'sFoot<-

![Captura](https://user-images.githubusercontent.com/78510935/167899982-88815468-d258-4089-8a48-0004329bcf43.PNG)

# MANUAL DE USUARIO

->Menú Inicial<-

![Captura1MenuInicial](https://user-images.githubusercontent.com/78510935/167907446-ee91970c-27ec-4e8a-9dcb-2cbed55f72ad.PNG)

->Menú de Clientes<-
Habiendo seleccionado el menú clientes, se nos mostrará la siguiente información

![Captura2MenuClientes](https://user-images.githubusercontent.com/78510935/167907653-cc24f8a3-2221-4d85-9b55-8f2616330cdc.PNG)

->Añadiendo Cliente<-
Con la opción de añadir un cliente, nos pedirá los datos y lo agregará a la BD

![Captura3AñadiendoCliente](https://user-images.githubusercontent.com/78510935/167908523-036bfa1b-dac0-4cd4-a62c-59033b866e34.PNG)

->Añadiendo Coche<-
Con la opción de añadir un coche, habrá que introducir el id del cliente para referenciarlo

![Captura4AgregandoCoche](https://user-images.githubusercontent.com/78510935/167908792-84e68915-9d08-4a65-a7f5-d9495bebdf05.PNG)

->Menú Reparación<-
En el menú reparación podremos agregar reparaciones, eliminarlas, darlas por finalizado, etc

![Captura5MenuReparaciones](https://user-images.githubusercontent.com/78510935/167909143-7f6c514b-d59a-40f8-b175-dcbfea792d57.PNG)

->Agregando Reparación<-
Al momento de agregar una reparación tenemos que asignarle el id del vehículo a reparar, la reparación se creará sin fecha de fin ya que para eso está la opcion de finalizar reparación del menú, la cual determina la hora de fin de la reparación a la hora en que se seleccionó finalizarla.

![Captura6AgregarReparacion](https://user-images.githubusercontent.com/78510935/167909618-d3fcde7e-d4d3-4671-a859-db317841bb0b.PNG)
![Captura7](https://user-images.githubusercontent.com/78510935/167909634-a90d882a-70a2-4cd0-8a03-de8fe5706f16.PNG)

->Menú Mecanico<-
Estas son las opciones disponibles en el menú mecanico, añadirlo, modificarlo, asignarle reparaciones, mostrarlas y eliminarlas.

![Captura8](https://user-images.githubusercontent.com/78510935/167909715-673e3e1c-7803-4802-8d33-13073bf96d42.PNG)

->Agregando Mecanico<-
Estas son las opciones disponibles en el menú mecanico, añadirlo, modificarlo, asignarle reparaciones, mostrarlas y eliminarlas.

![Captura9](https://user-images.githubusercontent.com/78510935/167910055-4c45002d-6b0f-4868-a2a4-742c2aeaf1de.PNG)

->Asignar reparación a mecanico<-
Despues de asignarle la reparación al mecánico, se muestra en una tabla aparte.

![Captura10](https://user-images.githubusercontent.com/78510935/167910360-98070f4e-80a1-48b9-bfc3-9127708fdb7d.PNG)

![Captura11](https://user-images.githubusercontent.com/78510935/167910372-44482ca0-a4ca-4ed2-a375-a489ba1a6528.PNG)

![Captura12](https://user-images.githubusercontent.com/78510935/167910484-bd1cecc0-5e35-425c-b6aa-0f1578c6bb21.PNG)

->Finalizar reparación<-
Al dar por finalizada la reparación, la reparación seguirá existiendo pero se quitará de la relación con los mecanicos que estuvieran trabajando en ella.

![Captura13](https://user-images.githubusercontent.com/78510935/167910835-d7e179a8-6a42-4fdc-b3e8-9710bcb2eb2e.PNG)
![Captura14](https://user-images.githubusercontent.com/78510935/167911107-1851dec7-5322-497a-a9f6-3911e321c559.PNG)
![Captura15](https://user-images.githubusercontent.com/78510935/167911129-e16ca993-aea7-44eb-be45-61942fa1e5c0.PNG)

->Menú consultas JPQL<-
Menú que será para consultas generales sobre la BD

![Captura16](https://user-images.githubusercontent.com/78510935/167911372-79bc51aa-904e-40e5-bc79-79182f5caa72.PNG)

->Probanco Consulta JPQL<-
Al seleccionar la consulta de clientes con vehículo, nos muestra los datos de los clientes con vehículos y los datos del mismo.

![Captura17](https://user-images.githubusercontent.com/78510935/167911631-2f72c5be-ede9-4731-bc14-4d50f992fbbd.PNG)


# MANUAL TÉCNICO
->Carpeta del proyecto<-

![Captura1Raiz](https://user-images.githubusercontent.com/78510935/167904261-56e50035-6717-49b8-9f22-3420faa3075c.PNG)

->Tablas generadas en la BD<-

![Captura9BD](https://user-images.githubusercontent.com/78510935/167904332-97e6a17a-b5ac-4e33-9f68-e5bb80f294ba.PNG)

->Ventana inicial de la aplicación<-

![Captura1Inicio](https://user-images.githubusercontent.com/78510935/166838271-02baaa75-17bb-4da6-934b-3d54c086d516.PNG)

->Clase Main<-
Aquí comienza el codigo, llamando al controlador de Main para mostrar el menú inicial

![Captura8MainInicio](https://user-images.githubusercontent.com/78510935/167904402-77190e6d-b46e-45f1-aed2-e114941d3468.PNG)

->Main Controller<-
Aquí dependiendo de la opción ingresada, mostrará el menú seleccionado

![Captura7Main](https://user-images.githubusercontent.com/78510935/167905197-434863f6-5dcf-42bd-bb34-c1479941e970.PNG)

->Cliente Controller<-
Por ejemplo, seleccionado el menú clientes, nos muestrá una función de su vista con las diversas opciones disponibles y ahí seleccionamos
la deseada

![Captura2ClienteController](https://user-images.githubusercontent.com/78510935/167905438-f3090d73-e11b-4be1-9e32-63f69bbc3749.PNG)

->Cliente DAO<-
El controlador llamará a la clase DAO para hacer las consultas a la BD etc

![Captura4ClienteDAO](https://user-images.githubusercontent.com/78510935/167905927-e0d3c3b2-ac6c-4d53-b423-2148af17c680.PNG)

->Cliente View<-
La clase DAO llamará a la clase ClienteView para pedir datos al usuario

![Captura5ClienteView](https://user-images.githubusercontent.com/78510935/167906050-a9a7a3a2-db31-45dd-a883-a5a3f3e83968.PNG)

->Clase View<-
Todas las clases EntityView extienden de esta clase para utilizar sus métodos, como el control de entrada de strings por teclado, ints, etc

![Captura6View](https://user-images.githubusercontent.com/78510935/167906222-e52663e2-aa93-4dd5-b48f-960349aa1583.PNG)

->Entity Cliente<-
Esta es la clase de la entidad Cliente

![Captura3ClienteEntity](https://user-images.githubusercontent.com/78510935/167906389-5c2e7395-2e2c-47fd-8c3d-d474e7121455.PNG)



# PROPUESTAS DE MEJORA
Una de las mejoras que quiero realizar es el control de excepciones y errores y mostrarle bien lo que sucede al usuario en todo momento.
Otra mejora sería añadir el campo matricula a vehículos para no controlarlos por el id y el dni a los clientes para lo mismo.
También hay que añadir el codigo de la entidad tractor, moto y posibles añadidos.

# CONCLUSIONES
En conclusión, la aplicación me parece sencilla y muy util para los talleres que no tienen nada de automatización y así tendrán un mejor 
control de lo que sucede en su trabajo.
