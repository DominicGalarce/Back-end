package cl.accenture.programatufuturo.proyecto.DAO;
import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Conexion conexion;

    public UsuarioDAO(){

        this.conexion = new Conexion();
    }


    public boolean login(Usuario usuario)throws SinConexionException {

        try{
            final String SQL = "select * from usuario where " +
                    "nombre=? and contraseña=?";

            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setString(1, usuario.getNombre() );
            ps.setString(2, usuario.getContraseña() );

            ResultSet rs = ps.executeQuery();
            return rs.next();

        }catch (SQLException e){
            return false;
        }
    }
}



