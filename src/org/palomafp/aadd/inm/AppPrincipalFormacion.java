package org.palomafp.aadd.inm;

import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.fichero.ProcesadorFicheroCSV;
import org.palomafp.aadd.inm.fichero.ProcesadorFicheroXML;

/**
 *
 * AppPrincipal: Clase que realiza la gestión de las principales operaciones
 * asociadas a la aplicación de Formación.
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 28 oct 2026
 * 
 * 
 */

public class AppPrincipalFormacion {

	public static void main(String[] args) {

		try {
			// Realizar el tratamiento de familias profesionales desde el fichero CSV
			ProcesadorFicheroCSV procesadorCSV = new ProcesadorFicheroCSV();
			procesadorCSV.realizarTratamientoFamiliasProfesionales();

			// Realizar el tratamiento de ciclos formativos desde el fichero XML
			ProcesadorFicheroXML procesadorXML = new ProcesadorFicheroXML();
			procesadorXML.realizarTratamientoCiclosFormativos();

		} catch (FormacionException e) {
			System.out.println("Error al realizar el tratamiento de Formación: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
