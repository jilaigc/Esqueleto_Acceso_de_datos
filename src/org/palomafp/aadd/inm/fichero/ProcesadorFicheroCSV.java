package org.palomafp.aadd.inm.fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.gestor.GestorConfiguracion;
import org.palomafp.aadd.inm.model.FamiliaProfesional;
import org.palomafp.aadd.inm.service.FamiliaProfesionalService;

/**
 *
 * ProcesadorFicheroCSV: Clase que realiza el procesamiento de un fichero CSV para obtener información de familias profesionales y realizar la inserción o actualización en la base de datos.
 * 
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 6 nov 2026
 * 
 * 
 */

public class ProcesadorFicheroCSV {
	public void realizarTratamientoFamiliasProfesionales() throws FormacionException {

		File ficheroFamiliasProfesionales = new File(GestorConfiguracion.getRutaFicheroCSVFamiliaProfesional());
		try (BufferedReader lectorCSV = new BufferedReader(new FileReader(ficheroFamiliasProfesionales));) {

			String linea = lectorCSV.readLine(); // Leer la primera línea (cabecera) y descartarla
			while ((linea = lectorCSV.readLine()) != null) {
				String[] campos = linea.split("\\|");
				String codFamiliaProfesional = campos[2].trim();
				String nombreFamiliaProfesional = campos[3].trim();

				FamiliaProfesional familiaProfesional = new FamiliaProfesional();
				familiaProfesional.setCodigo(codFamiliaProfesional);
				familiaProfesional.setNombre(nombreFamiliaProfesional);

				// Realización de la inserción o actualización de la familia profesional en la
				// base de datos
				FamiliaProfesionalService familiaProfesionalService = new FamiliaProfesionalService();
				boolean existeFP = familiaProfesionalService.existeFamiliaProfesionalPorClave(codFamiliaProfesional);
				if (existeFP) {
					System.out.println("Actualizando familia profesional: " + familiaProfesional);

					familiaProfesionalService.actualizarFamiliaProfesional(familiaProfesional);
				} else {
					System.out.println("Insertando la familia profesional: " + familiaProfesional);
					familiaProfesionalService.insertarFamiliaProfesional(familiaProfesional);
				}
			}

		} catch (IOException e) {
			throw new FormacionException("Error al leer el fichero CSV de familias profesionales.", e);
		}
	}
}
