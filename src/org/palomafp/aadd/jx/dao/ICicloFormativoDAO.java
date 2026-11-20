package org.palomafp.aadd.jx.dao;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.model.CicloFormativo;

public interface ICicloFormativoDAO {
	void insertarCicloFormativo(CicloFormativo cicloFormativo) throws FormacionException;

}