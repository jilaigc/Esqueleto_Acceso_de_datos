package org.palomafp.aadd.inm.dao;

import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.model.FamiliaProfesional;

/**
 *
 * IFamiliaProfesionalDAO: Interfaz que contiene los métodos para obtener
 * información de continentes desde un origen de datos.
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 26 sept 2026
 * 
 * 
 */

public interface IFamiliaProfesionalDAO {
	void insertarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException;

	void actualizarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException;

	boolean existeFamiliaProfesionalPorClave(String codFamiliaProfesional) throws FormacionException;
}
