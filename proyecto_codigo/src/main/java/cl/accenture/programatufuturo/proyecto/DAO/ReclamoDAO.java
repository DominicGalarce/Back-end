package cl.accenture.programatufuturo.proyecto.DAO;

import cl.accenture.programatufuturo.proyecto.exception.SinConexionException;
import cl.accenture.programatufuturo.proyecto.model.Reclamo;
import cl.accenture.programatufuturo.proyecto.model.Estado;


import java.sql.*;

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

    public void buscarPorId(int a) throws SinConexionException{
        try {

            PreparedStatement pstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM reclamo WHERE idreclamo=?");
            pstatementSelect.setInt(1, a);
            ResultSet rs = pstatementSelect.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("idreclamo"));
                System.out.println(rs.getString("titulo"));
                System.out.println(rs.getString("descripcion"));

                PreparedStatement psstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM usuario WHERE idusuario in (SELECT idreclamo FROM reclamo WHERE idreclamo=?");
                psstatementSelect.setInt(1, a);
                ResultSet rss = pstatementSelect.executeQuery();
                System.out.println(rss.getString("nombre"));

                System.out.println(rs.getDate("fecha"));
                System.out.println(rs.getString("region"));

                PreparedStatement ppsstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM estado WHERE idestado in (SELECT idreclamo FROM reclamo WHERE idreclamo=?");
                ppsstatementSelect.setInt(1, a);
                ResultSet rrss = pstatementSelect.executeQuery();
                System.out.println(rrss.getString("nombre"));

                PreparedStatement pesstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM tiporeclamo WHERE idtiporeclamo in (SELECT idreclamo FROM reclamo WHERE idreclamo=?");
                pesstatementSelect.setInt(1, a);
                ResultSet ress = pstatementSelect.executeQuery();
                System.out.println(ress.getString("nombre"));

            }

            PreparedStatement prstatementSelect = conexion.getConexion().prepareStatement("SELECT * FROM respuesta WHERE id=?");
            prstatementSelect.setInt(1, a);
            ResultSet prs = prstatementSelect.executeQuery();

            while (prs.next()) {
                System.out.println(prs.getString("comentario"));

                PreparedStatement ppesstatementSelect = conexion.getConexion().prepareStatement("SELECT nombre FROM usuario WHERE idusuario in (SELECT idreclamo FROM reclamo WHERE idreclamo=?");
                ppesstatementSelect.setInt(1, a);
                ResultSet rress = pstatementSelect.executeQuery();
                System.out.println(rress.getString("nombre"));

                System.out.println(prs.getDate("fecha"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
