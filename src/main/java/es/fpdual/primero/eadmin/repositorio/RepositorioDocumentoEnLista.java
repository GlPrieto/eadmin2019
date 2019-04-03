package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.*;
import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.EadminApplication;
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
			throw new AdministracionElectronicaException
			("El documento ya existe");
		}
		
		documentos.add(documento);
		logger.info("Documento nº" + documento.getId() + " creado correctamente");
//		if (documento.getTipoDocumento() == TipoDocumento.DOCUMENTO_CONTABLE) {
//		logger.trace("\n" + "************************************************************");
//		logger.trace( "Documento creado correctamente");
//		logger.trace("ID: " + documento.getId());
//		logger.trace("Nombre: " + documento.getNombre());
//		logger.trace("Usuario: " + documento.getUsuario().getId());
//		logger.trace( documento.getUsuario().getNombre()); 
//		logger.trace( documento.getUsuario().getCargo());
//		logger.trace( "Fecha creación: " + documento.getFechaCreacion());
//		logger.trace( "Tipo de documento: " + TipoDocumento.DOCUMENTO_CONTABLE);
//		logger.trace( "************************************************************");
//		} else {		
//		logger.debug("\n" + "************************************************************");
//		logger.debug( "Documento creado correctamente");
//		logger.debug("ID: " + documento.getId());
//		logger.debug("Nombre: " + documento.getNombre());
//		logger.debug("Usuario: " + documento.getUsuario().getId());
//		logger.debug( documento.getUsuario().getNombre()); 
//		logger.debug( documento.getUsuario().getCargo());
//		logger.debug( "Fecha creación: " + documento.getFechaCreacion());
//		logger.debug( "Tipo de documento: " + documento.getTipoDocumento());
//		logger.debug( "************************************************************");
//		}
		
		switch (documento.getTipoDocumento()) {
		case DOCUMENTO_CONTABLE:
			logger.trace("\n" + "************************************************************");
			logger.trace( "Documento creado correctamente");
			logger.trace("ID: " + documento.getId());
			logger.trace("Nombre: " + documento.getNombre());
			logger.trace("Usuario: " + documento.getUsuario().getId());
			logger.trace( documento.getUsuario().getNombre()); 
			logger.trace( documento.getUsuario().getCargo());
			logger.trace( "Fecha creación: " + documento.getFechaCreacion());
			logger.trace( "Tipo de documento: " + TipoDocumento.DOCUMENTO_CONTABLE);
			logger.trace( "************************************************************");
			break;
		case DOCUMENTO_FACTURA:
			logger.debug("\n" + "************************************************************");
			logger.debug( "Documento creado correctamente");
			logger.debug("ID: " + documento.getId());
			logger.debug("Nombre: " + documento.getNombre());
			logger.debug("Usuario: " + documento.getUsuario().getId());
			logger.debug( documento.getUsuario().getNombre()); 
			logger.debug( documento.getUsuario().getCargo());
			logger.debug( "Fecha creación: " + documento.getFechaCreacion());
			logger.debug( "Tipo de documento: " + documento.getTipoDocumento());
			logger.debug( "************************************************************");
			break;
		case DOCUMENTO_NOMINA:
			logger.warn("\n" + "************************************************************");
			logger.warn( "Documento creado correctamente");
			logger.warn("ID: " + documento.getId());
			logger.warn("Nombre: " + documento.getNombre());
			logger.warn("Usuario: " + documento.getUsuario().getId());
			logger.warn( documento.getUsuario().getNombre()); 
			logger.warn( documento.getUsuario().getCargo());
			logger.warn( "Fecha creación: " + documento.getFechaCreacion());
			logger.warn( "Tipo de documento: " + documento.getTipoDocumento());
			logger.warn( "************************************************************");
			break;
		case DOCUMENTO_SUBVENCION:
			logger.info("\n" + "************************************************************");
			logger.error( "Documento creado correctamente");
			logger.error("ID: " + documento.getId());
			logger.error("Nombre: " + documento.getNombre());
			logger.warn("Usuario: " + documento.getUsuario().getId());
			logger.warn( documento.getUsuario().getNombre()); 
			logger.warn( documento.getUsuario().getCargo());
			logger.debug( "Fecha creación: " + documento.getFechaCreacion());
			logger.debug( "Tipo de documento: " + documento.getTipoDocumento());
			logger.info( "************************************************************");
			break;
		case DOCUMENTO_PADRON:
			logger.info("\n" + "************************************************************");
			logger.info( "Documento creado correctamente");
			logger.info("ID: " + documento.getId());
			logger.info("Nombre: " + documento.getNombre());
			logger.info("Usuario: " + documento.getUsuario().getId());
			logger.info( documento.getUsuario().getNombre()); 
			logger.info( documento.getUsuario().getCargo());
			logger.info( "Fecha creación: " + documento.getFechaCreacion());
			logger.info( "Tipo de documento: " + documento.getTipoDocumento());
			logger.info( "************************************************************");
			break;
		default:
			logger.error("\n" + "************************************************************");
			logger.error( "Documento creado correctamente");
			logger.error("ID: " + documento.getId());
			logger.error("Nombre: " + documento.getNombre());
			logger.error("Usuario: " + documento.getUsuario().getId());
			logger.error( documento.getUsuario().getNombre()); 
			logger.error( documento.getUsuario().getCargo());
			logger.error( "Fecha creación: " + documento.getFechaCreacion());
			logger.error( "Tipo de documento: " + documento.getTipoDocumento());
			logger.error( "************************************************************");
			break;
		}
		System.out.println("Documento " + documento.getNombre()
				+ " almacenado correctamente");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException
			("El documento no existe");
		}
		
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int id) {
		
		//Solución 1
		Documento documentoAEliminar = new Documento (id, null,
				null, null, null);
		
		//Solución 2. Gusta menos, pues se recorerá la lista 
		//entera hasta encontrar el valor.
		
//		documentoAEliminar = documentos.stream().
//				filter(d -> d.getId()==id).
//				findAny().orElse(null);
		
		
		final int indice = 
				documentos.indexOf(documentoAEliminar);
		if (indice >= 0) {
		documentos.remove(indice);		
			
		}
		
		
	}
		
	@Override
	public List<Documento> obtenerTodosDocumentos() {
		//Esta bien, pero hay mejores opciones:
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
