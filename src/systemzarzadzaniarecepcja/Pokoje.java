/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemzarzadzaniarecepcja;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class Pokoje extends javax.swing.JFrame {

    public Pokoje() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        Logowanie logowanie = new Logowanie();
        labelZalogowano1.setText(logowanie.przekazLogin());
        WczytajTabele();
    }
    private void WyczyscOkno(){
        textfieldNumerDodaj.setText("");
        comboIleOsobDodaj.setSelectedItem("1");
        comboIleLozekDodaj.setSelectedItem("1");
        textfieldCenaDodaj.setText("");
        comboStatusDodaj.setSelectedItem("1");
        textfieldOpisDodaj.setText("");
        textfieldNumerZmien.setText("");
        comboIleOsobZmien.setSelectedItem("1");
        comboIleLozekZmien.setSelectedItem("1");
        textfieldCenaZmien.setText("");
        comboStatusZmien.setSelectedItem("1");
        textfieldOpisZmien.setText("");
        textfieldWyszukajPokoj.setText("");
    }
    private void WczytajTabele() {
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        ResultSetMetaData rsmd;
        DefaultTableModel model;
        int sortowanie = comboSortujPokoje.getSelectedIndex();
        int pokazjedynie = comboPokazPokoje.getSelectedIndex();
        String sortowanieS = null;
        String pokazjedynieS = null;
        try {
            tablePokoje.setModel(new DefaultTableModel());
            if (pokazjedynie == 0) {
                pokazjedynieS = "";
            } else if (pokazjedynie == 1) {
                pokazjedynieS = "WHERE status ='Wolny' ";
            } else if (pokazjedynie == 2) {
                pokazjedynieS = "WHERE status ='Zajety' ";
            } else if (pokazjedynie == 3) {
                pokazjedynieS = "WHERE status ='Nieczynny' ";
            }else if (pokazjedynie == 4) {
                pokazjedynieS = "WHERE telewizor='1' AND status ='Wolny' ";
            } else if (pokazjedynie == 5) {
                pokazjedynieS = "WHERE wifi='1' AND status ='Wolny' ";
            } else if (pokazjedynie == 6) {
                pokazjedynieS = "WHERE toaleta='1' AND status ='Wolny' ";
            } else if (pokazjedynie == 7) {
                pokazjedynieS = "WHERE aneks = '1' AND status ='Wolny' ";
            } else if (pokazjedynie == 8) {
                pokazjedynieS = "WHERE balkon = '1' AND status ='Wolny' ";
            }

            if (sortowanie == 0) {
                sortowanieS = "order by id desc";
            } else if (sortowanie == 1) {
                sortowanieS = "";
            } else if (sortowanie == 2) {
                sortowanieS = "order by cenadoba asc";
            } else if (sortowanie == 3) {
                sortowanieS = "order by cenadoba desc";
            } else if (sortowanie == 4) {
                sortowanieS = "order by ileosob asc";
            } else if (sortowanie == 5) {
                sortowanieS = "order by ileosob desc";
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select id,numerpokoju , ileosob , ilelozek , cenadoba , status, telewizor as tv, wifi, toaleta, aneks,balkon, opis from pokoje " + pokazjedynieS + sortowanieS;
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            rsmd = rs.getMetaData();
            model = (DefaultTableModel) tablePokoje.getModel();

            int kolumny = rsmd.getColumnCount();
            String[] nazwaKolumny = new String[kolumny];
            for (int i = 0; i < kolumny; i++) {
                nazwaKolumny[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(nazwaKolumny);

            String id, numer, ileosob, ilelozek, cena, status, tv, wifi, toaleta, aneks, balkon, opis;
            while (rs.next()) {
                id = rs.getString(1);
                numer = rs.getString(2);
                ileosob = rs.getString(3);
                ilelozek = rs.getString(4);
                cena = rs.getString(5);
                status = rs.getString(6);
                tv = rs.getString(7);
                wifi = rs.getString(8);
                toaleta = rs.getString(9);
                aneks = rs.getString(10);
                balkon = rs.getString(11);
                opis = rs.getString(12);

                String[] row = {id, numer, ileosob, ilelozek, cena, status, tv, wifi, toaleta, aneks, balkon, opis};
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
        tpanelPokoje = new javax.swing.JTabbedPane();
        panelListaPokoi = new javax.swing.JPanel();
        labelPokazJedynie = new javax.swing.JLabel();
        comboPokazPokoje = new javax.swing.JComboBox<>();
        labelSortuj = new javax.swing.JLabel();
        comboSortujPokoje = new javax.swing.JComboBox<>();
        buttonWyszukajPokoje = new javax.swing.JButton();
        scrollPanePokoje = new javax.swing.JScrollPane();
        tablePokoje = new javax.swing.JTable();
        panelDodajPokoje = new javax.swing.JPanel();
        labelImieDodaj = new javax.swing.JLabel();
        labelPlecDodaj = new javax.swing.JLabel();
        labelPeselDodaj = new javax.swing.JLabel();
        labelNrdowoduDodaj = new javax.swing.JLabel();
        labelNrtelefonuDodaj = new javax.swing.JLabel();
        labelEmailDodaj = new javax.swing.JLabel();
        textfieldNumerDodaj = new javax.swing.JTextField();
        textfieldCenaDodaj = new javax.swing.JTextField();
        textfieldOpisDodaj = new javax.swing.JTextField();
        buttonPokojeDodaj = new javax.swing.JButton();
        comboIleOsobDodaj = new javax.swing.JComboBox<>();
        comboIleLozekDodaj = new javax.swing.JComboBox<>();
        comboStatusDodaj = new javax.swing.JComboBox<>();
        radioTv = new javax.swing.JRadioButton();
        radioWiFi = new javax.swing.JRadioButton();
        radioToaleta = new javax.swing.JRadioButton();
        radioAneks = new javax.swing.JRadioButton();
        radioBalkon = new javax.swing.JRadioButton();
        panelZmienStatus = new javax.swing.JPanel();
        labelImieZmien = new javax.swing.JLabel();
        labelPlecZmien = new javax.swing.JLabel();
        labelPeselZmien = new javax.swing.JLabel();
        labelNrdowoduZmien = new javax.swing.JLabel();
        labelNrtelefonuZmien = new javax.swing.JLabel();
        labelEmailZmien = new javax.swing.JLabel();
        textfieldNumerZmien = new javax.swing.JTextField();
        textfieldCenaZmien = new javax.swing.JTextField();
        textfieldOpisZmien = new javax.swing.JTextField();
        buttonZapiszPokoj = new javax.swing.JButton();
        comboIleOsobZmien = new javax.swing.JComboBox<>();
        comboIleLozekZmien = new javax.swing.JComboBox<>();
        comboStatusZmien = new javax.swing.JComboBox<>();
        radioTvZmien = new javax.swing.JRadioButton();
        radioWifiZmien = new javax.swing.JRadioButton();
        radioToaletaZmien = new javax.swing.JRadioButton();
        radioAneksZmien = new javax.swing.JRadioButton();
        radioBalkonZmien = new javax.swing.JRadioButton();
        labelPodajNumer = new javax.swing.JLabel();
        textfieldWyszukajPokoj = new javax.swing.JTextField();
        buttonWyszukajPokoj = new javax.swing.JButton();
        buttonUsunPokoj = new javax.swing.JButton();
        buttonWyczysc = new javax.swing.JButton();
        labelZalogowano1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(255, 255, 255));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("Pokoje");

        javax.swing.GroupLayout panelTytulowyLayout = new javax.swing.GroupLayout(panelTytulowy);
        panelTytulowy.setLayout(panelTytulowyLayout);
        panelTytulowyLayout.setHorizontalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTytulowyLayout.createSequentialGroup()
                .addGap(317, 317, 317)
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

        labelPokoje.setFont(new java.awt.Font("Cambria", 1, 28)); // NOI18N
        labelPokoje.setForeground(new java.awt.Color(255, 255, 255));
        labelPokoje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPokoje.setText("Pokoje");
        labelPokoje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        tpanelPokoje.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        panelListaPokoi.setBackground(new java.awt.Color(51, 51, 51));
        panelListaPokoi.setForeground(new java.awt.Color(51, 51, 51));

        labelPokazJedynie.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokazJedynie.setForeground(new java.awt.Color(255, 255, 255));
        labelPokazJedynie.setText("Pokaż jedynie:");

        comboPokazPokoje.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboPokazPokoje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wszystko", "Wolne", "Zajęte", "Nieczynne", "Z telewizją", "Z wifi", "Z toaletą", "Z aneksem", "Z balkonem" }));

        labelSortuj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelSortuj.setForeground(new java.awt.Color(255, 255, 255));
        labelSortuj.setText("Sortuj według:");

        comboSortujPokoje.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboSortujPokoje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID (domyślnie)", "ID (rosnąco)", "Cena (rosnąco)", "Cena (malejąco)", "Liczba osób (rosnąco)", "Liczba osób (malejąco)" }));

        buttonWyszukajPokoje.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajPokoje.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajPokoje.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajPokoje.setText("Wyszukaj");
        buttonWyszukajPokoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajPokojeActionPerformed(evt);
            }
        });

        tablePokoje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "numer", "ileOsob", "ileLozek", "cena", "status", "tv", "wifi", "wc", "aneks", "balkon", "opis"
            }
        ));
        scrollPanePokoje.setViewportView(tablePokoje);

        javax.swing.GroupLayout panelListaPokoiLayout = new javax.swing.GroupLayout(panelListaPokoi);
        panelListaPokoi.setLayout(panelListaPokoiLayout);
        panelListaPokoiLayout.setHorizontalGroup(
            panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaPokoiLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaPokoiLayout.createSequentialGroup()
                        .addGap(0, 87, Short.MAX_VALUE)
                        .addGroup(panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaPokoiLayout.createSequentialGroup()
                                .addComponent(labelSortuj, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPokazJedynie))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaPokoiLayout.createSequentialGroup()
                                .addComponent(comboSortujPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(comboPokazPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 94, 94)
                        .addComponent(buttonWyszukajPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollPanePokoje))
                .addGap(0, 0, 0))
        );
        panelListaPokoiLayout.setVerticalGroup(
            panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaPokoiLayout.createSequentialGroup()
                .addComponent(scrollPanePokoje, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelListaPokoiLayout.createSequentialGroup()
                        .addGroup(panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokazJedynie)
                            .addComponent(labelSortuj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelListaPokoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSortujPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPokazPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonWyszukajPokoje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tpanelPokoje.addTab("Lista pokoi", panelListaPokoi);

        panelDodajPokoje.setBackground(new java.awt.Color(51, 51, 51));
        panelDodajPokoje.setForeground(new java.awt.Color(51, 51, 51));

        labelImieDodaj.setBackground(new java.awt.Color(255, 255, 255));
        labelImieDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelImieDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelImieDodaj.setText("Numer pokoju:");

        labelPlecDodaj.setBackground(new java.awt.Color(255, 255, 255));
        labelPlecDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPlecDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelPlecDodaj.setText("Ilu osobowy?");

        labelPeselDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPeselDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelPeselDodaj.setText("Ile łóżek?");

        labelNrdowoduDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrdowoduDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelNrdowoduDodaj.setText("Cena za dobę:");

        labelNrtelefonuDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrtelefonuDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelNrtelefonuDodaj.setText("Status:");

        labelEmailDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelEmailDodaj.setForeground(new java.awt.Color(255, 255, 255));
        labelEmailDodaj.setText("Opis:");

        textfieldNumerDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldCenaDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldOpisDodaj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        buttonPokojeDodaj.setBackground(new java.awt.Color(51, 51, 51));
        buttonPokojeDodaj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonPokojeDodaj.setForeground(new java.awt.Color(255, 255, 255));
        buttonPokojeDodaj.setText("Dodaj");
        buttonPokojeDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPokojeDodajActionPerformed(evt);
            }
        });

        comboIleOsobDodaj.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboIleOsobDodaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        comboIleLozekDodaj.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboIleLozekDodaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        comboStatusDodaj.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboStatusDodaj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wolny", "Zajety", "Nieczynny" }));

        radioTv.setBackground(new java.awt.Color(51, 51, 51));
        radioTv.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioTv.setForeground(new java.awt.Color(255, 255, 255));
        radioTv.setText("Telewizor");

        radioWiFi.setBackground(new java.awt.Color(51, 51, 51));
        radioWiFi.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioWiFi.setForeground(new java.awt.Color(255, 255, 255));
        radioWiFi.setText("WiFi");

        radioToaleta.setBackground(new java.awt.Color(51, 51, 51));
        radioToaleta.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioToaleta.setForeground(new java.awt.Color(255, 255, 255));
        radioToaleta.setText("Toaleta");

        radioAneks.setBackground(new java.awt.Color(51, 51, 51));
        radioAneks.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioAneks.setForeground(new java.awt.Color(255, 255, 255));
        radioAneks.setText("Aneks");

        radioBalkon.setBackground(new java.awt.Color(51, 51, 51));
        radioBalkon.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioBalkon.setForeground(new java.awt.Color(255, 255, 255));
        radioBalkon.setText("Balkon");

        javax.swing.GroupLayout panelDodajPokojeLayout = new javax.swing.GroupLayout(panelDodajPokoje);
        panelDodajPokoje.setLayout(panelDodajPokojeLayout);
        panelDodajPokojeLayout.setHorizontalGroup(
            panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDodajPokojeLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDodajPokojeLayout.createSequentialGroup()
                        .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPeselDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelImieDodaj)
                            .addComponent(labelPlecDodaj)
                            .addComponent(labelNrdowoduDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNrtelefonuDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmailDodaj))
                        .addGap(0, 0, 0)
                        .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldOpisDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboIleLozekDodaj, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboIleOsobDodaj, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfieldNumerDodaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboStatusDodaj, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfieldCenaDodaj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonPokojeDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelDodajPokojeLayout.createSequentialGroup()
                            .addComponent(radioTv)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioWiFi)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioToaleta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioAneks)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radioBalkon))))
                .addGap(0, 148, Short.MAX_VALUE))
        );
        panelDodajPokojeLayout.setVerticalGroup(
            panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDodajPokojeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelImieDodaj)
                    .addComponent(textfieldNumerDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPlecDodaj)
                    .addComponent(comboIleOsobDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPeselDodaj)
                    .addComponent(comboIleLozekDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldCenaDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNrdowoduDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNrtelefonuDodaj)
                    .addComponent(comboStatusDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmailDodaj)
                    .addComponent(textfieldOpisDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDodajPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioTv)
                    .addComponent(radioWiFi)
                    .addComponent(radioToaleta)
                    .addComponent(radioAneks)
                    .addComponent(radioBalkon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPokojeDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tpanelPokoje.addTab("Dodaj", panelDodajPokoje);

        panelZmienStatus.setBackground(new java.awt.Color(51, 51, 51));
        panelZmienStatus.setForeground(new java.awt.Color(51, 51, 51));

        labelImieZmien.setBackground(new java.awt.Color(255, 255, 255));
        labelImieZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelImieZmien.setForeground(new java.awt.Color(255, 255, 255));
        labelImieZmien.setText("Numer pokoju:");

        labelPlecZmien.setBackground(new java.awt.Color(255, 255, 255));
        labelPlecZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPlecZmien.setForeground(new java.awt.Color(255, 255, 255));
        labelPlecZmien.setText("Ilu osobowy?");

        labelPeselZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPeselZmien.setForeground(new java.awt.Color(255, 255, 255));
        labelPeselZmien.setText("Ile łóżek?");

        labelNrdowoduZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrdowoduZmien.setForeground(new java.awt.Color(255, 255, 255));
        labelNrdowoduZmien.setText("Cena za dobę:");

        labelNrtelefonuZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNrtelefonuZmien.setForeground(new java.awt.Color(255, 255, 255));
        labelNrtelefonuZmien.setText("Status:");

        labelEmailZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelEmailZmien.setForeground(new java.awt.Color(255, 255, 255));
        labelEmailZmien.setText("Opis:");

        textfieldNumerZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldCenaZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        textfieldOpisZmien.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        buttonZapiszPokoj.setBackground(new java.awt.Color(51, 51, 51));
        buttonZapiszPokoj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonZapiszPokoj.setForeground(new java.awt.Color(255, 255, 255));
        buttonZapiszPokoj.setText("Zmień");
        buttonZapiszPokoj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonZapiszPokojActionPerformed(evt);
            }
        });

        comboIleOsobZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboIleOsobZmien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        comboIleLozekZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboIleLozekZmien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        comboStatusZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        comboStatusZmien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wolny", "Zajety", "Nieczynny" }));

        radioTvZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioTvZmien.setForeground(new java.awt.Color(255, 255, 255));
        radioTvZmien.setText("Telewizor");

        radioWifiZmien.setBackground(new java.awt.Color(51, 51, 51));
        radioWifiZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioWifiZmien.setForeground(new java.awt.Color(255, 255, 255));
        radioWifiZmien.setText("WiFi");

        radioToaletaZmien.setBackground(new java.awt.Color(51, 51, 51));
        radioToaletaZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioToaletaZmien.setForeground(new java.awt.Color(255, 255, 255));
        radioToaletaZmien.setText("Toaleta");

        radioAneksZmien.setBackground(new java.awt.Color(51, 51, 51));
        radioAneksZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioAneksZmien.setForeground(new java.awt.Color(255, 255, 255));
        radioAneksZmien.setText("Aneks");

        radioBalkonZmien.setBackground(new java.awt.Color(51, 51, 51));
        radioBalkonZmien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        radioBalkonZmien.setForeground(new java.awt.Color(255, 255, 255));
        radioBalkonZmien.setText("Balkon");

        labelPodajNumer.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPodajNumer.setForeground(new java.awt.Color(255, 255, 255));
        labelPodajNumer.setText("Podaj numer pokoju:");

        textfieldWyszukajPokoj.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        buttonWyszukajPokoj.setBackground(new java.awt.Color(51, 51, 51));
        buttonWyszukajPokoj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonWyszukajPokoj.setForeground(new java.awt.Color(255, 255, 255));
        buttonWyszukajPokoj.setText("Wyszukaj");
        buttonWyszukajPokoj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWyszukajPokojActionPerformed(evt);
            }
        });

        buttonUsunPokoj.setBackground(new java.awt.Color(51, 51, 51));
        buttonUsunPokoj.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        buttonUsunPokoj.setForeground(new java.awt.Color(255, 255, 255));
        buttonUsunPokoj.setText("Usuń");
        buttonUsunPokoj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUsunPokojActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelZmienStatusLayout = new javax.swing.GroupLayout(panelZmienStatus);
        panelZmienStatus.setLayout(panelZmienStatusLayout);
        panelZmienStatusLayout.setHorizontalGroup(
            panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZmienStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonWyszukajPokoj, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(textfieldWyszukajPokoj, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(labelPodajNumer, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelZmienStatusLayout.createSequentialGroup()
                        .addComponent(buttonZapiszPokoj, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUsunPokoj, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelNrtelefonuZmien, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelZmienStatusLayout.createSequentialGroup()
                        .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPeselZmien, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelImieZmien)
                            .addComponent(labelPlecZmien)
                            .addComponent(labelEmailZmien))
                        .addGap(19, 19, 19)
                        .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldOpisZmien, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboIleOsobZmien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboIleLozekZmien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboStatusZmien, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textfieldCenaZmien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                            .addComponent(textfieldNumerZmien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelNrdowoduZmien, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelZmienStatusLayout.createSequentialGroup()
                        .addComponent(radioTvZmien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioWifiZmien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioToaletaZmien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioAneksZmien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBalkonZmien)))
                .addGap(0, 142, Short.MAX_VALUE))
        );
        panelZmienStatusLayout.setVerticalGroup(
            panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelZmienStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelZmienStatusLayout.createSequentialGroup()
                        .addComponent(labelPodajNumer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textfieldWyszukajPokoj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWyszukajPokoj))
                    .addGroup(panelZmienStatusLayout.createSequentialGroup()
                        .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelImieZmien)
                            .addComponent(textfieldNumerZmien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPlecZmien)
                            .addComponent(comboIleOsobZmien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPeselZmien)
                            .addComponent(comboIleLozekZmien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNrdowoduZmien)
                            .addComponent(textfieldCenaZmien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNrtelefonuZmien)
                    .addComponent(comboStatusZmien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textfieldOpisZmien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmailZmien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioTvZmien)
                    .addComponent(radioWifiZmien)
                    .addComponent(radioToaletaZmien)
                    .addComponent(radioAneksZmien)
                    .addComponent(radioBalkonZmien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelZmienStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonZapiszPokoj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUsunPokoj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tpanelPokoje.addTab("Zmień status lub usuń", panelZmienStatus);

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
            .addComponent(tpanelPokoje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelOpcji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tpanelPokoje)
                .addGap(7, 7, 7)
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

    private void buttonUsunPokojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUsunPokojActionPerformed
        Connection con;
        PreparedStatement pst;
        String numer = textfieldNumerZmien.getText();
        String ileOsob = comboIleOsobZmien.getSelectedItem().toString();
        String ileLozek = comboIleLozekZmien.getSelectedItem().toString();
        String cena = textfieldCenaZmien.getText();
        String status = comboStatusZmien.getSelectedItem().toString();
        String opis = textfieldOpisZmien.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("DELETE FROM pokoje WHERE numerpokoju='" + numer + "'AND ileosob='" + ileOsob + "'AND ilelozek='" + ileLozek + "'AND cenadoba='" + cena + "'AND status='" + status + "'AND opis='" + opis + "';");
            int result = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pomyślnie usunięto z bazy.");
            
            pst.close();
            con.close();

        } catch (Exception ee) {
            ee.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dany pokój nie istnieje w bazie lub nie wszystkie dane się zgadzają.");
        }
    }//GEN-LAST:event_buttonUsunPokojActionPerformed

    private void buttonWyczyscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyczyscActionPerformed

        WyczyscOkno();
        tablePokoje.setModel(new DefaultTableModel());
    }//GEN-LAST:event_buttonWyczyscActionPerformed

    private void buttonPokojeDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPokojeDodajActionPerformed
        String numer = textfieldNumerDodaj.getText();
        String ileOsob = comboIleOsobDodaj.getSelectedItem().toString();
        String ileLozek = comboIleLozekDodaj.getSelectedItem().toString();
        String cena = textfieldCenaDodaj.getText();
        String status = comboStatusDodaj.getSelectedItem().toString();
        String opis = textfieldOpisDodaj.getText();
        String radioTvs, radioWifis, radioWCs, radioAnekss, radioBalkons;
        Connection con;
        PreparedStatement pst;
        if (numer.isEmpty() || cena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Numer pokoju oraz cena nie mogą być puste.");
        } else try {
            if (radioTv.isSelected()) {
                radioTvs = "1";
            } else {
                radioTvs = "0";
            }
            if (radioWiFi.isSelected()) {
                radioWifis = "1";
            } else {
                radioWifis = "0";
            }
            if (radioToaleta.isSelected()) {
                radioWCs = "1";
            } else {
                radioWCs = "0";
            }
            if (radioAneks.isSelected()) {
                radioAnekss = "1";
            } else {
                radioAnekss = "0";
            }
            if (radioBalkon.isSelected()) {
                radioBalkons = "1";
            } else {
                radioBalkons = "0";
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            String sql = "INSERT INTO pokoje (numerpokoju, ileosob, ilelozek, cenadoba, status, opis, telewizor, wifi, toaleta, aneks, balkon) VALUES('" + numer + "','" + ileOsob + "','" + ileLozek + "','" + cena + "','" + status + "','" + opis + "','" + radioTvs + "','" + radioWifis + "','" + radioWCs + "','" + radioAnekss + "','" + radioBalkons + "');";
            pst = con.prepareStatement(sql);
            int result = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pomyślnie dodano pokój " + numer + " do bazy.");
            WyczyscOkno();
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Pokój o danym numerze już istnieje.");
            ee.printStackTrace();
        }
    }//GEN-LAST:event_buttonPokojeDodajActionPerformed

    private void buttonWyszukajPokojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajPokojActionPerformed
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        String szukanyPokoj = textfieldWyszukajPokoj.getText();
        String ileosob, ilelozek, status,radiotv, radiowifi, radiowc, radioaneks, radiobalkon;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            pst = con.prepareStatement("SELECT * From pokoje WHERE id ='" + szukanyPokoj + "' OR numerpokoju='" + szukanyPokoj + "'");
            rs = pst.executeQuery();
            if (rs.next()) {
                radiotv = rs.getString("telewizor");
                radiowifi = rs.getString("wifi");
                radiowc = rs.getString("toaleta");
                radioaneks = rs.getString("aneks");
                radiobalkon = rs.getString("balkon");
                if (radiotv.equals("1")) {
                    radioTvZmien.setSelected(true);
                } else {
                    radioTvZmien.setSelected(false);
                }
                if (radiowifi.equals("1")) {
                    radioWifiZmien.setSelected(true);
                } else {
                    radioWifiZmien.setSelected(false);
                }
                if (radiowc.equals("1")) {
                    radioToaletaZmien.setSelected(true);
                } else {
                    radioToaletaZmien.setSelected(false);
                }
                if (radioaneks.equals("1")) {
                    radioAneksZmien.setSelected(true);
                } else {
                    radioAneksZmien.setSelected(false);
                }
                if (radiobalkon.equals("1")) {
                    radioBalkonZmien.setSelected(true);
                } else {
                    radioBalkonZmien.setSelected(false);
                }
                ileosob = rs.getString("ileosob");
                ilelozek = rs.getString("ilelozek");
                status = rs.getString("status");
                comboIleOsobZmien.setSelectedItem(ileosob);
                comboIleLozekZmien.setSelectedItem(ilelozek);
                comboStatusZmien.setSelectedItem(status);
                textfieldNumerZmien.setText(rs.getString("numerpokoju"));
                textfieldCenaZmien.setText(rs.getString("cenadoba"));
                textfieldOpisZmien.setText(rs.getString("opis"));
            } else {
                JOptionPane.showMessageDialog(null, "Pokój o podanych danych nie istnieje");
            }
            rs.close();
            con.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }//GEN-LAST:event_buttonWyszukajPokojActionPerformed

    private void buttonZapiszPokojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonZapiszPokojActionPerformed
        String numer = textfieldNumerZmien.getText();
        String ileOsob = comboIleOsobZmien.getSelectedItem().toString();
        String ileLozek = comboIleLozekZmien.getSelectedItem().toString();
        String cena = textfieldCenaZmien.getText();
        String status = comboStatusZmien.getSelectedItem().toString();
        String opis = textfieldOpisZmien.getText();
        String szukanyPokoj = textfieldWyszukajPokoj.getText();
        String radioTvs, radioWifis, radioWCs, radioAnekss, radioBalkons;
        Connection con;
        PreparedStatement pst;
        if (numer.isEmpty() || cena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Numer pokoju oraz cena nie mogą być puste.");
        } else try {
            if (radioTv.isSelected()) {
                radioTvs = "1";
            } else {
                radioTvs = "0";
            }
            if (radioWiFi.isSelected()) {
                radioWifis = "1";
            } else {
                radioWifis = "0";
            }
            if (radioToaleta.isSelected()) {
                radioWCs = "1";
            } else {
                radioWCs = "0";
            }
            if (radioAneks.isSelected()) {
                radioAnekss = "1";
            } else {
                radioAnekss = "0";
            }
            if (radioBalkon.isSelected()) {
                radioBalkons = "1";
            } else {
                radioBalkons = "0";
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            String sql = "UPDATE pokoje SET numerpokoju='" + numer + "' , ileosob='" + ileOsob + "' , ilelozek ='" + ileLozek + "' ,cenadoba='" + cena + "' , status ='" + status + "' ,opis='" + opis + "' , telewizor='" + radioTvs + "', telewizor='" + radioTvs + "' , wifi='" + radioWifis + "' , toaleta='" + radioWCs + "' , aneks='" + radioAnekss + "' , balkon='" + radioBalkons + "' where id='" + szukanyPokoj + "' OR numerpokoju='" + szukanyPokoj + "';";
            pst = con.prepareStatement(sql);
            int wynik1 = pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pomyślnie zmieniono pokój. ");
            WyczyscOkno();
            pst.close();
            con.close();
        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Pokój o danym numerze już istnieje.");
            ee.printStackTrace();
        }
    }//GEN-LAST:event_buttonZapiszPokojActionPerformed

    private void buttonWyszukajPokojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWyszukajPokojeActionPerformed
        WczytajTabele();
    }//GEN-LAST:event_buttonWyszukajPokojeActionPerformed

    
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
            java.util.logging.Logger.getLogger(Pokoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pokoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pokoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pokoje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pokoje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPokojeDodaj;
    private javax.swing.JButton buttonUsunPokoj;
    private javax.swing.JButton buttonWyczysc;
    private javax.swing.JButton buttonWyjscie;
    private javax.swing.JButton buttonWyszukajPokoj;
    private javax.swing.JButton buttonWyszukajPokoje;
    private javax.swing.JButton buttonZapiszPokoj;
    private javax.swing.JComboBox<String> comboIleLozekDodaj;
    private javax.swing.JComboBox<String> comboIleLozekZmien;
    private javax.swing.JComboBox<String> comboIleOsobDodaj;
    private javax.swing.JComboBox<String> comboIleOsobZmien;
    private javax.swing.JComboBox<String> comboPokazPokoje;
    private javax.swing.JComboBox<String> comboSortujPokoje;
    private javax.swing.JComboBox<String> comboStatusDodaj;
    private javax.swing.JComboBox<String> comboStatusZmien;
    private javax.swing.JLabel labelEmailDodaj;
    private javax.swing.JLabel labelEmailZmien;
    private javax.swing.JLabel labelImieDodaj;
    private javax.swing.JLabel labelImieZmien;
    private javax.swing.JLabel labelKlienci;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel labelNrdowoduDodaj;
    private javax.swing.JLabel labelNrdowoduZmien;
    private javax.swing.JLabel labelNrtelefonuDodaj;
    private javax.swing.JLabel labelNrtelefonuZmien;
    private javax.swing.JLabel labelPeselDodaj;
    private javax.swing.JLabel labelPeselZmien;
    private javax.swing.JLabel labelPlecDodaj;
    private javax.swing.JLabel labelPlecZmien;
    private javax.swing.JLabel labelPodajNumer;
    private javax.swing.JLabel labelPokazJedynie;
    private javax.swing.JLabel labelPokoje;
    private javax.swing.JLabel labelRezerwacje;
    private javax.swing.JLabel labelRozliczenie;
    private javax.swing.JLabel labelSortuj;
    private javax.swing.JLabel labelStatystyki;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JLabel labelZalogowano;
    private javax.swing.JLabel labelZalogowano1;
    private javax.swing.JPanel panelDodajPokoje;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelListaPokoi;
    private javax.swing.JPanel panelOpcji;
    private javax.swing.JPanel panelTytulowy;
    private javax.swing.JPanel panelZmienStatus;
    private javax.swing.JRadioButton radioAneks;
    private javax.swing.JRadioButton radioAneksZmien;
    private javax.swing.JRadioButton radioBalkon;
    private javax.swing.JRadioButton radioBalkonZmien;
    private javax.swing.JRadioButton radioToaleta;
    private javax.swing.JRadioButton radioToaletaZmien;
    private javax.swing.JRadioButton radioTv;
    private javax.swing.JRadioButton radioTvZmien;
    private javax.swing.JRadioButton radioWiFi;
    private javax.swing.JRadioButton radioWifiZmien;
    private javax.swing.JScrollPane scrollPanePokoje;
    private javax.swing.JTable tablePokoje;
    private javax.swing.JTextField textfieldCenaDodaj;
    private javax.swing.JTextField textfieldCenaZmien;
    private javax.swing.JTextField textfieldNumerDodaj;
    private javax.swing.JTextField textfieldNumerZmien;
    private javax.swing.JTextField textfieldOpisDodaj;
    private javax.swing.JTextField textfieldOpisZmien;
    private javax.swing.JTextField textfieldWyszukajPokoj;
    private javax.swing.JTabbedPane tpanelPokoje;
    // End of variables declaration//GEN-END:variables
}
