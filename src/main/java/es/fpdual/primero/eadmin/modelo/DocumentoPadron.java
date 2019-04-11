package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

public class DocumentoPadron extends Documento {
	
	private final String direccion;

	public DocumentoPadron(int id, String nombre, Usuario usuario, LocalDate fechaCreacion,
			String direccion) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_PADRON);
		this.direccion = direccion;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof DocumentoPadron) {
			final DocumentoPadron documentoPadron = (DocumentoPadron) obj;
			return documentoPadron.getId() == this.id;
		}
		return false;
	}
	
}
