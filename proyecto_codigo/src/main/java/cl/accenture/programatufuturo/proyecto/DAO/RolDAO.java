package cl.accenture.programatufuturo.proyecto.DAO;

public class RolDAO {

    private Conexion conexion;

    public RolDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    // Agregar Rol, no retornamos nada, recibimos un Rol
    public void agregarRol(Rol x) throws SinConexionException {
        try {

            // en mi SQL hago un INSERT TO, y VALUES, con signos de interrogacion en los valores de las columnas
            // y a continuación les dadamos el valor
            final String SQL = "INSERT INTO Rol(id, nombre) VALUES (?,?)";

            PreparedStatement ps = conexion.getConexion().prepareStatement(SQL);

            // ingresamos los valores con Set, segun el lugar del signo,
            // y un get de la respuesta recibida según corresponda
            ps.setInteger(1, x.getId());
            ps.setString(2, x.getNombre());

            // Ejecutamos el almacenamiento
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Obetener lista de Roles, retornamos una List de Rol, no recibo nada.
    public List<Usuario> obtenerAll() throws SinConexionException {

        // Creo mi List y la inicializo como una ArrayList
        List<Rol> roles = new ArrayList<Rol>();

        try {

            // Selecciono todas las columnas, de la tabla Rol
            final String SQL = "SELECT * FROM Rol";

            // Creo mi PreparedStatement, con la conexion con mi SQL
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // en el ResultSet ejecuto la Query del ps.
            ResultSet rs = ps.executeQuery();

            // Mientras rs, siga teniendo respuestas, entonces
            while (rs.next()) {

                // creo un nuevo usuario SIN PARAMETROS
                Rol r = new Rol();

                // Asigno sus parametros al objeto previamente creado
                r.setId(rs.getInteger(1));
                r.setNombre(rs.getString(2));

                // añado mi Rol con sus atributos ya ingresados en mi list
                roles.add(r);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    // Eliminar un rol según su id, no retorno nada, recibo un int (id del Rol)
    public void eliminarRol (int x) throws SinConexionException {
        try {

            // Elimino todas las columnas de la tabla Rol, donde el id
            // sea igual a ? (valor ingresado a contiuacion)
            final String SQL = "DELETE * FROM Rol WHERE id = ?";

            // creo un Statement, conecto y creo Statement
            Statement sentenciaDelete = this.conexion.getConexion().createStatement();

            // variable resultado de esto, que sería la variable del
            // Statement ejecutando la modificacion del SQL.
            int resultadoDelete = sentenciaDelete.executeUpdate(SQL);

            // creo un PS, del SQL
            PreparedStatement ps = this.conexion.getConexion().prepareStatement(SQL);

            // le asigno valor a mi '?' que en este caso será el String que nos entregan (u)
            ps.setString(1, x);

            // ejecuto la modificacion
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
