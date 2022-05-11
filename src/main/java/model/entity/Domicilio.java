package model.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Domicilio {
    private String direccion;
    private String localidad;
    private int codigoPostal;
    private String provincia;
    private String pais;

    public Domicilio() {
    }

    public Domicilio(String direccion, String localidad, int codigoPostal, String provincia, String pais) {
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'';
    }
}
