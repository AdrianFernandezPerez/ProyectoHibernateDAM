package model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tractor", schema = "taller")
public class Tractor extends Vehiculo{
    private String tipo;

    public Tractor() {
    }

    public Tractor(String tipo, String marca, String modelo, int cc, Cliente cliente) {
        super(marca, modelo, cc, cliente);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tractor{" + "tipo=" + tipo + '}';
    }
}
