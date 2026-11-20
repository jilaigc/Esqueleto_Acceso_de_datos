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
	public void insertarCicloFormativo(CicloFormativo cicloFormativo) throws FormacionException {

		String sentenciaSQL = """
				INSERT INTO T_CICLO_FORMATIVO (codigo, nombre_corto, nombre_largo, horas_duracion, codigo_familia, codigo_tipo_formacion)
				VALUES (?, ?, ?, ?, ?, ?)
				""";
//		System.out.println(sentenciaSQL);
		try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(sentenciaSQL);) {
			sentenciaPreparada.setString(1, cicloFormativo.getCodigo());
			sentenciaPreparada.setString(2, cicloFormativo.getNombreCorto());
			sentenciaPreparada.setString(3, cicloFormativo.getNombreLargo());
			sentenciaPreparada.setInt(4, cicloFormativo.getNumeroHorasDuracion());
			sentenciaPreparada.setString(5, cicloFormativo.getFamiliaProfesional().getCodigo());
			sentenciaPreparada.setString(6, cicloFormativo.getTipoFormacion().getCodigo());
			sentenciaPreparada.executeUpdate();
		} catch (SQLException e) {
			throw new FormacionException("Error al insertar un ciclo formativo.", e);
		}

	}

}