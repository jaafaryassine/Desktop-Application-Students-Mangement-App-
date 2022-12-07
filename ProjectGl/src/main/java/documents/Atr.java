package documents;

import org.example.Doc;
import org.example.Etudiant;

public class Atr extends Doc {
    public int year;

    public Atr(int id_doc, String type, Etudiant e, int year){
        super(id_doc,type,e);
        this.year = year;
    }

    public void generateDoc(){

    }
}
