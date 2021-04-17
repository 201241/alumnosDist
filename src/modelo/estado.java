package modelo;


import javax.persistence.*;

@Entity
@Table(name = "estado")
public class estado {
    @Id
    @GeneratedValue
    @Column(name = "idEstado")
    private int idEstado;

    @Column(name = "Nombre")
    private String Nombre;

    public estado(){
    }

    public estado(String nombre) {
        Nombre = nombre;
    }




    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
