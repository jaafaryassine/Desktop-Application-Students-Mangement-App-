package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Dashboard extends javax.swing.JFrame {


    public Dashboard() {
        initComponents();
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ats = new javax.swing.JButton();
        traitedemande2 = new javax.swing.JButton();
        traitedemande3 = new javax.swing.JButton();
        atr = new javax.swing.JButton();
        releve = new javax.swing.JButton();
        cvs = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rechercher = new javax.swing.JTextField();
        recherche = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabhistorique = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tableau de bord");

        ats.setBackground(new java.awt.Color(153, 153, 255));
        ats.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ats.setText("Attestation de scolarité");
        ats.setBorder(null);
        ats.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));


        traitedemande2.setBackground(new java.awt.Color(102, 102, 255));
        traitedemande2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        traitedemande2.setIcon(new javax.swing.ImageIcon("D:\\User\\glAssets\\icons8-historical-30.png")); // NOI18N
        traitedemande2.setText("Historique de demandes");
        traitedemande2.setBorder(null);


        traitedemande3.setBackground(new java.awt.Color(102, 102, 255));
        traitedemande3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        traitedemande3.setIcon(new javax.swing.ImageIcon("D:\\User\\glAssets\\icons8-submit-progress-24.png")); // NOI18N
        traitedemande3.setText("Demandes non-traités");
        traitedemande3.setBorder(null);


        atr.setBackground(new java.awt.Color(153, 153, 255));
        atr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        atr.setText("Attestation de réussite");
        atr.setBorder(null);


        releve.setBackground(new java.awt.Color(153, 153, 255));
        releve.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        releve.setText("Relevé de notes");
        releve.setBorder(null);


        cvs.setBackground(new java.awt.Color(153, 153, 255));
        cvs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cvs.setText("Convention de stage");
        cvs.setBorder(null);


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(traitedemande3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(releve, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(atr, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cvs, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ats, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(traitedemande2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62)
                                .addComponent(traitedemande3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ats, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(cvs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(releve, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(atr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(traitedemande2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        rechercher.setBackground(new java.awt.Color(102, 102, 255));
        rechercher.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        rechercher.setForeground(new java.awt.Color(204, 204, 204));
        rechercher.setText("");
        rechercher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercherActionPerformed(evt);
            }
        });

        recherche.setBackground(new java.awt.Color(102, 102, 255));
        recherche.setIcon(new javax.swing.ImageIcon("D:\\User\\glAssets\\icons8-search-24.png")); // NOI18N


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(recherche, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(recherche))
                                .addGap(30, 30, 30))
        );

        tabhistorique.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nom et prénom", "email", "N_apogee", "Type de document", "Statut", "Action"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableModel table = (DefaultTableModel) tabhistorique.getModel();


        rechercher.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                convert();
            }
            public void removeUpdate(DocumentEvent e) {
                convert();
            }
            public void insertUpdate(DocumentEvent e) {
                convert();
            }
            public void convert(){
                table.setRowCount(0);
                getBySearch(rechercher.getText(), table);
            }

        });

        getNonTraite(table);


        // change Row table too historique
        traitedemande2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.setRowCount(0);
                getHistorique(table);
            }
        });

        // change table to demandes non traitées
        traitedemande3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.setRowCount(0);
                getNonTraite(table);
            }
        });

        atr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.setRowCount(0);
                getByType("attestation de réussite", table);
            }
        });
        ats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.setRowCount(0);
                getByType("attestation de scolarité", table);
            }
        });
        cvs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.setRowCount(0);
                getByType("convention de stage", table);
            }
        });
        releve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table.setRowCount(0);
                getByType("relevé de notes", table);
            }
        });

        jScrollPane1.setViewportView(tabhistorique);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 7, Short.MAX_VALUE))))
        );

        pack();

        // Functions

    }// </editor-fold>
    public void getNonTraite(DefaultTableModel table){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            if (conn != null) {
                String get_admin_query = "SELECT * FROM etudiants, documents WHERE etudiants.n_apogee = documents.n_apogee AND documents.statut=?";
                PreparedStatement preparedStatement = conn.prepareStatement(get_admin_query,ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                preparedStatement.setString(1,"n_traite");
                ResultSet res = preparedStatement.executeQuery();
                Action testAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTable table = (JTable)e.getSource();
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                        try {
                            res.absolute(modelRow + 1); // Positionne the cursor in the row clicked
                            if(res.getString("statut").equals("n_traite")){
                                System.out.println("non traite");
                                setVisible(false);
                                DetailsDoc detailsDoc = new DetailsDoc(res.getInt("id_doc"));
                            } else if (res.getString("statut").equals("accepte")) {
                                System.out.println("accepteeee");
                                setVisible(false);
                                DownloadDocPage downloadDocPage = new DownloadDocPage(res.getInt("id_doc"));
                            }
                            else if (res.getString("statut").equals("refuse")) {
                                System.out.println("refuse");
                                setVisible(false);
                                DocRefus docRefus = new DocRefus(res.getInt("id_doc"));
                            }
                        } catch (SQLException ex){
                            System.out.println(ex);
                        }
                    }
                };
                ButtonColumn test = new ButtonColumn(tabhistorique,testAction,5);

                while (res.next()){
                    table.addRow(new Object[]{res.getString("name"), res.getString("email"), res.getString("n_apogee"),res.getString("type"),res.getString("statut"),"Voir details"});
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getHistorique(DefaultTableModel table){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            if (conn != null) {
                String get_admin_query = "SELECT * FROM etudiants, documents WHERE etudiants.n_apogee = documents.n_apogee AND (documents.statut=? OR documents.statut=?)";
                PreparedStatement preparedStatement = conn.prepareStatement(get_admin_query,ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                preparedStatement.setString(1,"accepte");
                preparedStatement.setString(2,"refuse");
                ResultSet res = preparedStatement.executeQuery();
                Action testAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JTable table = (JTable)e.getSource();
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                        try {
                            res.absolute(modelRow + 1); // Positionne the cursor in the row clicked
                            if(res.getString("statut").equals("n_traite")){
                                System.out.println("non traite");
                                setVisible(false);
                                DetailsDoc detailsDoc = new DetailsDoc(res.getInt("id_doc"));
                            } else if (res.getString("statut").equals("accepte")) {
                                System.out.println("accepteeee");
                                setVisible(false);
                                DownloadDocPage downloadDocPage = new DownloadDocPage(res.getInt("id_doc"));
                            }
                            else if (res.getString("statut").equals("refuse")) {
                                System.out.println("refuse");
                                setVisible(false);
                                DocRefus docRefus = new DocRefus(res.getInt("id_doc"));
                            }
                        } catch (SQLException ex){
                            System.out.println(ex);
                        }
                    }
                };
                ButtonColumn test = new ButtonColumn(tabhistorique,testAction,5);

                while (res.next()){
                    JButton btn = new JButton("Accepter");
                    table.addRow(new Object[]{res.getString("name"), res.getString("email"), res.getString("n_apogee"),res.getString("type"),res.getString("statut"),"Voir details"});
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  void getBySearch(String input, DefaultTableModel table){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            String query = "SELECT * FROM etudiants, documents WHERE documents.n_apogee=etudiants.n_apogee AND (documents.n_apogee LIKE '" + input
                    + "%' OR name LIKE '" + input + "%' OR type LIKE '" + input + "%' OR statut LIKE '" + input + "%')";
            PreparedStatement preparedStatement = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet res = preparedStatement.executeQuery();
            Action testAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    try {
                        res.absolute(modelRow + 1); // Positionne the cursor in the row clicked
                        if(res.getString("statut").equals("n_traite")){
                            System.out.println("non traite");
                            setVisible(false);
                            DetailsDoc detailsDoc = new DetailsDoc(res.getInt("id_doc"));
                        } else if (res.getString("statut").equals("accepte")) {
                            System.out.println("accepteeee");
                            setVisible(false);
                            DownloadDocPage downloadDocPage = new DownloadDocPage(res.getInt("id_doc"));
                        }
                        else if (res.getString("statut").equals("refuse")) {
                            System.out.println("refuse");
                            setVisible(false);
                            DocRefus docRefus = new DocRefus(res.getInt("id_doc"));
                        }
                    } catch (SQLException ex){
                        System.out.println(ex);
                    }
                }
            };
            ButtonColumn test = new ButtonColumn(tabhistorique,testAction,5);

            while (res.next()){
                System.out.println(res.getInt("id_doc"));
                table.addRow(new Object[]{res.getString("name"), res.getString("email"), res.getString("n_apogee"),res.getString("type"),res.getString("statut"),"Voir details"});
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    public void getByType(String type, DefaultTableModel table){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gl","root","");
            String query = "SELECT * FROM etudiants, documents WHERE documents.n_apogee=etudiants.n_apogee AND type=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            preparedStatement.setString(1, type);
            ResultSet res = preparedStatement.executeQuery();
            Action testAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    try {
                        res.absolute(modelRow + 1); // Positionne the cursor in the row clicked
                        if(res.getString("statut").equals("n_traite")){
                            System.out.println("non traite");
                            setVisible(false);
                            DetailsDoc detailsDoc = new DetailsDoc(res.getInt("id_doc"));
                        } else if (res.getString("statut").equals("accepte")) {
                            System.out.println("accepteeee");
                            setVisible(false);
                            DownloadDocPage downloadDocPage = new DownloadDocPage(res.getInt("id_doc"));
                        }
                        else if (res.getString("statut").equals("refuse")) {
                            System.out.println("refuse");
                            setVisible(false);
                            DocRefus docRefus = new DocRefus(res.getInt("id_doc"));
                        }
                    } catch (SQLException ex){
                        System.out.println(ex);
                    }
                }
            };
            ButtonColumn test = new ButtonColumn(tabhistorique,testAction,5);

            while (res.next()){
                System.out.println(res.getInt("id_doc"));
                table.addRow(new Object[]{res.getString("name"), res.getString("email"), res.getString("n_apogee"),res.getString("type"),res.getString("statut"),"Voir details"});
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    private void attscolaritéActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void traitedemande2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void traitedemande3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void attreuissiteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void relevenoteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void conventionstageActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rechercheActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void rechercherActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton atr;
    private javax.swing.JButton ats;
    private javax.swing.JButton cvs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton recherche;
    private javax.swing.JTextField rechercher;
    private javax.swing.JButton releve;
    private javax.swing.JTable tabhistorique;
    private javax.swing.JButton traitedemande2;
    private javax.swing.JButton traitedemande3;
    // End of variables declaration
}










