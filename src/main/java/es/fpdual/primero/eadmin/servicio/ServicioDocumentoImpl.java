package es.fpdual.primero.eadmin.servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.primero.eadmin.modelo.Documento;
import es.fpdual.primero.eadmin.repositorio.RepositorioDocumento;


@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

		private final RepositorioDocumento repositorioDocumento;
		private static final Logger logger = LogManager.getLogger(ServicioDocumentoImpl.class);
		private List<Documento> documentos = new ArrayList<>();
	    
	    
		
		@Autowired
		public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
			this.repositorioDocumento = repositorioDocumento;
		}
		
	@Override
	public Documento altaDocumento(Documento documento) {
		final int siguienteId = repositorioDocumento.getSiguienteId();
		final LocalDate fechaActual = LocalDate.now();
		
		Documento documentoModificado = new Documento (
				siguienteId, documento.getNombre(), 
				documento.getUsuario(), fechaActual, 
				documento.getTipoDocumento()
		);
		
		repositorioDocumento.altaDocumento(documentoModificado);
		Excel();

		return documentoModificado;
	}

	@Override
	public void modificarDocumento(Documento documento) {
		repositorioDocumento.modificarDocumento(documento);
	}

	@Override
	public void eliminarDocumento(int codigoDocumento) {
		repositorioDocumento.eliminarDocumento(codigoDocumento);
		
	}

	@Override
	public List<Documento> obtenerTodosDocumentos() {
		return repositorioDocumento.obtenerTodosDocumentos();
	}
	@Override
	public Documento obtenerDocumentoPorId(int codigoDocumento) {
		return repositorioDocumento.obtenerDocumentoPorId(codigoDocumento);
	}
	
	public void Excel (){

	        // Creamos el archivo donde almacenaremos la hoja
	        // de calculo, recuerde usar la extension correcta,
	        // en este caso .xlsx
	        File archivo = new File("documentos.xlsx");

	        // Creamos el libro de trabajo de Excel formato OOXML
	        Workbook workbook = new XSSFWorkbook();

	        // La hoja donde pondremos los datos
	        Sheet pagina = workbook.createSheet("documentos");

	        // Creamos el estilo paga las celdas del encabezado
	        CellStyle style = workbook.createCellStyle();
	        // Indicamos que tendra un fondo azul aqua
	        // con patron solido del color indicado
	        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        String[] titulos = {"Id", "Nombre",
	            "Usuario", "Fecha creación", "Tipo de documento"};
//	        Double[] datos = {1.0, 10.0, 45.5, 25.50};

	        // Creamos una fila en la hoja en la posicion 0
	        Row fila = pagina.createRow(0);

	        // Creamos el encabezado
	      
	        for (int i = 0; i < titulos.length; i++) {
	            // Creamos una celda en esa fila, en la posicion 
	            // indicada por el contador del ciclo
	            Cell celda = fila.createCell(i);

	            // Indicamos el estilo que deseamos 
	            // usar en la celda, en este caso el unico 
	            // que hemos creado
	            celda.setCellStyle(style);
	            celda.setCellValue(titulos[i]);
	        }

	        // Ahora creamos una fila en la posicion 1
	        fila = pagina.createRow(1);

	        // Y colocamos los datos en esa fila
	        List<Documento> lista = obtenerTodosDocumentos();
	        int j = 1;
				for (Documento documento : lista) {
					Cell  celda = fila.createCell(0);
					celda.setCellValue(documento.getId());
					Cell celda1 = fila.createCell(1);
					celda1.setCellValue(documento.getNombre());
					Cell celda2 = fila.createCell(2);
					celda2.setCellValue(documento.getUsuario().getNombre());
					Cell celda3 = fila.createCell(3);
					celda3.setCellValue(documento.getFechaCreacion().toString());
					Cell celda4 = fila.createCell(4);
					celda4.setCellValue(documento.getTipoDocumento().name());
					j++;
					 fila = pagina.createRow(j);
				}
				
		
//	        for (int i = 0; i < datos.length; i++) {
//	            // Creamos una celda en esa fila, en la
//	            // posicion indicada por el contador del ciclo
//	            Cell celda = fila.createCell(i);
//
//	            celda.setCellValue(datos[i]);
//	        }

	        // Ahora guardaremos el archivo
	        try {
	            // Creamos el flujo de salida de datos,
	            // apuntando al archivo donde queremos 
	            // almacenar el libro de Excel
	            FileOutputStream salida = new FileOutputStream(archivo);

	            // Almacenamos el libro de 
	            // Excel via ese 
	            // flujo de datos
	            workbook.write(salida);

	            // Cerramos el libro para concluir operaciones
	            workbook.close();

//	            logger.log(Level.INFO, "Archivo creado existosamente en {0}", archivo.getAbsolutePath());

	        } catch (FileNotFoundException ex) {
//	        	logger.log(Level.SEVERE, "Archivo no localizable en sistema de archivos");
	        } catch (IOException ex) {
//	        	logger.log(Level.SEVERE, "Error de entrada/salida");
	        }
	}

}

