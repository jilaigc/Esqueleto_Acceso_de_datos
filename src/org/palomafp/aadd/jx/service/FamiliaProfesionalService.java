package org.palomafp.aadd.jx.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.palomafp.aadd.jx.dao.IFamiliaProfesionalDAO;
import org.palomafp.aadd.jx.dao.impl.FamiliaProfesionalDaoJDBC;
import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConexionesBBDD;
import org.palomafp.aadd.jx.model.FamiliaProfesional;

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