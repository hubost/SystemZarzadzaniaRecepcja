package systemzarzadzaniarecepcja;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();

        Logowanie logowanie = new Logowanie();
        labelZalogowano1.setText(logowanie.przekazLogin());
        if (logowanie.przekazLogin() == null) {
            labelZalogowano1.setText("test");
        }
        if (labelZalogowano1.getText().equals("admin")) {
            buttonAdmin.setVisible(true);
        } else {
            buttonAdmin.setVisible(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlowny = new javax.swing.JPanel();
        panelTytulowy = new javax.swing.JPanel();
        labelTytulowy = new javax.swing.JLabel();
        buttonWyjscie = new javax.swing.JButton();
        labelZalogowano = new javax.swing.JLabel();
        panelOpcji = new javax.swing.JPanel();
        labelMenu = new javax.swing.JLabel();
        labelRezerwacje = new javax.swing.JLabel();
        labelRozliczenie = new javax.swing.JLabel();
        labelStatystyki = new javax.swing.JLabel();
        labelKlienci = new javax.swing.JLabel();
        labelPokoje = new javax.swing.JLabel();
        labelZalogowano1 = new javax.swing.JLabel();
        buttonAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(255, 255, 255));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("Menu");

        javax.swing.GroupLayout panelTytulowyLayout = new javax.swing.GroupLayout(panelTytulowy);
        panelTytulowy.setLayout(panelTytulowyLayout);
        panelTytulowyLayout.setHorizontalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTytulowyLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(labelTytulowy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTytulowyLayout.setVerticalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTytulowyLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(labelTytulowy)
                .addContainerGap())
        );

        buttonWyjscie.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyjscie.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        buttonWyjscie.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyjscie.setText("Wyloguj się");
        buttonWyjscie.setBorderPainted(false);
        buttonWyjscie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyjscieActionPerformed(evt);
            }
        });

        labelZalogowano.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelZalogowano.setForeground(new java.awt.Color(0, 0, 0));
        labelZalogowano.setText("Zalogowano jako");

        panelOpcji.setBackground(new java.awt.Color(51, 51, 51));

        labelMenu.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        labelMenu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenu.setText("Menu");
        labelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelRezerwacje.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelRezerwacje.setForeground(new java.awt.Color(255, 255, 255));
        labelRezerwacje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRezerwacje.setText("Rezerwacje");
        labelRezerwacje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRezerwacje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRezerwacjeMouseClicked(evt);
            }
        });

        labelRozliczenie.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelRozliczenie.setForeground(new java.awt.Color(255, 255, 255));
        labelRozliczenie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRozliczenie.setText("Rozliczenie");
        labelRozliczenie.setToolTipText("");
        labelRozliczenie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelRozliczenie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRozliczenieMouseClicked(evt);
            }
        });

        labelStatystyki.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelStatystyki.setForeground(new java.awt.Color(255, 255, 255));
        labelStatystyki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatystyki.setText("Statystyki");
        labelStatystyki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelStatystyki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelStatystykiMouseClicked(evt);
            }
        });

        labelKlienci.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelKlienci.setForeground(new java.awt.Color(255, 255, 255));
        labelKlienci.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelKlienci.setText("Klienci");
        labelKlienci.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelKlienci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelKlienciMouseClicked(evt);
            }
        });

        labelPokoje.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelPokoje.setForeground(new java.awt.Color(255, 255, 255));
        labelPokoje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPokoje.setText("Pokoje");
        labelPokoje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPokoje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPokojeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelOpcjiLayout = new javax.swing.GroupLayout(panelOpcji);
        panelOpcji.setLayout(panelOpcjiLayout);
        panelOpcjiLayout.setHorizontalGroup(
            panelOpcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcjiLayout.createSequentialGroup()
                .addComponent(labelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelRozliczenie, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelStatystyki, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelOpcjiLayout.setVerticalGroup(
            panelOpcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcjiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelOpcjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRozliczenie, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStatystyki, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        labelZalogowano1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        labelZalogowano1.setForeground(new java.awt.Color(0, 0, 0));
        labelZalogowano1.setText("Zalogowano jako");

        buttonAdmin.setBackground(new java.awt.Color(51, 51, 51));
        buttonAdmin.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        buttonAdmin.setForeground(new java.awt.Color(255, 255, 255));
        buttonAdmin.setText("ADMIN Dodaj pracownika");
        buttonAdmin.setBorder(null);
        buttonAdmin.setBorderPainted(false);
        buttonAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAdminMouseClicked(evt);
            }
        });
        buttonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlownyLayout = new javax.swing.GroupLayout(panelGlowny);
        panelGlowny.setLayout(panelGlownyLayout);
        panelGlownyLayout.setHorizontalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOpcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTytulowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlownyLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelZalogowano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelZalogowano1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelOpcji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZalogowano)
                    .addComponent(labelZalogowano1)
                    .addComponent(buttonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void labelPokojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPokojeMouseClicked

        new Pokoje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelPokojeMouseClicked

    private void labelStatystykiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelStatystykiMouseClicked

        new Statystyki().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelStatystykiMouseClicked

    private void labelRozliczenieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRozliczenieMouseClicked

        new Rozliczenie().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelRozliczenieMouseClicked

    private void labelRezerwacjeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRezerwacjeMouseClicked

        new Rezerwacje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelRezerwacjeMouseClicked

    private void labelKlienciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKlienciMouseClicked

        new Klienci().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelKlienciMouseClicked

    private void buttonAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAdminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAdminMouseClicked

    private void buttonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdminActionPerformed
        new Pracownik().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_buttonAdminActionPerformed

    private void buttonWyjscieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyjscieActionPerformed
        new Logowanie().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_buttonWyjscieActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdmin;
    private javax.swing.JButton buttonWyjscie;
    private javax.swing.JLabel labelKlienci;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel labelPokoje;
    private javax.swing.JLabel labelRezerwacje;
    private javax.swing.JLabel labelRozliczenie;
    private javax.swing.JLabel labelStatystyki;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JLabel labelZalogowano;
    private javax.swing.JLabel labelZalogowano1;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelOpcji;
    private javax.swing.JPanel panelTytulowy;
    // End of variables declaration//GEN-END:variables
}
