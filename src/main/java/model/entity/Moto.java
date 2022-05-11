package model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "moto", schema = "taller")
public class Moto extends Vehiculo {
    private int numRuedas;

    public Moto() {
    }

    public Moto(int numRuedas, String marca, String modelo, int cc, Cliente cliente) {
        super(marca, modelo, cc, cliente);
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    @Override
    public String toString() {
        return "Moto{" + "numRuedas=" + numRuedas + '}';
    }
}
