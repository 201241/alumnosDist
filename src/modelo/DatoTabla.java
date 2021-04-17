package modelo;

public class DatoTabla {
//idAlumno Nombre ciudad estado usuario
    private int idAlumno;
    private String Nombre;
    private String ciudad;
    private String estado;
    private String usuario;



    public DatoTabla() {
    }

    public DatoTabla(int idAlumno, String nombre, String ciudad, String estado, String usuario) {
        this.idAlumno = idAlumno;
        Nombre = nombre;
        this.ciudad = ciudad;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
