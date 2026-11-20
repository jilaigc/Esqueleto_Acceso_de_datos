package org.palomafp.aadd.jx.model;

public class CicloFormativo {
	
	private String codigo;
	private String nombreCorto;
	private String nombreLargo;
	private int numeroHorasDuracion;
	private FamiliaProfesional familiaProfesional;
	private TipoFormacion tipoFormacion;
	
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
	public int getNumeroHorasDuracion() {
		return numeroHorasDuracion;
	}
	public void setNumeroHorasDuracion(int numeroHorasDuracion) {
		this.numeroHorasDuracion = numeroHorasDuracion;
	}
	public FamiliaProfesional getFamiliaProfesional() {
		return familiaProfesional;
	}
	public void setFamiliaProfesional(FamiliaProfesional familiaProfesional) {
		this.familiaProfesional = familiaProfesional;
	}
	public TipoFormacion getTipoFormacion() {
		return tipoFormacion;
	}
	public void setTipoFormacion(TipoFormacion tipoFormacion) {
		this.tipoFormacion = tipoFormacion;
	}
	@Override
	public String toString() {
		return "CicloFormativo [codigo=" + codigo + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", numeroHorasDuracion=" + numeroHorasDuracion + ", familiaProfesional=" + familiaProfesional
				+ ", tipoFormacion=" + tipoFormacion + "]";
	}
	
}