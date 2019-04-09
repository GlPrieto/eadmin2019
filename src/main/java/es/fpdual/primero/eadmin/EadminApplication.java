package es.fpdual.primero.eadmin;

import java.util.Date;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import javax.imageio.ImageIO;

import es.fpdual.primero.eadmin.modelo.DocumentoContable;
import es.fpdual.primero.eadmin.modelo.Usuario;

@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LogManager.getLogger(EadminApplication.class);

	public static void main(String[] args) throws DocumentException, IOException, WriterException {

		final Usuario usuario = new Usuario(4, "bob", "chef");
		final Date fecha = new Date();

		final DocumentoContable documentoContable = new DocumentoContable(10, "operacion contable", usuario, fecha,
				"00001254684686");

		// final Documento documento = new DocumentoContable (15, "operacion", usuario,
		// fecha, "99991254684686");

		// final Expediente expediente = new Expediente(1,"expediente1", usuario, fecha,
		// tipoExpediente.EXPEDIENTE_SANCIONADOR,);

		documentoContable.getNumeroOperacionContable();
		// AdministracionElectronicaBase documento;
		// documento.toString();
		// documento. <-- Esto no podrá ver los métodos de la clase
		// documentoContable, pues solo puede ver los métodos de las
		// clases de las que hereda y los propios.

		try {
			FileWriter fichero = new FileWriter("trazas.txt", true);

			PrintWriter impFichero = new PrintWriter(fichero);
			logger.info("Iniciando servicio");
			SpringApplication.run(EadminApplication.class, args);
			logger.info("Finalizando servicio");
			impFichero.println("Iniciando servicio");
			impFichero.println("Finalizando servicio");
			impFichero.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		docToPDF();
	}

	public static void docToPDF() throws FileNotFoundException, DocumentException {
		String linea, FileName;
		File InFile = null;
		FileReader fr = null;
		BufferedReader br = null;

		// Selecciona el archivo a convertir.
		FileName = "trazas.txt";

		// Abre el archivo y crea el reader.
		InFile = new File(FileName);
		fr = new FileReader(InFile);
		br = new BufferedReader(fr);

		// Crea el documento de salida.
		FileOutputStream archivo = new FileOutputStream(
				"C:\\Users\\formacion\\Desktop\\eclipse-workspace\\eadmin\\trazas.pdf");
		Document documento = new Document();
		PdfWriter.getInstance(documento, archivo);
		documento.open();

		try {
			while ((linea = br.readLine()) != null) {
				documento = AddNewLine(documento, linea);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// En el finally cerramos el fichero, para asegurarnos en cualquier
			// circunstancia.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// Cerramos el documento PDF.
		documento.close();

	}

	/**
	 * Método: AddNewLine()
	 * 
	 * @param doc
	 * @param linea
	 * @return
	 */
	static public Document AddNewLine(Document doc, String linea) {
		try {
			doc.add(new Paragraph(linea));
		} catch (DocumentException de) {
			de.printStackTrace();
		}

		return doc;
	}
	


}
