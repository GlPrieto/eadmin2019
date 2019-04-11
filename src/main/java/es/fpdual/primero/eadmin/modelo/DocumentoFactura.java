package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

public class DocumentoFactura extends Documento{

	private final double importeFactura;
	
	public DocumentoFactura (int id, String nombre, Usuario usuario, LocalDate fechaCreacion, Double importeFactura) {
		super(id, nombre, usuario, fechaCreacion, TipoDocumento.DOCUMENTO_FACTURA);
		this.importeFactura = importeFactura;
	}

	public double getImporteFactura() {
		return importeFactura;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof DocumentoFactura) {
			final DocumentoFactura documentoFactura = (DocumentoFactura) obj;
			return documentoFactura.getId() == this.id;
		}
		return false;
	}
}
