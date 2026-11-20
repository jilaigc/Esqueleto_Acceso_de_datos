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

public class ProcesadorFicheroXML {
	public void realizarTratamientoCiclosFormativos() throws FormacionException {

		JsonNode arbolXMLCatalogoFormacion = cargarArbolXMLFichero();

		CicloFormativoService cicloFormativoService = new CicloFormativoService();

		JsonNode listaCiclos = arbolXMLCatalogoFormacion.path("informacion_adicional").path("ciclos_formativos")
				.path("ciclo");

		for (JsonNode elementoCiclo : listaCiclos) {

			// Tratamiento de atributo y contenido de etiquetas con JsonNode
			String codCicloFormativo = elementoCiclo.path("cod_cf").asText();
			String nombreCortoCicloFormativo = elementoCiclo.path("nomb_corto").asText();
			String nombreLargoCicloFormativo = elementoCiclo.path("nombrelargo").asText();
			String numeroHorasCF = elementoCiclo.path("num_horas_duracion").asText();
			String codigoFamiliaProfesional = elementoCiclo.path("codigo_familia").asText();
			String codigoTipoFormacion = elementoCiclo.path("codigo_tipoestudio").asText();

			CicloFormativo cicloFormativo = new CicloFormativo();
			cicloFormativo.setCodigo(codCicloFormativo);
			cicloFormativo.setNombreCorto(nombreCortoCicloFormativo);
			cicloFormativo.setNombreLargo(nombreLargoCicloFormativo);
			cicloFormativo.setNumeroHorasDuracion(Integer.parseInt(numeroHorasCF));

			FamiliaProfesional familiaProfesional = new FamiliaProfesional();
			familiaProfesional.setCodigo(codigoFamiliaProfesional);
			cicloFormativo.setFamiliaProfesional(familiaProfesional);

			TipoFormacion tipoFormacion = new TipoFormacion();
			tipoFormacion.setCodigo(codigoTipoFormacion);
			cicloFormativo.setTipoFormacion(tipoFormacion);

			System.out.println(cicloFormativo);

			cicloFormativoService.insertarCicloFormativo(cicloFormativo);
		}
	}

	private JsonNode cargarArbolXMLFichero() throws FormacionException {

		JsonNode nodoRaiz = null;

		try {
			XmlMapper xmlMapper = new XmlMapper();

			File fichero = new File(GestorConfiguracion.getRutaFicheroXMLCatalogoFormacion());

			nodoRaiz = xmlMapper.readTree(fichero);

		} catch (Exception e) {
			throw new FormacionException("Error al leer el fichero con los ciclos formativos.", e);
		}

		return nodoRaiz;
	}

}