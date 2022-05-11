package model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coche", schema = "taller")
public class Coche extends Vehiculo {
    private String carroceria;

    public Coche() {
    }

    public Coche(String carroceria, String marca, String modelo, int cc, Cliente cliente) {
        super(marca, modelo, cc, cliente);
        this.carroceria = carroceria;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    @Override
    public String toString() {
        return "Marca: " +getMarca() + ", Modelo: " + getModelo() + ", CC: " + getCc() + ", Carroceria: " + getCarroceria();
    }
}
