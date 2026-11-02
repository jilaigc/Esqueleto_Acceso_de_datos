package org.palomafp.aadd.inm.excepcion;


/**
 *
 * FormacionException: Clase abstracta que representa la excepción base del proyecto Formacion
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 15 oct 2026
 * 
 * 
 */

public class FormacionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FormacionException(String mensaje) {
        super(mensaje);
    }

	public FormacionException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}

