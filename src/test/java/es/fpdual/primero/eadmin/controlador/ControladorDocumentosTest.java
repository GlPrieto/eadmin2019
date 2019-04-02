package es.fpdual.primero.eadmin.controlador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.PathVariable;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.servicio.ServicioDocumento;

public class ControladorDocumentosTest {
	ServicioDocumento servicioDocumento;
	ControladorDocumentos controladorDocumentos;
	private final DocumentoRequest documentoRequest = 
			mock (DocumentoRequest.class);
	
	@Before
	public void ejecutarAntesDeCadaTest() {
		this.servicioDocumento =
				mock (ServicioDocumento.class);
		this.controladorDocumentos = 
				new ControladorDocumentos (servicioDocumento);
		
	}
	
	@Test
	public void deberiaAlmacenarDocumento () {
		
		Documento documentoInsertado = mock (Documento.class);
		
		when(this.servicioDocumento.
				altaDocumento(any())).
		thenReturn(documentoInsertado);
		
		when(documentoRequest.getUsuario()).thenReturn("20");
		
		when(documentoRequest.getTipoDocumento()).thenReturn("DOCUMENTO_CONTABLE");
		
		final Documento resultado = this.controladorDocumentos.altaDocumento(documentoRequest);
		
		assertSame(documentoInsertado,resultado);
	}
	
	@Test
	public void deberiaObtenerDocumentoPorId () {
		
		Documento documento = mock (Documento.class);
		
		when(this.servicioDocumento.
				obtenerDocumentoPorId(documento.getId())).
		thenReturn(documento);

		
		final Documento resultado = this.controladorDocumentos.obtenerDocumentoPorId(documento.getId());
		
		assertSame(documento,resultado);
	}
	
}
