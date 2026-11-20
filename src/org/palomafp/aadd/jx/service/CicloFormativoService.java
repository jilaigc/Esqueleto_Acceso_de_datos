package org.palomafp.aadd.jx.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.palomafp.aadd.jx.dao.ICicloFormativoDAO;
import org.palomafp.aadd.jx.dao.IFamiliaProfesionalDAO;
import org.palomafp.aadd.jx.dao.ITipoFormacionDAO;
import org.palomafp.aadd.jx.dao.impl.CicloFormativoDaoJDBC;
import org.palomafp.aadd.jx.dao.impl.FamiliaProfesionalDaoJDBC;
import org.palomafp.aadd.jx.dao.impl.TipoFormacionDaoJDBC;
import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConexionBBDD;
import org.palomafp.aadd.jx.model.CicloFormativo;

public class CicloFormativoService {

	public void insertarCiclo(CicloFormativo ciclo) throws FormacionException {
		try (Connection conexion = GestorConexionBBDD.obtenerConexion()) {
			IFamiliaProfesionalDAO familiaDao = new FamiliaProfesionalDaoJDBC(conexion);
			ITipoFormacionDAO tipoDao = new TipoFormacionDaoJDBC(conexion);
			ICicloFormativoDAO cicloDao = new CicloFormativoDaoJDBC(conexion);

			// Validamos integridad referencial antes de insertar
			String codFamilia = ciclo.getFamiliaProfesional().getCodigoFamilia();
			if (!familiaDao.existeFamiliaProfesionalPorClave(codFamilia)) {
				throw new FormacionException("No existe la familia profesional con código: " + codFamilia);
			}

			String codTipo = ciclo.getTipoFormacion().getCodigo();
			if (!tipoDao.existeTipoFormacionPorClave(codTipo)) {
				throw new FormacionException("No existe el tipo de formación con código: " + codTipo);
			}

			cicloDao.insertarCicloFormativo(ciclo);

		} catch (SQLException e) {
			throw new FormacionException("Error de conexión al insertar el ciclo formativo.", e);
		}
	}
}