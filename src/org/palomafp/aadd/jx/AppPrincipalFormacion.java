package org.palomafp.aadd.jx;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.fichero.CicloFormativoProcesadorXml;
import org.palomafp.aadd.jx.fichero.FamiliaProfesionalProcesadorJson;
import org.palomafp.aadd.jx.fichero.ProcesadorFicheroCSV;

public class AppPrincipalFormacion {

	public static void main(String[] args) {

		try {
			ProcesadorFicheroCSV procesadorCSV = new ProcesadorFicheroCSV();
			procesadorCSV.realizarTratamientoFamiliasProfesionales();

			FamiliaProfesionalProcesadorJson procesadorJson = new FamiliaProfesionalProcesadorJson();
			procesadorJson.realizarTratamientoFamilias();

			CicloFormativoProcesadorXml procesadorXml = new CicloFormativoProcesadorXml();
			procesadorXml.realizarTratamientoCiclos();

		} catch (FormacionException e) {
			System.out.println("Error al realizar el tratamiento de Formación: " + e.getMessage());
			e.printStackTrace();
		}
	}
}