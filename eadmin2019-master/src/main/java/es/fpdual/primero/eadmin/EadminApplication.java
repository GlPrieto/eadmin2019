package es.fpdual.primero.eadmin;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;
//import es.fpdual.primero.eadmin.modelo.DocumentoFactura;
//import es.fpdual.primero.eadmin.modelo.TipoDocumento;
import es.fpdual.primero.eadmin.modelo.Usuario;

@SpringBootApplication
public class EadminApplication {

	public static void main(String[] args) {
		
		final Usuario usuario = new Usuario (4, "bob", "chef");
		final Date fecha = new Date();
		
		final DocumentoContable documentoContable = new DocumentoContable (10, "operacion contable", usuario, fecha, "00001254684686");
		
		final Documento documento = new DocumentoContable (15, "operacion", usuario, fecha, "99991254684686");
		
//		final Expediente expediente = new Expediente(1,"expediente1", usuario, fecha, tipoExpediente.EXPEDIENTE_SANCIONADOR,);
		
		documentoContable.getNumeroOperacionContable();
		documento.toString();
//		documento. <-- Esto no podrá ver los métodos de la clase 
//		documentoContable, pues solo puede ver los métodos de las 
//		clases de las que hereda y los propios.
		
		SpringApplication.run(EadminApplication.class, args);
	}

}
