package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;

public class DocumentoPadron extends Documento {

	private final String direccion;

	public DocumentoPadron(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, String direccion) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_PADRON);
		this.direccion = direccion;
	}

}
