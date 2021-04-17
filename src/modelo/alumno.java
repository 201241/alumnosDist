package modelo;

import javax.persistence.*;

@Entity
@Table(name = "alumno")

public class alumno {

    @Id
    @GeneratedValue
    @Column(name = "idalumno")
    private int idAlumno;

    @Column(name = "idusuario")
    private int idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "idciudad")
    private int idCiudad;

    public alumno(){
    }

    public alumno(int idUsuario, String nombre, int idCiudad) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
}
