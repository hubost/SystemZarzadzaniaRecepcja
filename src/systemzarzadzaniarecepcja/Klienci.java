/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemzarzadzaniarecepcja;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Klienci extends javax.swing.JFrame implements ActionListener {

    public Klienci() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();

        Logowanie logowanie = new Logowanie();
        labelZalogowano1.setText(logowanie.przekazLogin());
        WczytajTabele();
    }
    private void WyczyscOkno(){
        textfieldImieDodaj.setText("");
            textfieldNazwiskoDodaj.setText("");
            ftextfieldPeselDodaj.setText("");
            textfieldNrdowoduDodaj.setText("");
            ftextfieldNrTelDodaj.setText("");
            textfieldEmailDodaj.setText("");
            
            textfieldImieEdytuj.setText("");
            textfieldNazwiskoEdytuj.setText("");
            ftextfieldPeselEdytuj.setText("");
            textfieldNrdowoduEdytuj.setText("");
            ftextfieldNrTelEdytuj.setText("");
            textfieldEmailEdytuj.setText("");
            textfieldWyszukajEdytuj.setText("");
    }
    private void WczytajTabele(){
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        ResultSetMetaData rsmd;
        DefaultTableModel model;
        try {
            tableKlienci.setModel(new DefaultTableModel());
            int sortowanie = comboSortujKlienci.getSelectedIndex();
            int pokazjedynie = comboPokazKlienci.getSelectedIndex();
            String sortowanieS = "";
            String sql = "select * from klient";
            if (sortowanie == 0) { 
                sortowanieS = " ORDER BY id DESC";
            } else if (sortowanie == 1) {
                sortowanieS = "";
            } else if (sortowanie == 2) {
                sortowanieS = " ORDER BY data_utworzenia ASC";
            } else if (sortowanie == 3) {
                sortowanieS = " ORDER BY data_utworzenia DESC";
            }   
            if (pokazjedynie == 0) {
            } else if (pokazjedynie == 1) {
                sql = "select k.id, k.imie, k.plec, k.nazwisko, k.pesel, k.numerdowodu, k.numertelefonu, k.email, k.data_utworzenia from rezerwacja r join klient k ON r.klient_id = k.id where czy_rozliczona =0";
            } else if (pokazjedynie == 2) {
                sql = "select distinct k.id, k.imie, k.plec, k.nazwisko, k.pesel, k.numerdowodu, k.numertelefonu, k.email, k.data_utworzenia from rezerwacja r join klient k ON r.klient_id = k.id where czy_rozliczona =1";
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement(sql + sortowanieS);
            rs = pst.executeQuery();
            rsmd = rs.getMetaData();
            model = (DefaultTableModel) tableKlienci.getModel();
            int kolumny = rsmd.getColumnCount();
            String[] nazwaKolumny = new String[kolumny];
            for (int i = 0; i < kolumny; i++) {
                nazwaKolumny[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(nazwaKolumny);
            String id, imie, nazwisko, plec, pesel, numerdowodu, numertelefonu, email, datautworzenia;
            while (rs.next()) {
                id = rs.getString(1);
                imie = rs.getString(2);
                nazwisko = rs.getString(3);
                plec = rs.getString(4);
                pesel = rs.getString(5);
                numerdowodu = rs.getString(6);
                numertelefonu = rs.getString(7);
                email = rs.getString(8);
                datautworzenia = rs.getString(9);
                String[] row = {id, imie, nazwisko, plec, pesel, numerdowodu, numertelefonu, email, datautworzenia};
                model.addRow(row);
            }
            rs.close();
            con.close();
        } catch (Exception ee) {
           ee.printStackTrace();
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
        tpanelKlienci = new javax.swing.JTabbedPane();
        panelSprawdzListe = new javax.swing.JPanel();
        buttonWyszukajSprawdz = new javax.swing.JButton();
        panelScrollKlienci = new javax.swing.JScrollPane();
        tableKlienci = new javax.swing.JTable();
        labelSortuj = new javax.swing.JLabel();
        comboSortujKlienci = new javax.swing.JComboBox<>();
        labelPokazJedynie = new javax.swing.JLabel();
        comboPokazKlienci = new javax.swing.JComboBox<>();
        panelDodaj = new javax.swing.JPanel();
        labelImieDodaj = new javax.swing.JLabel();
        labelNazwiskoDodaj = new javax.swing.JLabel();
        labelPlecDodaj = new javax.swing.JLabel();
        labelPeselDodaj = new javax.swing.JLabel();
        labelNrdowoduDodaj = new javax.swing.JLabel();
        labelNrtelefonuDodaj = new javax.swing.JLabel();
        labelEmailDodaj = new javax.swing.JLabel();
        textfieldImieDodaj = new javax.swing.JTextField();
        textfieldNazwiskoDodaj = new javax.swing.JTextField();
        textfieldNrdowoduDodaj = new javax.swing.JTextField();
        textfieldEmailDodaj = new javax.swing.JTextField();
        comboPlecDodaj = new javax.swing.JComboBox<>();
        buttonDodaj = new javax.swing.JButton();
        ftextfieldNrTelDodaj = new javax.swing.JFormattedTextField();
        ftextfieldPeselDodaj = new javax.swing.JFormattedTextField();
        panelEdytuj = new javax.swing.JPanel();
        labelImieEdytuj = new javax.swing.JLabel();
        labelPlecEdytuj = new javax.swing.JLabel();
        labelPeselEdytuj = new javax.swing.JLabel();
        labelNrdowoduEdytuj = new javax.swing.JLabel();
        labelNrtelefonuEdytuj = new javax.swing.JLabel();
        labelEmailEdytuj = new javax.swing.JLabel();
        textfieldImieEdytuj = new javax.swing.JTextField();
        textfieldNazwiskoEdytuj = new javax.swing.JTextField();
        textfieldNrdowoduEdytuj = new javax.swing.JTextField();
        textfieldEmailEdytuj = new javax.swing.JTextField();
        comboPlecEdytuj = new javax.swing.JComboBox<>();
        buttonUsunEdytuj = new javax.swing.JButton();
        buttonZmienEdytuj = new javax.swing.JButton();
        buttonWyszukajEdytuj = new javax.swing.JButton();
        textfieldWyszukajEdytuj = new javax.swing.JTextField();
        labelNazwiskoEdytuj = new javax.swing.JLabel();
        labelIdLubPeselEdytuj = new javax.swing.JLabel();
        ftextfieldNrTelEdytuj = new javax.swing.JFormattedTextField();
        ftextfieldPeselEdytuj = new javax.swing.JFormattedTextField();
        buttonWyczysc = new javax.swing.JButton();
        labelZalogowano1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(255, 255, 255));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("Klienci");

        javax.swing.GroupLayout panelTytulowyLayout = new javax.swing.GroupLayout(panelTytulowy);
        panelTytulowy.setLayout(panelTytulowyLayout);
        panelTytulowyLayout.setHorizontalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTytulowyLayout.createSequentialGroup()
                .addGap(318, 318, 318)
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

        labelKlienci.setFont(new java.awt.Font("Cambria", 1, 28)); // NOI18N
        labelKlienci.setForeground(new java.awt.Color(255, 255, 255));
        labelKlienci.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelKlienci.setText("Klienci");
        labelKlienci.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        tpanelKlienci.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        panelSprawdzListe.setBackground(new java.awt.Color(51, 51, 51));
        panelSprawdzListe.setForeground(new java.awt.Color(51, 51, 51));

        buttonWyszukajSprawdz.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajSprawdz.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajSprawdz.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajSprawdz.setText("Wyszukaj");
        buttonWyszukajSprawdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajSprawdzActionPerformed(evt);
            }
        });

        panelScrollKlienci.setBackground(new java.awt.Color(102, 102, 102));
        panelScrollKlienci.setForeground(new java.awt.Color(102, 102, 102));
        panelScrollKlienci.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N

        tableKlienci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "imie", "nazwisko", "login", "plec", "pesel", "nrDowodu", "nrTel", "email", "dataUtworzenia"
            }
        ));
        panelScrollKlienci.setViewportView(tableKlienci);
        if (tableKlienci.getColumnModel().getColumnCount() > 0) {
            tableKlienci.getColumnModel().getColumn(3).setResizable(false);
        }

        labelSortuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelSortuj.setForeground(new java.awt.Color(255, 255, 255));
        labelSortuj.setText("Sortuj według:");

        comboSortujKlienci.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboSortujKlienci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID (domyślnie)", "ID (rosnąco)", "Data utworzenia (rosnąco)", "Data utworzenia (malejąco)" }));

        labelPokazJedynie.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokazJedynie.setForeground(new java.awt.Color(255, 255, 255));
        labelPokazJedynie.setText("Pokaż jedynie:");

        comboPokazKlienci.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboPokazKlienci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wszystko", "Klienci z rezerwacją", "Klienci bez rezerwacji" }));

        javax.swing.GroupLayout panelSprawdzListeLayout = new javax.swing.GroupLayout(panelSprawdzListe);
        panelSprawdzListe.setLayout(panelSprawdzListeLayout);
        panelSprawdzListeLayout.setHorizontalGroup(
            panelSprawdzListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSprawdzListeLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(panelSprawdzListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSortuj, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSortujKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSprawdzListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPokazKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPokazJedynie))
                .addGap(65, 65, 65)
                .addComponent(buttonWyszukajSprawdz, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(panelScrollKlienci)
        );
        panelSprawdzListeLayout.setVerticalGroup(
            panelSprawdzListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSprawdzListeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelScrollKlienci, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSprawdzListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonWyszukajSprawdz)
                    .addGroup(panelSprawdzListeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelSprawdzListeLayout.createSequentialGroup()
                            .addComponent(labelSortuj)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboSortujKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelSprawdzListeLayout.createSequentialGroup()
                            .addComponent(labelPokazJedynie)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboPokazKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );

        tpanelKlienci.addTab("Sprawdź Listę", panelSprawdzListe);

        panelDodaj.setBackground(new java.awt.Color(51, 51, 51));
        panelDodaj.setForeground(new java.awt.Color(51, 51, 51));

        labelImieDodaj.setBackground(new java.awt.Color(255, 255, 255));
        labelImieDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelImieDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelImieDodaj.setText("Imie:");

        labelNazwiskoDodaj.setBackground(new java.awt.Color(255, 255, 255));
        labelNazwiskoDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNazwiskoDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelNazwiskoDodaj.setText("Nazwisko:");

        labelPlecDodaj.setBackground(new java.awt.Color(255, 255, 255));
        labelPlecDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPlecDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelPlecDodaj.setText("Płeć:");

        labelPeselDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPeselDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelPeselDodaj.setText("Pesel:");

        labelNrdowoduDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrdowoduDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelNrdowoduDodaj.setText("Numer dowodu:");

        labelNrtelefonuDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrtelefonuDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelNrtelefonuDodaj.setText("Numer telefonu:");

        labelEmailDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelEmailDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelEmailDodaj.setText("Adres e-mail:");

        textfieldImieDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldNazwiskoDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldNrdowoduDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldEmailDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        comboPlecDodaj.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboPlecDodaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kobieta", "Mezczyzna" }));

        buttonDodaj.setBackground(new java.awt.Color(51, 51, 51));
        buttonDodaj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonDodaj.setForeground(new java.awt.Color(255, 255, 255));
        buttonDodaj.setText("Dodaj");
        buttonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDodajActionPerformed(evt);
            }
        });

        ftextfieldNrTelDodaj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        ftextfieldNrTelDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        ftextfieldPeselDodaj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########"))));
        ftextfieldPeselDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelDodajLayout = new javax.swing.GroupLayout(panelDodaj);
        panelDodaj.setLayout(panelDodajLayout);
        panelDodajLayout.setHorizontalGroup(
            panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDodajLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDodajLayout.createSequentialGroup()
                        .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDodajLayout.createSequentialGroup()
                                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNrdowoduDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPeselDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPlecDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelImieDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNazwiskoDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldNrdowoduDodaj)
                                    .addComponent(textfieldImieDodaj)
                                    .addComponent(textfieldNazwiskoDodaj)
                                    .addGroup(panelDodajLayout.createSequentialGroup()
                                        .addComponent(comboPlecDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 57, Short.MAX_VALUE))
                                    .addComponent(ftextfieldPeselDodaj)))
                            .addComponent(buttonDodaj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(203, 203, 203))
                    .addGroup(panelDodajLayout.createSequentialGroup()
                        .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNrtelefonuDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmailDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDodajLayout.createSequentialGroup()
                                .addComponent(ftextfieldNrTelDodaj)
                                .addGap(203, 203, 203))
                            .addGroup(panelDodajLayout.createSequentialGroup()
                                .addComponent(textfieldEmailDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        panelDodajLayout.setVerticalGroup(
            panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDodajLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImieDodaj)
                    .addComponent(textfieldImieDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldNazwiskoDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNazwiskoDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPlecDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlecDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPeselDodaj)
                    .addComponent(ftextfieldPeselDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNrdowoduDodaj)
                    .addComponent(textfieldNrdowoduDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNrtelefonuDodaj)
                    .addComponent(ftextfieldNrTelDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldEmailDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmailDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        tpanelKlienci.addTab("Dodaj", panelDodaj);

        panelEdytuj.setBackground(new java.awt.Color(51, 51, 51));
        panelEdytuj.setForeground(new java.awt.Color(51, 51, 51));

        labelImieEdytuj.setBackground(new java.awt.Color(255, 255, 255));
        labelImieEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelImieEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelImieEdytuj.setText("Imie:");

        labelPlecEdytuj.setBackground(new java.awt.Color(255, 255, 255));
        labelPlecEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPlecEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelPlecEdytuj.setText("Płeć:");

        labelPeselEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPeselEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelPeselEdytuj.setText("Pesel:");

        labelNrdowoduEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrdowoduEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelNrdowoduEdytuj.setText("Numer dowodu:");

        labelNrtelefonuEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrtelefonuEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelNrtelefonuEdytuj.setText("Numer telefonu:");

        labelEmailEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelEmailEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelEmailEdytuj.setText("Adres e-mail:");

        textfieldImieEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        textfieldImieEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldImieEdytujActionPerformed(evt);
            }
        });

        textfieldNazwiskoEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldNrdowoduEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldEmailEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        comboPlecEdytuj.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboPlecEdytuj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kobieta", "Mezczyzna" }));

        buttonUsunEdytuj.setBackground(new java.awt.Color(51, 51, 51));
        buttonUsunEdytuj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonUsunEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        buttonUsunEdytuj.setText("Usuń");
        buttonUsunEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUsunEdytujActionPerformed(evt);
            }
        });

        buttonZmienEdytuj.setBackground(new java.awt.Color(51, 51, 51));
        buttonZmienEdytuj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonZmienEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        buttonZmienEdytuj.setText("Zmień");
        buttonZmienEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZmienEdytujActionPerformed(evt);
            }
        });

        buttonWyszukajEdytuj.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajEdytuj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajEdytuj.setText("Wyszukaj");
        buttonWyszukajEdytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajEdytujActionPerformed(evt);
            }
        });

        textfieldWyszukajEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        labelNazwiskoEdytuj.setBackground(new java.awt.Color(255, 255, 255));
        labelNazwiskoEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNazwiskoEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelNazwiskoEdytuj.setText("Nazwisko:");

        labelIdLubPeselEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelIdLubPeselEdytuj.setForeground(new java.awt.Color(255, 255, 255));
        labelIdLubPeselEdytuj.setText("ID lub PESEL użytkownika:");

        ftextfieldNrTelEdytuj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        ftextfieldNrTelEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        ftextfieldPeselEdytuj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###########"))));
        ftextfieldPeselEdytuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelEdytujLayout = new javax.swing.GroupLayout(panelEdytuj);
        panelEdytuj.setLayout(panelEdytujLayout);
        panelEdytujLayout.setHorizontalGroup(
            panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEdytujLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelIdLubPeselEdytuj)
                    .addComponent(textfieldWyszukajEdytuj)
                    .addComponent(buttonWyszukajEdytuj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEdytujLayout.createSequentialGroup()
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEdytujLayout.createSequentialGroup()
                                .addComponent(buttonZmienEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonUsunEdytuj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelEdytujLayout.createSequentialGroup()
                                .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNrdowoduEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPeselEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPlecEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelImieEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNazwiskoEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelEdytujLayout.createSequentialGroup()
                                        .addComponent(comboPlecEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(textfieldNrdowoduEdytuj, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textfieldImieEdytuj, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(textfieldNazwiskoEdytuj)
                                    .addComponent(ftextfieldPeselEdytuj))))
                        .addGap(203, 203, 203))
                    .addGroup(panelEdytujLayout.createSequentialGroup()
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNrtelefonuEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmailEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEdytujLayout.createSequentialGroup()
                                .addComponent(ftextfieldNrTelEdytuj)
                                .addGap(203, 203, 203))
                            .addGroup(panelEdytujLayout.createSequentialGroup()
                                .addComponent(textfieldEmailEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        panelEdytujLayout.setVerticalGroup(
            panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdytujLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImieEdytuj)
                    .addComponent(textfieldImieEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdLubPeselEdytuj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEdytujLayout.createSequentialGroup()
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfieldNazwiskoEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNazwiskoEdytuj))
                        .addGap(6, 6, 6)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboPlecEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPlecEdytuj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPeselEdytuj)
                            .addComponent(ftextfieldPeselEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNrdowoduEdytuj)
                            .addComponent(textfieldNrdowoduEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNrtelefonuEdytuj)
                            .addComponent(ftextfieldNrTelEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfieldEmailEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmailEdytuj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEdytujLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonZmienEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonUsunEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(panelEdytujLayout.createSequentialGroup()
                        .addComponent(textfieldWyszukajEdytuj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyszukajEdytuj)
                        .addGap(238, 238, 238))))
        );

        tpanelKlienci.addTab("Edytuj lub usuń", panelEdytuj);

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
                .addGap(7, 7, 7))
            .addComponent(panelOpcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tpanelKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelOpcji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tpanelKlienci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void labelPokojeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPokojeMouseClicked

        new Pokoje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelPokojeMouseClicked

    private void labelRezerwacjeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRezerwacjeMouseClicked

        new Rezerwacje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelRezerwacjeMouseClicked

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

    private void buttonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDodajActionPerformed
        String imie = textfieldImieDodaj.getText();
        String nazwisko = textfieldNazwiskoDodaj.getText();
        String pesel = ftextfieldPeselDodaj.getText();
        String numerDowodu = textfieldNrdowoduDodaj.getText();
        String numerTelefonu = ftextfieldNrTelDodaj.getText();
        String email = textfieldEmailDodaj.getText();
        String plec = comboPlecDodaj.getSelectedItem().toString();
        Connection con;
        PreparedStatement pst;
        
        if (imie.isEmpty() || nazwisko.isEmpty() || pesel.isEmpty() || numerDowodu.isEmpty() || numerTelefonu.isEmpty() || email.isEmpty() || plec.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pola nie mogą być puste.");
        } else if (pesel.length() != 11) {
            JOptionPane.showMessageDialog(null, "Błędny numer PESEL.");
        } else if (numerTelefonu.length() != 9) {
            JOptionPane.showMessageDialog(null, "Błędny numer telefonu.");
        } else try {
            if (plec.equals("Mezczyzna")) {
            plec = "m";
        } else {
            plec = "k";
        }
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            String sql = "INSERT INTO klient (imie,nazwisko,plec,pesel,numerdowodu,numertelefonu,email,data_utworzenia) VALUES('" + imie + "','" + nazwisko + "','" + plec + "','" + pesel + "','" + numerDowodu + "','" + numerTelefonu + "','" + email + "',CURRENT_DATE" + ");";
            pst = con.prepareStatement(sql);
            int wynik1 = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pomyślnie dodano klienta do bazy.");
            WyczyscOkno();
            con.close();
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Dana osoba już istnieje w bazie."); 
        }
            
    }//GEN-LAST:event_buttonDodajActionPerformed

    private void buttonWyszukajEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajEdytujActionPerformed
        String szukaneDane = textfieldWyszukajEdytuj.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("SELECT * From klient WHERE id ='" + szukaneDane + "' OR pesel='" + szukaneDane + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                String plec = rs.getString("plec");
                if (plec.equals("m")) {
                    comboPlecEdytuj.setSelectedItem("Mezczyzna");
                } else if (plec.equals("k")) {
                    comboPlecEdytuj.setSelectedItem("Kobieta");
                }
                textfieldImieEdytuj.setText(rs.getString("imie"));
                textfieldNazwiskoEdytuj.setText(rs.getString("nazwisko"));
                ftextfieldPeselEdytuj.setText(rs.getString("pesel"));
                textfieldNrdowoduEdytuj.setText(rs.getString("numerdowodu"));
                ftextfieldNrTelEdytuj.setText(rs.getString("numertelefonu"));
                textfieldEmailEdytuj.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "Klient o podanych danych nie istnieje.");
            }
            rs.close();
            con.close();
            
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }//GEN-LAST:event_buttonWyszukajEdytujActionPerformed

    private void buttonZmienEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZmienEdytujActionPerformed
        Connection con;
        PreparedStatement pst;

        String imie = textfieldImieEdytuj.getText();
        String nazwisko = textfieldNazwiskoEdytuj.getText();
        String pesel = ftextfieldPeselEdytuj.getText();
        String numerDowodu = textfieldNrdowoduEdytuj.getText();
        String numerTelefonu = ftextfieldNrTelEdytuj.getText();
        String email = textfieldEmailEdytuj.getText();
        String plec = comboPlecDodaj.getSelectedItem().toString();
        if (plec.equals("Mezczyzna")) {
            plec = "m";
        } else {
            plec = "k";
        }
        String szukaneDane = textfieldWyszukajEdytuj.getText();
        if (imie.isEmpty() || nazwisko.isEmpty() || pesel.isEmpty() || numerDowodu.isEmpty() || numerTelefonu.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pola nie mogą być puste.");
        } else if (pesel.length() != 11) {
            JOptionPane.showMessageDialog(null, "Błędny numer PESEL.");
        } else if (numerTelefonu.length() != 9) {
            JOptionPane.showMessageDialog(null, "Błędny numer telefonu.");
        } else 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("UPDATE klient SET imie='" + imie + "' , nazwisko='" + nazwisko + "' , plec ='" + plec + "' ,pesel='" + pesel + "' , numerdowodu ='" + numerDowodu + "' ,numertelefonu='" + numerTelefonu + "' , email='" + email + "' WHERE id = '" + szukaneDane + "' OR pesel='" + szukaneDane + "';");
            int wynik1 = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dane klienta zostały zaktualizowane.");
            WyczyscOkno();
            con.close();
        } catch (Exception ee) {
            WyczyscOkno();
        }
    }//GEN-LAST:event_buttonZmienEdytujActionPerformed

    private void buttonWyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyczyscActionPerformed
        WyczyscOkno();
        tableKlienci.setModel(new DefaultTableModel());
    }//GEN-LAST:event_buttonWyczyscActionPerformed

    private void textfieldImieEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldImieEdytujActionPerformed
        String szukaneDane = buttonWyszukajSprawdz.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("SELECT * From klient WHERE id ='" + szukaneDane + "' OR pesel='" + szukaneDane + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                String plec = rs.getString("plec");
                if (plec.equals("m")) {
                    comboPlecEdytuj.setSelectedItem("Mezczyzna");
                } else if (plec.equals("k")) {
                    comboPlecEdytuj.setSelectedItem("Kobieta");
                }
                textfieldImieEdytuj.setText(rs.getString("imie"));
                textfieldNazwiskoEdytuj.setText(rs.getString("nazwisko"));
                ftextfieldPeselEdytuj.setText(rs.getString("pesel"));
                textfieldNrdowoduEdytuj.setText(rs.getString("numerdowodu"));
                ftextfieldNrTelEdytuj.setText(rs.getString("numertelefonu"));
                textfieldEmailEdytuj.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "Klient o podanych danych nie istnieje.");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }//GEN-LAST:event_textfieldImieEdytujActionPerformed

    private void buttonWyszukajSprawdzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajSprawdzActionPerformed
        WczytajTabele();
    }//GEN-LAST:event_buttonWyszukajSprawdzActionPerformed

    private void buttonUsunEdytujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUsunEdytujActionPerformed
        Connection con;
        PreparedStatement pst;
        String imie = textfieldImieEdytuj.getText();
        String nazwisko = textfieldNazwiskoEdytuj.getText();
        String pesel = ftextfieldPeselEdytuj.getText();
        String numerDowodu = textfieldNrdowoduEdytuj.getText();
        String numerTelefonu = ftextfieldNrTelEdytuj.getText();
        String email = textfieldEmailEdytuj.getText();
        if (imie.isEmpty() || nazwisko.isEmpty() || pesel.isEmpty() || numerDowodu.isEmpty() || numerTelefonu.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pola nie mogą być puste.");
        } else if (pesel.length() != 11) {
            JOptionPane.showMessageDialog(null, "Błędny numer PESEL.");
        } else if (numerTelefonu.length() != 9) {
            JOptionPane.showMessageDialog(null, "Błędny numer telefonu.");
        } else 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("DELETE FROM klient WHERE imie='" + imie + "'AND nazwisko='" + nazwisko + "'AND pesel='" + pesel + "'AND numerdowodu='" + numerDowodu + "'AND numertelefonu='" + numerTelefonu + "'AND email='" + email + "';");
            int wynik1 = pst.executeUpdate();
            
            WyczyscOkno();
            JOptionPane.showMessageDialog(null, "Pomyślnie usunięto z bazy.");
            pst.close();
            con.close();
        } catch (Exception ee) {
            WyczyscOkno();
            JOptionPane.showMessageDialog(null, "Dana osoba nie istnieje w bazie.");
        }
    }//GEN-LAST:event_buttonUsunEdytujActionPerformed
    
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
            java.util.logging.Logger.getLogger(Klienci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Klienci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Klienci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Klienci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Klienci().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDodaj;
    private javax.swing.JButton buttonUsunEdytuj;
    private javax.swing.JButton buttonWyczysc;
    private javax.swing.JButton buttonWyjscie;
    private javax.swing.JButton buttonWyszukajEdytuj;
    private javax.swing.JButton buttonWyszukajSprawdz;
    private javax.swing.JButton buttonZmienEdytuj;
    private javax.swing.JComboBox<String> comboPlecDodaj;
    private javax.swing.JComboBox<String> comboPlecEdytuj;
    private javax.swing.JComboBox<String> comboPokazKlienci;
    private javax.swing.JComboBox<String> comboSortujKlienci;
    private javax.swing.JFormattedTextField ftextfieldNrTelDodaj;
    private javax.swing.JFormattedTextField ftextfieldNrTelEdytuj;
    private javax.swing.JFormattedTextField ftextfieldPeselDodaj;
    private javax.swing.JFormattedTextField ftextfieldPeselEdytuj;
    private javax.swing.JLabel labelEmailDodaj;
    private javax.swing.JLabel labelEmailEdytuj;
    private javax.swing.JLabel labelIdLubPeselEdytuj;
    private javax.swing.JLabel labelImieDodaj;
    private javax.swing.JLabel labelImieEdytuj;
    private javax.swing.JLabel labelKlienci;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel labelNazwiskoDodaj;
    private javax.swing.JLabel labelNazwiskoEdytuj;
    private javax.swing.JLabel labelNrdowoduDodaj;
    private javax.swing.JLabel labelNrdowoduEdytuj;
    private javax.swing.JLabel labelNrtelefonuDodaj;
    private javax.swing.JLabel labelNrtelefonuEdytuj;
    private javax.swing.JLabel labelPeselDodaj;
    private javax.swing.JLabel labelPeselEdytuj;
    private javax.swing.JLabel labelPlecDodaj;
    private javax.swing.JLabel labelPlecEdytuj;
    private javax.swing.JLabel labelPokazJedynie;
    private javax.swing.JLabel labelPokoje;
    private javax.swing.JLabel labelRezerwacje;
    private javax.swing.JLabel labelRozliczenie;
    private javax.swing.JLabel labelSortuj;
    private javax.swing.JLabel labelStatystyki;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JLabel labelZalogowano;
    private javax.swing.JLabel labelZalogowano1;
    private javax.swing.JPanel panelDodaj;
    private javax.swing.JPanel panelEdytuj;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelOpcji;
    private javax.swing.JScrollPane panelScrollKlienci;
    private javax.swing.JPanel panelSprawdzListe;
    private javax.swing.JPanel panelTytulowy;
    private javax.swing.JTable tableKlienci;
    private javax.swing.JTextField textfieldEmailDodaj;
    private javax.swing.JTextField textfieldEmailEdytuj;
    private javax.swing.JTextField textfieldImieDodaj;
    private javax.swing.JTextField textfieldImieEdytuj;
    private javax.swing.JTextField textfieldNazwiskoDodaj;
    private javax.swing.JTextField textfieldNazwiskoEdytuj;
    private javax.swing.JTextField textfieldNrdowoduDodaj;
    private javax.swing.JTextField textfieldNrdowoduEdytuj;
    private javax.swing.JTextField textfieldWyszukajEdytuj;
    private javax.swing.JTabbedPane tpanelKlienci;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
