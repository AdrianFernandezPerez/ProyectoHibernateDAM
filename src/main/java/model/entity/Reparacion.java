package model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reparacion", schema = "taller")
public class Reparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReparacion")
    private int idReparacion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehiculo_id_vehiculo", referencedColumnName = "idVehiculo", nullable=false)
    private Coche coche;

    @ManyToMany(mappedBy = "reparaciones")
    private List<Mecanico> lMecanicos;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;


    public Vehiculo getVehiculo() {
        return coche;
    }

    public void setVehiculo(Coche coche) {
        this.coche = coche;
    }

    public List<Mecanico> getMecanicos() {
        return lMecanicos;
    }

    public void setlMecanicos(List<Mecanico> lMecanicos) {
        this.lMecanicos = lMecanicos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdReparacion() {
        return idReparacion;
    }

    public Reparacion(Coche coche, String descripcion, Date fechaInicio) {
        this.coche = coche;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        lMecanicos= new ArrayList<Mecanico>();
    }

    public Reparacion() {
        lMecanicos= new ArrayList<Mecanico>();
    }

    @Override
    public String toString() {
        return "Reparacion{" + "idReparacion=" + idReparacion + ", vehiculo=" + coche + ", lMecanicos=" + lMecanicos + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }


}




