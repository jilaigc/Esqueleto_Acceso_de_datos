package org.palomafp.aadd.jx.model;

public class FamiliaProfesional {
	private String codigo;
	private String nombre;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "FamiliaProfesional [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}