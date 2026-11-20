package org.palomafp.aadd.jx.dao;

import org.palomafp.aadd.jx.excepcion.FormacionException;

public interface ITipoFormacionDAO {
	boolean existeTipoFormacionPorCod(String codTipo) throws FormacionException;
	boolean existeTipoFormacionPorClave(String codigoTipoFormacion) throws FormacionException;
}