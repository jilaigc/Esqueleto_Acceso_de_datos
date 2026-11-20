package org.palomafp.aadd.jx.model;

public class TipoFormacion {

	private String codigo;
	private String nombreCorto;
	private String nombreLargo;
	
	public TipoFormacion() {
	}
	
	public TipoFormacion(String codigo, String nombreCorto, String nombreLargo) {
		this.codigo = codigo;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
	}

	public String getCodigo() {
		return codigo;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
}