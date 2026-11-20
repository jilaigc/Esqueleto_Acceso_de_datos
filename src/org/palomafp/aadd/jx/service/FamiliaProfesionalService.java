package org.palomafp.aadd.jx.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.palomafp.aadd.jx.dao.IFamiliaProfesionalDAO;
import org.palomafp.aadd.jx.dao.impl.FamiliaProfesionalDaoJDBC;
import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConexionBBDD;
import org.palomafp.aadd.jx.model.FamiliaProfesional;

public class FamiliaProfesionalService {

	public boolean existeFamiliaProfesionalPorClave(String codFamiliaProfesional) throws FormacionException {
		boolean existe = false;

		try (Connection conexion = GestorConexionBBDD.obtenerConexion()) {
			IFamiliaProfesionalDAO dao = new FamiliaProfesionalDaoJDBC(conexion);
			existe = dao.existeFamiliaProfesionalPorClave(codFamiliaProfesional);
		} catch (SQLException e) {
			throw new FormacionException("Error al comprobar la clave de la familia profesional", e);
		}
		return existe;
	}
	
	public void insertarFamiliaProfesional(FamiliaProfesional familia) throws FormacionException {
		try (Connection conexion = GestorConexionBBDD.obtenerConexion()) {
			IFamiliaProfesionalDAO dao = new FamiliaProfesionalDaoJDBC(conexion);

			if (dao.existeFamiliaProfesionalPorClave(familia.getCodigoFamilia())) {
				throw new FormacionException("La Familia " + familia.getCodigoFamilia() + " ya existe.");
			}
			dao.insertarFamiliaProfesional(familia);
		} catch (SQLException e) {
			throw new FormacionException("Error al insertar la familia profesional.", e);
		}
	}

	public void actualizarFamiliaProfesional(FamiliaProfesional familia) throws FormacionException {
		try (Connection conexion = GestorConexionBBDD.obtenerConexion()) {
			IFamiliaProfesionalDAO dao = new FamiliaProfesionalDaoJDBC(conexion);

			if (!dao.existeFamiliaProfesionalPorClave(familia.getCodigoFamilia())) {
				throw new FormacionException("La Familia " + familia.getCodigoFamilia() + " no existe.");
			}
			dao.actualizarFamiliaProfesional(familia);
		} catch (SQLException e) {
			throw new FormacionException("Error al actualizar la familia profesional.", e);
		}
	}
	
	public void insertarFamilia(FamiliaProfesional familia) throws FormacionException {
		insertarFamiliaProfesional(familia);
	}
	
	public void actualizarFamilia(FamiliaProfesional familia) throws FormacionException {
		actualizarFamiliaProfesional(familia);
	}
}