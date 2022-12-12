package org.example;
import java.awt.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;


public class Download {
    Doc doc;

    public Download(Doc doc){
        this.doc = doc;
    }

    public void dowloadDocument(){
        URL url;
        URLConnection con;
        DataInputStream dis;
        FileOutputStream fos;
        byte[] fileData;
        try {

            url = new URL("http://localhost/glDocs/" + this.doc.id_doc + ".pdf"); //File Location goes here
            con = url.openConnection(); // open the url connection.
            dis = new DataInputStream(con.getInputStream());
            fileData = new byte[con.getContentLength()];
            for (int q = 0; q < fileData.length; q++) {
                fileData[q] = dis.readByte();
            }
            dis.close(); // close the data input stream
            File file = new File("D:\\Downloads\\gl_downloads\\" + this.doc.type + "_" + this.doc.etudiant.name + ".pdf");
            fos = new FileOutputStream(file); //FILE Save Location goes here
            fos.write(fileData);  // write out the file we want to save.
            fos.close(); // close the output stream writer
            Desktop.getDesktop().open(file);
        }
        catch(Exception m) {
            System.out.println(m);
        }
    }
}
