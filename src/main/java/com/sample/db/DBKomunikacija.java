package com.sample.db;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBKomunikacija {
    
    Connection konekcija;
    
    public void ucitajDrajver(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Nije ucitan drajver");
        }
    }
    
    public void otvoriKonekciju(){
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteligentnisistemi", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.err.println("Nije otvorena konekcija");        }
    }
    
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
        } catch (SQLException ex) {
            System.err.println("Nije zatvorena konekcija");
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            System.out.println("Nije izvrsen commit");
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            System.out.println("Nije izvrsen rollback");    
        }
    }
    
    public String vratiPoziciju(String ime,String prezime) throws SQLException{
    	String upit = "SELECT pozicija FROM kosarkas WHERE ime='"+ime+"' AND prezime='"+prezime+"'";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        String pozicija=null;
        while(rs.next()){
        	pozicija = rs.getString("pozicija");
        }
        rs.close();
        s.close();
        return pozicija;
    }
    
    public int vratiVisinu(String ime,String prezime) throws SQLException{
    	String upit = "SELECT visina FROM kosarkas WHERE ime='"+ime+"' AND prezime='"+prezime+"'";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        int visina=0;
        while(rs.next()){
        	visina = rs.getInt("visina");
        }
        rs.close();
        s.close();
        return visina;
    }
    
    public int vratiTezinu(String ime,String prezime) throws SQLException{
    	String upit = "SELECT tezina FROM kosarkas WHERE ime='"+ime+"' AND prezime='"+prezime+"'";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        int tezina=0;
        while(rs.next()){
        	tezina = rs.getInt("tezina");
        }
        rs.close();
        s.close();
        return tezina;
    }
    
    public String vratiKvalitetOdbranbeneIgra(String ime,String prezime) throws SQLException{
    	String upit = "SELECT kvalitetOdbranbeneIgre FROM kosarkas WHERE ime='"+ime+"' AND prezime='"+prezime+"'";
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        String kvalitet=null;
        while(rs.next()){
        	kvalitet = rs.getString("kvalitetOdbranbeneIgre");
        }
        rs.close();
        s.close();
        return kvalitet;
    }
    
    public String vratiPozicijuIgraca(String ime,String prezime) throws SQLException{
    	ucitajDrajver();
    	otvoriKonekciju();
    	String pozicija = vratiPoziciju(ime,prezime);
    	zatvoriKonekciju();
    	return pozicija;
    }
    
    public String vratiKvalitetOdbranbeneIgreIgraca(String ime,String prezime) throws SQLException{
    	ucitajDrajver();
    	otvoriKonekciju();
    	String pozicija = vratiKvalitetOdbranbeneIgra(ime, prezime);
    	zatvoriKonekciju();
    	return pozicija;
    }
    
    public int vratiVisinuIgraca(String ime,String prezime) throws SQLException{
    	ucitajDrajver();
    	otvoriKonekciju();
    	int visina = vratiVisinu(ime, prezime);
    	zatvoriKonekciju();
    	return visina;
    }
    
    public int vratiTezinuIgraca(String ime,String prezime) throws SQLException{
    	ucitajDrajver();
    	otvoriKonekciju();
    	int tezina = vratiTezinu(ime, prezime);
    	zatvoriKonekciju();
    	return tezina;
    }

}

