import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.forms.PdfAcroForm;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TestReadPdf {
 public static void main (String... args) throws Exception {
   File file = File.createTempFile("test", ".pdf");
   try {
     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
     InputStream inputStream = classLoader.getResourceAsStream("f940_2019-test.pdf");

     FileOutputStream outputStream = new FileOutputStream(file);

     PdfDocument pdfDocument = new PdfDocument(new PdfReader(inputStream),
         new PdfWriter(outputStream));
     PdfAcroForm pdfAcroForm = PdfAcroForm.getAcroForm(pdfDocument, true);
   } finally {
     file.delete();
   }
 }
}
