package org.palomafp.aadd.inm.model;

/**
 *
 * FamiliaProfesional: Clase que se asocia a la información de una familia
 * profesional.
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 24 sept 2026
 * 
 * 
 */

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
