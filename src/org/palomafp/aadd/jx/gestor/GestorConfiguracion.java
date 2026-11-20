package org.palomafp.aadd.jx.gestor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.palomafp.aadd.jx.excepcion.FormacionException;

public class GestorConfiguracion {

	private static final String RUTA_FICHERO_CONFIGURACION = "application.properties";
	private static final Properties PROPIEDADES_CONFIGURACION = new Properties();
	private static boolean cargado = false;

	private GestorConfiguracion() {
	}

	private static void cargarPropiedades() throws FormacionException {
		if (!cargado) {
			try (InputStream is = GestorConfiguracion.class.getClassLoader()
					.getResourceAsStream(RUTA_FICHERO_CONFIGURACION)) {
				if (is == null) {
					throw new FormacionException(
							"No se ha encontrado el fichero de configuración: " + RUTA_FICHERO_CONFIGURACION);
				}
				PROPIEDADES_CONFIGURACION.load(is);
				cargado = true;

			} catch (IOException e) {
				throw new FormacionException("No se ha podido cargar el fichero de configuración", e);
			}
		}
	}
	
	public static String getRutaJsonFamilias() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("ruta.json.familias", "./ficheros/familias_pro.json");
	}
	
	public static String getRutaXmlFormacion() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("ruta.xml.formaciones", "./ficheros/catalogo_formacion.xml");
	}

	public static String getRutaFicheroCSVFamiliaProfesional() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("ruta.csv.familias", "./ficheros/familias_profesionales.csv");
	}
	
	public static String getClaseDriver() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("sgdb.clase.driver");
	}

	public static String getConexionURL() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("sgdb.conexion.url");
	}

	public static String getNombreBBDD() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("bbdd.nombre");
	}

	public static String getUsuarioBBDD() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("bbdd.usuario");
	}

	public static String getClaveBBDD() throws FormacionException {
		cargarPropiedades();
		return PROPIEDADES_CONFIGURACION.getProperty("bbdd.clave");
	}
}