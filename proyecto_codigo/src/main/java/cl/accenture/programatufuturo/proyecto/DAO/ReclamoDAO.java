package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Estado;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ReclamoDAO {

    private Conexion conexion;

    public ReclamoDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public void insertarReclamo(Reclamo a) throws SinConexionException {

        try {

            PreparedStatement pstatementInsert = conexion.getConexion().prepareStatement("INSERT INTO reclamo (Id, Titulo, Descripcion, fecha, estado, region)" + "VALUES (?,?,?,?,?,?)");

            pstatementInsert.setInt(1,a.getId());
            pstatementInsert.setString(2,a.getTitulo());
            pstatementInsert.setString(3,a.getDescripcion());
            pstatementInsert.setDate(4, (Date) a.getFecha());
            pstatementInsert.setInt(5, a.getEstado().getId());
            pstatementInsert.setString(6,a.getRegion());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
