package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

public class DocumentoSubvencion extends Documento {
	
	private final String nif;
	public DocumentoSubvencion(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, String nif) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_SUBVENCION);
		this.nif = nif;
	}
	public String getNif() {
		return nif;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof DocumentoSubvencion) {
			final DocumentoSubvencion documentoSubvencion = (DocumentoSubvencion) obj;
			return documentoSubvencion.getId() == this.id;
		}
		return false;
	}

}
