package org.palomafp.aadd.jx.model;

public class FamiliaProfesional {

	private String codigoFamilia;
	private String nombre;
	
	public FamiliaProfesional() {
	}
	
	public FamiliaProfesional(String codigoFamilia, String nombre) {
		this.codigoFamilia = codigoFamilia;
		this.nombre = nombre;
	}

	public String getCodigoFamilia() {
		return codigoFamilia;
	}
	
	public String getCodigo() {
		return codigoFamilia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCodigoFamilia(String codigoFamilia) {
		this.codigoFamilia = codigoFamilia;
	}

	public void setCodigo(String codigoFamilia) {
		this.codigoFamilia = codigoFamilia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "FamiliaProfesional [codigoFamilia=" + codigoFamilia + ", nombre=" + nombre + "]";
	}
}