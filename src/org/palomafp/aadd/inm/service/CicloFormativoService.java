package org.palomafp.aadd.inm.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.palomafp.aadd.inm.dao.ICicloFormativoDAO;
import org.palomafp.aadd.inm.dao.IFamiliaProfesionalDAO;
import org.palomafp.aadd.inm.dao.ITipoFormacionDAO;
import org.palomafp.aadd.inm.dao.impl.CicloFormativoDaoJDBC;
import org.palomafp.aadd.inm.dao.impl.FamiliaProfesionalDaoJDBC;
import org.palomafp.aadd.inm.dao.impl.TipoFormacionDaoJDBC;
import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.gestores.GestorConexionesBBDD;
import org.palomafp.aadd.inm.model.CicloFormativo;

/**
 *
 * CicloFormativoService: Clase que se encarga de las operaciones de servicio de un Ciclo Formativo
 * (Casos de uso de CicloFormativo).
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 29 oct 2026
 * 
 * 
 */

public class CicloFormativoService {
	public void insertarCicloFormativo(CicloFormativo cicloFormativo) throws FormacionException {

		try (Connection conexion = GestorConexionesBBDD.obtenerConexion();) {
			// Comprobar que existe la familia profesional
			IFamiliaProfesionalDAO iFamiliaProfesionalDAO = new FamiliaProfesionalDaoJDBC(conexion);
			boolean existeFamiliaProfesional = false;
			existeFamiliaProfesional = iFamiliaProfesionalDAO.existeFamiliaProfesionalPorClave(cicloFormativo.getFamiliaProfesional().getCodigo());

			// Comprobar que existe el tipo de formación
			boolean existeTipoFormacion= false;
			ITipoFormacionDAO iTipoFormacionDAO= new TipoFormacionDaoJDBC(conexion);
			existeTipoFormacion= iTipoFormacionDAO.existeTipoFormacionPorClave(cicloFormativo.getTipoFormacion().getCodigo());
			
			// Insertar el ciclo formativo si existen la familia profesional y el tipo de formación
			ICicloFormativoDAO iCicloFormativoDAO = new CicloFormativoDaoJDBC(conexion);
			if(existeFamiliaProfesional && existeTipoFormacion) {
				iCicloFormativoDAO.insertarCicloFormativo(cicloFormativo);
			}
		} catch (SQLException e) {
			throw new FormacionException("Error al obtener la conexión", e);
		}
	}

}
