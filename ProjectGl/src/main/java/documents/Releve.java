package documents;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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

public class Releve extends Doc {
	public Integer year;
	public Integer semester;
	public  ArrayList<ArrayList<String>> notes = new ArrayList<ArrayList<String>>();

	public Releve(int id_doc, String type, Etudiant e, Integer year, Integer semester) {
		super(id_doc, type, e);
		this.year = year;
		this.semester = semester;
	}

	public void generateDoc() throws MalformedURLException, FileNotFoundException {
		
		getNotes();
		// The variable that we'll use to fill the document
		
		String nom = this.etudiant.name;
		String cin = this.etudiant.cin;
		String code_natio = this.etudiant.cne;
		String c_apoge = this.etudiant.apogee;
		String date_naiss = this.etudiant.date_naissance;
		String annee_actuel = " 2022/2023";
		Date now = new Date();
		SimpleDateFormat sdf = new  SimpleDateFormat("dd MMMM yyyy");
		String date_attestation =sdf.format(now);


		// Creating a path to the pdf
		String path = "D:\\xampp\\htdocs\\glDocs\\" + this.id_doc + ".pdf";
		String imagePath = "D:\\User\\glAssets\\logo.jpeg";
		String imagePath2 = "D:\\User\\glAssets\\signature.jpeg";
		String imagePath3 = "D:\\User\\glAssets\\arabe_en_tete.jpeg" ;

		
		// Creating a PdfWriter object ,
		// which will contain the path to the pdf
		// + Creating a pdfDocument object
		// that have as a parameter the
		// pdfWriter Object
		// +creating a document object that'll
		// contains the pdf
		// + //The size of the pdf
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		Document document = new Document(pdfDocument);
		pdfDocument.setDefaultPageSize(PageSize.A4);

		// Creating a table that contain 2 columns
		float two_col150 = 390f;
		float columnWidth[] = { two_col150 };

		// CUSTOM BORDER :
		SolidBorder gb = new SolidBorder(Color.BLACK, 1f / 2f);

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
			    
			    



		// HEADER OF THE DOC :
		document.add(new Paragraph("ROYAUME DU MAROC \r\n" + "Université Abdelmalek Essaadi \r\n"
				+ "Ecole Nationale des Sciences \r\n" + "Appliquées \r\n" + "Tetouan \r\n"
				+ "Service des Affaires Estudiantines                \r\n \r\n").setFontSize(10F));

		// Creating a table object that have an array as a parameter
		// And adding a new cell to the array so i can write on it
		Table table = new Table(columnWidth);
		table.setMarginLeft(90f);
		table.addCell(new Cell().add(" RELEVE DE NOTES ET RESULTATS").setBold().setBorder(gb).setFontSize(20F)
				.setPaddingLeft(20));
		document.add(table);

		// BODY OF THE DOC :
		document.add(new Paragraph("\r\n" + nom + "\r\n").setBold());
		document.add(new Paragraph("Numéro de la carte d’identité nationale : " + cin + "\n"
				+ "Code national de l’étudiant :   " + code_natio + " \n" + "N°etudiant :   " + c_apoge + "\n"
				+ "Ne le :   " + date_naiss + "\n" + "Inscrit :   " + annee_actuel + " \r\n" + "\n"
				+ "A obtenue les notes suivantes :" + "\r\n" + "\n").setFontSize(10F));

		Table table2 = new Table(4);
		table2.addCell(new Cell().add(" " + "Modules ").setFontSize(10F));
		table2.addCell(new Cell().add(" " + "Note/Baréme").setFontSize(10F));
		table2.addCell(new Cell().add(" " + "Résultat ").setFontSize(10F));
		table2.addCell(new Cell().add(" " + "Points jury").setFontSize(10F));
		for (int i = 0; i < this.notes.size(); i++) {
			table2.addCell(new Cell().add(this.notes.get(i).get(0)).setFontSize(10F));
			table2.addCell(new Cell().add(this.notes.get(i).get(1)).setFontSize(10F));
			table2.addCell(new Cell().add(this.notes.get(i).get(2)).setFontSize(10F));
			table2.addCell(new Cell().add(this.notes.get(i).get(3)).setFontSize(10F));
		}

		document.add(table2);
		String statut = "";
		String session = "";
		double result = getMoy();
		if(this.year > 0){
			// IMAGE SIGNATURE:
			ImageData imageData2 = ImageDataFactory.create(imagePath2);
			Image image2 = new Image(imageData2);

			float z = pdfDocument.getDefaultPageSize().getWidth() / 2;
			float t = pdfDocument.getDefaultPageSize().getHeight() / 2;

			image2.setFixedPosition(z - 270, t -410);
			image2.setHeight(80);
			image2.setWidth(300);

			document.add(image2);
			if(this.etudiant.actual_semester==1 || this.etudiant.actual_semester==2){
				session= "1ère année Classe Préparatoire";

			} else if (this.etudiant.actual_semester==3 || this.etudiant.actual_semester==4){
				session = "2ème année Classe Préparatoire";

			}else if (this.etudiant.actual_semester==5|| this.etudiant.actual_semester==6) {
				session = "1ère année Cycle Ingenieur " + this.etudiant.filiere;

			}else if (this.etudiant.actual_semester==7 || this.etudiant.actual_semester==8) {
				session = "2ème année Cycle Ingenieur " + this.etudiant.filiere;
			}else if (this.etudiant.actual_semester==9 || this.etudiant.actual_semester==10) {
				session = "3ème année Cycle Ingenieur " + this.etudiant.filiere;}

			if (this.year > 2 && result >= 12){
				statut = "Admis";
			} if (this.year > 2  && result < 12 ){
				statut = "Ajourné";
			}
		}
		else if (this.semester > 0) {
			session = "S" + this.semester;
			// IMAGE SIGNATURE:
			ImageData imageData2 = ImageDataFactory.create(imagePath2);
			Image image2 = new Image(imageData2);

			float z = pdfDocument.getDefaultPageSize().getWidth() / 2;
			float t = pdfDocument.getDefaultPageSize().getHeight() / 2;

			image2.setFixedPosition(z - 270, t -360);
			image2.setHeight(80);
			image2.setWidth(300);

			document.add(image2);
		}

		document.add(new Paragraph("Résultat d'admission  :        " + result+ "         " + statut)
				.setFontSize(10F));

		// FOOTER OF THE DOC :
		Table table3 = new Table(1);
		table3.addCell(new Cell().add("\n \n \n  Fait à TETOUAN, le " + date_attestation).setBorder(Border.NO_BORDER)
				.setFontSize(10F).setPaddingLeft(10));
		document.add(table3);

		Table table4 = new Table(1);
		table4.addCell(new Cell().add("Directeur de l'Ecole Nationale des Sciences Appliquées")
				.setBorder(Border.NO_BORDER).setFontSize(10F));
		document.add(table4);

		// Closing the document
		document.close();
		// Making sure the code got executed
		System.out.println("hello");

	}

	public void getNotes(){
		int s1=0,s2=0;
		if (this.year > 0){
			 s1 = year * 2 - 1;
			 s2 = year * 2;
		} else if (this.semester > 0) {
			 s1 = this.semester;
			 s2 = this.semester;
		}
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
			if (conn != null) {
				String query = "SELECT * FROM notes WHERE n_apogee=? AND (semestre=? OR semestre=?)";
				PreparedStatement preparedStatement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				preparedStatement.setString(1,this.etudiant.apogee);
				preparedStatement.setInt(2,s1);
				preparedStatement.setInt(3,s2);

				ResultSet res = preparedStatement.executeQuery();
				while(res.next()){
					notes.add(new ArrayList<String>(Arrays.asList(res.getString("nom_module"),  res.getString("note"), res.getString("statut"),res.getString("points_jury"))));
				}

			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}

	}
	public double getMoy(){
		int s1=0,s2=0;
		if (this.year > 0){
			s1 = year * 2 - 1;
			s2 = year * 2;
		} else if (this.semester > 0) {
			s1 = this.semester;
			s2 = this.semester;
		}
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
			if (conn != null) {
				String query = "SELECT AVG(note) as moy FROM notes WHERE n_apogee=? AND (semestre=? OR semestre=?)";
				PreparedStatement preparedStatement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				preparedStatement.setString(1,this.etudiant.apogee);
				preparedStatement.setInt(2,s1);
				preparedStatement.setInt(3,s2);
				ResultSet res = preparedStatement.executeQuery();
				res.next();
				return res.getDouble("moy");

			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
}
