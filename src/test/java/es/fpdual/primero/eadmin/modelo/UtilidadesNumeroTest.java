package es.fpdual.primero.eadmin.modelo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UtilidadesNumeroTest {

	@Test
	public void testName() throws Exception {
		final int numero1 = new Integer(1000);
		final int numero2 = new Integer(1000);

		boolean resultado = UtilidadesNumero.comparar(numero1, numero2);

		assertThat(resultado, is(true));
	}
}
