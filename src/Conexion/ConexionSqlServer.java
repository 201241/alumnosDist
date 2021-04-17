package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSqlServer {

    public static Connection getConexion(){

        String url = "jdbc:sqlserver://localhost:1433;"
                + "database=alumnos;"
                +"user=sa;"
                +"password=201241;";

        try{
            Connection con = DriverManager.getConnection(url);
            return con;
        }catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }

}
