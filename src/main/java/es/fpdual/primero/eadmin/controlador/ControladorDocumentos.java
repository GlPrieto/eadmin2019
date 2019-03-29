package es.fpdual.primero.eadmin.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;

@RestController
public class ControladorDocumentos {
	
	ServicioDocumento servicioDocumento;

	@Autowired
	public ControladorDocumentos(ServicioDocumento servicioDocumento) {
		this.servicioDocumento = servicioDocumento;
	}

	@PostMapping("/documentos")
	public Documento altaDocumento(@RequestBody DocumentoRequest documentoRequest) {
		final Documento documentoAInsertar = 
				DocumentoRequestMapper.toDocumento(documentoRequest);
		return this.servicioDocumento.altaDocumento(documentoAInsertar);
	}
}
