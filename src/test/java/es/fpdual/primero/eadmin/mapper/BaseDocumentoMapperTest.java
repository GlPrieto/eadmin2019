package es.fpdual.primero.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	private Usuario usuario;
	private LocalDate fecha;
	private Documento documento;

	@Autowired
	DocumentoMapper mapper;

	@Before
	public void inicializarEnCadaTest() {
		this.usuario = new Usuario(1, "Manu", "Master");
		this.fecha = LocalDate.now();
		this.documento = new Documento(1, "Documento de prueba", usuario, fecha, TipoDocumento.DOCUMENTO_PADRON);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		// DECLARACION

		// ENTRENAMIENTO

		// PRUEBA
		Integer resultado = this.mapper.insertarDocumento(documento);
		// COMPROBACION
		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaRescatarElDocumento() throws Exception {
		// DECLARACION

		// ENTRENAMIENTO
		this.mapper.insertarDocumento(this.documento);
		// PRUEBA
		Documento resultado = this.mapper.getDocumento(1);
		// COMPROBACION
		assertThat(resultado, is(this.documento));
	}

	@Test
	public void deberiaModificarElDocumento() throws Exception {
		// DECLARACIÓN
		Documento modificado = Documento.builder().clone(this.documento).withNombre("nombre actualizado").build();

		// ENTRENAMIENTO
		this.mapper.insertarDocumento(this.documento);

		// PRUEBA
		Integer resultado = this.mapper.actualizarDocumento(modificado);

		// COMPROBACIÓN
		assertThat(resultado, is(1));
		Documento documentoActualizado = this.mapper.getDocumento(1);
		assertThat(documentoActualizado, is(notNullValue()));
		assertThat(documentoActualizado.getNombre(), is("nombre actualizado"));
	}
}
