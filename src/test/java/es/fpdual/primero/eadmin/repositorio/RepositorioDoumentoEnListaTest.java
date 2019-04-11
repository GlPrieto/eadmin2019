package es.fpdual.primero.eadmin.repositorio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;

public class RepositorioDoumentoEnListaTest {
	
	private RepositorioDocumento repositorioDocumento;
	private Documento documento;
	
	@Before
	public void inicializarEnCadaTest() {
		
		this.repositorioDocumento = 
				new RepositorioDocumentoEnLista();
		
		documento = mock (Documento.class);
	}
	
	
	@Test @Ignore ("Falta de tiempo")
	public void deberiaAlmacenarNuevoDocumento () {
		//ENTRENAMIENTO
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		//PRUEBA
		this.repositorioDocumento.altaDocumento(documento);
		//COMPROBACIÓN
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
	}
	
	@Test (expected = AdministracionElectronicaException.class) @Ignore ("Falta de tiempo")
	public void deberiaLanzarExcepcionAlAlmacenarDocumentoYaExistente () {
		
		when(documento.getNombre()).thenReturn("documento1");
		when(documento.getId()).thenReturn(5);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.altaDocumento(documento);
		
	}
	
	@Test @Ignore ("Falta de tiempo")
	public void deberiaModificarDocumento () {
		
		Documento documentoAl = new Documento(20, "Doc1", null, null, null);
		Documento documentoModificado = new Documento(20, "Doc2", null, null, null);
		
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
	
	@Test @Ignore ("Falta de tiempo")
	public void deberiaEliminarDocumento () {

		when(documento.getId()).thenReturn(20);
		
		this.repositorioDocumento.altaDocumento(documento);
		this.repositorioDocumento.eliminarDocumento(20);
		
		//No seria totalmente correcto, pues no se ejecutaría el equals
		//assertFalse(this.repositorioDocumento.obtenerTodosDocumentos().contains(documento));
		
		assertTrue(this.repositorioDocumento.obtenerTodosDocumentos().isEmpty());
	}
	
	@Test
	public void deberiaNoHacerNadaSiElDocumentoAEliminarNoExiste () {
		
		this.repositorioDocumento.eliminarDocumento(20);
		
	}
	
	@Test @Ignore("Falta de tiempo")
	public void deberiaDevolverElSiguienteDocumento () {
		when(documento.getId()).thenReturn(20);
		when(documento.getNombre()).thenReturn("doc20");
		when(documento.getTipoDocumento()).thenReturn(TipoDocumento.DOCUMENTO_CONTABLE);
		this.repositorioDocumento.altaDocumento(documento);

		assertEquals(21,repositorioDocumento.getSiguienteId());

	}
	
	@Test
	public void deberiaDevolver1SiLaListaEstaVacia () {

		assertEquals(1,repositorioDocumento.getSiguienteId());
		
	}
	 
	
}
