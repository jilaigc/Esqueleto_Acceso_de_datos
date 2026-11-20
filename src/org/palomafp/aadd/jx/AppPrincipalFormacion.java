package org.palomafp.aadd.jx;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.fichero.ProcesadorFicheroJSON;
import org.palomafp.aadd.jx.fichero.ProcesadorFicheroXML;

public class AppPrincipalFormacion {

	public static void main(String[] args) {

		try {
			ProcesadorFicheroJSON procesadorCSV = new ProcesadorFicheroJSON();
			procesadorCSV.realizarTratamientoFamiliasProfesionales();

			ProcesadorFicheroXML procesadorXML = new ProcesadorFicheroXML();
			procesadorXML.realizarTratamientoCiclosFormativos();

		} catch (FormacionException e) {
			System.out.println("Error al realizar el tratamiento de Formación: " + e.getMessage());
			e.printStackTrace();
		}
	}

}