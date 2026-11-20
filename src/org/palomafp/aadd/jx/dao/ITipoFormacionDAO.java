package org.palomafp.aadd.jx.dao;

import org.palomafp.aadd.jx.excepcion.FormacionException;

public interface ITipoFormacionDAO {
	boolean existeTipoFormacionPorClave(String codigoTipoFormacion) throws FormacionException;

}