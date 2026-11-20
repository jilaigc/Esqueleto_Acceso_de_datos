package org.palomafp.aadd.jx.fichero;

import java.io.File;
import java.io.IOException;

import org.palomafp.aadd.jx.excepcion.FormacionException;
import org.palomafp.aadd.jx.gestor.GestorConfiguracion;
import org.palomafp.aadd.jx.model.CicloFormativo;
import org.palomafp.aadd.jx.model.FamiliaProfesional;
import org.palomafp.aadd.jx.model.TipoFormacion;
import org.palomafp.aadd.jx.service.CicloFormativoService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CicloFormativoProcesadorXml {

	private final String rutaFichero;
	private final CicloFormativoService cicloService;

	public CicloFormativoProcesadorXml() throws FormacionException {
		this.rutaFichero = GestorConfiguracion.getRutaXmlFormacion();
		this.cicloService = new CicloFormativoService();
	}

	public void realizarTratamientoCiclos() throws FormacionException {
		JsonNode raiz = cargarXml();

		for (JsonNode encontrado : raiz.findValues("ciclo")) {
			if (encontrado.isArray()) {
				for (JsonNode nodoCiclo : encontrado) {
					tratarCiclo(nodoCiclo);
				}
			} else {
				tratarCiclo(encontrado);
			}
		}
	}

	private JsonNode cargarXml() throws FormacionException {
		try {
			return new XmlMapper().readTree(new File(rutaFichero));
		} catch (IOException e) {
			throw new FormacionException("No se ha podido leer el fichero XML de ciclos " + rutaFichero, e);
		}
	}

	private void tratarCiclo(JsonNode nodoCiclo) {
		String codigo = textoHijo(nodoCiclo, "cod_cf");

		try {
			CicloFormativo ciclo = crearCiclo(nodoCiclo);
			cicloService.insertarCiclo(ciclo);
			System.out.println("Ciclo " + codigo + ": insertado.");
		} catch (FormacionException e) {
			System.err.println("Ciclo " + codigo + ": " + e.getMessage());
		}
	}

	private CicloFormativo crearCiclo(JsonNode nodoCiclo) throws FormacionException {
		CicloFormativo ciclo = new CicloFormativo();
		ciclo.setCodigoFormacion(textoHijo(nodoCiclo, "cod_cf"));
		ciclo.setNombreCorto(textoHijo(nodoCiclo, "nomb_corto"));
		ciclo.setNombreLargo(textoHijo(nodoCiclo, "nombrelargo"));

		try {
			ciclo.setHorasDuracion(Integer.parseInt(textoHijo(nodoCiclo, "num_horas_duracion")));
		} catch (NumberFormatException e) {
			throw new FormacionException("Horas de duración no válidas.", e);
		}

		FamiliaProfesional familia = new FamiliaProfesional();
		familia.setCodigoFamilia(textoHijo(nodoCiclo, "codigo_familia"));
		ciclo.setFamiliaProfesional(familia);

		TipoFormacion formacion = new TipoFormacion();
		formacion.setCodigo(textoHijo(nodoCiclo, "codigo_tipoestudio"));
		ciclo.setTipoFormacion(formacion);

		return ciclo;
	}

	private String textoHijo(JsonNode padre, String etiqueta) {
		JsonNode nodo = padre.path(etiqueta);
		if (nodo.isMissingNode() || nodo.isNull()) {
			return "";
		}
		return nodo.asText("").trim();
	}
}