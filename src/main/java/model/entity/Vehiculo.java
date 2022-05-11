package model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "vehiculo", schema = "taller")
public abstract class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idVehiculo", unique = true , nullable = false )
    private int idVehiculo;
    private String marca;
    private String modelo;
    private int cc;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="Cliente_idCliente", referencedColumnName = "idCliente", nullable=false)
    private Cliente cliente;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int cc, Cliente cliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.cc = cc;
        this.cliente = cliente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cc=" + cc +
                ", cliente=" + cliente +
                '}';
    }
}
