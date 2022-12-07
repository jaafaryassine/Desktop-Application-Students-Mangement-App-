package documents;

import org.example.Doc;
import org.example.Etudiant;

public class ConventionStage extends Doc {
    public String companyName;
    public int period; //  En mois

    public  ConventionStage(int id_doc, String type, Etudiant e, String companyName, int period){
        super(id_doc,type,e);
        this.companyName = companyName;
        this.period = period;
    }

    public void generateDoc(){

    }
}
