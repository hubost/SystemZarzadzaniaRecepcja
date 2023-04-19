/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemzarzadzaniarecepcja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

public class Rezerwacje extends javax.swing.JFrame {

    private String dataOdFormatS, dataDoFormatS, idKlienta, pokojId, numer, pracownikId;

    public Rezerwacje() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        Logowanie logowanie = new Logowanie();
        WczytajTabele();
        labelZalogowano1.setText(logowanie.przekazLogin());
        wyczyscOkno();

    }

    private void wyczyscOkno() {
        labelDostepnePokoje.setVisible(false);
        comboDostepnePokoje.setVisible(false);
        buttonWybierz.setVisible(false);
        labelPodsumowanie.setVisible(false);
        labelImieNazwisko.setVisible(false);
        labelIleOsob.setVisible(false);
        labelIleDob.setVisible(false);
        labelPesel.setVisible(false);
        labelWybranyPokoj.setVisible(false);
        labelId.setVisible(false);
        labelKoszt.setVisible(false);
        labelWaluta.setVisible(false);
        labelData.setVisible(false);
        buttonDokonaj.setVisible(false);
        labelIleDob2.setVisible(false);
        labelImieNazwisko2.setVisible(false);
        labelIleOsob2.setVisible(false);
        labelPesel2.setVisible(false);
        labelWybranyPokoj2.setVisible(false);
        labelId2.setVisible(false);
        labelKoszt2.setVisible(false);
        labelData2.setVisible(false);
    }

    private void WczytajTabele() {
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        ResultSetMetaData rsmd;
        DefaultTableModel model;
        int pokazjedynie = comboPokazRezerwacje.getSelectedIndex();
        String pokazjedynieS = null;
        try {
            String nazwisko = textfieldNazwisko.getText();
            String szukanaDataFormatS = ftextfieldData.getText();
            if (nazwisko.equals("")) {
                nazwisko = "";
            } else {
                nazwisko = "AND k.nazwisko ='" + textfieldNazwisko.getText() + "'";
            }
            if (szukanaDataFormatS.equals("")) {
                szukanaDataFormatS = "";
            } else {
                szukanaDataFormatS = "AND data_od ='" + ftextfieldData.getText() + "'";
            }
            tableRezerwacje.setModel(new DefaultTableModel());
            if (pokazjedynie == 0) {
                pokazjedynieS = "WHERE czy_rozliczona = '0' ";
            } else if (pokazjedynie == 1) {
                pokazjedynieS = "WHERE czy_rozliczona = '1' ";
            } else if (pokazjedynie == 2) {
                pokazjedynieS = "";
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            String sql = "select r.id, pr.login,data_od,data_do, ilosc_dob, koszt, czy_rozliczona,  p.numerpokoju, k.imie, k.nazwisko from rezerwacja r join pokoje p on p.id = r.pokoje_id join pracownik pr on pr.id = r.pracownik_id join klient k on k.id = r.klient_id " + pokazjedynieS + nazwisko + szukanaDataFormatS + " ORDER BY r.id DESC";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            rsmd = rs.getMetaData();
            model = (DefaultTableModel) tableRezerwacje.getModel();
            int kolumny = rsmd.getColumnCount();
            String[] nazwaKolumny = new String[kolumny];
            for (int i = 0; i < kolumny; i++) {
                nazwaKolumny[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(nazwaKolumny);
            String id, pracownik, dataOd, dataDo, iloscDob, koszt, rozliczenie, pokojNr, klientImie, klientNazwisko;
            while (rs.next()) {
                id = rs.getString(1);
                pracownik = rs.getString(2);
                dataOd = rs.getString(3);
                dataDo = rs.getString(4);
                iloscDob = rs.getString(5);
                koszt = rs.getString(6);
                rozliczenie = rs.getString(7);
                pokojNr = rs.getString(8);
                klientImie = rs.getString(9);
                klientNazwisko = rs.getString(10);
                String[] row = {id, pracownik, dataOd, dataDo, iloscDob, koszt, rozliczenie, pokojNr, klientImie, klientNazwisko};
                model.addRow(row);
            }
            rs.close();
            con.close();
        } catch (Exception ee) {
            
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
        tpanelRezerwacje = new javax.swing.JTabbedPane();
        panelListaRezerwacji = new javax.swing.JPanel();
        labelPokazJedynie = new javax.swing.JLabel();
        comboPokazRezerwacje = new javax.swing.JComboBox<>();
        buttonWyszukaj = new javax.swing.JButton();
        scrollPaneRezerwacje = new javax.swing.JScrollPane();
        tableRezerwacje = new javax.swing.JTable();
        labelDataRezerwacji = new javax.swing.JLabel();
        ftextfieldData = new javax.swing.JFormattedTextField();
        labelNazwisko = new javax.swing.JLabel();
        textfieldNazwisko = new javax.swing.JTextField();
        panelDokonajRezerwacji = new javax.swing.JPanel();
        labelDostepnePokoje = new javax.swing.JLabel();
        labelIleDob = new javax.swing.JLabel();
        labelKoszt = new javax.swing.JLabel();
        buttonDokonaj = new javax.swing.JButton();
        comboDostepnePokoje = new javax.swing.JComboBox<>();
        labelDataOd = new javax.swing.JLabel();
        labelDataDo = new javax.swing.JLabel();
        labelIdPesel = new javax.swing.JLabel();
        textfieldIdLubPesel = new javax.swing.JTextField();
        labelImieNazwisko = new javax.swing.JLabel();
        buttonSprawdz = new javax.swing.JButton();
        labelDlaIluOsob = new javax.swing.JLabel();
        comboIleOsob = new javax.swing.JComboBox<>();
        labelWaluta = new javax.swing.JLabel();
        labelPodsumowanie = new javax.swing.JLabel();
        labelPesel = new javax.swing.JLabel();
        labelIleOsob = new javax.swing.JLabel();
        buttonWybierz = new javax.swing.JButton();
        labelWybranyPokoj = new javax.swing.JLabel();
        datechooserDataOd = new com.toedter.calendar.JDateChooser();
        datechooserDataDo = new com.toedter.calendar.JDateChooser();
        labelIleDob2 = new javax.swing.JLabel();
        labelPesel2 = new javax.swing.JLabel();
        labelImieNazwisko2 = new javax.swing.JLabel();
        labelIleOsob2 = new javax.swing.JLabel();
        labelWybranyPokoj2 = new javax.swing.JLabel();
        labelKoszt2 = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        labelId2 = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelData2 = new javax.swing.JLabel();
        buttonWyczysc = new javax.swing.JButton();
        labelZalogowano1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(255, 255, 255));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("Rezerwacje");

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
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(labelTytulowy)
                .addContainerGap())
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

        labelZalogowano.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelZalogowano.setForeground(new java.awt.Color(0, 0, 0));
        labelZalogowano.setText("Zalogowano jako");

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

        labelRezerwacje.setFont(new java.awt.Font("Cambria", 1, 28)); // NOI18N
        labelRezerwacje.setForeground(new java.awt.Color(255, 255, 255));
        labelRezerwacje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRezerwacje.setText("Rezerwacje");
        labelRezerwacje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                .addComponent(labelRezerwacje)
                .addGap(18, 18, 18)
                .addComponent(labelRozliczenie, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelStatystyki)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        tpanelRezerwacje.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        panelListaRezerwacji.setBackground(new java.awt.Color(51, 51, 51));
        panelListaRezerwacji.setForeground(new java.awt.Color(51, 51, 51));

        labelPokazJedynie.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokazJedynie.setForeground(new java.awt.Color(255, 255, 255));
        labelPokazJedynie.setText("Pokaż jedynie:");

        comboPokazRezerwacje.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboPokazRezerwacje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nierozliczone", "Rozliczone", "Wszystko" }));

        buttonWyszukaj.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukaj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukaj.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukaj.setText("Wyszukaj");
        buttonWyszukaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajActionPerformed(evt);
            }
        });

        tableRezerwacje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "pracownik", "dataOd", "dataDo", "iloscDob", "koszt", "rozliczenie", "pokojNr", "klientImie", "klientNazwisko"
            }
        ));
        scrollPaneRezerwacje.setViewportView(tableRezerwacje);

        labelDataRezerwacji.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataRezerwacji.setForeground(new java.awt.Color(255, 255, 255));
        labelDataRezerwacji.setText("Data rezerwacji:");

        ftextfieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        ftextfieldData.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        labelNazwisko.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNazwisko.setForeground(new java.awt.Color(255, 255, 255));
        labelNazwisko.setText("Nazwisko klienta:");

        javax.swing.GroupLayout panelListaRezerwacjiLayout = new javax.swing.GroupLayout(panelListaRezerwacji);
        panelListaRezerwacji.setLayout(panelListaRezerwacjiLayout);
        panelListaRezerwacjiLayout.setHorizontalGroup(
            panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRezerwacjiLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaRezerwacjiLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelListaRezerwacjiLayout.createSequentialGroup()
                                .addComponent(textfieldNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboPokazRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelListaRezerwacjiLayout.createSequentialGroup()
                                .addComponent(labelNazwisko)
                                .addGap(18, 18, 18)
                                .addComponent(labelPokazJedynie, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftextfieldData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDataRezerwacji, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonWyszukaj, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPaneRezerwacje, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelListaRezerwacjiLayout.setVerticalGroup(
            panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaRezerwacjiLayout.createSequentialGroup()
                .addComponent(scrollPaneRezerwacje, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaRezerwacjiLayout.createSequentialGroup()
                        .addGroup(panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokazJedynie)
                            .addComponent(labelDataRezerwacji)
                            .addComponent(labelNazwisko))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonWyszukaj, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftextfieldData)
                        .addComponent(comboPokazRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textfieldNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tpanelRezerwacje.addTab("Lista rezerwacji", panelListaRezerwacji);

        panelDokonajRezerwacji.setBackground(new java.awt.Color(51, 51, 51));
        panelDokonajRezerwacji.setForeground(new java.awt.Color(51, 51, 51));

        labelDostepnePokoje.setBackground(new java.awt.Color(255, 255, 255));
        labelDostepnePokoje.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDostepnePokoje.setForeground(new java.awt.Color(255, 255, 255));
        labelDostepnePokoje.setText("Dostępne pokoje:");

        labelIleDob.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIleDob.setForeground(new java.awt.Color(255, 255, 255));
        labelIleDob.setText("Ilość dób:");

        labelKoszt.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelKoszt.setForeground(new java.awt.Color(255, 255, 255));
        labelKoszt.setText("Całkowity koszt:");

        buttonDokonaj.setBackground(new java.awt.Color(51, 51, 51));
        buttonDokonaj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonDokonaj.setForeground(new java.awt.Color(255, 255, 255));
        buttonDokonaj.setText("Dokonaj rezerwacji");
        buttonDokonaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDokonajActionPerformed(evt);
            }
        });

        comboDostepnePokoje.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        labelDataOd.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataOd.setForeground(new java.awt.Color(255, 255, 255));
        labelDataOd.setText("Data od:");

        labelDataDo.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDataDo.setForeground(new java.awt.Color(255, 255, 255));
        labelDataDo.setText("Data do:");

        labelIdPesel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIdPesel.setForeground(new java.awt.Color(255, 255, 255));
        labelIdPesel.setText("ID lub PESEL użytkownika:");

        textfieldIdLubPesel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        labelImieNazwisko.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelImieNazwisko.setForeground(new java.awt.Color(255, 255, 255));
        labelImieNazwisko.setText("Imie i Nazwisko:");

        buttonSprawdz.setBackground(new java.awt.Color(51, 51, 51));
        buttonSprawdz.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonSprawdz.setForeground(new java.awt.Color(255, 255, 255));
        buttonSprawdz.setText("Sprawdź");
        buttonSprawdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSprawdzActionPerformed(evt);
            }
        });

        labelDlaIluOsob.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelDlaIluOsob.setForeground(new java.awt.Color(255, 255, 255));
        labelDlaIluOsob.setText("Dla ilu osób?");

        comboIleOsob.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboIleOsob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        labelWaluta.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelWaluta.setForeground(new java.awt.Color(255, 255, 255));
        labelWaluta.setText("złotych.");

        labelPodsumowanie.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        labelPodsumowanie.setForeground(new java.awt.Color(255, 255, 255));
        labelPodsumowanie.setText("Podsumowanie");

        labelPesel.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPesel.setForeground(new java.awt.Color(255, 255, 255));
        labelPesel.setText("PESEL:");

        labelIleOsob.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIleOsob.setForeground(new java.awt.Color(255, 255, 255));
        labelIleOsob.setText("Ilość osób:");

        buttonWybierz.setBackground(new java.awt.Color(51, 51, 51));
        buttonWybierz.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWybierz.setForeground(new java.awt.Color(255, 255, 255));
        buttonWybierz.setText("Wybierz");
        buttonWybierz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWybierzActionPerformed(evt);
            }
        });

        labelWybranyPokoj.setBackground(new java.awt.Color(255, 255, 255));
        labelWybranyPokoj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelWybranyPokoj.setForeground(new java.awt.Color(255, 255, 255));
        labelWybranyPokoj.setText("Wybrany pokój:");

        datechooserDataOd.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        datechooserDataDo.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        labelIleDob2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelIleDob2.setForeground(new java.awt.Color(255, 255, 255));
        labelIleDob2.setText("Ilość dób:");

        labelPesel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPesel2.setForeground(new java.awt.Color(255, 255, 255));
        labelPesel2.setText("PESEL:");

        labelImieNazwisko2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelImieNazwisko2.setForeground(new java.awt.Color(255, 255, 255));
        labelImieNazwisko2.setText("Imie i Nazwisko:");

        labelIleOsob2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelIleOsob2.setForeground(new java.awt.Color(255, 255, 255));
        labelIleOsob2.setText("Ilość osób:");

        labelWybranyPokoj2.setBackground(new java.awt.Color(255, 255, 255));
        labelWybranyPokoj2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelWybranyPokoj2.setForeground(new java.awt.Color(255, 255, 255));
        labelWybranyPokoj2.setText("Wybrany pokój:");

        labelKoszt2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelKoszt2.setForeground(new java.awt.Color(255, 255, 255));
        labelKoszt2.setText("Koszt");

        labelId.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelId.setForeground(new java.awt.Color(255, 255, 255));
        labelId.setText("ID:");

        labelId2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelId2.setForeground(new java.awt.Color(255, 255, 255));
        labelId2.setText("ID:");

        labelData.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelData.setForeground(new java.awt.Color(255, 255, 255));
        labelData.setText("Data Od-Do:");

        labelData2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelData2.setForeground(new java.awt.Color(255, 255, 255));
        labelData2.setText("Data Od-Do:");

        javax.swing.GroupLayout panelDokonajRezerwacjiLayout = new javax.swing.GroupLayout(panelDokonajRezerwacji);
        panelDokonajRezerwacji.setLayout(panelDokonajRezerwacjiLayout);
        panelDokonajRezerwacjiLayout.setHorizontalGroup(
            panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataDo)
                            .addComponent(labelDataOd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datechooserDataOd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datechooserDataDo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(buttonSprawdz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addComponent(labelDlaIluOsob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboIleOsob, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelIdPesel)
                    .addComponent(buttonWybierz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDostepnePokoje)
                    .addComponent(comboDostepnePokoje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textfieldIdLubPesel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonDokonaj, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                                                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(labelIleDob, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(labelIleOsob))
                                                .addGap(50, 50, 50))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDokonajRezerwacjiLayout.createSequentialGroup()
                                                .addComponent(labelImieNazwisko)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelIleOsob2)
                                            .addComponent(labelIleDob2)
                                            .addComponent(labelImieNazwisko2)))
                                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                                        .addComponent(labelWybranyPokoj)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelWybranyPokoj2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                                        .addComponent(labelKoszt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelKoszt2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelWaluta))
                                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                                        .addComponent(labelData)
                                        .addGap(39, 39, 39)
                                        .addComponent(labelData2)))
                                .addGap(97, 97, 97))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDokonajRezerwacjiLayout.createSequentialGroup()
                                .addComponent(labelId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelId2)
                                .addGap(18, 18, 18)
                                .addComponent(labelPesel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPesel2)
                                .addGap(197, 197, 197))))
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(labelPodsumowanie))))
        );
        panelDokonajRezerwacjiLayout.setVerticalGroup(
            panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelIdPesel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfieldIdLubPesel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboIleOsob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDlaIluOsob, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataOd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datechooserDataOd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelDataDo)
                            .addComponent(datechooserDataDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSprawdz)
                        .addGap(27, 27, 27)
                        .addComponent(labelDostepnePokoje))
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelPodsumowanie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelImieNazwisko)
                            .addComponent(labelImieNazwisko2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPesel2)
                            .addComponent(labelPesel)
                            .addComponent(labelId2)
                            .addComponent(labelId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIleOsob2)
                            .addComponent(labelIleOsob))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIleDob2)
                            .addComponent(labelIleDob))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelData)
                            .addComponent(labelData2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelWybranyPokoj)
                            .addComponent(labelWybranyPokoj2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDokonajRezerwacjiLayout.createSequentialGroup()
                        .addComponent(comboDostepnePokoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelKoszt)
                        .addComponent(labelKoszt2)
                        .addComponent(labelWaluta)))
                .addGroup(panelDokonajRezerwacjiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonWybierz)
                    .addComponent(buttonDokonaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        tpanelRezerwacje.addTab("Dokonaj rezerwacji", panelDokonajRezerwacji);

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

        labelZalogowano1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        labelZalogowano1.setForeground(new java.awt.Color(0, 0, 0));
        labelZalogowano1.setText("Zalogowano jako");

        javax.swing.GroupLayout panelGlownyLayout = new javax.swing.GroupLayout(panelGlowny);
        panelGlowny.setLayout(panelGlownyLayout);
        panelGlownyLayout.setHorizontalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTytulowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelZalogowano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelZalogowano1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonWyczysc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelOpcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpanelRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelOpcji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tpanelRezerwacje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZalogowano)
                    .addComponent(buttonWyczysc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZalogowano1))
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

    private void labelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuMouseClicked

        new Menu().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelMenuMouseClicked

    private void labelKlienciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelKlienciMouseClicked

        new Klienci().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelKlienciMouseClicked

    private void labelPokojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPokojeMouseClicked

        new Pokoje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelPokojeMouseClicked

    private void labelRozliczenieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRozliczenieMouseClicked

        new Rozliczenie().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelRozliczenieMouseClicked

    private void labelStatystykiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelStatystykiMouseClicked

        new Statystyki().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelStatystykiMouseClicked

    private void buttonWyjscieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonWyjscieMouseClicked
        new Logowanie().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_buttonWyjscieMouseClicked

    private void buttonWyszukajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajActionPerformed
        WczytajTabele();
    }//GEN-LAST:event_buttonWyszukajActionPerformed

    private void buttonWybierzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWybierzActionPerformed

        labelPodsumowanie.setVisible(true);
        labelImieNazwisko.setVisible(true);
        labelIleOsob.setVisible(true);
        labelIleDob.setVisible(true);
        labelPesel.setVisible(true);
        labelWybranyPokoj.setVisible(true);
        labelKoszt.setVisible(true);
        labelId.setVisible(true);
        labelData.setVisible(true);
        labelData2.setVisible(true);
        labelIleDob2.setVisible(true);
        labelImieNazwisko2.setVisible(true);
        labelIleOsob2.setVisible(true);
        labelPesel2.setVisible(true);
        labelWybranyPokoj2.setVisible(true);
        labelKoszt2.setVisible(true);
        labelWaluta.setVisible(true);
        buttonDokonaj.setVisible(true);
        labelId2.setVisible(true);

        String wybranyPokoj = comboDostepnePokoje.getSelectedItem().toString();
        numer = wybranyPokoj.substring(6, 9);
        String koszt = wybranyPokoj.substring(34, 37);
        String dni = labelIleDob2.getText();
        int calkowityKoszt = Integer.parseInt(dni) * Integer.parseInt(koszt);
        labelWybranyPokoj2.setText(numer);
        labelKoszt2.setText(Integer.toString(calkowityKoszt));
    }//GEN-LAST:event_buttonWybierzActionPerformed

    private void buttonSprawdzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSprawdzActionPerformed
        comboDostepnePokoje.removeAllItems();
        Connection con;
        ResultSet rs;
        PreparedStatement pst, pst2;
        String szukaneDane = textfieldIdLubPesel.getText();
        String szukanaLiczbaOsob = comboIleOsob.getSelectedItem().toString();
        Date dataOd = datechooserDataOd.getDate();
        Date dataDo = datechooserDataDo.getDate();
        SimpleDateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        if (szukaneDane.equals("") || dataOd == null || dataDo == null) {
            JOptionPane.showMessageDialog(null, "Pola nie mogą być puste oraz muszą posiadać poprawny format.");
        } else try {
            Date dataOdFormat = formatDaty.parse(formatDaty.format(datechooserDataOd.getDate()));
            Date dataDoFormat = formatDaty.parse(formatDaty.format(datechooserDataDo.getDate()));
            dataOdFormatS = formatDaty.format(datechooserDataOd.getDate());
            dataDoFormatS = formatDaty.format(datechooserDataDo.getDate());
            labelData2.setText(dataOdFormatS + " - " + dataDoFormatS);
            long iloscDob = dataOdFormat.getTime() - dataDoFormat.getTime();
            long godziny = iloscDob / (60 * 60 * 1000);
            long dni = godziny / -24;
            labelIleDob2.setText(Long.toString(dni));
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("SELECT id,numerpokoju,ilelozek,cenadoba From pokoje WHERE status ='Wolny' AND ileosob='" + szukanaLiczbaOsob + "'");
            pst2 = con.prepareStatement("SELECT id,imie,nazwisko,pesel from klient WHERE id ='" + szukaneDane + "' OR pesel='" + szukaneDane + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                String ileLozek, cena;
                numer = rs.getString("numerpokoju");
                ileLozek = rs.getString("ilelozek");
                cena = rs.getString("cenadoba");
                comboDostepnePokoje.addItem("Pokój " + (numer) + ", Liczba łóżek: " + (ileLozek) + ", cena: " + cena + " zł");
            }
            rs = pst2.executeQuery();
            if (rs.next()) {
                String imie, nazwisko;
                idKlienta = rs.getString("id");
                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                labelImieNazwisko2.setText(imie + " " + nazwisko);
                labelPesel2.setText(rs.getString("pesel"));
                labelIleOsob2.setText(szukanaLiczbaOsob);
                labelId2.setText(idKlienta);
                labelDostepnePokoje.setVisible(true);
                comboDostepnePokoje.setVisible(true);
                buttonWybierz.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Podane ID lub PESEL są nieprawidłowe.");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {}
    }//GEN-LAST:event_buttonSprawdzActionPerformed

    private void buttonDokonajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDokonajActionPerformed
        Connection con;
        ResultSet rs;
        PreparedStatement pst, pst2, pst3, pst4;
        String iloscDob, koszt, pracownikLogin;
        iloscDob = labelIleDob2.getText();
        koszt = labelKoszt2.getText();
        Logowanie logowanie = new Logowanie();
        pracownikLogin = logowanie.przekazLogin();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("SELECT id from pokoje WHERE numerpokoju ='" + numer + "'");
            rs = pst.executeQuery();

            if (rs.next()) {
                pokojId = rs.getString("id");
            }
            pst2 = con.prepareStatement("SELECT id from pracownik WHERE login ='" + pracownikLogin + "'");
            rs = pst2.executeQuery();

            if (rs.next()) {
                pracownikId = rs.getString("id");
            }
            pst3 = con.prepareStatement("INSERT INTO rezerwacja (data_od,data_do,ilosc_dob,koszt,czy_rozliczona,pokoje_id,pracownik_id,klient_id,data_utworzenia) VALUES('" + dataOdFormatS + "','" + dataDoFormatS + "','" + iloscDob + "','" + koszt + "','0','" + pokojId + "','" + pracownikId + "','" + idKlienta + "',CURRENT_DATE);");
            int result = pst3.executeUpdate();
            pst4 = con.prepareStatement("UPDATE pokoje SET status='Zajety' WHERE id='" + pokojId + "'");
            int result2 = pst4.executeUpdate();
            rs.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Rezerwacja została zatwierdzona!");

            wyczyscOkno();
            textfieldIdLubPesel.setText("");
            datechooserDataOd.setCalendar(null);
            datechooserDataDo.setCalendar(null);
            comboIleOsob.setSelectedIndex(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonDokonajActionPerformed

    private void buttonWyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyczyscActionPerformed

        wyczyscOkno();
        tableRezerwacje.setModel(new DefaultTableModel());
        textfieldIdLubPesel.setText("");
        comboDostepnePokoje.removeAllItems();
        textfieldNazwisko.setText("");
        ftextfieldData.setText("");
        datechooserDataOd.setCalendar(null);
        datechooserDataDo.setCalendar(null);
        comboIleOsob.setSelectedIndex(0);
        comboPokazRezerwacje.setSelectedIndex(0);
    }//GEN-LAST:event_buttonWyczyscActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Rezerwacje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rezerwacje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rezerwacje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rezerwacje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rezerwacje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDokonaj;
    private javax.swing.JButton buttonSprawdz;
    private javax.swing.JButton buttonWybierz;
    private javax.swing.JButton buttonWyczysc;
    private javax.swing.JButton buttonWyjscie;
    private javax.swing.JButton buttonWyszukaj;
    private javax.swing.JComboBox<String> comboDostepnePokoje;
    private javax.swing.JComboBox<String> comboIleOsob;
    private javax.swing.JComboBox<String> comboPokazRezerwacje;
    private com.toedter.calendar.JDateChooser datechooserDataDo;
    private com.toedter.calendar.JDateChooser datechooserDataOd;
    private javax.swing.JFormattedTextField ftextfieldData;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelData2;
    private javax.swing.JLabel labelDataDo;
    private javax.swing.JLabel labelDataOd;
    private javax.swing.JLabel labelDataRezerwacji;
    private javax.swing.JLabel labelDlaIluOsob;
    private javax.swing.JLabel labelDostepnePokoje;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelId2;
    private javax.swing.JLabel labelIdPesel;
    private javax.swing.JLabel labelIleDob;
    private javax.swing.JLabel labelIleDob2;
    private javax.swing.JLabel labelIleOsob;
    private javax.swing.JLabel labelIleOsob2;
    private javax.swing.JLabel labelImieNazwisko;
    private javax.swing.JLabel labelImieNazwisko2;
    private javax.swing.JLabel labelKlienci;
    private javax.swing.JLabel labelKoszt;
    private javax.swing.JLabel labelKoszt2;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel labelNazwisko;
    private javax.swing.JLabel labelPesel;
    private javax.swing.JLabel labelPesel2;
    private javax.swing.JLabel labelPodsumowanie;
    private javax.swing.JLabel labelPokazJedynie;
    private javax.swing.JLabel labelPokoje;
    private javax.swing.JLabel labelRezerwacje;
    private javax.swing.JLabel labelRozliczenie;
    private javax.swing.JLabel labelStatystyki;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JLabel labelWaluta;
    private javax.swing.JLabel labelWybranyPokoj;
    private javax.swing.JLabel labelWybranyPokoj2;
    private javax.swing.JLabel labelZalogowano;
    private javax.swing.JLabel labelZalogowano1;
    private javax.swing.JPanel panelDokonajRezerwacji;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelListaRezerwacji;
    private javax.swing.JPanel panelOpcji;
    private javax.swing.JPanel panelTytulowy;
    private javax.swing.JScrollPane scrollPaneRezerwacje;
    private javax.swing.JTable tableRezerwacje;
    private javax.swing.JTextField textfieldIdLubPesel;
    private javax.swing.JTextField textfieldNazwisko;
    private javax.swing.JTabbedPane tpanelRezerwacje;
    // End of variables declaration//GEN-END:variables
}
