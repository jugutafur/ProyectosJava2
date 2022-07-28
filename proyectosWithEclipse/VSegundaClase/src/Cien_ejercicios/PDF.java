package Cien_ejercicios;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;

public class PDF {

 public static void main(String[] args) {
	 
	 System.out.println("En esta clase nos es posible generar un archivo PDF");
  //Creamos la representaci�n de una p�gina, con un tama�o
  //por defecto.
  Rectangle pagina = new Rectangle(PageSize.LETTER);  
  
  //Establecemos el color de la p�gina y reescribimos la funci�n
  //toString de la clase BaseColor para obtener el nombre del color.
  pagina.setBackgroundColor(new BaseColor(java.awt.Color.LIGHT_GRAY) {
   public String toString() {
    return "Light Gray";
   }
  });
  
   // Creamos un documento y le pasamos como parametro un objeto de
   // tipo Rectangle, dicho objeto contiene las especificaciones
   // de como se vera nuestra p�gina.
  Document documento = new Document(pagina);

  try {
   
   // Obtenemos una instancia de un objeto PDFWriter
   PdfWriter.getInstance(documento, new FileOutputStream(
     "Ejemplo1.pdf"));
   documento.open();
   
   // Generamos nuestro contenido.
   String contenido = "Generaci�n de un PDF simple:\n "
     + "\t\tAncho de p�gina: "
     + documento.getPageSize().getWidth()
     + "\n\t\tAlto de p�gina: "
     + documento.getPageSize().getHeight()
     + "\n\t\tColor de p�gina: "
     + documento.getPageSize().getBackgroundColor().toString();

   // Lo agregamos al documento por medio de una instancia
   // de un obtjeto Paragraph.
   //
   documento.add(new Paragraph(contenido));
   
   // Cerramos el documento para hacer persistente el contenido.
   documento.close();
   
  } catch (DocumentException ex) {
   // Atrapamos excepciones concernientes al documento.
  } catch (java.io.IOException ex) {
   // Atrapamos excepciones concernientes al I/O.
  }
 }
}
