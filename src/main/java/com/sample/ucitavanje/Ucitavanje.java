package com.sample.ucitavanje;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sample.db.*;
import com.sample.domen.*;


public class Ucitavanje {

	WebScraper ws;
	DBKomunikacija db;
	
	public Ucitavanje(){
		ws = new WebScraper();
		db = new DBKomunikacija();
	}
	
	public void otvoriSajt(String url){
		ws.opetTestSite(url);
	}
	
	public List<Igrac> ucitajNaseIgrace(List<Igrac> ls) throws IOException, SQLException{
		int i = 1;
		for(Igrac igrac: ls){
			if(i<10){
			igrac = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_LocalClubStats_repTeamStats_ctl0"+i+"_row", igrac);
			i++;
			} else {
				igrac = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_LocalClubStats_repTeamStats_ctl"+i+"_row", igrac);
				i++;
			}
			igrac = ws.ucitajDokument("http://www.basketball-reference.com/euro/players/"+igrac.getIme().toLowerCase()+"-"+igrac.getPrezime().toLowerCase()+"-1.html", igrac);
		
			igrac = postaviPodatkeIzBaze(igrac);
		}
		return ls;
	}
	
	public List<Igrac> ucitajProtivnickeIgrace(List<Igrac> ls) throws IOException, SQLException{
		Igrac i1 = ls.get(0);
		Igrac i2 = ls.get(1);
		Igrac i3 = ls.get(2);
		Igrac i4 = ls.get(3);
		Igrac i5 = ls.get(4);
        i1 = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_RoadClubStats_repTeamStats_ctl03_row", i1);
        i2 = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_RoadClubStats_repTeamStats_ctl06_row", i2);
        i3 = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_RoadClubStats_repTeamStats_ctl04_row", i3);
        i4 = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_RoadClubStats_repTeamStats_ctl08_row", i4);
        i5 = ws.setStatistikaIgracaNaUtakmici("ctl00_ctl00_ctl00_ctl00_maincontainer_maincontent_contentpane_boxscorepane_ctl00_RoadClubStats_repTeamStats_ctl12_row", i5);
		
		for(Igrac igrac: ls){
			igrac = ws.ucitajDokument("http://www.basketball-reference.com/euro/players/"+igrac.getIme().toLowerCase()+"-"+igrac.getPrezime().toLowerCase()+"-1.html", igrac);
			igrac = postaviPodatkeIzBaze(igrac);
		}
		
		return ls;
	}
	
	public Utakmica postaviUtakmicu(Utakmica u){
		return ws.postaviUtakmicu(u);
	}
	
	public void upisiUJson() throws IOException{
		ws.upisiJson();
	}
	
	public void zatvoriPregledac(){
		ws.close();
	}
	
	private Igrac postaviPodatkeIzBaze(Igrac i) throws SQLException{
		i.setVisina(db.vratiVisinuIgraca(i.getIme(), i.getPrezime()));
		i.setTezina(db.vratiTezinuIgraca(i.getIme(), i.getPrezime()));
		i.setKvalitetOdbrambeneIgre(db.vratiKvalitetOdbranbeneIgreIgraca(i.getIme(), i.getPrezime()));
		i.setPozicija(db.vratiPozicijuIgraca(i.getIme(), i.getPrezime()));
		return i;
	}
}
