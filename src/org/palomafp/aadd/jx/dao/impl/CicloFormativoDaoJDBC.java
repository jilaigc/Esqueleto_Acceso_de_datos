package org.palomafp.aadd.jx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.palomafp.aadd.jx.dao.ICicloFormativoDAO;
import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.model.CicloFormativo;

public class CicloFormativoDaoJDBC implements ICicloFormativoDAO {

	private final Connection conexion;

	public CicloFormativoDaoJDBC(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void insertarCicloFormativo(CicloFormativo ciclo) throws FormacionException {
		String sentenciaSQL = """
				INSERT INTO T_CICLO_FORMATIVO 
				(codigo, nombre_corto, nombre_largo, horas_duracion, codigo_familia, codigo_tipo_formacion) 
				VALUES (?, ?, ?, ?, ?, ?)
				""";

		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL)) {
			sentenciaPreparada.setString(1, ciclo.getCodigoFormacion());
			sentenciaPreparada.setString(2, ciclo.getNombreCorto());
			sentenciaPreparada.setString(3, ciclo.getNombreLargo());
			sentenciaPreparada.setInt(4, ciclo.getHorasDuracion());
			sentenciaPreparada.setString(5, ciclo.getFamiliaProfesional().getCodigoFamilia());
			sentenciaPreparada.setString(6, ciclo.getTipoFormacion().getCodigo());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			throw new FormacionException("Error al insertar el ciclo formativo " + ciclo.getCodigoFormacion() + ".", e);
		}
	}
}