package org.palomafp.aadd.inm.dao;

import org.palomafp.aadd.inm.excepcion.FormacionException;

/**
 *
 * ICicloFormativoDAO: Interfaz que contiene los métodos para obtener información los tipos de formación existentes.
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 26 sept 2026
 * 
 * 
 */

public interface ITipoFormacionDAO {
	boolean existeTipoFormacionPorClave(String codigoTipoFormacion) throws FormacionException;

}

