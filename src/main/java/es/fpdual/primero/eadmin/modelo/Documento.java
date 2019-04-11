package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

public class Documento extends AdministracionElectronicaBase {

	private final TipoDocumento tipoDocumento;
	
	public Documento(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, TipoDocumento tipoDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoDocumento = tipoDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj instanceof Documento) {
			final Documento documento = (Documento) obj;
			return documento.getId() == this.id;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Documento " + id + ", nombre: " + nombre;
	}

	
}
