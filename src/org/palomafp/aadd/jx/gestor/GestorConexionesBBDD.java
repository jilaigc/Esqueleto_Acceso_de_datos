package org.palomafp.aadd.jx.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexionesBBDD {


	private GestorConexionesBBDD() {
	}

	public static Connection obtenerConexion() throws SQLException {
		Connection conexion = null;

		String urlConexionCompleta = GestorConfiguracion.getConexionURL() + GestorConfiguracion.getNombreBBDD();
		String usuarioBBDD = GestorConfiguracion.getUsuarioBBDD();
		String claveBBDD = GestorConfiguracion.getClaveBBDD();
		conexion = DriverManager.getConnection(urlConexionCompleta, usuarioBBDD, claveBBDD);

		return conexion;
	}
}