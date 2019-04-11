package es.fpdual.primero.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

public abstract class BaseDocumentoMapperTest {

	@Autowired
	DocumentoMapper mapper;

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		// DECLARACION
		Usuario usuario = new Usuario(1, "Manu", "Master");
		LocalDate fecha = LocalDate.now();
		Documento documento = new Documento(1, "Documento de prueba", usuario, fecha, TipoDocumento.DOCUMENTO_PADRON);
		// ENTRENAMIENTO
		// PRUEBA
		Integer resultado = this.mapper.insertarDocumento(documento);
		// COMPROBACION
		assertThat(resultado, is(1));
	}
}
