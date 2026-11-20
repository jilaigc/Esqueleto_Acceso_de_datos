package org.palomafp.aadd.jx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.palomafp.aadd.jx.dao.IFamiliaProfesionalDAO;
import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.model.FamiliaProfesional;

public class FamiliaProfesionalDaoJDBC implements IFamiliaProfesionalDAO {
	private final Connection conexion;

	public FamiliaProfesionalDaoJDBC(Connection conexion) {
		this.conexion = conexion;
	}
	
	@Override
	public boolean existeFamiliaProfesionalPorClave(String codFamiliaProfesional) throws FormacionException {
		boolean existeFamiliaProfesional = false;

		String sentenciaSQL = """
				SELECT EXISTS(
					SELECT 1
					FROM T_FAMILIA_PROFESIONAL
					WHERE codigo = ?
					) AS existe_fp
				""";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);) {
			sentenciaPreparada.setString(1, codFamiliaProfesional);
			ResultSet resultados = sentenciaPreparada.executeQuery();
			if (resultados.next()) {
				existeFamiliaProfesional = resultados.getBoolean("existe_fp");
			}

		} catch (SQLException e) {
			throw new FormacionException("Error al validar si existe una familia profesional por código.", e);
		}

		return existeFamiliaProfesional;
	}

	@Override
	public void insertarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException {
		String sentenciaSQL = """
				INSERT INTO T_FAMILIA_PROFESIONAL (codigo, nombre)
				VALUES (?, ?)
				""";

		
		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);) {
			sentenciaPreparada.setString(1, familiaProfesional.getCodigo());
			sentenciaPreparada.setString(2, familiaProfesional.getNombre());
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			throw new FormacionException("Error al insertar una familia profesional.", e);
		}

	}

	@Override
	public void actualizarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException {
		String sentenciaSQL = """
				UPDATE T_FAMILIA_PROFESIONAL
				SET nombre = ?
				WHERE codigo= ?
				""";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);) {
			sentenciaPreparada.setString(1, familiaProfesional.getNombre());
			sentenciaPreparada.setString(2, familiaProfesional.getCodigo());
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			throw new FormacionException("Error al actualizar una familia profesional.", e);
		}
	}

}