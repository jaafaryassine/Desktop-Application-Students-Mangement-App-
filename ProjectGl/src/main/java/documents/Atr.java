package documents;

import java.io.FileNotFoundException;
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

	public void generateDoc() throws MalformedURLException, FileNotFoundException {
		// The variable that we'll use to fill the document
	
		String nom = this.etudiant.name;
		String cin = this.etudiant.cin;
		String code_natio = this.etudiant.cne;
		String c_apoge = this.etudiant.apogee;
		String date_naiss = this.etudiant.date_naissance;
		String date_attestation = " 4 decembre 2022";
		String niveau_attestation="";
		if(this.year==1){
			niveau_attestation ="1ère année Classe Préparatoire" ; 			
		} else if (this.year==2){
			niveau_attestation= "2ème année Classe Préparatoire";
			
		}else if (this.year==3) { 
			niveau_attestation = "1ère année Cycle Ingenieur " ;
		}else if (this.year==4) { 
			niveau_attestation = "2ème année Cycle Ingenieur " ;
		}else if (this.year==5 ) { 
			niveau_attestation = "3ème année Cycle Ingenieur " ;}
		// Creating a path to the pdf
		String path = "D:\\xampp\\htdocs\\glDocs\\" + this.id_doc + ".pdf";
		String imagePath = "D:\\User\\glAssets\\logo.jpeg";
		String imagePath2 = "D:\\User\\glAssets\\signature.jpeg";
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

		// IMAGE SIGNATURE:
				ImageData imageData2 = ImageDataFactory.create(imagePath2);
				Image image2 = new Image(imageData2);

				float z = pdfDocument.getDefaultPageSize().getWidth() / 2;
				float t = pdfDocument.getDefaultPageSize().getHeight() / 2;

				image2.setFixedPosition(z + 20, t - 150);
				image2.setHeight(80);
				image2.setWidth(300);

				document.add(image2);

				// HEADER OF THE DOC :
				document.add(new Paragraph("ROYAUME DU MAROC \r\n" + "Université Abdelmalek Essaadi \r\n"
						+ "Ecole Nationale des Sciences \r\n" + "Appliquées \r\n" + "Tetouan \r\n"
						+ "Service des Affaires Estudiantines                \r\n \r\n").setFontSize(10F));

				// Creating a table object that have an array as a parameter
				// And adding a new cell to the array so i can write on it
				// what i want

				Table table = new Table(columnWidth);
				table.setMarginLeft(100f);

				table.addCell(new Cell().add(" " + "ATTESTATION DE REUSSITE ").setBold().setBorder(gb).setFontSize(20F)
						.setPaddingLeft(10));
				document.add(table);

				// Writing the body on the document
				document.add(new Paragraph(
						"\r\n" + "Le Directeur de l'Ecole Nationale des Sciences Appliquées atteste que :  " + "\r\n")
						.setFontSize(10F));
				document.add(new Paragraph(nom + "\r\n").setBold().setFontSize(10F));

				document.add(new Paragraph("Numéro de la carte d’identité nationale :   " + cin + "\r\n" + "\n"
						+ "Code national de l’étudiant :   " + code_natio + " \r\n" + "\n" + "N°etudiant :   " + c_apoge
						+ "\r\n" + "\n" + "Né le :   " + date_naiss + "\r\n" + "\n"
						+ "A été déclare admis au : " +niveau_attestation 
						+ "au titre de l'année universitaire 2020/2021 \r\n \n \n\n\n").setFontSize(10F));
				document.add(new Paragraph("Fait à TETOUAN, le " + date_attestation).setPaddingLeft(300).setFontSize(10F));

				Table table5 = new Table(1);
				table5.addCell(
						new Cell()
								.add(" \n \n \n \n \n \n \n \n \n Adresse : M'Hannech II \n "
										+ "          B.P . 2222 Tétouan \n" + "      Tél: 0539968802 FAX : 05399994624\n")
								.setBorder(Border.NO_BORDER).setFontSize(10F));
				document.add(table5);

				// Closing the document
				document.close();
				// Making sure the code got executed
				System.out.println("hello");

	}
}
