package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoumentoTest {

	@Test
	public void deberiaDevolverTrueSiDosObjetosDocumentosSonIguales() {

		// inicialización -- Estos comentarios no deberían ponerse,
		// pero sirven como guía cuando se empieza
		final Documento documento1 = new Documento(1, null, null, null, null);
		final Documento documento2 = new Documento(1, null, null, null, null);

		// ejecución
		final boolean resultado = documento1.equals(documento2);

		// comprobación de resultados
		assertTrue(resultado);// 100%
	}

	@Test
	public void deberiaDevolverTrueSiDosObjetosDocumentosSonDistintos() {

		// inicialización -- Estos comentarios no deberían ponerse,
		// pero sirven como guía cuando se empieza
		final Documento documento1 = new Documento(1, null, null, null, null);
		final Documento documento2 = new Documento(2, null, null, null, null);

		// ejecución
		final boolean resultado = documento1.equals(documento2);

		// comprobación de resultados
		assertFalse(resultado);// 100%
	}

	@Test
	public void deberiaDevolverFalseSiNoEsDocumento() {

		// inicialización -- Estos comentarios no deberían ponerse,
		// pero sirven como guía cuando se empieza
		final Documento documento1 = new Documento(1, null, null, null, null);
		final Documento documento2 = new Documento(2, null, null, null, null);

		// ejecución
		final boolean resultado = documento1.equals(documento2);

		// comprobación de resultados
		assertFalse(resultado);// 100%
	}

	@Test
	public void deberiaCalcularHashCodeDeDocumento() {
		final Documento documento = new Documento(100, null, null, null, null);

		final int resultado = documento.hashCode();

		assertEquals(100, resultado);
	}

}
