package systemzarzadzaniarecepcja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Rozliczenie extends javax.swing.JFrame {

    private String idRezerwacji, numerPokoju;

    public Rozliczenie() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        Logowanie logowanie = new Logowanie();
        labelZalogowano1.setText(logowanie.przekazLogin());

        WyczyscOkno();
    }
    private void WyczyscOkno(){
        labelDaneOsobowe.setVisible(false);
        labelDaneRezerwacje.setVisible(false);
        labelNumerPokoju.setVisible(false);
        labelDataOd.setVisible(false);
        labelDataDo.setVisible(false);
        labelIleDob.setVisible(false);
        labelKosztCalkowity2.setVisible(false);
        labelNumerPokoju2.setVisible(false);
        labelImie.setVisible(false);
        labelDataOd2.setVisible(false);
        labelDataDo2.setVisible(false);
        labelIleDob2.setVisible(false);
        labelKosztCalkowity.setVisible(false);
        buttonUsun.setVisible(false);
        buttonRozliczenie.setVisible(false);
        labelImie.setVisible(false);
        labelNazwisko.setVisible(false);
        labelPeselKlienta.setVisible(false);
        labelNrTelKlienta.setVisible(false);
        labelEmailKlienta.setVisible(false);
        labelNrDowoduKlienta.setVisible(false);
    }
    private void PokazLabel(){
                labelDaneOsobowe.setVisible(true);
                labelDaneRezerwacje.setVisible(true);
                labelNumerPokoju.setVisible(true);
                labelDataOd.setVisible(true);
                labelDataDo.setVisible(true);
                labelIleDob.setVisible(true);
                labelKosztCalkowity2.setVisible(true);
                labelNumerPokoju2.setVisible(true);
                labelImie.setVisible(true);
                labelDataOd2.setVisible(true);
                labelDataDo2.setVisible(true);
                labelIleDob2.setVisible(true);
                labelKosztCalkowity.setVisible(true);
                buttonUsun.setVisible(true);
                buttonRozliczenie.setVisible(true);
                labelImie.setVisible(true);
                labelNazwisko.setVisible(true);
                labelPeselKlienta.setVisible(true);
                labelNrTelKlienta.setVisible(true);
                labelEmailKlienta.setVisible(true);
                labelNrDowoduKlienta.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlowny = new javax.swing.JPanel();
        panelTytulowy = new javax.swing.JPanel();
        labelTytulowy = new javax.swing.JLabel();
        buttonWyjscie = new javax.swing.JButton();
        panelOpcji = new javax.swing.JPanel();
        labelMenu = new javax.swing.JLabel();
        labelRezerwacje = new javax.swing.JLabel();
        labelRozliczenie = new javax.swing.JLabel();
        labelStatystyki = new javax.swing.JLabel();
        labelKlienci = new javax.swing.JLabel();
        labelPokoje = new javax.swing.JLabel();
        labelNumerPokoju = new javax.swing.JLabel();
        labelDataOd = new javax.swing.JLabel();
        labelDataDo = new javax.swing.JLabel();
        labelIleDob = new javax.swing.JLabel();
        buttonRozliczenie = new javax.swing.JButton();
        labelIdPesel = new javax.swing.JLabel();
        textfieldIdPesel = new javax.swing.JTextField();
        buttonWyszukajKlienta = new javax.swing.JButton();
        labelSzukanyNumer = new javax.swing.JLabel();
        textfieldNumerPokoju = new javax.swing.JTextField();
        buttonWyszukajPokoj = new javax.swing.JButton();
        labelKosztCalkowity2 = new javax.swing.JLabel();
        labelZalogowano = new javax.swing.JLabel();
        labelZalogowano1 = new javax.swing.JLabel();
        labelIdRezerwacji = new javax.swing.JLabel();
        textfieldId = new javax.swing.JTextField();
        buttonWyszukajId = new javax.swing.JButton();
        labelNumerPokoju2 = new javax.swing.JLabel();
        labelImie = new javax.swing.JLabel();
        labelDataOd2 = new javax.swing.JLabel();
        labelDataDo2 = new javax.swing.JLabel();
        labelIleDob2 = new javax.swing.JLabel();
        labelKosztCalkowity = new javax.swing.JLabel();
        buttonUsun = new javax.swing.JButton();
        buttonWyczysc = new javax.swing.JButton();
        labelNazwisko = new javax.swing.JLabel();
        labelPeselKlienta = new javax.swing.JLabel();
        labelNrTelKlienta = new javax.swing.JLabel();
        labelEmailKlienta = new javax.swing.JLabel();
        labelNrDowoduKlienta = new javax.swing.JLabel();
        labelDaneOsobowe = new javax.swing.JLabel();
        labelDaneRezerwacje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(102, 102, 102));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("Rozliczenie");

        javax.swing.GroupLayout panelTytulowyLayout = new javax.swing.GroupLayout(panelTytulowy);
        panelTytulowy.setLayout(panelTytulowyLayout);
        panelTytulowyLayout.setHorizontalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTytulowyLayout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(labelTytulowy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTytulowyLayout.setVerticalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTytulowyLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelTytulowy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonWyjscie.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyjscie.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        buttonWyjscie.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyjscie.setText("Wyloguj się");
        buttonWyjscie.setBorderPainted(false);
        buttonWyjscie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonWyjscieMouseClicked(evt);
            }
        });

        panelOpcji.setBackground(new java.awt.Color(51, 51, 51));

        labelMenu.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelMenu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenu.setText("Menu");
        labelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMenuMouseClicked(evt);
            }
        });

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

        labelRozliczenie.setFont(new java.awt.Font("Cambria", 1, 28)); // NOI18N
        labelRozliczenie.setForeground(new java.awt.Color(255, 255, 255));
        labelRozliczenie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRozliczenie.setText("Rozliczenie");
        labelRozliczenie.setToolTipText("");
        labelRozliczenie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                .addComponent(labelRezerwacje)
                .addGap(24, 24, 24)
                .addComponent(labelRozliczenie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelStatystyki, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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

        labelNumerPokoju.setBackground(new java.awt.Color(0, 0, 0));
        labelNumerPokoju.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNumerPokoju.setForeground(new java.awt.Color(255, 255, 255));
        labelNumerPokoju.setText("Numer pokoju:");

        labelDataOd.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataOd.setForeground(new java.awt.Color(255, 255, 255));
        labelDataOd.setText("Data od:");

        labelDataDo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataDo.setForeground(new java.awt.Color(255, 255, 255));
        labelDataDo.setText("Data do:");

        labelIleDob.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIleDob.setForeground(new java.awt.Color(255, 255, 255));
        labelIleDob.setText("Ilość dób:");

        buttonRozliczenie.setBackground(new java.awt.Color(51, 51, 51));
        buttonRozliczenie.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonRozliczenie.setForeground(new java.awt.Color(255, 255, 255));
        buttonRozliczenie.setText("Dokonaj rozliczenia");
        buttonRozliczenie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRozliczenieActionPerformed(evt);
            }
        });

        labelIdPesel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIdPesel.setForeground(new java.awt.Color(255, 255, 255));
        labelIdPesel.setText("ID lub PESEL klienta:");

        textfieldIdPesel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        buttonWyszukajKlienta.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajKlienta.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajKlienta.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajKlienta.setText("Wyszukaj");
        buttonWyszukajKlienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajKlientaActionPerformed(evt);
            }
        });

        labelSzukanyNumer.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelSzukanyNumer.setForeground(new java.awt.Color(255, 255, 255));
        labelSzukanyNumer.setText("Numer pokoju:");

        textfieldNumerPokoju.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        buttonWyszukajPokoj.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajPokoj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajPokoj.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajPokoj.setText("Wyszukaj");
        buttonWyszukajPokoj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajPokojActionPerformed(evt);
            }
        });

        labelKosztCalkowity2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelKosztCalkowity2.setForeground(new java.awt.Color(255, 255, 255));
        labelKosztCalkowity2.setText("Koszt całkowity:");

        labelZalogowano.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelZalogowano.setForeground(new java.awt.Color(0, 0, 0));
        labelZalogowano.setText("Zalogowano jako");

        labelZalogowano1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        labelZalogowano1.setForeground(new java.awt.Color(0, 0, 0));
        labelZalogowano1.setText("Zalogowano jako");

        labelIdRezerwacji.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIdRezerwacji.setForeground(new java.awt.Color(255, 255, 255));
        labelIdRezerwacji.setText("ID rezerwacji:");

        textfieldId.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        buttonWyszukajId.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajId.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajId.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajId.setText("Wyszukaj");
        buttonWyszukajId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajIdActionPerformed(evt);
            }
        });

        labelNumerPokoju2.setBackground(new java.awt.Color(0, 0, 0));
        labelNumerPokoju2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNumerPokoju2.setForeground(new java.awt.Color(255, 255, 255));
        labelNumerPokoju2.setText("Numer pokoju:");

        labelImie.setBackground(new java.awt.Color(255, 255, 255));
        labelImie.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelImie.setForeground(new java.awt.Color(255, 255, 255));
        labelImie.setText("Imie");

        labelDataOd2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataOd2.setForeground(new java.awt.Color(255, 255, 255));
        labelDataOd2.setText("Data od:");

        labelDataDo2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataDo2.setForeground(new java.awt.Color(255, 255, 255));
        labelDataDo2.setText("Data do:");

        labelIleDob2.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIleDob2.setForeground(new java.awt.Color(255, 255, 255));
        labelIleDob2.setText("Ilość dób:");

        labelKosztCalkowity.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelKosztCalkowity.setForeground(new java.awt.Color(255, 255, 255));
        labelKosztCalkowity.setText("Koszt całkowity:");

        buttonUsun.setBackground(new java.awt.Color(51, 51, 51));
        buttonUsun.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonUsun.setForeground(new java.awt.Color(255, 255, 255));
        buttonUsun.setText("Usuń");
        buttonUsun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUsunActionPerformed(evt);
            }
        });

        buttonWyczysc.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyczysc.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        buttonWyczysc.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyczysc.setText("Wyczyść okno");
        buttonWyczysc.setBorderPainted(false);
        buttonWyczysc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyczyscActionPerformed(evt);
            }
        });

        labelNazwisko.setBackground(new java.awt.Color(255, 255, 255));
        labelNazwisko.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNazwisko.setForeground(new java.awt.Color(255, 255, 255));
        labelNazwisko.setText("Nazwisko");

        labelPeselKlienta.setBackground(new java.awt.Color(255, 255, 255));
        labelPeselKlienta.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPeselKlienta.setForeground(new java.awt.Color(255, 255, 255));
        labelPeselKlienta.setText("PESEL");

        labelNrTelKlienta.setBackground(new java.awt.Color(255, 255, 255));
        labelNrTelKlienta.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrTelKlienta.setForeground(new java.awt.Color(255, 255, 255));
        labelNrTelKlienta.setText("Numer telefonu");

        labelEmailKlienta.setBackground(new java.awt.Color(255, 255, 255));
        labelEmailKlienta.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelEmailKlienta.setForeground(new java.awt.Color(255, 255, 255));
        labelEmailKlienta.setText("Email");

        labelNrDowoduKlienta.setBackground(new java.awt.Color(255, 255, 255));
        labelNrDowoduKlienta.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrDowoduKlienta.setForeground(new java.awt.Color(255, 255, 255));
        labelNrDowoduKlienta.setText("Numer dowodu");

        labelDaneOsobowe.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        labelDaneOsobowe.setForeground(new java.awt.Color(255, 255, 255));
        labelDaneOsobowe.setText("Dane osobowe");

        labelDaneRezerwacje.setBackground(new java.awt.Color(255, 255, 255));
        labelDaneRezerwacje.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        labelDaneRezerwacje.setForeground(new java.awt.Color(255, 255, 255));
        labelDaneRezerwacje.setText("Dane rezerwacji");

        javax.swing.GroupLayout panelGlownyLayout = new javax.swing.GroupLayout(panelGlowny);
        panelGlowny.setLayout(panelGlownyLayout);
        panelGlownyLayout.setHorizontalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTytulowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelOpcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlownyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addComponent(labelZalogowano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelZalogowano1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(276, 276, 276)
                        .addComponent(buttonWyczysc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlownyLayout.createSequentialGroup()
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(buttonWyszukajKlienta, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(labelSzukanyNumer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfieldNumerPokoju, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(buttonWyszukajPokoj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelIdRezerwacji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfieldId)
                                .addComponent(buttonWyszukajId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfieldIdPesel))
                            .addComponent(labelIdPesel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlownyLayout.createSequentialGroup()
                                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGlownyLayout.createSequentialGroup()
                                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelKosztCalkowity2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelIleDob)
                                            .addComponent(labelDataDo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelDataOd)
                                            .addComponent(labelNumerPokoju))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNumerPokoju2)
                                            .addComponent(labelDataOd2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelDataDo2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelIleDob2)
                                            .addComponent(labelKosztCalkowity, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(labelDaneRezerwacje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDaneOsobowe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGlownyLayout.createSequentialGroup()
                                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelPeselKlienta)
                                            .addComponent(labelImie)
                                            .addComponent(labelEmailKlienta))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNrDowoduKlienta)
                                            .addComponent(labelNazwisko)
                                            .addComponent(labelNrTelKlienta))))
                                .addGap(76, 76, 76))
                            .addGroup(panelGlownyLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(buttonUsun, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRozliczenie, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelOpcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(textfieldIdPesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyszukajKlienta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelSzukanyNumer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfieldNumerPokoju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyszukajPokoj)
                        .addGap(21, 21, 21)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIdRezerwacji)
                            .addGroup(panelGlownyLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(textfieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlownyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDaneOsobowe)
                            .addGroup(panelGlownyLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelImie)
                                    .addComponent(labelNazwisko))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelPeselKlienta)
                                    .addComponent(labelNrTelKlienta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelEmailKlienta)
                                    .addComponent(labelNrDowoduKlienta))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelDaneRezerwacje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNumerPokoju)
                            .addComponent(labelNumerPokoju2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDataOd)
                            .addComponent(labelDataOd2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDataDo)
                            .addComponent(labelDataDo2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIleDob)
                            .addComponent(labelIleDob2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelKosztCalkowity2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelKosztCalkowity)))
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelIdPesel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonWyszukajId)
                    .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonUsun)
                        .addComponent(buttonRozliczenie, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonWyczysc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlownyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelZalogowano)
                            .addComponent(labelZalogowano1))))
                .addContainerGap())
        );

        textfieldNumerPokoju.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlowny, javax.swing.GroupLayout.PREFERRED_SIZE, 782, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGlowny, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRozliczenieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRozliczenieActionPerformed
        Connection con;
        PreparedStatement pst, pst2;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("UPDATE rezerwacja SET czy_rozliczona='1' WHERE id='" + idRezerwacji + "'");
            int wynik1 = pst.executeUpdate();
            pst2 = con.prepareStatement("UPDATE pokoje SET status='Wolny' WHERE numerpokoju='" + numerPokoju + "'");
            int wynik2 = pst2.executeUpdate();
            con.close();
            WyczyscOkno();
            textfieldIdPesel.setText("");
            textfieldNumerPokoju.setText("");
            textfieldId.setText("");
            JOptionPane.showMessageDialog(null, "Rezerwacja została rozliczona! Status pokoju się zmienił.");
        } catch (Exception ex) {}
    }//GEN-LAST:event_buttonRozliczenieActionPerformed

    private void labelPokojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPokojeMouseClicked
        new Pokoje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelPokojeMouseClicked

    private void labelKlienciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKlienciMouseClicked
        new Klienci().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelKlienciMouseClicked

    private void labelStatystykiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelStatystykiMouseClicked
        new Statystyki().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelStatystykiMouseClicked

    private void labelRezerwacjeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRezerwacjeMouseClicked
        new Rezerwacje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelRezerwacjeMouseClicked

    private void labelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuMouseClicked
        new Menu().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelMenuMouseClicked

    private void buttonWyjscieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonWyjscieMouseClicked
        new Logowanie().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_buttonWyjscieMouseClicked

    private void buttonWyszukajKlientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajKlientaActionPerformed
        String szukaneDane = textfieldIdPesel.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        try {
            String imie, nazwisko, pesel, numerTel, email, numerDowodu, dataOd, dataDo, ileDob, kosztCalkowity;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("select r.id,imie,nazwisko,pesel,numertelefonu,email,numerdowodu,numerpokoju,data_od,data_do,ilosc_dob,r.koszt from rezerwacja r JOIN klient k ON k.id = r.klient_id JOIN pokoje p ON p.id = r.pokoje_id WHERE pesel ='" + szukaneDane + "' OR k.id ='" + szukaneDane + "' AND r.czy_rozliczona='0'");
            rs = pst.executeQuery();
            if (rs.next()) {
                PokazLabel();
                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                pesel = rs.getString("pesel");
                numerTel = rs.getString("numertelefonu");
                email = rs.getString("email");
                numerDowodu = rs.getString("numerdowodu");
                numerPokoju = rs.getString("numerpokoju");
                dataOd = rs.getString("data_od");
                dataDo = rs.getString("data_do");
                ileDob = rs.getString("ilosc_dob");
                kosztCalkowity = rs.getString("koszt");
                idRezerwacji = rs.getString("id");
                labelImie.setText(imie);
                labelNazwisko.setText(nazwisko);
                labelPeselKlienta.setText("PESEL: " + pesel);
                labelNrTelKlienta.setText("Tel." + numerTel);
                labelEmailKlienta.setText(email);
                labelNrDowoduKlienta.setText("nr.Dowodu " + numerDowodu);
                labelNumerPokoju2.setText(numerPokoju);
                labelKosztCalkowity.setText(kosztCalkowity);
                labelDataOd2.setText(dataOd);
                labelDataDo2.setText(dataDo);
                labelIleDob2.setText(ileDob);
            } else {
                JOptionPane.showMessageDialog(null, "Aktywna rezerwacja na dane nazwisko nie istnieje.");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {  }
    }//GEN-LAST:event_buttonWyszukajKlientaActionPerformed

    private void buttonWyszukajPokojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajPokojActionPerformed
        String szukaneDane = textfieldNumerPokoju.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        try {
            String imie, nazwisko, pesel, numerTel, email, numerDowodu, dataOd, dataDo, ileDob, kosztCalkowity;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("select r.id,imie,nazwisko,pesel,numertelefonu,email,numerdowodu,numerpokoju,data_od,data_do,ilosc_dob,r.koszt from rezerwacja r JOIN klient k ON k.id = r.klient_id JOIN pokoje p ON p.id = r.pokoje_id WHERE numerpokoju ='" + szukaneDane + "' AND r.czy_rozliczona='0'");
            rs = pst.executeQuery();
            if (rs.next()) {
                PokazLabel();

                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                pesel = rs.getString("pesel");
                numerTel = rs.getString("numertelefonu");
                email = rs.getString("email");
                numerDowodu = rs.getString("numerdowodu");
                numerPokoju = rs.getString("numerpokoju");
                dataOd = rs.getString("data_od");
                dataDo = rs.getString("data_do");
                ileDob = rs.getString("ilosc_dob");
                kosztCalkowity = rs.getString("koszt");
                idRezerwacji = rs.getString("id");

                labelImie.setText(imie);
                labelNazwisko.setText(nazwisko);
                labelPeselKlienta.setText("PESEL: " + pesel);
                labelNrTelKlienta.setText("Tel." + numerTel);
                labelEmailKlienta.setText(email);
                labelNrDowoduKlienta.setText("nr.Dowodu " + numerDowodu);
                labelNumerPokoju2.setText(numerPokoju);
                labelKosztCalkowity.setText(kosztCalkowity);
                labelDataOd2.setText(dataOd);
                labelDataDo2.setText(dataDo);
                labelIleDob2.setText(ileDob);
            } else {
                JOptionPane.showMessageDialog(null, "Aktywna rezerwacja na dany pokój nie istnieje.");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }//GEN-LAST:event_buttonWyszukajPokojActionPerformed

    private void buttonWyszukajIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajIdActionPerformed
        String szukaneDane = textfieldId.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        try {
            String imie, nazwisko, pesel, numerTel, email, numerDowodu, dataOd, dataDo, ileDob, kosztCalkowity;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("select r.id,imie,nazwisko,pesel,numertelefonu,email,numerdowodu,numerpokoju,data_od,data_do,ilosc_dob,r.koszt from rezerwacja r JOIN klient k ON k.id = r.klient_id JOIN pokoje p ON p.id = r.pokoje_id WHERE r.id ='" + szukaneDane + "' AND r.czy_rozliczona='0'");
            rs = pst.executeQuery();
            if (rs.next()) {
                PokazLabel();

                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                pesel = rs.getString("pesel");
                numerTel = rs.getString("numertelefonu");
                email = rs.getString("email");
                numerDowodu = rs.getString("numerdowodu");
                numerPokoju = rs.getString("numerpokoju");
                dataOd = rs.getString("data_od");
                dataDo = rs.getString("data_do");
                ileDob = rs.getString("ilosc_dob");
                kosztCalkowity = rs.getString("koszt");
                idRezerwacji = rs.getString("id");

                labelImie.setText(imie);
                labelNazwisko.setText(nazwisko);
                labelPeselKlienta.setText("PESEL: " + pesel);
                labelNrTelKlienta.setText("Tel." + numerTel);
                labelEmailKlienta.setText(email);
                labelNrDowoduKlienta.setText("nr.Dowodu " + numerDowodu);
                labelNumerPokoju2.setText(numerPokoju);
                labelKosztCalkowity.setText(kosztCalkowity);
                labelDataOd2.setText(dataOd);
                labelDataDo2.setText(dataDo);
                labelIleDob2.setText(ileDob);

            } else {
                JOptionPane.showMessageDialog(null, "Aktywna rezerwacja na dane ID nie istnieje.");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }//GEN-LAST:event_buttonWyszukajIdActionPerformed

    private void buttonUsunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUsunActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć historie rezerwacji?", "Czy usunąć", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Connection con;
            PreparedStatement pst, pst2;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
                pst = con.prepareStatement("DELETE FROM rezerwacja WHERE id='" + idRezerwacji + "'");
                int wynik1 = pst.executeUpdate();
                pst2 = con.prepareStatement("UPDATE pokoje SET status='Wolny' WHERE numerpokoju='" + numerPokoju + "'");
                int wynik2 = pst2.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(null, "Rezerwacja została usunięta. Status pokoju się zmienił.");
            } catch (Exception ex) {}
        }


    }//GEN-LAST:event_buttonUsunActionPerformed

    private void buttonWyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyczyscActionPerformed

        textfieldIdPesel.setText("");
        textfieldNumerPokoju.setText("");
        textfieldId.setText("");
        WyczyscOkno();
    }//GEN-LAST:event_buttonWyczyscActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rozliczenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rozliczenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rozliczenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rozliczenie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rozliczenie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRozliczenie;
    private javax.swing.JButton buttonUsun;
    private javax.swing.JButton buttonWyczysc;
    private javax.swing.JButton buttonWyjscie;
    private javax.swing.JButton buttonWyszukajId;
    private javax.swing.JButton buttonWyszukajKlienta;
    private javax.swing.JButton buttonWyszukajPokoj;
    private javax.swing.JLabel labelDaneOsobowe;
    private javax.swing.JLabel labelDaneRezerwacje;
    private javax.swing.JLabel labelDataDo;
    private javax.swing.JLabel labelDataDo2;
    private javax.swing.JLabel labelDataOd;
    private javax.swing.JLabel labelDataOd2;
    private javax.swing.JLabel labelEmailKlienta;
    private javax.swing.JLabel labelIdPesel;
    private javax.swing.JLabel labelIdRezerwacji;
    private javax.swing.JLabel labelIleDob;
    private javax.swing.JLabel labelIleDob2;
    private javax.swing.JLabel labelImie;
    private javax.swing.JLabel labelKlienci;
    private javax.swing.JLabel labelKosztCalkowity;
    private javax.swing.JLabel labelKosztCalkowity2;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel labelNazwisko;
    private javax.swing.JLabel labelNrDowoduKlienta;
    private javax.swing.JLabel labelNrTelKlienta;
    private javax.swing.JLabel labelNumerPokoju;
    private javax.swing.JLabel labelNumerPokoju2;
    private javax.swing.JLabel labelPeselKlienta;
    private javax.swing.JLabel labelPokoje;
    private javax.swing.JLabel labelRezerwacje;
    private javax.swing.JLabel labelRozliczenie;
    private javax.swing.JLabel labelStatystyki;
    private javax.swing.JLabel labelSzukanyNumer;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JLabel labelZalogowano;
    private javax.swing.JLabel labelZalogowano1;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelOpcji;
    private javax.swing.JPanel panelTytulowy;
    private javax.swing.JTextField textfieldId;
    private javax.swing.JTextField textfieldIdPesel;
    private javax.swing.JTextField textfieldNumerPokoju;
    // End of variables declaration//GEN-END:variables
}
