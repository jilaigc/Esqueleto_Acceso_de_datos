package org.palomafp.aadd.jx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.palomafp.aadd.jx.dao.ITipoFormacionDAO;
import org.palomafp.aadd.jx.excepcion.FormacionException;

public class TipoFormacionDaoJDBC implements ITipoFormacionDAO {
	private final Connection conexion;

	public TipoFormacionDaoJDBC(Connection conexion) {
		this.conexion = conexion;
	}
	@Override
	public boolean existeTipoFormacionPorClave(String codigoTipoFormacion) throws FormacionException {
		boolean existeTipoFormacion = false;

		String sentenciaSQL = """
				SELECT EXISTS(
					SELECT 1
					FROM T_TIPO_FORMACION
					WHERE codigo = ?
					) AS existe_tf
				""";
//		System.out.println(sentenciaSQL);
		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);) {
			sentenciaPreparada.setString(1, codigoTipoFormacion);
			ResultSet resultados = sentenciaPreparada.executeQuery();
			if (resultados.next()) {
				existeTipoFormacion = resultados.getBoolean("existe_tf");
			}

		} catch (SQLException e) {
			throw new FormacionException("Error al validar si existe un tipo de formación por código.", e);
		}

		return existeTipoFormacion;
	}

}