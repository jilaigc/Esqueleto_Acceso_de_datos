package org.palomafp.aadd.jx.gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.palomafp.aadd.jx.excepcion.FormacionException;

public class GestorConexionBBDD {

	private GestorConexionBBDD() {
	}

	public static Connection obtenerConexion() throws FormacionException {
		Connection conexion = null;
		
		try {
			Class.forName(GestorConfiguracion.getClaseDriver());

			String urlConexionCompleta = GestorConfiguracion.getConexionURL() + GestorConfiguracion.getNombreBBDD();
			String usuarioBBDD = GestorConfiguracion.getUsuarioBBDD();
			String claveBBDD = GestorConfiguracion.getClaveBBDD();
			
			conexion = DriverManager.getConnection(urlConexionCompleta, usuarioBBDD, claveBBDD);
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new FormacionException("No se ha podido obtener una conexión con el SGBD", e); 
		}
		return conexion;
	}
}