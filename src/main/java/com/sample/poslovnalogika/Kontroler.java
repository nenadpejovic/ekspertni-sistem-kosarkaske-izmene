package com.sample.poslovnalogika;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.drools.compiler.lang.DRL5Expressions.instanceof_key_return;

import com.sample.test.DroolsTester;
import com.sample.ucitavanje.Ucitavanje;
import com.sample.domen.*;
public class Kontroler {

	private static Kontroler instance;
	private Ucitavanje ucitavanje;
	private DroolsTester dt;
	
	private Kontroler(){
		ucitavanje = new Ucitavanje();
		dt = new DroolsTester();
	}
	
	public static Kontroler getInstance(){
		if(instance == null){
			instance = new Kontroler();
		}
		return instance;
	}
	
	public void postaviDroolsPostavke(){
		dt.postaviDroolsPostavke();
	}
	
	public void inicijalizuj(){
		dt.inicijalizuj();
	}
	
	public List<Igrac> vratiNaseIgrace(){
		return dt.vratiNase();
	}

	public List<Igrac> vratiProtivnickeIgrace(){
		return dt.vratiProtivnicke();
	}
	
	public void otvoriPregledac(String url){
		ucitavanje.otvoriSajt(url);
	}
	
	public Utakmica vratiUtakmicu(){
		return dt.vratiUtakmicu();
	}
	
	public void zatvoriPregledac(){
		ucitavanje.zatvoriPregledac();
	}
	
	public void upisiUJSON() throws IOException{
		ucitavanje.upisiUJson();
	}
	
	public List<Igrac> vratiNaseIgrace(List<Igrac> ls) throws IOException, SQLException{
		return ucitavanje.ucitajNaseIgrace(ls);
	}
	
	public List<Igrac> vratiProtivnickeIgrace(List<Igrac> ls) throws IOException, SQLException{
		return ucitavanje.ucitajProtivnickeIgrace(ls);
	}
	
	public Utakmica postaviUtakmicu(Utakmica u){
		return ucitavanje.postaviUtakmicu(u);
	}
	
	public void izvrsiPravila(){
		dt.izvrsiPravila();
	}
	
	public void postaviIgrace(){
		dt.postaviIgrace();
	}
}
