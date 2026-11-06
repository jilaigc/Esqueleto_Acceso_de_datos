package org.palomafp.aadd.inm.fichero;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.palomafp.aadd.inm.excepcion.FormacionException;
import org.palomafp.aadd.inm.gestor.GestorConfiguracion;
import org.palomafp.aadd.inm.model.CicloFormativo;
import org.palomafp.aadd.inm.model.FamiliaProfesional;
import org.palomafp.aadd.inm.model.TipoFormacion;
import org.palomafp.aadd.inm.service.CicloFormativoService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * ProcesadorFicheroXL: Clase que realiza ....
 * @author Isidoro Nevares Martín - IES Virgen de la Paloma
 * @date 6 nov 2026
 * 
 * 
 */

public class ProcesadorFicheroXML {
	public void realizarTratamientoCiclosFormativos() throws FormacionException {
		Document arbolDOMCatalogoFormacion = cargarArbolDOMFicheroXML();  

		CicloFormativoService cicloFormativoService = new CicloFormativoService();

		NodeList listaCiclos = arbolDOMCatalogoFormacion.getElementsByTagName("ciclo");
		for (int i = 0; i < listaCiclos.getLength(); i++) {
			Element elementoCiclo = (Element) listaCiclos.item(i);
			String codCicloFormativo= elementoCiclo.getAttribute("cod_cf");
			String nombreCortoCicloFormativo= elementoCiclo.getElementsByTagName("nomb_corto").item(0).getTextContent();
			String nombreLargoCicloFormativo= elementoCiclo.getElementsByTagName("nombrelargo").item(0).getTextContent();
			String numeroHorasCF= elementoCiclo.getElementsByTagName("num_horas_duracion").item(0).getTextContent();
			String codigoFamiliaProfesional= elementoCiclo.getElementsByTagName("codigo_familia").item(0).getTextContent();
			String codigoTipoFormacion= elementoCiclo.getElementsByTagName("codigo_tipoestudio").item(0).getTextContent();
		
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

	private Document cargarArbolDOMFicheroXML() {
		Document document = null;

		try {
			// 1. Crear la fábrica
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// 2. Crear el parser que se usará para obtener el árbol DOM
			DocumentBuilder builder = factory.newDocumentBuilder();

			// 3. Leer el fichero XML y lo parseamos para obtener el árbol DOM
			File fichero = new File(GestorConfiguracion.getRutaFicheroXMLCatalogoFormacion());
			document = builder.parse(fichero);

			// 4. Obtener el documento raíz normalizado
			document.getDocumentElement().normalize();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}

}

