package org.example;

public class Etudiant {
    public String name;
    public String email;
    public String apogee;
    public String cin;
    public String cne;
    public String date_naissance;
    public int actual_semester;
    public String filiere;


    public Etudiant(){

    }
    public Etudiant(String name, String email, String apogee, String cin){
        this.name = name;
        this.email = email;
        this.apogee = apogee;
        this.cin = cin;
    }
}
