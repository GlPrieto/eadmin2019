package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;

public class DocumentoSubvencion extends Documento {

	private final String nif;

	public DocumentoSubvencion(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, String nif) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_SUBVENCION);
		this.nif = nif;
	}

	public String getNif() {
		return nif;
	}

}
