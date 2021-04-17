package modelo;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
public class ciudad {
    @Id
    @GeneratedValue
    @Column(name = "idCiudad")
    private int idCiudad;

    @Column(name = "idEstado")
    private int idEstado;

    @Column(name = "nombre")
    private String nombre;

    public ciudad(){
    }

    public ciudad(int idEstado, String nombre) {
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
