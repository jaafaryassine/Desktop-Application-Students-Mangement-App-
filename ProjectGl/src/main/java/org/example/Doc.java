package org.example;
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
public class Doc {
    public int id_doc;
    public String type;
    public Etudiant etudiant;

    public Doc(){

    }
    public Doc(int id_doc,String type, Etudiant e){
        this.id_doc = id_doc;
        this.type = type;
        this.etudiant = e;
    }
}















