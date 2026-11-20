package org.palomafp.aadd.jx.dao;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.model.FamiliaProfesional;

public interface IFamiliaProfesionalDAO {
	void insertarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException;
	void actualizarFamiliaProfesional(FamiliaProfesional familiaProfesional) throws FormacionException;
	boolean existeFamiliaProfesionalPorCod(String codFamilia) throws FormacionException;
	boolean existeFamiliaProfesionalPorClave(String codFamiliaProfesional) throws FormacionException;
}