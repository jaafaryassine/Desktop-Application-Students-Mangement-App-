package documents;

import java.net.MalformedURLException;

import org.example.Doc;
import org.example.Etudiant;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

public class Atr extends Doc {
	public int year;

	public Atr(int id_doc, String type, Etudiant e, int year) {
		super(id_doc, type, e);
		this.year = year;
	}

	public void generateDoc() throws MalformedURLException {
		// The variable that we'll use to fill the document
		String sexe = "Monsieur ";
		String nom = "Mohamed Fatehi Alhabib";
		String cin = "BE911812";
		String code_natio = " R134480330";
		String c_apoge = "18044080";
		String date_naiss = "15 Mars 2020";
		String niveau_attestation = "2 eme anne preparatoire ";
		String date_niveau_attesté = "2020/2021";
		String date_attestation = " 4 decembre 2022";
		// Creating a path to the pdf
		String path = "C:\\\\Users\\\\Simofatt\\\\Desktop\\\\attestation_de_reussite.pdf ";
		String imagePath = "C:\\Users\\Simofatt\\Downloads\\Logo.png";
		String imagePath2 = "C:\\Users\\Simofatt\\Downloads\\Signature .jpg";

		// Creating a PdfWriter object ,
		// which will contain the path to the pdf
		// + Creating a pdfDocument object
		// that have as a parameter the
		// pdfWriter Object
		// +creating a document object that'll
		// contains the pdf
		// The size of the pdf
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);
		SolidBorder gb = new SolidBorder(Color.BLACK, 1f / 2f);

		// Creating a table that contain 2 columns
		float two_col150 = 300f;
		float columnWidth[] = { two_col150 };

		// IMAGE LOGO :
		ImageData imageData = ImageDataFactory.create(imagePath);
		Image image = new Image(imageData);

		float x = pdfDocument.getDefaultPageSize().getWidth() / 2;
		float y = pdfDocument.getDefaultPageSize().getHeight() / 2;

		image.setFixedPosition(x - 70, y + 280);
		image.setHeight(112);
		document.add(image);

	}
}
