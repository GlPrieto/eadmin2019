package es.fpdual.primero.eadmin.modelo;

import java.time.LocalDate;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import es.fpdual.primero.eadmin.EadminApplication;

public class DocumentoContable extends Documento{

	private final String numeroOperacionContable;
	private static final Logger logger = LogManager.getLogger(EadminApplication.class);
	
	public DocumentoContable(int id, String nombre, Usuario usuario, LocalDate localDate, String numeroOperacionContable) {
		super(id, nombre, usuario, localDate, TipoDocumento.DOCUMENTO_CONTABLE);
		this.numeroOperacionContable = numeroOperacionContable;
	}

	public String getNumeroOperacionContable() {
		return numeroOperacionContable;
	}
	
}
