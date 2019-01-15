package cl.accenture.programatufuturo.proyecto.DAO;

public class RespuestaDAO {

    private Conexion conexion;

    public RespuestaDAO(Conexion conexion) {
        this.conexion = new conexion;
    }

    // Añadir Respuesta, no retornamos nada, recibimos un Usuario
    public void añadirRespuesta(Respuesta x) throws SinConexionException {
        try{

            // en mi SQL hago un INSERT TO, y VALUES, con signos de interrogacion en los valores de las columnas
            // y a continuación les dadamos el valor
            final String SQL = "INSERT INTO Respuesta(id, comentario, usuario, fecha) VALUES (?,?,?,?)";


            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);

            // ingresamos los valores con Set, segun el lugar del signo,
            // y un get de la respuesta recibida según corresponda
            ps.setInt(1,x.getId());
            ps.setString(2,x.getComentario());
            ps.setUsuario(3,x.getUsuario());
            ps.setDate(4,x.getFecha());

            // Ejecutamos el almacenamiento
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ordenar por Fecha, retorno lista ordenada, no recibo nada.
    public List<Respuesta> ordenarPorFecha (){
        List<Respuesta> respuestas = new ArrayList<Respuesta>();

        try{
            final String SQL = "SELECT * FROM Respuesta";

            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Respuesta res = new Respuesta();

                res.setId(rs.getInt(1));
                res.setComentario(rs.getString(2));
                res.setUsuario(rs.getUsuario(3));
                res.setFecha(rs.getDate(4));

                respuestas.add(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.sort(respuestas);
    }

}
