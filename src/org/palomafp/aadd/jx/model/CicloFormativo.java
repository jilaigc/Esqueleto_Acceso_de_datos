package org.palomafp.aadd.jx.model;

public class CicloFormativo {
	
	private String codigoFormacion;
	private String nombreCorto;
	private String nombreLargo;
	private int horasDuracion;
	private FamiliaProfesional familiaProfesional;
	private TipoFormacion tipoFormacion;
	
	public CicloFormativo(){
	}
	
	public CicloFormativo(String codigoFormacion, String nombreCorto, String nombreLargo, int horasDuracion,
			FamiliaProfesional familiaProfesional, TipoFormacion tipoFormacion) {
		this.codigoFormacion = codigoFormacion;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
		this.horasDuracion = horasDuracion;
		this.familiaProfesional = familiaProfesional;
		this.tipoFormacion = tipoFormacion;
	}

	public String getCodigoFormacion() {
		return codigoFormacion;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public int getHorasDuracion() {
		return horasDuracion;
	}
	public FamiliaProfesional getFamiliaProfesional() {
		return familiaProfesional;
	}
	public TipoFormacion getTipoFormacion() {
		return tipoFormacion;
	}

	public void setCodigoFormacion(String codigoFormacion) {
		this.codigoFormacion = codigoFormacion;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	public void setHorasDuracion(int horasDuracion) {
		this.horasDuracion = horasDuracion;
	}
	public void setFamiliaProfesional(FamiliaProfesional familiaProfesional) {
		this.familiaProfesional = familiaProfesional;
	}
	public void setTipoFormacion(TipoFormacion tipoFormacion) {
		this.tipoFormacion = tipoFormacion;
	}

	@Override
	public String toString() {
		return "CicloFormativo [codigoFormacion=" + codigoFormacion + ", nombreCorto=" + nombreCorto + ", nombreLargo="
				+ nombreLargo + ", horasDuracion=" + horasDuracion + ", familiaProfesional=" + familiaProfesional
				+ ", tipoFormacion=" + tipoFormacion + "]";
	}
}