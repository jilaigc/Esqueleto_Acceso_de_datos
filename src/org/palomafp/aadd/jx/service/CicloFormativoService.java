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
import org.palomafp.aadd.jx.gestor.GestorConexionesBBDD;
import org.palomafp.aadd.jx.model.CicloFormativo;

public class CicloFormativoService {
	public void insertarCicloFormativo(CicloFormativo cicloFormativo) throws FormacionException {

		try (Connection conexion = GestorConexionesBBDD.obtenerConexion();) {
			IFamiliaProfesionalDAO iFamiliaProfesionalDAO = new FamiliaProfesionalDaoJDBC(conexion);
			boolean existeFamiliaProfesional = false;
			existeFamiliaProfesional = iFamiliaProfesionalDAO.existeFamiliaProfesionalPorClave(cicloFormativo.getFamiliaProfesional().getCodigo());

			boolean existeTipoFormacion= false;
			ITipoFormacionDAO iTipoFormacionDAO= new TipoFormacionDaoJDBC(conexion);
			existeTipoFormacion= iTipoFormacionDAO.existeTipoFormacionPorClave(cicloFormativo.getTipoFormacion().getCodigo());
			
			ICicloFormativoDAO iCicloFormativoDAO = new CicloFormativoDaoJDBC(conexion);
			if(existeFamiliaProfesional && existeTipoFormacion) {
				iCicloFormativoDAO.insertarCicloFormativo(cicloFormativo);
			}
		} catch (SQLException e) {
			throw new FormacionException("Error al obtener la conexión", e);
		}
	}

}