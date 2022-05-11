package model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "mecanico", schema = "taller")
public class Mecanico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMecanico")
    private int idMecanico;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "telefono", unique = true)
    private int telefono;

    @ManyToMany
    @JoinTable(name = "mecanico_has_reparacion",joinColumns =   @JoinColumn(name="idMeacanico"),
            inverseJoinColumns = @JoinColumn(name="idReparacion"))
    private List<Reparacion> reparaciones;


    public Mecanico() {
        reparaciones = new ArrayList<Reparacion>();
    }

    public Mecanico(String nombre, String apellido, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        reparaciones = new ArrayList<Reparacion>();
    }

    /*
    Añadir reparaciones
    */
    public void setReparaciones(Reparacion r){
        reparaciones.add(r);
    }

    /*
    Metodo que elimina una reparacion del mecanico
    */
    public void deleteReparacion(Reparacion r){
        //Creo un iterador para recorrer la lista de reparaciones
        Iterator<Reparacion> iter = reparaciones.iterator();
        //Mientras encuentre reparaciones
        while(iter.hasNext()){
            //Guardo el id de la reparación que iteró
            int id = iter.next().getIdReparacion();
            //Si el id es igual al id de la reparación que se quiere eliminar
            if(id == r.getIdReparacion()){
                //Elimino la reparación
                iter.remove();
            }
        }
    }

    public List<Reparacion> getReparaciones(){
        return reparaciones;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Mecanico{" + "idMecanico=" + idMecanico + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + '}';
    }

}
