package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.PaginaWeb;
import vos.Restaurante;


public class DAOTablaRestaurante 
{
	/**
	 * Clase DAO que se conecta la base de datos usando JDBC para resolver los requerimientos de la aplicación
	 * @author Monitores 2017-20
	 */
	public class DAOTablaVideos {


		/**
		 * Arraylits de recursos que se usan para la ejecución de sentencias SQL
		 */
		private ArrayList<Object> recursos;

		/**
		 * Atributo que genera la conexión a la base de datos
		 */
		private Connection conn;

		/**
		 * Metodo constructor que crea DAOVideo
		 * <b>post: </b> Crea la instancia del DAO e inicializa el Arraylist de recursos
		 */
		public DAOTablaVideos() {
			recursos = new ArrayList<Object>();
		}

		/**
		 * Metodo que cierra todos los recursos que estan enel arreglo de recursos
		 * <b>post: </b> Todos los recurso del arreglo de recursos han sido cerrados
		 */
		public void cerrarRecursos() {
			for(Object ob : recursos){
				if(ob instanceof PreparedStatement)
					try {
						((PreparedStatement) ob).close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
			}
		}

		/**
		 * Metodo que inicializa la connection del DAO a la base de datos con la conexión que entra como parametro.
		 * @param con  - connection a la base de datos
		 */
		public void setConn(Connection con){
			this.conn = con;
		}

		/**
		 * Metodo que, usando la conexión a la base de datos, saca todos los restaurantes de la base de datos
		 * <b>SQL Statement:</b> SELECT * FROM RESTAURANTE;
		 * @return Arraylist con los videos de la base de datos.
		 * @throws SQLException - Cualquier error que la base de datos arroje.
		 * @throws Exception - Cualquier error que no corresponda a la base de datos
		 */
		public ArrayList<Restaurante> darRestaurantes() throws SQLException, Exception {
			ArrayList<Restaurante> restaruantes = new ArrayList<Restaurante>();

			String sql = "SELECT * FROM RESTAURANTE";

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("NAME");
				Long id = rs.getLong("ID");
				String representante= rs.getString("REPRESENTANTE");
				String tipoComida= rs.getString("TIPO_COMIDA");
				Long idPaginaWeb= rs.getLong("ID_PAGINAWEB");
				Long idZona=rs.getLong("ID_ZONE");
				Restaurante vo = new Restaurante();
				vo.setId(id);
				vo.setnombre(name);
				vo.setrepresentante(representante);
				vo.settipoComida(tipoComida);
				vo.setIdPaginaWeb(idPaginaWeb);
				vo.setIdZona(idZona);
            restaruantes.add(vo);
			}
			return restaruantes;
		}
		
		


		/**
		 * Metodo que busca el video con el id que entra como parametro.
		 * @param name - Id de el video a buscar
		 * @return Restaurante encontrado
		 * @throws SQLException - Cualquier error que la base de datos arroje.
		 * @throws Exception - Cualquier error que no corresponda a la base de datos
		 */
	
		public Restaurante buscarRestaurantePorId(Long id) throws SQLException, Exception 
		{
			Restaurante restaurante = null;

			String sql = "SELECT * FROM RESTAURANTE WHERE ID =" + id;

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			ResultSet rs = prepStmt.executeQuery();

			if(rs.next()) {
				String name = rs.getString("NOMBRE");
				Long id2 = rs.getLong("ID");
				String representante = rs.getString("REPRESENTANTE");
				String tipoComida = rs.getString("TIPO_COMIDA");
				Long idZona = rs.getLong("ID_ZONA");
				Long idPaginaWeb = rs.getLong("ID_PAGINAWEB");
				
				restaurante = new Restaurante(id2, name, representante, tipoComida, null, null, null, idZona, idPaginaWeb);
				
				
				
			}

			return restaurante;
		}

		/**
		 * Metodo que agrega el video que entra como parametro a la base de datos.
		 * @param video - el video a agregar. video !=  null
		 * <b> post: </b> se ha agregado el video a la base de datos en la transaction actual. pendiente que el video master
		 * haga commit para que el video baje  a la base de datos.
		 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo agregar el video a la base de datos
		 * @throws Exception - Cualquier error que no corresponda a la base de datos
		 */
		public void addRestaurante(Restaurante restaurante) throws SQLException, Exception {

			String sql = "INSERT INTO Restaurante VALUES (";
			sql += restaurante.getId() + ",'";
			sql += restaurante.getnombre() + "',";
			sql += restaurante.getrepresentante() + "',";
			sql += restaurante.gettipoComida() + "',";
			sql += restaurante.getIdZona() + "',";
			sql += restaurante.getIdPaginaWeb() + "',";

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();

		}
		
		/**
		 * Metodo que actualiza el video que entra como parametro en la base de datos.
		 * @param video - el video a actualizar. video !=  null
		 * <b> post: </b> se ha actualizado el video en la base de datos en la transaction actual. pendiente que el video master
		 * haga commit para que los cambios bajen a la base de datos.
		 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
		 * @throws Exception - Cualquier error que no corresponda a la base de datos
		 */
		public void updateRestaurante(Restaurante restaurante) throws SQLException, Exception {

			String sql = "UPDATE VIDEO SET ";
			sql += "NOMBRE='" + restaurante.getnombre() + "',";
			sql += "REPRESENTANTE=" + restaurante.getrepresentante()+ "',";
			sql += "TIPO_COMIDA=" + restaurante.gettipoComida()+ "',";
			sql += "ID_ZONA=" + restaurante.getIdZona()+ "',";
			sql += "ID_PAGINAWEB=" + restaurante.getIdPaginaWeb()+ "',";
			sql += " WHERE ID = " + restaurante.getId();


			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

		/**
		 * Metodo que elimina el video que entra como parametro en la base de datos.
		 * @param video - el video a borrar. video !=  null
		 * <b> post: </b> se ha borrado el video en la base de datos en la transaction actual. pendiente que el video master
		 * haga commit para que los cambios bajen a la base de datos.
		 * @throws SQLException - Cualquier error que la base de datos arroje. No pudo actualizar el video.
		 * @throws Exception - Cualquier error que no corresponda a la base de datos
		 */
		public void deleteRestaurante(Restaurante restaurante) throws SQLException, Exception {

			String sql = "DELETE FROM RESTAURANTE";
			sql += " WHERE ID = " + restaurante.getId();

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}

	}


}
