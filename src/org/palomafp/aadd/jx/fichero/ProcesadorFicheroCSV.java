package org.palomafp.aadd.jx.fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConfiguracion;
import org.palomafp.aadd.jx.model.FamiliaProfesional;
import org.palomafp.aadd.jx.service.FamiliaProfesionalService;

public class ProcesadorFicheroCSV {
	
	public void realizarTratamientoFamiliasProfesionales() throws FormacionException {
		File ficheroFamiliasProfesionales = new File(GestorConfiguracion.getRutaFicheroCSVFamiliaProfesional());
		
		try (BufferedReader lectorCSV = new BufferedReader(new FileReader(ficheroFamiliasProfesionales))) {
			String linea = lectorCSV.readLine(); // Descartar cabecera
			while ((linea = lectorCSV.readLine()) != null) {
				String[] campos = linea.split("\\|");
				if (campos.length >= 4) {
					String codFamiliaProfesional = campos[2].trim();
					String nombreFamiliaProfesional = campos[3].trim();

					FamiliaProfesional familiaProfesional = new FamiliaProfesional();
					familiaProfesional.setCodigoFamilia(codFamiliaProfesional);
					familiaProfesional.setNombre(nombreFamiliaProfesional);

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
			}
		} catch (IOException e) {
			throw new FormacionException("Error al leer el fichero CSV de familias profesionales.", e);
		}
	}
}