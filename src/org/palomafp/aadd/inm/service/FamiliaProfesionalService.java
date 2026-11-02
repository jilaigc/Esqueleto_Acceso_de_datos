package org.palomafp.aadd.inm.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.palomafp.aadd.inm.dao.IFamiliaProfesionalDAO;
import org.palomafp.aadd.inm.dao.impl.FamiliaProfesionalDaoJDBC;
import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.gestores.GestorConexionesBBDD;
import org.palomafp.aadd.inm.model.FamiliaProfesional;

/**
 *
 * FamiliaProfesionalService: Clase que se encarga de las operaciones de
 * servicio de una Familia Profesional.
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 29 oct 2026
 * 
 * 
 */

public class FamiliaProfesionalService {
	public boolean existeFamiliaProfesionalPorClave(String codFamiliaProfesional) throws FormacionException {
		boolean existeFP = false;

		try (Connection conexion = GestorConexionesBBDD.obtenerConexion();) {
			IFamiliaProfesionalDAO iFamiliaProfesionalDAO = new FamiliaProfesionalDaoJDBC(conexion);
			existeFP = iFamiliaProfesionalDAO.existeFamiliaProfesionalPorClave(codFamiliaProfesional);
		} catch (SQLException e) {
			throw new FormacionException("Error al obtener la conexión", e);
		}
		return existeFP;
	}

	public void insertarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException {

		try (Connection conexion = GestorConexionesBBDD.obtenerConexion();) {
			IFamiliaProfesionalDAO iFamiliaProfesionalDAO = new FamiliaProfesionalDaoJDBC(conexion);
			iFamiliaProfesionalDAO.insertarFamiliaProfesional(familiaProfesional);
		} catch (SQLException e) {
			throw new FormacionException("Error al obtener la conexión", e);
		}
	}

	public void actualizarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException {

		try (Connection conexion = GestorConexionesBBDD.obtenerConexion();) {
			IFamiliaProfesionalDAO iFamiliaProfesionalDAO = new FamiliaProfesionalDaoJDBC(conexion);
			iFamiliaProfesionalDAO.actualizarFamiliaProfesional(familiaProfesional);
		} catch (SQLException e) {
			throw new FormacionException("Error al obtener la conexión", e);
		}
	}

}
