package es.fpdual.primero.eadmin.modelo;

public enum TipoDocumento {

	DOCUMENTO_CONTABLE("1"), DOCUMENTO_FACTURA("2"), DOCUMENTO_NOMINA("3"), DOCUMENTO_SUBVENCION("4"), DOCUMENTO_PADRON(
			"5");

	private String codigo;

	private TipoDocumento(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

}
