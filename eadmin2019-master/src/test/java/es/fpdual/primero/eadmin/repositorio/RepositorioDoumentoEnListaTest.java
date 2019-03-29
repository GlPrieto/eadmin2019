package es.fpdual.primero.eadmin.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;

public class RepositorioDoumentoEnListaTest {
	
	private RepositorioDocumento repositorioDocumento;
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		
		this.repositorioDocumento = 
				new RepositorioDocumentoEnLista();
		
		documento = mock (Documento.class);
	}
	
	
	@Test
	public void deberiaAlmacenarNuevoDocumento () {

		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoYaExistente () {
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
		
	}
	
	@Test
	public void deberiaModificarDocumento () {
		
		Documento documentoAl = new Documento(20, "Doc1", null, null, null);
		Documento documentoModificado = new Documento(20, "Doc2", null, null, null);
		
//		when(documento.getId()).thenReturn(20);
//		when(documentoModificado.getId()).thenReturn(20);
//		when(documento.getNombre()).thenReturn("doc1");
//		when(documentoModificado.getNombre()).thenReturn("doc2");
		
		this.repositorioDocumento.altaDocumento(documentoAl);
		this.repositorioDocumento.modificarDocumento(documentoModificado);
		
		assertEquals("Doc2",this.repositorioDocumento
				.obtenerTodosDocumentos()
				.get(0).getNombre());
	}
	
	@Test (expected = AdministracionElectronicaException.class)
	public void deberiaLanzarExcepcionAlModificarDocumento () {
		
		Documento documentoModificado = new Documento(20, "Doc2", null, null, null);
		
		this.repositorioDocumento.modificarDocumento(documentoModificado);

	}
	
	@Test
	public void deberiaEliminarDocumento () {

		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(documento.getId());
		
		assertFalse(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test
	public void deberiaDevolverElSiguienteDocumento () {
		
		List<Documento> documentos = new ArrayList<>();
		documentos.add(documento);
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		Documento doc2 = mock (Documento.class);
		documentos.add(doc2);
		when(doc2.getNombre()).thenReturn("doc2");
		when(doc2.getId()).thenReturn(6);
		
		assertEquals(1,repositorioDocumento.getSiguienteId());
		
		
		
	}
	
	
}
