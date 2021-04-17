package modelo;

import javax.persistence.*;

@Entity
@Table(name = "usuario")

public class usuario {

    @Id
    @GeneratedValue
    @Column(name = "idUsuario")
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    public usuario() {
    }

    public usuario(String nombre) {
        this.nombre = nombre;
    }



    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
