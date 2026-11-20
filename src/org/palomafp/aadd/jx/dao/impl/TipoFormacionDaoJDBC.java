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
	public boolean existeTipoFormacionPorCod(String codTipo) throws FormacionException {
		boolean existe = false;
		String sentenciaSQL = "SELECT EXISTS(SELECT 1 FROM T_TIPO_FORMACION WHERE codigo = ?) AS existe_tipo";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
			sentenciaPreparada.setString(1, codTipo);

			try (ResultSet resultados = sentenciaPreparada.executeQuery()) {
				if (resultados.next()) {
					existe = resultados.getBoolean("existe_tipo");
				}
			}
		} catch (SQLException e) {
			throw new FormacionException("Error al comprobar si existe el tipo de formación " + codTipo + ".", e);
		}
		return existe;
	}

	@Override
	public boolean existeTipoFormacionPorClave(String codigoTipoFormacion) throws FormacionException {
		return existeTipoFormacionPorCod(codigoTipoFormacion);
	}
}