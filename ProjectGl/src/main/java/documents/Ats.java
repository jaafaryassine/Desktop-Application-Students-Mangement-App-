package documents;


import java.io.FileNotFoundException;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfWriter ;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document ;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph ;
import com.itextpdf.layout.element.Table;
import org.example.Doc;
import org.example.Etudiant;

public class Ats extends Doc {
    public Ats(int id_doc,String type, Etudiant e){
        super(id_doc,type,e);
    }

    public void generateDoc() throws FileNotFoundException {
//The variable that we'll use to fill the document
        String nom = this.etudiant.name ;
        String cin = this.etudiant.cin ;
        String code_natio = " R134480330" ;
        String c_apoge =this.etudiant.apogee ;
        String date_naiss ="15 Mars 2020" ;
        String annee_actuel = "2022/2023" ;
        String annee_etude ="2eme Annee du Cycle Ingenieur: Genie Informatique" ;
        String date_attestation = " 4 decembre 2022" ;
        //Creating a path to the pdf
        String path ="D:\\xampp\\htdocs\\glDocs\\" + this.id_doc + ".pdf";


        //Creating a PdfWriter object ,
        //which will contain the path to the  pdf
        //+ Creating a pdfDocument object
        //that have as a parameter the
        //pdfWriter Object
        //+creating a document object that'll
        //contains the pdf
        PdfWriter pdfWriter = new PdfWriter(path) ;
        PdfDocument pdfDocument = new PdfDocument(pdfWriter) ;
        Document document = new Document (pdfDocument ) ;
        //The size of the pdf
        pdfDocument.setDefaultPageSize(PageSize.A4) ;
        //Creating a table that contain 2 columns
        float two_col = 100f ;
        float two_col150  = 318f;
        float columnWidth [] = {two_col,two_col150} ;

        //Writing on the header of the document
        document.add(new Paragraph("ROYAUME DU MAROC \r\n"
                + "Université Abdelmalek Essaadi \r\n"
                + "Ecole Nationale des Sciences \r\n"
                + "Appliquées \r\n"
                + "Tetouan \r\n"
                + "Service des Affaires Estudiantines                \r\n \r\n"  ));

        //Creating a table object that have an array as a parameter
        //And adding a new cell to the array so i can write on it
        //what i want
        SolidBorder gb = new SolidBorder(Color.BLACK ,1f/2f) ;
        Table table = new Table (columnWidth) ;
        table.addCell(new Cell().add("  ").setBold().setBorder(Border.NO_BORDER)) ;
        table.addCell(new Cell().add(" ATTESTATION DE SCOLARITE ").setBold().setBorder(Border.NO_BORDER).setBorder(gb).setFontSize(20F)) ;
        document.add(table) ;


        //Writing the body on the document
        document.add(new Paragraph (
                " \r\n"

                        + "Le directeur de l’école Nationale des Sciences Appliquées de Tetouan atteste que l’étudiant : \r\n"));
        document.add( new Paragraph (nom+    "\r\n").setBold());
        document.add(new Paragraph(	"\n"
                + "Numéro de la carte d’identité nationale :   " +cin+        "\r\n"
                +"\n"
                + "Code national de l’étudiant :   "             +code_natio+     " \r\n"
                +"\n"
                + "N°etudiant :   " +c_apoge+         "\r\n"
                +"\n"
                + "Né le :   "+date_naiss+                      "\r\n"
                +"\n"
                + "Poursuit ses études a l’Ecole Nationale des Sciences Appliquées Tetouan pour l’année universitaire : "+annee_actuel+ "          \r\n"
                + "\n"
                + "Diplôme : Diplôme d’ingénieur  \r\n"
                +"\n"
                + "Année : "+annee_etude+ "                                                        \r\n"
                + "\r\n"
                + "\r\n"));
        document.add(new Paragraph ("Fait à TETOUAN, le " +date_attestation).setPaddingLeft(300));

        document.add(new Paragraph( " \n \n \n Adresse : M'Hannech II \r\n"
                + "          B.P . 2222 Tétouan \r\n"
                + "          Tél: 0539968802 FAX : 05399994624"
                + ""
                + "                                             "
                + " ")) ;




        //Closing the document
        document.close() ;
        //Making sure the code got executed
        System.out.println("hello") ;
    }
}
