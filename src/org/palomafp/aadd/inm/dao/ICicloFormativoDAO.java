package org.palomafp.aadd.inm.dao;

import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.model.CicloFormativo;

/**
 *
 * ICicloFormativoDAO: Interfaz que contiene los métodos para obtener información de los ciclos formativos desde un origen de datos.
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 26 sept 2026
 * 
 * 
 */

public interface ICicloFormativoDAO {
	void insertarCicloFormativo(CicloFormativo cicloFormativo) throws FormacionException;

}

