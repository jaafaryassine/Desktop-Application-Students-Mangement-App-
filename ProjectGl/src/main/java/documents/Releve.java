package documents;

import org.example.Doc;
import org.example.Etudiant;

public class Releve extends Doc {
    public int year;

    public Releve(int id_doc, String type, Etudiant e, int year){
        super(id_doc,type,e);
        this.year = year;
    }

    public void generateDoc(){

    }
}
