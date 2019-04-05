package es.fpdual.primero.eadmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.*;

import org.apache.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.fpdual.primero.eadmin.modelo.Documento;

/**
 *
 * @author david
 */
public class Excel {

	private static final Logger logger = LogManager.getLogger(Excel.class);
	private List<Documento> documentos = new ArrayList<>();
    public static void main(String[] args) {
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
        Double[] datos = {1.0, 10.0, 45.5, 25.50};

        // Creamos una fila en la hoja en la posicion 0
        Row fila = pagina.createRow(0);

        // Creamos el encabezado
        for (Cell cell : fila) {
			
		}
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
        for (int i = 0; i < datos.length; i++) {
            // Creamos una celda en esa fila, en la
            // posicion indicada por el contador del ciclo
            Cell celda = fila.createCell(i);

            celda.setCellValue(datos[i]);
        }

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

//            logger.log(Level.INFO, "Archivo creado existosamente en {0}", archivo.getAbsolutePath());

        } catch (FileNotFoundException ex) {
//        	logger.log(Level.SEVERE, "Archivo no localizable en sistema de archivos");
        } catch (IOException ex) {
//        	logger.log(Level.SEVERE, "Error de entrada/salida");
        }
    }

}