package es.fpdual.primero.eadmin.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.fpdual.primero.eadmin.modelo.AdministracionElectronicaException;
import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.modelo.DocumentoContable;

@Repository
public class RepositorioDocumentoEnLista implements RepositorioDocumento {
	
	private final List<Documento> documentos = new ArrayList<>();
	@Override
	public void altaDocumento(Documento documento) {
		
		if (documentos.contains(documento)) {
			throw new AdministracionElectronicaException
			("El documento ya existe");
		}
		
		documentos.add(documento);
	}

	@Override
	public void modificarDocumento(Documento documento) {
		
		if (!documentos.contains(documento)) {
			throw new AdministracionElectronicaException
			("El documento no existe");
		}
		
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		//Solución 1
		final Documento documentoAEliminar = new Documento (codigoDocumento, null,
				null, null, null);
		
		//Solución 2
		documentos.stream().filter(d -> d.getId().intValue ==codigoDocumento).
		findAny().orElse(null);
		
		//Para ambas:
		final int indice = 
				documentos.indexOf(documentoAEliminar);
		documentos.remove(indice);
		
		
	}
		
	@Override
	public List<Documento> obtenerTodosDocumentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSiguienteId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
