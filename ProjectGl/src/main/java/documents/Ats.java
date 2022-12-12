package documents;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.example.Doc;
import org.example.Etudiant;

public class Ats extends Doc {
	public Ats(int id_doc, String type, Etudiant e) {
		super(id_doc, type, e);
	}

	public void generateDoc() throws FileNotFoundException, MalformedURLException {
//The variable that we'll use to fill the document
		// The variable that we'll use to fill the document
		String nom = this.etudiant.name;
		String cin = this.etudiant.cin;
		String code_natio = this.etudiant.cne;
		String c_apoge = this.etudiant.apogee;
		String date_naiss = this.etudiant.date_naissance;
		String annee_actuel = " 2022/2023";
		String annee_etude="";
		if(this.etudiant.actual_semester==1 || this.etudiant.actual_semester==2){
			annee_etude = "1ère année Classe Préparatoire";
			
		} else if (this.etudiant.actual_semester==3 || this.etudiant.actual_semester==4){
			annee_etude = "2ème année Classe Préparatoire";

		}else if (this.etudiant.actual_semester==5|| this.etudiant.actual_semester==6) { 
			annee_etude = "1ère année Cycle Ingenieur " + this.etudiant.filiere;
			
		}else if (this.etudiant.actual_semester==7 || this.etudiant.actual_semester==8) { 
			annee_etude = "2ème année Cycle Ingenieur " + this.etudiant.filiere;
		}else if (this.etudiant.actual_semester==9 || this.etudiant.actual_semester==10) { 
			annee_etude = "3ème année Cycle Ingenieur " + this.etudiant.filiere;}
		


		String date_attestation = " 4 decembre 2022";
		// Creating a path to the pdf
		String path = "D:\\xampp\\htdocs\\glDocs\\" + this.id_doc + ".pdf";
		String imagePath = "D:\\User\\glAssets\\logo.jpeg";
		String imagePath2 = "D:\\User\\glAssets\\signature.jpeg";
		String imagePath3 = "C:\\Users\\Simofatt\\Downloads\\arabe_en_tete.jpg" ; 

		// Creating a PdfWriter object ,
		// which will contain the path to the pdf
		// + Creating a pdfDocument object
		// that have as a parameter the
		// pdfWriter Object
		// +creating a document object that'll
		// contains the pdf
		// +The size of the pdf
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);

		// Creating a table that contain 2 columns
		float two_col150 = 350f;
		float columnWidth[] = { two_col150 };

		// IMAGE LOGO :
		ImageData imageData = ImageDataFactory.create(imagePath);
		Image image = new Image(imageData);

		float x = pdfDocument.getDefaultPageSize().getWidth() / 2;
		float y = pdfDocument.getDefaultPageSize().getHeight() / 2;

		image.setFixedPosition(x - 70, y + 280);
		image.setHeight(112);
		document.add(image);
		
		 //IMAGE ARABE : 
		ImageData imageData3 = ImageDataFactory.create(imagePath3) ;
		Image image3 = new Image(imageData3) ;  
		 
		float a =pdfDocument.getDefaultPageSize().getWidth()/2 ; 
		float b =pdfDocument.getDefaultPageSize().getHeight() /2; 
		
		image3.setFixedPosition(a+90,b+285); 
		image3.setHeight(112) ; 
		image3.setOpacity((float ) 1) ; 
	    document.add(image3 ) ; 


		// IMAGE SIGNATURE:
		ImageData imageData2 = ImageDataFactory.create(imagePath2);
		Image image2 = new Image(imageData2);

		float z = pdfDocument.getDefaultPageSize().getWidth() / 2;
		float t = pdfDocument.getDefaultPageSize().getHeight() / 2;

		image2.setFixedPosition(z + 20, t - 180);
		image2.setHeight(80);
		image2.setWidth(300);

		document.add(image2);

		// Writing on the header of the document
		document.add(new Paragraph("ROYAUME DU MAROC \r\n" + "Université Abdelmalek Essaadi \r\n"
				+ "Ecole Nationale des Sciences \r\n" + "Appliquées \r\n" + "Tetouan \r\n"
				+ "Service des Affaires Estudiantines                \r\n \r\n").setFontSize(10F));

		// Creating a table object that have an array as a parameter
		// And adding a new cell to the array so i can write on it
		// what i want
		SolidBorder gb = new SolidBorder(Color.BLACK, 1f / 2f);
		Table table = new Table(columnWidth);
		table.setMarginLeft(90f);
		table.addCell(new Cell().add("  ").setBold().setBorder(Border.NO_BORDER));
		table.addCell(new Cell().add(" ATTESTATION DE SCOLARITE ").setBold().setBorder(Border.NO_BORDER).setBorder(gb)
				.setFontSize(20F).setPaddingLeft(20));
		document.add(table);

		// Writing the body on the document
		document.add(new Paragraph(" \r\n"
				+ "Le directeur de l’école Nationale des Sciences Appliquées de Tetouan atteste que l’étudiant : \r\n"));
		document.add(new Paragraph( nom).setBold().setFontSize(10F));
		document.add(new Paragraph("Numéro de la carte d’identité nationale :   " + cin + "\r\n" + "\n"
				+ "Code national de l’étudiant :   " + code_natio + " \r\n" + "\n" + "N°etudiant :   " + c_apoge
				+ "\r\n" + "\n" + "Né le :   " + date_naiss + "\r\n" + "\n"
				+ "Poursuit ses études a l’Ecole Nationale des Sciences Appliquées Tetouan pour l’année universitaire : "
				+ annee_actuel + "  \r\n" + "\n" + "Diplôme : Diplôme d’ingénieur  \r\n" + "Année : " + annee_etude
				+ "                                                        \r\n" + "\r\n").setFontSize(10F));

		// FOOTER OF THE DOC :
		document.add(new Paragraph("Fait à TETOUAN, le " + date_attestation).setPaddingLeft(300).setFontSize(10F));
		document.add(new Paragraph(" \n \n  Adresse : M'Hannech II \r\n" + "  B.P . 2222 Tétouan \r\n"
				+ "  Tél: 0539968802 FAX : 05399994624 \r\n \r\n \r\n").setFontSize(10F));

		Table table5 = new Table(1);
		table5.addCell(new Cell().add("Le présent document n'est délivré qu'en un seul exemplaire")
				.setBorder(Border.NO_BORDER).setFontSize(10F).setPaddingLeft(100));
		table5.addCell(new Cell().add("Il appartient à l'étudiant d'en faire des photocopies certifiées conformes.")
				.setBorder(Border.NO_BORDER).setFontSize(10F).setPaddingLeft(90));
		document.add(table5);

		// Closing the document
		document.close();
		// Making sure the code got executed
		System.out.println("hello");

	}
}
