package org.palomafp.aadd.jx.excepcion;

public class FormacionException extends Exception {
	
	public FormacionException(String mensaje) {
		super(mensaje);
	}

	public FormacionException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}