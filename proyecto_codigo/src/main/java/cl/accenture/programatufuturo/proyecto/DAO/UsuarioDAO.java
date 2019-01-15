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

    // Login para ingresar, retorna un boolean, recibe un Usuario
    public boolean login(Usuario usuario)throws SinConexionException {

        try{
            final String SQL = "SELECT * FROM usuario WHERE nombre=? AND contraseña=?";

            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);
            ps.setString(1, usuario.getNombre() );
            ps.setString(2, usuario.getContraseña() );

            ResultSet rs = ps.executeQuery();
            return rs.next();

        }catch (SQLException e){
            return false;
        }
    }

    // Buscar un Usuario por su nombre, retorno una Lista de Usuarios
    // recibo un String que será el nombre del Usuario
    public List<Usuario> buscarUsuarioPorNombre (String name) throws SinConexionException {

        // Creo mi lista, de tipo Array porque quiero >:)
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            // Selecciono todas las columnas de la tabla Usuario, donde
            // su nombre sea equivalente a un valor que entregaré a continuacion
            final String SQL = "SELECT * FROM Usuario WHERE nombre = ?";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // aqui ingreso el valor de mi signo de interrogacion, es decir '?'
            // será igual a name que es el String que me ingresan (nombre del Usuario)
            ps.setString(1, name);

            // respuesta almacenada en una variable, de la Query ejecutada en ps.
            ResultSet rs = ps.executeQuery();

            // Mientras sigan habíendo respuestas
            while (rs.next()) {

                // Creo objeto Usuario
                Usuario user = new Usuario();

                // y le entrego los valores que corresponden a sus atributos
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setContraseña(rs.getString(4));
                user.setUltimoLogin(rs.getDate(5));
                user.setFechaNac(rs.getDate(6));
                user.setTelefono(rs.getInt(7));
                user.setNacionalidad(rs.getString(8));
                user.setRut(rs.getString(9));
                user.setGenero(rs.getString(10));
                user.setRol(rs.getRol(11));

                // añado la cancion a mi list
                usuarios.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // Buscar un Usuario por su email, retorno una Lista de Usuarios
    // recibo un String que será el email del Usuario
    public List<Usuario> buscarUsuarioPorEmail (String email) throws SinConexionException {

        // Creo mi lista, de tipo Array porque quiero >:)
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            // Selecciono todas las columnas de la tabla Usuario, donde
            // su email sea equivalente a un valor que entregaré a continuacion
            final String SQL = "SELECT * FROM Usuario WHERE email = ?";
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // aqui ingreso el valor de mi signo de interrogacion, es decir '?'
            // será igual a name que es el String que me ingresan (nombre del Usuario)
            ps.setString(1, email);

            // respuesta almacenada en una variable, de la Query ejecutada en ps.
            ResultSet rs = ps.executeQuery();

            // Mientras sigan habíendo respuestas
            while (rs.next()) {

                // Creo objeto Usuario
                Usuario user = new Usuario();

                // y le entrego los valores que corresponden a sus atributos
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setContraseña(rs.getString(4));
                user.setUltimoLogin(rs.getDate(5));
                user.setFechaNac(rs.getDate(6));
                user.setTelefono(rs.getInt(7));
                user.setNacionalidad(rs.getString(8));
                user.setRut(rs.getString(9));
                user.setGenero(rs.getString(10));
                user.setRol(rs.getRol(11));

                // añado la cancion a mi list
                usuarios.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }


    //
}



