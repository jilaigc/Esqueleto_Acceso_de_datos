package org.palomafp.aadd.inm.model;

/**
 *
 * TipoFormacion: Clase que se asocia a la información de un Tipo de Formacion.
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 24 sept 2026
 * 
 * 
 */

public class TipoFormacion {
	private String codigo;
	private String nombreCorto;
	private String nombreLargo;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	@Override
	public String toString() {
		return "TipoFormacion [codigo=" + codigo + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ "]";
	}
	
}

