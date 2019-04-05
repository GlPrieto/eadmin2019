package es.fpdual.primero.eadmin.repositorio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.EadminApplication;
import es.fpdual.primero.eadmin.Excel;
import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger(EadminApplication.class);

	@Override
	public void altaDocumento(Documento documento) {

		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento ya existe");
		}

		documentos.add(documento);

		logger.info("Documento nº" + documento.getId() + " creado correctamente");

		switch (documento.getTipoDocumento()) {
		case DOCUMENTO_CONTABLE:
			logger.trace("\n" + "************************************************************");
			logger.trace("Documento creado correctamente");
			logger.trace("ID: " + documento.getId());
			logger.trace("Nombre: " + documento.getNombre());
			logger.trace("Usuario: " + documento.getUsuario().getId());
			logger.trace(documento.getUsuario().getNombre());
			logger.trace(documento.getUsuario().getCargo());
			logger.trace("Fecha creación: " + documento.getFechaCreacion());
			logger.trace("Tipo de documento: " + TipoDocumento.DOCUMENTO_CONTABLE);
			logger.trace("************************************************************");
			break;
		case DOCUMENTO_FACTURA:
			logger.debug("\n" + "************************************************************");
			logger.debug("Documento creado correctamente");
			logger.debug("ID: " + documento.getId());
			logger.debug("Nombre: " + documento.getNombre());
			logger.debug("Usuario: " + documento.getUsuario().getId());
			logger.debug(documento.getUsuario().getNombre());
			logger.debug(documento.getUsuario().getCargo());
			logger.debug("Fecha creación: " + documento.getFechaCreacion());
			logger.debug("Tipo de documento: " + documento.getTipoDocumento());
			logger.debug("************************************************************");
			break;
		case DOCUMENTO_NOMINA:
			logger.warn("\n" + "************************************************************");
			logger.warn("Documento creado correctamente");
			logger.warn("ID: " + documento.getId());
			logger.warn("Nombre: " + documento.getNombre());
			logger.warn("Usuario: " + documento.getUsuario().getId());
			logger.warn(documento.getUsuario().getNombre());
			logger.warn(documento.getUsuario().getCargo());
			logger.warn("Fecha creación: " + documento.getFechaCreacion());
			logger.warn("Tipo de documento: " + documento.getTipoDocumento());
			logger.warn("************************************************************");
			break;
		case DOCUMENTO_SUBVENCION:
			logger.info("\n" + "************************************************************");
			logger.error("Documento creado correctamente");
			logger.error("ID: " + documento.getId());
			logger.error("Nombre: " + documento.getNombre());
			logger.warn("Usuario: " + documento.getUsuario().getId());
			logger.warn(documento.getUsuario().getNombre());
			logger.warn(documento.getUsuario().getCargo());
			logger.debug("Fecha creación: " + documento.getFechaCreacion());
			logger.debug("Tipo de documento: " + documento.getTipoDocumento());
			logger.info("************************************************************");
			break;
		case DOCUMENTO_PADRON:
			logger.info("\n" + "************************************************************");
			logger.info("Documento creado correctamente");
			logger.info("ID: " + documento.getId());
			logger.info("Nombre: " + documento.getNombre());
			logger.info("Usuario: " + documento.getUsuario().getId());
			logger.info(documento.getUsuario().getNombre());
			logger.info(documento.getUsuario().getCargo());
			logger.info("Fecha creación: " + documento.getFechaCreacion());
			logger.info("Tipo de documento: " + documento.getTipoDocumento());
			logger.info("************************************************************");
			break;
		default:
			logger.error("\n" + "************************************************************");
			logger.error("Documento creado correctamente");
			logger.error("ID: " + documento.getId());
			logger.error("Nombre: " + documento.getNombre());
			logger.error("Usuario: " + documento.getUsuario().getId());
			logger.error(documento.getUsuario().getNombre());
			logger.error(documento.getUsuario().getCargo());
			logger.error("Fecha creación: " + documento.getFechaCreacion());
			logger.error("Tipo de documento: " + documento.getTipoDocumento());
			logger.error("************************************************************");
			break;
		}
		System.out.println("Documento " + documento.getNombre() + " almacenado correctamente");

		try {
			FileWriter fichero = new FileWriter(documento.getNombre() + ".txt", true);

			PrintWriter impFichero = new PrintWriter(fichero);
			impFichero.println("ID: " + documento.getId());
			impFichero.println("Nombre: " + documento.getNombre());
			impFichero.println("Usuario: " + documento.getUsuario().getId());
			impFichero.println(documento.getUsuario().getNombre());
			impFichero.println(documento.getUsuario().getCargo());
			impFichero.println("Fecha creación: " + documento.getFechaCreacion());
			impFichero.println("Tipo de documento: " + documento.getTipoDocumento());
			impFichero.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			File fichero = new File(documento.getNombre() + "_" + documento.getTipoDocumento() + ".txt");
			if (fichero.exists()) {
				logger.error("El fichero ya existe");
			} else {
				logger.error("El fichero no existe, creando documento " + documento.getId());
				PrintWriter impFichero = new PrintWriter(fichero);
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + documento.getTipoDocumento());
				impFichero.close();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			FileWriter fichero = new FileWriter("trazas.txt", true);

			PrintWriter impFichero = new PrintWriter(fichero);
			impFichero.println("Documento nº" + documento.getId() + " creado correctamente");

			switch (documento.getTipoDocumento()) {
			case DOCUMENTO_CONTABLE:
				impFichero.println("\n" + "************************************************************");
				impFichero.println("Documento creado correctamente");
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + TipoDocumento.DOCUMENTO_CONTABLE);
				impFichero.println("************************************************************");
				break;
			case DOCUMENTO_FACTURA:
				impFichero.println("\n" + "************************************************************");
				impFichero.println("Documento creado correctamente");
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + TipoDocumento.DOCUMENTO_FACTURA);
				impFichero.println("************************************************************");
				break;
			case DOCUMENTO_NOMINA:
				impFichero.println("\n" + "************************************************************");
				impFichero.println("Documento creado correctamente");
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + TipoDocumento.DOCUMENTO_NOMINA);
				impFichero.println("************************************************************");
				break;
			case DOCUMENTO_SUBVENCION:
				impFichero.println("\n" + "************************************************************");
				impFichero.println("Documento creado correctamente");
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + TipoDocumento.DOCUMENTO_SUBVENCION);
				impFichero.println("************************************************************");
				break;
			case DOCUMENTO_PADRON:
				impFichero.println("\n" + "************************************************************");
				impFichero.println("Documento creado correctamente");
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + TipoDocumento.DOCUMENTO_PADRON);
				impFichero.println("************************************************************");
				break;
			default:
				impFichero.println("\n" + "************************************************************");
				impFichero.println("Documento creado correctamente");
				impFichero.println("ID: " + documento.getId());
				impFichero.println("Nombre: " + documento.getNombre());
				impFichero.println("Usuario: " + documento.getUsuario().getId());
				impFichero.println(documento.getUsuario().getNombre());
				impFichero.println(documento.getUsuario().getCargo());
				impFichero.println("Fecha creación: " + documento.getFechaCreacion());
				impFichero.println("Tipo de documento: " + documento.getTipoDocumento());
				impFichero.println("************************************************************");
				break;
			}

			impFichero.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException("El documento no existe");
		}

		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int id) {

		// Solución 1
		Documento documentoAEliminar = new Documento(id, null, null, null, null);

		// Solución 2. Gusta menos, pues se recorerá la lista
		// entera hasta encontrar el valor.

		// documentoAEliminar = documentos.stream().
		// filter(d -> d.getId()==id).
		// findAny().orElse(null);

		final int indice = documentos.indexOf(documentoAEliminar);
		if (indice >= 0) {
			documentos.remove(indice);

		}

	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {

		try {
			FileWriter fichero = new FileWriter("ListaDocumentos.txt");
			PrintWriter impFichero = new PrintWriter(fichero);

			for (Documento d : this.documentos) {
				impFichero.println("---------------------------------------------------------");
				impFichero.println("ID: " + d.getId());
				impFichero.println("Nombre: " + d.getNombre());
				impFichero.println("Fecha creación: " + d.getFechaCreacion());
				impFichero.println("Usuario: " + d.getUsuario().getId() + " " + d.getUsuario().getNombre() + " "
						+ d.getUsuario().getCargo());
				impFichero.println("Tipo de documento: " + d.getTipoDocumento());

			}
			impFichero.println("---------------------------------------------------------");
			impFichero.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return this.documentos.stream().collect(Collectors.toList());
	}

	@Override
	public int getSiguienteId() {
		if (documentos.isEmpty()) {
			return 1;
		}
		return documentos.get(documentos.size() - 1).getId() + 1;

	}

	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {

		return this.documentos.stream().filter(d -> d.getId() == codigoDocumento).findFirst().orElse(null);
	}

}
