/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemzarzadzaniarecepcja;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Logowanie extends javax.swing.JFrame {

    
    public Logowanie() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        initComponents();
    }

    private static String login;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlowny = new javax.swing.JPanel();
        panelTytulowy = new javax.swing.JPanel();
        labelTytulowy = new javax.swing.JLabel();
        textfieldLogin = new javax.swing.JTextField();
        passfieldHaslo = new javax.swing.JPasswordField();
        buttonZaloguj = new javax.swing.JButton();
        labelHaslo = new javax.swing.JLabel();
        labelLogin = new javax.swing.JLabel();
        buttonWyjdz = new javax.swing.JButton();
        buttonPierwszeLogowanie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(255, 255, 255));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setBackground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("System Zarządzania Recepcją");

        javax.swing.GroupLayout panelTytulowyLayout = new javax.swing.GroupLayout(panelTytulowy);
        panelTytulowy.setLayout(panelTytulowyLayout);
        panelTytulowyLayout.setHorizontalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTytulowyLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(labelTytulowy)
                .addGap(32, 32, 32))
        );
        panelTytulowyLayout.setVerticalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTytulowyLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(labelTytulowy)
                .addContainerGap())
        );

        textfieldLogin.setBackground(new java.awt.Color(255, 255, 255));
        textfieldLogin.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        textfieldLogin.setForeground(new java.awt.Color(0, 0, 0));

        passfieldHaslo.setBackground(new java.awt.Color(255, 255, 255));
        passfieldHaslo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        passfieldHaslo.setForeground(new java.awt.Color(0, 0, 0));

        buttonZaloguj.setBackground(new java.awt.Color(255, 255, 255));
        buttonZaloguj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        buttonZaloguj.setForeground(new java.awt.Color(0, 0, 0));
        buttonZaloguj.setText("Zaloguj");
        buttonZaloguj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZalogujActionPerformed(evt);
            }
        });

        labelHaslo.setBackground(new java.awt.Color(255, 255, 255));
        labelHaslo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelHaslo.setForeground(new java.awt.Color(0, 0, 0));
        labelHaslo.setText("Hasło:");

        labelLogin.setBackground(new java.awt.Color(255, 255, 255));
        labelLogin.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelLogin.setForeground(new java.awt.Color(0, 0, 0));
        labelLogin.setText("Login:");

        buttonWyjdz.setBackground(new java.awt.Color(255, 255, 255));
        buttonWyjdz.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        buttonWyjdz.setForeground(new java.awt.Color(0, 0, 0));
        buttonWyjdz.setText("Wyjdź");
        buttonWyjdz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonWyjdzMouseClicked(evt);
            }
        });

        buttonPierwszeLogowanie.setBackground(new java.awt.Color(255, 255, 255));
        buttonPierwszeLogowanie.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        buttonPierwszeLogowanie.setForeground(new java.awt.Color(0, 0, 0));
        buttonPierwszeLogowanie.setText("Pierwsze logowanie");
        buttonPierwszeLogowanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPierwszeLogowanieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlownyLayout = new javax.swing.GroupLayout(panelGlowny);
        panelGlowny.setLayout(panelGlownyLayout);
        panelGlownyLayout.setHorizontalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTytulowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelHaslo)
                            .addComponent(labelLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passfieldHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addComponent(buttonZaloguj, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyjdz, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonPierwszeLogowanie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passfieldHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHaslo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonZaloguj)
                    .addComponent(buttonWyjdz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPierwszeLogowanie)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlowny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlowny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonWyjdzMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonWyjdzMouseClicked
        System.exit(0);
    }//GEN-LAST:event_buttonWyjdzMouseClicked

    private void buttonZalogujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZalogujActionPerformed

        login = textfieldLogin.getText();
        przekazLogin();
        String haslo = passfieldHaslo.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        if (textfieldLogin.getText().equals("") || passfieldHaslo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pola nie mogą być puste.");
        } else
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("SELECT p.login, l.haslo FROM pracownik p JOIN logowanie l on l.id_pracownik = p.id WHERE login='" + login + "' AND haslo='" + haslo + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Pomyślnie zalogowano.");
                dispose();
                Menu menu = new Menu();
                menu.show();
            } else {
                JOptionPane.showMessageDialog(null, "Podano błędne dane.");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {   
        }
    }//GEN-LAST:event_buttonZalogujActionPerformed

    private void buttonPierwszeLogowanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPierwszeLogowanieActionPerformed

        if (textfieldLogin.getText().equals("") || passfieldHaslo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pola nie mogą być puste.");
        } else try {
            login = textfieldLogin.getText();
            przekazLogin();
            String haslo = passfieldHaslo.getText();
            Connection con;
            ResultSet rs;
            PreparedStatement pst;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");

            pst = con.prepareStatement("SELECT * FROM pracownik p JOIN logowanie l on l.id_pracownik = p.id WHERE login='" + login + "' AND haslo is null;");
            rs = pst.executeQuery();

            if (rs.next()) {
                String idPracownika = rs.getString("id");
                pst = con.prepareStatement("UPDATE logowanie SET haslo ='" + haslo + "' WHERE id_pracownik = '" + idPracownika + "';");
                int wynik = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pomyślnie zalogowano oraz ustawiono hasło.");
                dispose();
                Menu menu = new Menu();
                menu.show();
            } else {
                JOptionPane.showMessageDialog(null, "Podano błędne dane.");

            }
            rs.close();
            con.close();
        } catch (Exception ee) {
             
        }
    }//GEN-LAST:event_buttonPierwszeLogowanieActionPerformed
    public String przekazLogin() {
        return login;
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Logowanie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPierwszeLogowanie;
    private javax.swing.JButton buttonWyjdz;
    private javax.swing.JButton buttonZaloguj;
    private javax.swing.JLabel labelHaslo;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelTytulowy;
    private javax.swing.JPasswordField passfieldHaslo;
    private javax.swing.JTextField textfieldLogin;
    // End of variables declaration//GEN-END:variables

}
