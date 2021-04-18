package sample;

import Conexion.ConexionSqlServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private TableView<DatoTabla> tablaDatos;
    @FXML private TableColumn colum_idAlum;
    @FXML private TableColumn colum_nombre;
    @FXML private TableColumn colum_ciudad;
    @FXML private TableColumn colum_estado;
    @FXML private TableColumn colum_usuario;

    private ObservableList<DatoTabla> listaDatos;


    public String dato="";
    @FXML
    void iniciarPostgreSql(ActionEvent e){
        dato = "hibernatePost.cfg.xml";
        initialize1(dato);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        listaDatos= FXCollections.observableArrayList();

        this.colum_idAlum.setCellValueFactory(new PropertyValueFactory("idAlumno"));
        this.colum_nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colum_ciudad.setCellValueFactory(new PropertyValueFactory("ciudad"));
        this.colum_estado.setCellValueFactory(new PropertyValueFactory("estado"));
        this.colum_usuario.setCellValueFactory(new PropertyValueFactory("usuario"));
    }


    public void initialize1(String dato)
    {
        //Combo_BoxCity.getItems().clear();
        List<alumno> listAlum = null;

        System.out.println("Entra op1");
        DAOAlumno daoAlum = new DAOAlumno(dato);
        List alumnos = daoAlum.Listado();
    listAlum = alumnos;
        System.out.println("End op1");

        List<usuario> listUser = null;

        System.out.println("Entra op2");
        dato = "hibernateServer.cfg.xml";
        DAOUsuario daoUser = new DAOUsuario(dato);
        List users =  daoUser.Listado();
    listUser = users;
        System.out.println("End op2");

        List<ciudad> listCiudad = null;

        System.out.println("Entra op3");
        dato = "hibernate.cfg.xml";
        DAOCiudad daoCity = new DAOCiudad(dato);
        List ciudades = daoCity.Listado();
    listCiudad = ciudades;
        System.out.println("End op3");

        List<estado> listEstado = null;

        System.out.println("Entra op4");
        dato = "hibernate.cfg.xml";
        DAOEstado daoEstado = new DAOEstado(dato);
        List estados = daoEstado.Listado();
    listEstado = estados;
        System.out.println("End op4");
        this.listaDatos.clear();

        for (usuario user: listUser){
            for (alumno alum: listAlum){
                if(user.getIdUsuario() == alum.getIdUsuario()){
                    for(ciudad ciudad: listCiudad){
                        if(alum.getIdCiudad() == ciudad.getIdCiudad()){
                            for(estado estad: listEstado){
                                if(ciudad.getIdEstado() == estad.getIdEstado()){
                                    System.out.println("IdAlumno:"+alum.getIdAlumno()+ " Nombre: "+alum.getNombre()+ " Ciudad:"+ciudad.getNombre()+ " Estado: "+ estad.getNombre());

                                    try{

                                        DatoTabla datos = new DatoTabla(alum.getIdAlumno(), alum.getNombre(), ciudad.getNombre(), estad.getNombre(), user.getNombre());
                                        this.listaDatos.add(datos);

                                    }catch (Exception e){
                                        System.out.println("Error de llenado");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        this.tablaDatos.setItems(listaDatos);

    }


    @FXML
    public void iniciarSqlServer(){

        this.listaDatos.clear();

        ResultSet reultQ;
        try{
            Connection con = ConexionSqlServer.getConexion();
            PreparedStatement ps = con.prepareStatement("  select * from alumnos.dbo.usuario as us \n" +
                    "\t\tinner join POSTGRESQLLOCAL...alumno as al on us.idUsuario=al.idusuario\n" +
                    "\t\t\t inner join MYSQLLOCAL...ciudad as ci on al.idciudad = ci.idCiudad \n" +
                    "\t\t\t inner join MYSQLLOCAL...estado as es on ci.idEstado = es.idestado");
            reultQ = ps.executeQuery();
            while (reultQ.next()){
                System.out.println("idAlumno "+reultQ.getString(3) + " Nombre: " +reultQ.getString(5)+ " Ciudad: " + reultQ.getString(9)+ " Estado:" + reultQ.getString(11) + " User: "+ reultQ.getString(2));
                DatoTabla datosServer = new DatoTabla(Integer.parseInt(reultQ.getString(3)), reultQ.getString(5), reultQ.getString(9), reultQ.getString(11), reultQ.getString(2));
                this.listaDatos.add(datosServer);
                //mostrar print de tabla

            }
            this.tablaDatos.setItems(listaDatos);
            System.out.println("Peticion enviada");
        }catch (SQLException e){
            System.out.println( "Catch "+e.toString());
        }
    }

}


