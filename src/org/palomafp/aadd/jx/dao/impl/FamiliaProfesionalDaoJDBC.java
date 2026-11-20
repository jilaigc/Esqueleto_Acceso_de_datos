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
	public boolean existeFamiliaProfesionalPorCod(String codFamilia) throws FormacionException {
		boolean existe = false;
		String sentenciaSQL = "SELECT EXISTS(SELECT 1 FROM T_FAMILIA_PROFESIONAL WHERE codigo = ?) AS existe_familia";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
			sentenciaPreparada.setString(1, codFamilia);
			try (ResultSet resultados = sentenciaPreparada.executeQuery()) {
				if (resultados.next()) {
					existe = resultados.getBoolean("existe_familia");
				}
			}
		} catch (SQLException e) {
			throw new FormacionException("Error al comprobar si existe la familia " + codFamilia + ".", e);
		}
		return existe;
	}

	@Override
	public boolean existeFamiliaProfesionalPorClave(String codFamiliaProfesional) throws FormacionException {
		return existeFamiliaProfesionalPorCod(codFamiliaProfesional);
	}

	@Override
	public void insertarFamiliaProfesional(FamiliaProfesional familia) throws FormacionException {
		String sentenciaSQL = "INSERT INTO T_FAMILIA_PROFESIONAL (codigo, nombre) VALUES (?, ?)";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
			sentenciaPreparada.setString(1, familia.getCodigoFamilia());
			sentenciaPreparada.setString(2, familia.getNombre());
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			throw new FormacionException("Error al insertar la familia " + familia.getCodigoFamilia() + ".", e);
		}
	}

	@Override
	public void actualizarFamiliaProfesional(FamiliaProfesional familia) throws FormacionException {
		String sentenciaSQL = "UPDATE T_FAMILIA_PROFESIONAL SET nombre = ? WHERE codigo = ?";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
			sentenciaPreparada.setString(1, familia.getNombre());
			sentenciaPreparada.setString(2, familia.getCodigoFamilia());
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			throw new FormacionException("Error al actualizar la familia " + familia.getCodigoFamilia() + ".", e);
		}
	}
}