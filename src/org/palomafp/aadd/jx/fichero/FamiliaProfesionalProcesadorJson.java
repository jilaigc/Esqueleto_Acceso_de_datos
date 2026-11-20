package org.palomafp.aadd.jx.fichero;

import java.io.File;
import java.io.IOException;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConfiguracion;
import org.palomafp.aadd.jx.model.FamiliaProfesional;
import org.palomafp.aadd.jx.service.FamiliaProfesionalService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FamiliaProfesionalProcesadorJson {

	private final String rutaFichero;
	private final FamiliaProfesionalService familiaService;

	public FamiliaProfesionalProcesadorJson() throws FormacionException {
		this.rutaFichero = GestorConfiguracion.getRutaJsonFamilias();
		this.familiaService = new FamiliaProfesionalService();
	}

	public void realizarTratamientoFamilias() throws FormacionException {
		JsonNode raiz = cargarJson();

		for (JsonNode nodo : raiz) {
			try {
				FamiliaProfesional familia = crearFamiliaProfesional(nodo);

				if (familiaService.existeFamiliaProfesionalPorClave(familia.getCodigoFamilia())) {
					familiaService.actualizarFamilia(familia);
					System.out.println("Familia " + familia.getCodigoFamilia() + ": actualizada.");
				} else {
					familiaService.insertarFamilia(familia);
					System.out.println("Familia " + familia.getCodigoFamilia() + ": insertada.");
				}
			} catch (FormacionException e) {
				System.err.println("Familia: " + e.getMessage());
			}
		}
	}

	private JsonNode cargarJson() throws FormacionException {
		try {
			return new ObjectMapper().readTree(new File(rutaFichero));
		} catch (IOException e) {
			throw new FormacionException("Error al leer el fichero JSON de familias " + rutaFichero, e);
		}
	}

	private FamiliaProfesional crearFamiliaProfesional(JsonNode nodo) throws FormacionException {
		String codigo = nodo.path("cod_tipo_fam").asText("").trim();
		String nombre = nodo.path("nombre_tf").asText("").trim();

		if (codigo.isEmpty() || nombre.isEmpty()) {
			throw new FormacionException("Familia no válida en el JSON: " + nodo);
		}

		FamiliaProfesional familia = new FamiliaProfesional();
		familia.setCodigoFamilia(codigo);
		familia.setNombre(nombre);

		return familia;
	}
}