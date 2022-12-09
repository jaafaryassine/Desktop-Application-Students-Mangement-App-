package org.example;


import documents.Atr;
import documents.Ats;
import documents.ConventionStage;
import documents.Releve;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import documents.Atr;
public class DetailsDoc extends javax.swing.JFrame {
    public int id_doc;

    public DetailsDoc(int id_doc) {
        this.id_doc = id_doc;
        initComponents();
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        Etudiant etudiant = new Etudiant();
        Doc doc = new Doc();

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        detailspanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_apogee = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_type = new javax.swing.JLabel();
        lb_cin = new javax.swing.JLabel();
        refBtn = new javax.swing.JButton();
        accBtn = new javax.swing.JButton();
        titledetail = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\User\\glAssets\\icons8-return-24.png")); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dashboard dashboard = new Dashboard();
                setVisible(false);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        detailspanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nom et Prenom         :");

        jLabel3.setText("Cin                              :");

        jLabel4.setText("N_apogee                  :");

        jLabel5.setText("Type du document    :");

        jLabel6.setText("Email                          :");

        getDetailsDoc(etudiant, doc);
        accBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(doc.type.equals("attestation de scolarité")){
                    Ats ats = new Ats(doc.id_doc, doc.type, doc.etudiant);
                    try{
                        ats.generateDoc();
                        System.out.println("doc generated");
                        Email email = new Email(ats);
                        email.sendMail();
                    }
                    catch (Exception exc){
                        System.out.println(exc);
                    }
                } else if (doc.type.equals("convention de stage")) {
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
                        if (conn != null) {
                            String query = "SELECT * FROM cvs WHERE id_doc=?";
                            PreparedStatement preparedStatement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                                    ResultSet.CONCUR_UPDATABLE);
                            preparedStatement.setInt(1,doc.id_doc);
                            ResultSet res = preparedStatement.executeQuery();
                            res.next();
                            ConventionStage conventionStage = new ConventionStage(doc.id_doc, doc.type, doc.etudiant,res.getString("company_name"),res.getString("start_date"),res.getString("end_date"),res.getString("address_company"));
                            try{
                                conventionStage.generateDoc();
                                System.out.println("doc generated");
                                Email email = new Email(conventionStage);
                                email.sendMail();
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                        }
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }



                } else if (doc.type.equals("relevé de notes")) {
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
                        if (conn != null) {
                            String query = "SELECT * FROM releve WHERE id_doc=?";
                            PreparedStatement preparedStatement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                                    ResultSet.CONCUR_UPDATABLE);
                            preparedStatement.setInt(1,doc.id_doc);
                            ResultSet res = preparedStatement.executeQuery();
                            res.next();
                            Releve releve = new Releve(doc.id_doc, doc.type, doc.etudiant, res.getInt("year"), res.getInt("semester"));
                            try{
                                releve.generateDoc();
                                System.out.println("doc generated");
                                Email email = new Email(releve);
                                email.sendMail();
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                        }
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }

                } else if (doc.type.equals("attestation de réussite")) {
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
                        if (conn != null) {
                            String query = "SELECT * FROM atr WHERE id_doc=?";
                            PreparedStatement preparedStatement = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
                                    ResultSet.CONCUR_UPDATABLE);
                            preparedStatement.setInt(1,doc.id_doc);
                            ResultSet res = preparedStatement.executeQuery();
                            res.next();
                            Atr atr = new Atr(doc.id_doc, doc.type, doc.etudiant, res.getInt("year"));
                            try{
                                atr.generateDoc();
                                System.out.println("doc generated");
                                Email email = new Email(atr);
                                email.sendMail();
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                        }
                    }
                    catch (SQLException e){
                        e.printStackTrace();
                    }

                }
                updateStatusDoc("accepte");
                DownloadDocPage downloadDocPage = new DownloadDocPage(doc.id_doc);
                setVisible(false);
            }
        });


        refBtn.setBackground(java.awt.Color.red);
        refBtn.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        refBtn.setForeground(new java.awt.Color(255, 255, 255));
        refBtn.setText("Refuser");
        refBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        refBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Email emailRef = new Email(doc);
                updateStatusDoc("refuse");
                emailRef.sendMailRefus();
                Dashboard dash = new Dashboard();
                setVisible(false);
            }
        });

        accBtn.setBackground(new java.awt.Color(0, 204, 102));
        accBtn.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        accBtn.setForeground(new java.awt.Color(255, 255, 255));
        accBtn.setText("Accepter");
        accBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        accBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accBtnActionPerformed(evt);
            }
        });

        titledetail.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        titledetail.setText("Details de la demande");

        javax.swing.GroupLayout detailspanelLayout = new javax.swing.GroupLayout(detailspanel);
        detailspanel.setLayout(detailspanelLayout);
        detailspanelLayout.setHorizontalGroup(
                detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(detailspanelLayout.createSequentialGroup()
                                .addGap(443, 443, 443)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(detailspanelLayout.createSequentialGroup()
                                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lb_apogee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lb_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailspanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(titledetail, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(446, 446, 446))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailspanelLayout.createSequentialGroup()
                                .addContainerGap(336, Short.MAX_VALUE)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailspanelLayout.createSequentialGroup()
                                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lb_cin, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(detailspanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(lb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(414, 414, 414))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailspanelLayout.createSequentialGroup()
                                                .addComponent(refBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(287, 287, 287)
                                                .addComponent(accBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(363, 363, 363))))
        );
        detailspanelLayout.setVerticalGroup(
                detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(detailspanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(titledetail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_apogee, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lb_cin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addGroup(detailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(refBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(accBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(detailspanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 16, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(detailspanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    public void getDetailsDoc(Etudiant etudiant, Doc doc){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            if (conn != null) {
                String get_admin_query = "SELECT * FROM etudiants, documents WHERE etudiants.n_apogee = documents.n_apogee AND documents.id_doc=" + this.id_doc;
                PreparedStatement preparedStatement = conn.prepareStatement(get_admin_query, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                ResultSet res = preparedStatement.executeQuery();
                res.next();
                etudiant.name = res.getString("name");
                etudiant.email = res.getString("email");
                etudiant.apogee = res.getString("n_apogee");
                etudiant.cin = res.getString("cin");
                etudiant.cne = res.getString("cne");
                etudiant.date_naissance = res.getString("date_naissance");
                etudiant.actual_semester = res.getInt("actual_semester");
                etudiant.filiere = res.getString("filiere");
                doc.id_doc = res.getInt("id_doc");
                doc.type = res.getString("type");
                doc.etudiant = etudiant;
                lb_name.setText(etudiant.name);
                lb_email.setText(etudiant.email);
                lb_cin.setText(etudiant.cin);
                lb_apogee.setText(etudiant.apogee);
                lb_type.setText(doc.type);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateStatusDoc(String action){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            if (conn != null) {
                String get_admin_query = "UPDATE documents SET statut=? WHERE id_doc=?";
                PreparedStatement preparedStatement = conn.prepareStatement(get_admin_query, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                preparedStatement.setString(1,action);
                preparedStatement.setInt(2,this.id_doc);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void accBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void refBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailsDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailsDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailsDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailsDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify
    private javax.swing.JButton accBtn;
    private javax.swing.JPanel detailspanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lb_apogee;
    private javax.swing.JLabel lb_cin;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_type;
    private javax.swing.JButton refBtn;
    private javax.swing.JLabel titledetail;
}
// End of variables declaration
