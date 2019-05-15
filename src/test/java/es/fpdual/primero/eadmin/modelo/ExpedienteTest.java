package es.fpdual.primero.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExpedienteTest {

	@Test
	public void deberiaConstruirUnExpedienteConDocumentos() {

		final Usuario usuario = new Usuario(4, "bob", "chef");
		// inicialización
		final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario,
				LocalDate.now(), "00001254684686");

		final Documento documento = new DocumentoContable(15, "operacion", usuario, LocalDate.now(), "99991254684686");
		final Documento documentoNuevo = new Documento(20, "nuevo documento", usuario, LocalDate.now(),
				TipoDocumento.DOCUMENTO_PADRON);

		final List<Documento> documentos = new ArrayList<>();
		documentos.add(documentoContable);
		documentos.add(documento);
		documentos.add(documentoNuevo);

		// for(Documento documentoActual: documentos) {
		// System.out.println(documentoActual);
		// }

		// for(Documento documentoActual: documentos) {
		// if
		// (documentoActual.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE))
		// {
		// System.out.println(documentoActual);
		// }
		// }

		for (Documento documentoActual : documentos) {
			if (esDocumentoContable(documentoActual)) {
				System.out.println(documentoActual);
			}
		}

		documentos.stream(). // Recorre la lista de elementos
				filter(documentoActual -> esDocumentoContable(documentoActual)). // filtra
				forEach(documentoActual -> System.out.println(documentoActual)); // Devuelve
		// Es similar a:
		documentos.stream().filter(this::esDocumentoContable).forEach(System.out::println);// Es mejor

		documentos.stream().filter(this::esDocumentoContable).count();

		// final List<Documento> documentosContables =
		// documentos.stream().
		// filter(this::esDocumentoContable).
		// collect(Collectors.toList());

		documentos.stream().map(documentoActual -> documentoActual.getNombre()).map(nombre -> nombre.length())
				.forEach(longitud -> System.out.println(longitud));
		// Otra forma:
		documentos.stream().map(Documento::getNombre).map(String::length).forEach(System.out::println);

		for (Documento documentoActual : documentos) {
			System.out.println(documentoActual.getNombre().length());
		}
		// ejecución
		final Expediente expediente = new Expediente(1, "expediente1", usuario, LocalDate.now(),
				TipoExpediente.EXPEDIENTE_SANCIONADOR, documentos);
		// comprobación de resultados
		assertEquals(documentos, expediente.getDocumentos());
		assertTrue(expediente.getDocumentos().contains(documentoContable));
		assertEquals(3, expediente.getDocumentos().size());
	}

	// A revisar
	@Test
	public void deberiaObtenerLongitudNombresDocumentos() {

		final Usuario usuario = new Usuario(4, "bob", "chef");

		// inicialización
		final DocumentoContable doc1 = new DocumentoContable(1, "uno", usuario, LocalDate.now(), "00001254684686");

		final Documento doc2 = new DocumentoContable(2, "tres", usuario, LocalDate.now(), "99991254684686");

		final List<Documento> documentos = new ArrayList<>();
		documentos.add(doc1);
		documentos.add(doc2);
		final Expediente expediente = new Expediente(1, "expediente1", usuario, LocalDate.now(),
				TipoExpediente.EXPEDIENTE_SUBVENCION, documentos);

		// ejecución

		final List<Integer> resultado = expediente.obtenerLongitudNombresDocumentos();

		// comprobación de resultados
		assertEquals(2, resultado.size());
		assertEquals(3, resultado.get(0).intValue());
		// assertEquals(Integer.parseInt ("6"),resultado.get(0).intValue());
		assertEquals(new Integer(4), resultado.get(1));
	}

	private boolean esDocumentoContable(Documento documentoActual) {
		return documentoActual.getTipoDocumento().equals(TipoDocumento.DOCUMENTO_CONTABLE);
	}

	@Test
	public void deberiaDevolverTrueSiDosObjetosExpedientesSonIguales() {

		final Expediente expediente1 = new Expediente(1, null, null, null, null, null);
		final Expediente expediente2 = new Expediente(1, null, null, null, null, null);

		final boolean resultado = expediente1.equals(expediente2);

		assertTrue(resultado);
	}

	@Test
	public void deberiaDevolverTrueSiDosObjetosExpedientesSonDistintos() {

		final Expediente expediente1 = new Expediente(1, null, null, null, null, null);
		final Expediente expediente2 = new Expediente(2, null, null, null, null, null);

		final boolean resultado = expediente1.equals(expediente2);

		assertFalse(resultado);
	}

	@Test
	public void deberiaCalcularHashCodeDeExpediente() {
		final Expediente expediente = new Expediente(100, null, null, null, null, null);

		final int resultado = expediente.hashCode();

		assertEquals(100, resultado);
	}

	// @Test
	// public void deberiaDevolverDocumentosAgrupados () {
	// final Usuario usuario = new Usuario (4, "bob", "chef");
	// final Date fecha = new Date();
	// final Documento doc1 = new Documento (1, "uno", usuario, fecha,
	// TipoDocumento.DOCUMENTO_CONTABLE);
	// final Documento doc2= new Documento (2, "dos", usuario, fecha,
	// TipoDocumento.DOCUMENTO_CONTABLE);
	// final Documento doc3= new Documento (3, "otro", usuario, fecha,
	// TipoDocumento.DOCUMENTO_NOMINA);
	// }

}
