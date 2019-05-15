package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Expediente extends AdministracionElectronicaBase {

	private final TipoExpediente tipoExpediente;
	private final List<Documento> documentos;

	public Expediente(int id, String nombre, Usuario usuario, LocalDate fechaCreacion, TipoExpediente tipoExpediente,
			List<Documento> documentos) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoExpediente = tipoExpediente;
		this.documentos = documentos;
	}

	public final TipoExpediente getTipoExpediente() {
		return tipoExpediente;
	}

	public final List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			final Expediente expediente = (Expediente) obj;
			return expediente.getId() == this.id;
		}
		return false;
	}

	private boolean esDocumentoContable(Documento documentoActual) {
		return documentoActual.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	public List<Integer> obtenerLongitudNombresDocumentos() {
		if (documentos.size() == 0) {
			throw new AdministracionElectronicaException("Lista de documentos vacía");
		}
		return documentos.stream().filter(this::esDocumentoContable).map(Documento::getNombre).map(String::length)
				.collect(Collectors.toList());
	}

	public Map<TipoDocumento, List<Documento>> obtenerDocumentosPorTipo() {

		return documentos.stream().collect(Collectors.groupingBy(Documento::getTipoDocumento));
		// (Collectors.groupingBy(Documento(d -> d.getTipoDocumento()));
	}

}
