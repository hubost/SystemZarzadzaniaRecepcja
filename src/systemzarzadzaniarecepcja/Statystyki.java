/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package systemzarzadzaniarecepcja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;

public class Statystyki extends javax.swing.JFrame {

    public Statystyki() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
        Logowanie logowanie = new Logowanie();
        labelZalogowano1.setText(logowanie.przekazLogin());

        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///systemzarzadzaniarecepcja", "root", "password");
            //Rezerwacje
            String wszystkieRezerwacje = null, aktywneRezerwacje = null, rezerwacjeDzis = null, sredniPobyt = null, sredniKoszt = null;
            pst = con.prepareStatement("select count(*) from rezerwacja;");
            rs = pst.executeQuery();
            if (rs.next()) {
                wszystkieRezerwacje = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from rezerwacja WHERE czy_rozliczona = '0'");
            rs = pst.executeQuery();
            if (rs.next()) {
                aktywneRezerwacje = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from rezerwacja WHERE data_utworzenia = Current_DATE");
            rs = pst.executeQuery();
            if (rs.next()) {
                rezerwacjeDzis = rs.getString(1);
            }
            pst = con.prepareStatement("select ROUND(avg(ilosc_dob)) from rezerwacja");
            rs = pst.executeQuery();
            if (rs.next()) {
                sredniPobyt = rs.getString(1);
            }
            pst = con.prepareStatement("select ROUND(avg(koszt)) from rezerwacja");
            rs = pst.executeQuery();
            if (rs.next()) {
                sredniKoszt = rs.getString(1);
            }
            labelWszystkieRezerwacje2.setText(wszystkieRezerwacje);
            labelAktywneRezerwacje2.setText(aktywneRezerwacje);
            labelRezerwacjeDzis2.setText(rezerwacjeDzis);
            labelSredniPobyt2.setText(sredniPobyt);
            labelSredniKoszt2.setText(sredniKoszt);
            //Pokoje
            String wszystkiePokoje = null, pokojeWolneZajete = null, pokojeWolneZajete2 = null, pokojeNieczynne = null,
                    pokoje1os = null, pokoje2os = null, pokoje3os = null, pokoje4os = null,
                    pokoje5os = null, pokoje6os = null;
            pst = con.prepareStatement("select count(*) from pokoje;");
            rs = pst.executeQuery();
            if (rs.next()) {
                wszystkiePokoje = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE status = 'Wolny' ");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokojeWolneZajete = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE status = 'Zajety';");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokojeWolneZajete2 = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE status = 'Nieczynny';");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokojeNieczynne = rs.getString(1);
            }
            //Pokoje 1-6os
            pst = con.prepareStatement("select count(*) from pokoje WHERE ileosob ='1' AND status='Wolny' ;");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokoje1os = rs.getString(1);
            }

            pst = con.prepareStatement("select count(*) from pokoje WHERE ileosob ='2' AND status='Wolny'; ");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokoje2os = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE ileosob ='3' AND status='Wolny';");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokoje3os = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE ileosob ='4' AND status='Wolny';");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokoje4os = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE ileosob ='5' AND status='Wolny';");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokoje5os = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from pokoje WHERE ileosob ='6' AND status='Wolny';");
            rs = pst.executeQuery();
            if (rs.next()) {
                pokoje6os = rs.getString(1);
            }
            labelWszystkiePokoje2.setText(wszystkiePokoje);
            labelPokojeWolneZajete2.setText(pokojeWolneZajete + "/" + pokojeWolneZajete2);
            labelPokojeNieczynne2.setText(pokojeNieczynne);
            labelPokojeWolne1os2.setText(pokoje1os);
            labelPokojeWolne2os2.setText(pokoje2os);
            labelPokojeWolne3os2.setText(pokoje3os);
            labelPokojeWolne4os2.setText(pokoje4os);
            labelPokojeWolne5os2.setText(pokoje5os);
            labelPokojeWolne6os2.setText(pokoje6os);
            //Klienci
            String wszyscyKlienci = null, SredniaWieku = null, kobiety = null, mezczyzni = null;
            int rok = Year.now().getValue();
            String rokS = "1" + String.valueOf(rok).substring(2, 4);
            rok = Integer.parseInt(rokS);

            pst = con.prepareStatement("select count(*) from klient;");
            rs = pst.executeQuery();
            if (rs.next()) {
                wszyscyKlienci = rs.getString(1);
            }
            pst = con.prepareStatement("select ROUND(AVG(left(pesel,2))) from klient where left(pesel,2) > right(year(current_date),2) ");
            rs = pst.executeQuery();
            if (rs.next()) {
                SredniaWieku = rs.getString(1).substring(0, 2);
                int wiek = rok - (Integer.parseInt(SredniaWieku));
                SredniaWieku = String.valueOf(wiek);
            }
            pst = con.prepareStatement("select count(*) from klient where plec ='k'");
            rs = pst.executeQuery();
            if (rs.next()) {
                kobiety = rs.getString(1);
            }
            pst = con.prepareStatement("select count(*) from klient where plec='m';");
            rs = pst.executeQuery();
            if (rs.next()) {
                mezczyzni = rs.getString(1);
            }
            labelWszyscyKlienci2.setText(wszyscyKlienci);
            labelSredniaWieku2.setText(SredniaWieku);
            labelKobietyMezczyzni2.setText(kobiety + "/" + mezczyzni);
            //Pracownicy
            String wszyscyPracownicy = null, najnowszyPracownik = null;
            pst = con.prepareStatement("select count(*) from pracownik;");
            rs = pst.executeQuery();
            if (rs.next()) {
                wszyscyPracownicy = rs.getString(1);
            }
            pst = con.prepareStatement("select login from pracownik order by data_utworzenia desc limit 1 ;");
            rs = pst.executeQuery();
            if (rs.next()) {
                najnowszyPracownik = rs.getString(1);
            }
            labelWszyscyPracownicy2.setText(wszyscyPracownicy);
            labelNajwiecejRezerwacji2.setText(najnowszyPracownik);
            rs.close();
            con.close();
        } catch (Exception ex) {}
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
        panelRezerwacje = new javax.swing.JPanel();
        labelStatystykiRezerwacje = new javax.swing.JLabel();
        labelWszystkieRezerwacje = new javax.swing.JLabel();
        labelAktywneRezerwacje = new javax.swing.JLabel();
        labelRezerwacjeDzis = new javax.swing.JLabel();
        labelSredniPobyt = new javax.swing.JLabel();
        labelSredniKoszt = new javax.swing.JLabel();
        labelRezerwacjeDzis2 = new javax.swing.JLabel();
        labelSredniPobyt2 = new javax.swing.JLabel();
        labelSredniKoszt2 = new javax.swing.JLabel();
        labelAktywneRezerwacje2 = new javax.swing.JLabel();
        labelWszystkieRezerwacje2 = new javax.swing.JLabel();
        panelPokoje = new javax.swing.JPanel();
        labelStatystykiPokoje = new javax.swing.JLabel();
        labelWszystkiePokoje = new javax.swing.JLabel();
        labelPokojeWolneZajete = new javax.swing.JLabel();
        labelPokojeNieczynne = new javax.swing.JLabel();
        labelPokojeWolne1os = new javax.swing.JLabel();
        labelPokojeWolne2os = new javax.swing.JLabel();
        labelPokojeWolne3os = new javax.swing.JLabel();
        labelPokojeWolne5os = new javax.swing.JLabel();
        labelPokojeWolne6os = new javax.swing.JLabel();
        labelPokojeWolne4os = new javax.swing.JLabel();
        labelWszystkiePokoje2 = new javax.swing.JLabel();
        labelPokojeNieczynne2 = new javax.swing.JLabel();
        labelPokojeWolneZajete2 = new javax.swing.JLabel();
        labelPokojeWolne1os2 = new javax.swing.JLabel();
        labelPokojeWolne2os2 = new javax.swing.JLabel();
        labelPokojeWolne4os2 = new javax.swing.JLabel();
        labelPokojeWolne3os2 = new javax.swing.JLabel();
        labelPokojeWolne6os2 = new javax.swing.JLabel();
        labelPokojeWolne5os2 = new javax.swing.JLabel();
        panelKlienci = new javax.swing.JPanel();
        labelStatystykiKlienci = new javax.swing.JLabel();
        labelWszyscyKlienci = new javax.swing.JLabel();
        labelWszyscyKlienci2 = new javax.swing.JLabel();
        labelSredniaWieku = new javax.swing.JLabel();
        labelSredniaWieku2 = new javax.swing.JLabel();
        labelKobietyMezczyzni = new javax.swing.JLabel();
        labelKobietyMezczyzni2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelStatystykiKlienci1 = new javax.swing.JLabel();
        labelWszyscyPracownicy = new javax.swing.JLabel();
        labelWszyscyPracownicy2 = new javax.swing.JLabel();
        labelNajwiecejRezerwacji = new javax.swing.JLabel();
        labelNajwiecejRezerwacji2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGlowny.setBackground(new java.awt.Color(102, 102, 102));

        panelTytulowy.setBackground(new java.awt.Color(51, 51, 51));

        labelTytulowy.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        labelTytulowy.setForeground(new java.awt.Color(255, 255, 255));
        labelTytulowy.setText("Statystyki");

        javax.swing.GroupLayout panelTytulowyLayout = new javax.swing.GroupLayout(panelTytulowy);
        panelTytulowy.setLayout(panelTytulowyLayout);
        panelTytulowyLayout.setHorizontalGroup(
            panelTytulowyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTytulowyLayout.createSequentialGroup()
                .addGap(284, 284, 284)
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
        labelZalogowano.setForeground(new java.awt.Color(255, 255, 255));
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

        labelStatystyki.setFont(new java.awt.Font("Cambria", 1, 28)); // NOI18N
        labelStatystyki.setForeground(new java.awt.Color(255, 255, 255));
        labelStatystyki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatystyki.setText("Statystyki");
        labelStatystyki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                .addComponent(labelRozliczenie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(labelStatystyki, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
        labelZalogowano1.setForeground(new java.awt.Color(255, 255, 255));
        labelZalogowano1.setText("Zalogowano jako");

        panelRezerwacje.setBackground(new java.awt.Color(51, 51, 51));
        panelRezerwacje.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N

        labelStatystykiRezerwacje.setBackground(new java.awt.Color(255, 255, 255));
        labelStatystykiRezerwacje.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        labelStatystykiRezerwacje.setForeground(new java.awt.Color(255, 255, 255));
        labelStatystykiRezerwacje.setText("Rezerwacje");

        labelWszystkieRezerwacje.setBackground(new java.awt.Color(255, 255, 255));
        labelWszystkieRezerwacje.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelWszystkieRezerwacje.setForeground(new java.awt.Color(255, 255, 255));
        labelWszystkieRezerwacje.setText("Wszystkie rezerwacje:");

        labelAktywneRezerwacje.setBackground(new java.awt.Color(255, 255, 255));
        labelAktywneRezerwacje.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelAktywneRezerwacje.setForeground(new java.awt.Color(255, 255, 255));
        labelAktywneRezerwacje.setText("Aktywne rezerwacje:");

        labelRezerwacjeDzis.setBackground(new java.awt.Color(255, 255, 255));
        labelRezerwacjeDzis.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelRezerwacjeDzis.setForeground(new java.awt.Color(255, 255, 255));
        labelRezerwacjeDzis.setText("Rezerwacje dziś:");

        labelSredniPobyt.setBackground(new java.awt.Color(255, 255, 255));
        labelSredniPobyt.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelSredniPobyt.setForeground(new java.awt.Color(255, 255, 255));
        labelSredniPobyt.setText("Średnia długość pobytu:");

        labelSredniKoszt.setBackground(new java.awt.Color(255, 255, 255));
        labelSredniKoszt.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelSredniKoszt.setForeground(new java.awt.Color(255, 255, 255));
        labelSredniKoszt.setText("Średni koszt:");

        labelRezerwacjeDzis2.setBackground(new java.awt.Color(255, 255, 255));
        labelRezerwacjeDzis2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelRezerwacjeDzis2.setForeground(new java.awt.Color(255, 255, 255));
        labelRezerwacjeDzis2.setText("OUT");

        labelSredniPobyt2.setBackground(new java.awt.Color(255, 255, 255));
        labelSredniPobyt2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelSredniPobyt2.setForeground(new java.awt.Color(255, 255, 255));
        labelSredniPobyt2.setText("OUT");

        labelSredniKoszt2.setBackground(new java.awt.Color(255, 255, 255));
        labelSredniKoszt2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelSredniKoszt2.setForeground(new java.awt.Color(255, 255, 255));
        labelSredniKoszt2.setText("OUT");

        labelAktywneRezerwacje2.setBackground(new java.awt.Color(255, 255, 255));
        labelAktywneRezerwacje2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelAktywneRezerwacje2.setForeground(new java.awt.Color(255, 255, 255));
        labelAktywneRezerwacje2.setText("OUT");

        labelWszystkieRezerwacje2.setBackground(new java.awt.Color(255, 255, 255));
        labelWszystkieRezerwacje2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelWszystkieRezerwacje2.setForeground(new java.awt.Color(255, 255, 255));
        labelWszystkieRezerwacje2.setText("OUT");

        javax.swing.GroupLayout panelRezerwacjeLayout = new javax.swing.GroupLayout(panelRezerwacje);
        panelRezerwacje.setLayout(panelRezerwacjeLayout);
        panelRezerwacjeLayout.setHorizontalGroup(
            panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRezerwacjeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRezerwacjeLayout.createSequentialGroup()
                        .addComponent(labelAktywneRezerwacje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAktywneRezerwacje2))
                    .addGroup(panelRezerwacjeLayout.createSequentialGroup()
                        .addComponent(labelRezerwacjeDzis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRezerwacjeDzis2))
                    .addGroup(panelRezerwacjeLayout.createSequentialGroup()
                        .addComponent(labelWszystkieRezerwacje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWszystkieRezerwacje2))
                    .addGroup(panelRezerwacjeLayout.createSequentialGroup()
                        .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRezerwacjeLayout.createSequentialGroup()
                                .addComponent(labelSredniKoszt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelSredniKoszt2))
                            .addComponent(labelSredniPobyt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSredniPobyt2))
                    .addComponent(labelStatystykiRezerwacje))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelRezerwacjeLayout.setVerticalGroup(
            panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRezerwacjeLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelStatystykiRezerwacje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWszystkieRezerwacje)
                    .addComponent(labelWszystkieRezerwacje2))
                .addGap(33, 33, 33)
                .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAktywneRezerwacje)
                    .addComponent(labelAktywneRezerwacje2))
                .addGap(33, 33, 33)
                .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRezerwacjeDzis)
                    .addComponent(labelRezerwacjeDzis2))
                .addGap(33, 33, 33)
                .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSredniPobyt)
                    .addComponent(labelSredniPobyt2))
                .addGap(33, 33, 33)
                .addGroup(panelRezerwacjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSredniKoszt)
                    .addComponent(labelSredniKoszt2))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        panelPokoje.setBackground(new java.awt.Color(51, 51, 51));
        panelPokoje.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N

        labelStatystykiPokoje.setBackground(new java.awt.Color(255, 255, 255));
        labelStatystykiPokoje.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        labelStatystykiPokoje.setForeground(new java.awt.Color(255, 255, 255));
        labelStatystykiPokoje.setText("Pokoje");

        labelWszystkiePokoje.setBackground(new java.awt.Color(255, 255, 255));
        labelWszystkiePokoje.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelWszystkiePokoje.setForeground(new java.awt.Color(255, 255, 255));
        labelWszystkiePokoje.setText("Wszystkie pokoje:");

        labelPokojeWolneZajete.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolneZajete.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolneZajete.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolneZajete.setText("Pokoje wolne/zajęte:");

        labelPokojeNieczynne.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeNieczynne.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeNieczynne.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeNieczynne.setText("Pokoje nieczynne:");

        labelPokojeWolne1os.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne1os.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolne1os.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne1os.setText("Pokoje wolne 1os:");

        labelPokojeWolne2os.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne2os.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolne2os.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne2os.setText("Pokoje wolne 2os:");

        labelPokojeWolne3os.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne3os.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolne3os.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne3os.setText("Pokoje wolne 3os:");

        labelPokojeWolne5os.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne5os.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolne5os.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne5os.setText("Pokoje wolne 5os:");

        labelPokojeWolne6os.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne6os.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolne6os.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne6os.setText("Pokoje wolne 6os:");

        labelPokojeWolne4os.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne4os.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelPokojeWolne4os.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne4os.setText("Pokoje wolne 4os:");

        labelWszystkiePokoje2.setBackground(new java.awt.Color(255, 255, 255));
        labelWszystkiePokoje2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelWszystkiePokoje2.setForeground(new java.awt.Color(255, 255, 255));
        labelWszystkiePokoje2.setText("OUT");

        labelPokojeNieczynne2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeNieczynne2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeNieczynne2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeNieczynne2.setText("OUT");

        labelPokojeWolneZajete2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolneZajete2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolneZajete2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolneZajete2.setText("OUT");

        labelPokojeWolne1os2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne1os2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolne1os2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne1os2.setText("OUT");

        labelPokojeWolne2os2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne2os2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolne2os2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne2os2.setText("OUT");

        labelPokojeWolne4os2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne4os2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolne4os2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne4os2.setText("OUT");

        labelPokojeWolne3os2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne3os2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolne3os2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne3os2.setText("OUT");

        labelPokojeWolne6os2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne6os2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolne6os2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne6os2.setText("OUT");

        labelPokojeWolne5os2.setBackground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne5os2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelPokojeWolne5os2.setForeground(new java.awt.Color(255, 255, 255));
        labelPokojeWolne5os2.setText("OUT");

        javax.swing.GroupLayout panelPokojeLayout = new javax.swing.GroupLayout(panelPokoje);
        panelPokoje.setLayout(panelPokojeLayout);
        panelPokojeLayout.setHorizontalGroup(
            panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPokojeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelStatystykiPokoje)
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelWszystkiePokoje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWszystkiePokoje2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolneZajete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolneZajete2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeNieczynne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeNieczynne2)))
                .addGap(21, 21, 21)
                .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolne4os)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolne4os2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolne6os)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolne6os2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolne5os)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolne5os2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolne2os)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolne2os2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolne3os)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolne3os2))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addComponent(labelPokojeWolne1os)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPokojeWolne1os2)))
                .addGap(21, 21, 21))
        );
        panelPokojeLayout.setVerticalGroup(
            panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPokojeLayout.createSequentialGroup()
                .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelStatystykiPokoje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelWszystkiePokoje)
                            .addComponent(labelWszystkiePokoje2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeWolneZajete)
                            .addComponent(labelPokojeWolneZajete2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeNieczynne)
                            .addComponent(labelPokojeNieczynne2)))
                    .addGroup(panelPokojeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeWolne1os)
                            .addComponent(labelPokojeWolne1os2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeWolne2os)
                            .addComponent(labelPokojeWolne2os2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeWolne3os)
                            .addComponent(labelPokojeWolne3os2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPokojeWolne4os2)
                            .addComponent(labelPokojeWolne4os, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(6, 6, 6)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeWolne5os)
                            .addComponent(labelPokojeWolne5os2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPokojeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPokojeWolne6os)
                            .addComponent(labelPokojeWolne6os2))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        panelKlienci.setBackground(new java.awt.Color(51, 51, 51));
        panelKlienci.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N

        labelStatystykiKlienci.setBackground(new java.awt.Color(255, 255, 255));
        labelStatystykiKlienci.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        labelStatystykiKlienci.setForeground(new java.awt.Color(255, 255, 255));
        labelStatystykiKlienci.setText("Klienci");

        labelWszyscyKlienci.setBackground(new java.awt.Color(255, 255, 255));
        labelWszyscyKlienci.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelWszyscyKlienci.setForeground(new java.awt.Color(255, 255, 255));
        labelWszyscyKlienci.setText("Wszyscy klienci:");

        labelWszyscyKlienci2.setBackground(new java.awt.Color(255, 255, 255));
        labelWszyscyKlienci2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelWszyscyKlienci2.setForeground(new java.awt.Color(255, 255, 255));
        labelWszyscyKlienci2.setText("OUT");

        labelSredniaWieku.setBackground(new java.awt.Color(255, 255, 255));
        labelSredniaWieku.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelSredniaWieku.setForeground(new java.awt.Color(255, 255, 255));
        labelSredniaWieku.setText("Średnia wieku:");

        labelSredniaWieku2.setBackground(new java.awt.Color(255, 255, 255));
        labelSredniaWieku2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelSredniaWieku2.setForeground(new java.awt.Color(255, 255, 255));
        labelSredniaWieku2.setText("OUT");

        labelKobietyMezczyzni.setBackground(new java.awt.Color(255, 255, 255));
        labelKobietyMezczyzni.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelKobietyMezczyzni.setForeground(new java.awt.Color(255, 255, 255));
        labelKobietyMezczyzni.setText("Kobiety/Mężczyźni:");

        labelKobietyMezczyzni2.setBackground(new java.awt.Color(255, 255, 255));
        labelKobietyMezczyzni2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelKobietyMezczyzni2.setForeground(new java.awt.Color(255, 255, 255));
        labelKobietyMezczyzni2.setText("OUT");

        javax.swing.GroupLayout panelKlienciLayout = new javax.swing.GroupLayout(panelKlienci);
        panelKlienci.setLayout(panelKlienciLayout);
        panelKlienciLayout.setHorizontalGroup(
            panelKlienciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKlienciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKlienciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelStatystykiKlienci)
                    .addGroup(panelKlienciLayout.createSequentialGroup()
                        .addComponent(labelWszyscyKlienci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelWszyscyKlienci2))
                    .addGroup(panelKlienciLayout.createSequentialGroup()
                        .addComponent(labelSredniaWieku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSredniaWieku2))
                    .addGroup(panelKlienciLayout.createSequentialGroup()
                        .addComponent(labelKobietyMezczyzni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelKobietyMezczyzni2)))
                .addGap(25, 25, 25))
        );
        panelKlienciLayout.setVerticalGroup(
            panelKlienciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKlienciLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelStatystykiKlienci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelKlienciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWszyscyKlienci)
                    .addComponent(labelWszyscyKlienci2))
                .addGap(33, 33, 33)
                .addGroup(panelKlienciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSredniaWieku)
                    .addComponent(labelSredniaWieku2))
                .addGap(33, 33, 33)
                .addGroup(panelKlienciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKobietyMezczyzni)
                    .addComponent(labelKobietyMezczyzni2))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        labelStatystykiKlienci1.setBackground(new java.awt.Color(255, 255, 255));
        labelStatystykiKlienci1.setFont(new java.awt.Font("Cambria", 1, 20)); // NOI18N
        labelStatystykiKlienci1.setForeground(new java.awt.Color(255, 255, 255));
        labelStatystykiKlienci1.setText("Pracownicy");

        labelWszyscyPracownicy.setBackground(new java.awt.Color(255, 255, 255));
        labelWszyscyPracownicy.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelWszyscyPracownicy.setForeground(new java.awt.Color(255, 255, 255));
        labelWszyscyPracownicy.setText("Wszyscy pracownicy:");

        labelWszyscyPracownicy2.setBackground(new java.awt.Color(255, 255, 255));
        labelWszyscyPracownicy2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelWszyscyPracownicy2.setForeground(new java.awt.Color(255, 255, 255));
        labelWszyscyPracownicy2.setText("OUT");

        labelNajwiecejRezerwacji.setBackground(new java.awt.Color(255, 255, 255));
        labelNajwiecejRezerwacji.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        labelNajwiecejRezerwacji.setForeground(new java.awt.Color(255, 255, 255));
        labelNajwiecejRezerwacji.setText("Najnowszy pracownik:");

        labelNajwiecejRezerwacji2.setBackground(new java.awt.Color(255, 255, 255));
        labelNajwiecejRezerwacji2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        labelNajwiecejRezerwacji2.setForeground(new java.awt.Color(255, 255, 255));
        labelNajwiecejRezerwacji2.setText("OUT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelStatystykiKlienci1)
                    .addComponent(labelWszyscyPracownicy)
                    .addComponent(labelNajwiecejRezerwacji)
                    .addComponent(labelNajwiecejRezerwacji2)
                    .addComponent(labelWszyscyPracownicy2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelStatystykiKlienci1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelWszyscyPracownicy)
                .addGap(5, 5, 5)
                .addComponent(labelWszyscyPracownicy2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNajwiecejRezerwacji)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNajwiecejRezerwacji2)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGlownyLayout = new javax.swing.GroupLayout(panelGlowny);
        panelGlowny.setLayout(panelGlownyLayout);
        panelGlownyLayout.setHorizontalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTytulowy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelOpcji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addComponent(panelRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlownyLayout.createSequentialGroup()
                                .addComponent(panelKlienci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panelPokoje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addComponent(labelZalogowano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelZalogowano1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelGlownyLayout.setVerticalGroup(
            panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlownyLayout.createSequentialGroup()
                .addComponent(panelTytulowy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelOpcji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRezerwacje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGlownyLayout.createSequentialGroup()
                        .addComponent(panelPokoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelKlienci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGlownyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonWyjscie, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelZalogowano)
                    .addComponent(labelZalogowano1))
                .addGap(12, 12, 12))
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

    private void labelRezerwacjeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRezerwacjeMouseClicked
        new Rezerwacje().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_labelRezerwacjeMouseClicked

    private void labelRozliczenieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRozliczenieMouseClicked
        new Rozliczenie().setVisible(rootPaneCheckingEnabled);
        dispose();

    }//GEN-LAST:event_labelRozliczenieMouseClicked

    private void buttonWyjscieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonWyjscieMouseClicked
        new Logowanie().setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_buttonWyjscieMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Statystyki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statystyki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statystyki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statystyki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statystyki().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonWyjscie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAktywneRezerwacje;
    private javax.swing.JLabel labelAktywneRezerwacje2;
    private javax.swing.JLabel labelKlienci;
    private javax.swing.JLabel labelKobietyMezczyzni;
    private javax.swing.JLabel labelKobietyMezczyzni2;
    private javax.swing.JLabel labelMenu;
    private javax.swing.JLabel labelNajwiecejRezerwacji;
    private javax.swing.JLabel labelNajwiecejRezerwacji2;
    private javax.swing.JLabel labelPokoje;
    private javax.swing.JLabel labelPokojeNieczynne;
    private javax.swing.JLabel labelPokojeNieczynne2;
    private javax.swing.JLabel labelPokojeWolne1os;
    private javax.swing.JLabel labelPokojeWolne1os2;
    private javax.swing.JLabel labelPokojeWolne2os;
    private javax.swing.JLabel labelPokojeWolne2os2;
    private javax.swing.JLabel labelPokojeWolne3os;
    private javax.swing.JLabel labelPokojeWolne3os2;
    private javax.swing.JLabel labelPokojeWolne4os;
    private javax.swing.JLabel labelPokojeWolne4os2;
    private javax.swing.JLabel labelPokojeWolne5os;
    private javax.swing.JLabel labelPokojeWolne5os2;
    private javax.swing.JLabel labelPokojeWolne6os;
    private javax.swing.JLabel labelPokojeWolne6os2;
    private javax.swing.JLabel labelPokojeWolneZajete;
    private javax.swing.JLabel labelPokojeWolneZajete2;
    private javax.swing.JLabel labelRezerwacje;
    private javax.swing.JLabel labelRezerwacjeDzis;
    private javax.swing.JLabel labelRezerwacjeDzis2;
    private javax.swing.JLabel labelRozliczenie;
    private javax.swing.JLabel labelSredniKoszt;
    private javax.swing.JLabel labelSredniKoszt2;
    private javax.swing.JLabel labelSredniPobyt;
    private javax.swing.JLabel labelSredniPobyt2;
    private javax.swing.JLabel labelSredniaWieku;
    private javax.swing.JLabel labelSredniaWieku2;
    private javax.swing.JLabel labelStatystyki;
    private javax.swing.JLabel labelStatystykiKlienci;
    private javax.swing.JLabel labelStatystykiKlienci1;
    private javax.swing.JLabel labelStatystykiPokoje;
    private javax.swing.JLabel labelStatystykiRezerwacje;
    private javax.swing.JLabel labelTytulowy;
    private javax.swing.JLabel labelWszyscyKlienci;
    private javax.swing.JLabel labelWszyscyKlienci2;
    private javax.swing.JLabel labelWszyscyPracownicy;
    private javax.swing.JLabel labelWszyscyPracownicy2;
    private javax.swing.JLabel labelWszystkiePokoje;
    private javax.swing.JLabel labelWszystkiePokoje2;
    private javax.swing.JLabel labelWszystkieRezerwacje;
    private javax.swing.JLabel labelWszystkieRezerwacje2;
    private javax.swing.JLabel labelZalogowano;
    private javax.swing.JLabel labelZalogowano1;
    private javax.swing.JPanel panelGlowny;
    private javax.swing.JPanel panelKlienci;
    private javax.swing.JPanel panelOpcji;
    private javax.swing.JPanel panelPokoje;
    private javax.swing.JPanel panelRezerwacje;
    private javax.swing.JPanel panelTytulowy;
    // End of variables declaration//GEN-END:variables
}
