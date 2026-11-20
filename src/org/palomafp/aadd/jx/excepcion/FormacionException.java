package org.palomafp.aadd.jx.excepcion;

public class FormacionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FormacionException(String mensaje) {
        super(mensaje);
    }

	public FormacionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}