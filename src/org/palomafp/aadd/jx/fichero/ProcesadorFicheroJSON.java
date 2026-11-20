package org.palomafp.aadd.jx.fichero;

import java.io.File;
import java.io.IOException;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConfiguracion;
import org.palomafp.aadd.jx.model.FamiliaProfesional;
import org.palomafp.aadd.jx.service.FamiliaProfesionalService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProcesadorFicheroJSON {
	public void realizarTratamientoFamiliasProfesionales() throws FormacionException {

		File ficheroFamiliasProfesionales = new File(GestorConfiguracion.getRutaFicheroCSVFamiliaProfesional());
		ObjectMapper mapper = new ObjectMapper();

		try {
			JsonNode nodoFamilias = mapper.readTree(ficheroFamiliasProfesionales);
			for (JsonNode nodoFamilia : nodoFamilias) {
				String codFamiliaProfesional = nodoFamilia.get("cod_tipo_fam").asText();
				String nombreFamiliaProfesional = nodoFamilia.get("nombre_tf").asText();

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