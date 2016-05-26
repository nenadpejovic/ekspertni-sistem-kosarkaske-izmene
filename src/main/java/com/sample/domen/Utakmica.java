package com.sample.domen;

import com.sample.domen.Igrac;

public class Utakmica {
	
	Igrac plej;
	Igrac bek;
	Igrac krilo;
	Igrac krilniCentar;
	Igrac centar;
	Igrac rezervniPlej;
	Igrac rezervniBek;
	Igrac rezervnoKrilo;
	Igrac rezervniKrilniCentar;
	Igrac rezervniCentar;
	Igrac centarKrilniCentar;
	Igrac plejBek;
	StringBuffer objasnjenje = new StringBuffer();
	
	int rezultat;
	double minut;
	String taktika;
	String kvalitetProtivnickeEkipe;
	int licneGreskeDoBonusa;
	boolean domacin;
	boolean vaznostUtakmice;
	boolean posed;
	
	Igrac protivnickiPlej;
	Igrac protivnickiBek;
	Igrac protivnickoKrilo;
	Igrac protivnickiKrilniCentar;
	Igrac protivnickiCentar;
	
	String izmena;

	public Igrac getPlej() {
		return plej;
	}

	public void setPlej(Igrac plej) {
		this.plej = plej;
	}

	public Igrac getBek() {
		return bek;
	}

	public void setBek(Igrac bek) {
		this.bek = bek;
	}

	public Igrac getKrilo() {
		return krilo;
	}

	public void setKrilo(Igrac krilo) {
		this.krilo = krilo;
	}

	public Igrac getKrilniCentar() {
		return krilniCentar;
	}

	public void setKrilniCentar(Igrac krilniCentar) {
		this.krilniCentar = krilniCentar;
	}

	public Igrac getCentar() {
		return centar;
	}

	public void setCentar(Igrac centar) {
		this.centar = centar;
	}

	public Igrac getRezervniPlej() {
		return rezervniPlej;
	}

	public void setRezervniPlej(Igrac rezervniPlej) {
		this.rezervniPlej = rezervniPlej;
	}

	public Igrac getRezervniBek() {
		return rezervniBek;
	}

	public void setRezervniBek(Igrac rezervniBek) {
		this.rezervniBek = rezervniBek;
	}

	public Igrac getRezervnoKrilo() {
		return rezervnoKrilo;
	}

	public void setRezervnoKrilo(Igrac rezervnoKrilo) {
		this.rezervnoKrilo = rezervnoKrilo;
	}

	public Igrac getRezervniKrilniCentar() {
		return rezervniKrilniCentar;
	}

	public void setRezervniKrilniCentar(Igrac rezervniKrilniCentar) {
		this.rezervniKrilniCentar = rezervniKrilniCentar;
	}

	public Igrac getRezervniCentar() {
		return rezervniCentar;
	}

	public void setRezervniCentar(Igrac rezervniCentar) {
		this.rezervniCentar = rezervniCentar;
	}

	public Igrac getCentarKrilniCentar() {
		return centarKrilniCentar;
	}

	public void setCentarKrilniCentar(Igrac centarKrilniCentar) {
		this.centarKrilniCentar = centarKrilniCentar;
	}

	public Igrac getPlejBek() {
		return plejBek;
	}

	public void setPlejBek(Igrac plejBek) {
		this.plejBek = plejBek;
	}

	public int getRezultat() {
		return rezultat;
	}

	public void setRezultat(int rezultat) {
		this.rezultat = rezultat;
	}

	public double getMinut() {
		return minut;
	}

	public void setMinut(double minut) {
		this.minut = minut;
	}

	public String getTaktika() {
		return taktika;
	}

	public void setTaktika(String taktika) {
		this.taktika = taktika;
	}

	public String getKvalitetProtivnickeEkipe() {
		return kvalitetProtivnickeEkipe;
	}

	public void setKvalitetProtivnickeEkipe(String kvalitetProtivnickeEkipe) {
		this.kvalitetProtivnickeEkipe = kvalitetProtivnickeEkipe;
	}

	public int getLicneGreskeDoBonusa() {
		return licneGreskeDoBonusa;
	}

	public void setLicneGreskeDoBonusa(int licneGreskeDoBonusa) {
		this.licneGreskeDoBonusa = licneGreskeDoBonusa;
	}

	public boolean isDomacin() {
		return domacin;
	}

	public void setDomacin(boolean domacin) {
		this.domacin = domacin;
	}

	public boolean isVaznostUtakmice() {
		return vaznostUtakmice;
	}

	public void setVaznostUtakmice(boolean vaznostUtakmice) {
		this.vaznostUtakmice = vaznostUtakmice;
	}

	public boolean isPosed() {
		return posed;
	}

	public void setPosed(boolean posed) {
		this.posed = posed;
	}

	public Igrac getProtivnickiPlej() {
		return protivnickiPlej;
	}

	public void setProtivnickiPlej(Igrac protivnickiPlej) {
		this.protivnickiPlej = protivnickiPlej;
	}

	public Igrac getProtivnickiBek() {
		return protivnickiBek;
	}

	public void setProtivnickiBek(Igrac protivnickiBek) {
		this.protivnickiBek = protivnickiBek;
	}

	public Igrac getProtivnickoKrilo() {
		return protivnickoKrilo;
	}

	public void setProtivnickoKrilo(Igrac protivnickoKrilo) {
		this.protivnickoKrilo = protivnickoKrilo;
	}

	public Igrac getProtivnickiKrilniCentar() {
		return protivnickiKrilniCentar;
	}

	public void setProtivnickiKrilniCentar(Igrac protivnickiKrilniCentar) {
		this.protivnickiKrilniCentar = protivnickiKrilniCentar;
	}

	public Igrac getProtivnickiCentar() {
		return protivnickiCentar;
	}

	public void setProtivnickiCentar(Igrac protivnickiCentar) {
		this.protivnickiCentar = protivnickiCentar;
	}

	public String getIzmena() {
		return izmena;
	}

	public void setIzmena(String izmena) {
		this.izmena = izmena;
	}

	public String getObjasnjenje() {
		return objasnjenje.toString();
	}
	
	public void dodajObjasnjenje(String tekst){
		objasnjenje.append(tekst);
	}
}
	
	


