package com.sample.domen;

public class Igrac {

	String ime;
	String prezime;
	
	String pozicija;

	int visina;
	int tezina;
	
	double procenatSuta1;
	double prosecanProcenatSuta1;
	double procenatSuta2;
	double prosecanProcenatSuta2;
	double procenatSuta3;
	double prosecanProcenatSuta3;
	
	int brojPoena;
	double prosecanBrojPoena;
	int skokovi;
	double prosecanBrojSkokova;
	int ukradeneLopte;
	int asistencije;
	double prosecanBrojAsistencija;
	double prosecanBrojUkradenihLopti;
	int izgubljeneLopte;
	double prosecanBrojIzgubljenihLopti;
	double vreme;
	double prosecnoVreme;
	int blokade;
	double prosecanBrojBlokada;
	
	int indexForme;
	double indexUmora;
	
	int brLicnihGreski;
	
	boolean povredjen;
	boolean iskljucen;
	
	String kvalitetOdbrambeneIgre;

	public String getPozicija() {
		return pozicija;
	}

	public void setPozicija(String pozicija) {
		this.pozicija = pozicija;
	}
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}
	
	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}
	
	


	public double getProcenatSuta1() {
		return procenatSuta1;
	}

	public void setProcenatSuta1(double procenatSuta1) {
		this.procenatSuta1 = procenatSuta1;
	}

	public double getProsecanProcenatSuta1() {
		return prosecanProcenatSuta1;
	}

	public void setProsecanProcenatSuta1(double prosecanProcenatSuta1) {
		this.prosecanProcenatSuta1 = prosecanProcenatSuta1;
	}

	public double getProcenatSuta2() {
		return procenatSuta2;
	}

	public void setProcenatSuta2(double procenatSuta2) {
		this.procenatSuta2 = procenatSuta2;
	}

	public double getProsecanProcenatSuta2() {
		return prosecanProcenatSuta2;
	}

	public void setProsecanProcenatSuta2(double prosecanProcenatSuta2) {
		this.prosecanProcenatSuta2 = prosecanProcenatSuta2;
	}

	public double getProcenatSuta3() {
		return procenatSuta3;
	}

	public void setProcenatSuta3(double procenatSuta3) {
		this.procenatSuta3 = procenatSuta3;
	}

	public double getProsecanProcenatSuta3() {
		return prosecanProcenatSuta3;
	}

	public void setProsecanProcenatSuta3(double prosecanProcenatSuta3) {
		this.prosecanProcenatSuta3 = prosecanProcenatSuta3;
	}

	public int getBrojPoena() {
		return brojPoena;
	}

	public void setBrojPoena(int brojPoena) {
		this.brojPoena = brojPoena;
	}

	public double getProsecanBrojPoena() {
		return prosecanBrojPoena;
	}

	public void setProsecanBrojPoena(double prosecanBrojPoena) {
		this.prosecanBrojPoena = prosecanBrojPoena;
	}

	public int getSkokovi() {
		return skokovi;
	}

	public void setSkokovi(int skokovi) {
		this.skokovi = skokovi;
	}

	public double getProsecanBrojSkokova() {
		return prosecanBrojSkokova;
	}

	public void setProsecanBrojSkokova(double prosecanBrojSkokova) {
		this.prosecanBrojSkokova = prosecanBrojSkokova;
	}

	public int getUkradeneLopte() {
		return ukradeneLopte;
	}

	public void setUkradeneLopte(int ukradeneLopte) {
		this.ukradeneLopte = ukradeneLopte;
	}

	public double getProsecanBrojUkradenihLopti() {
		return prosecanBrojUkradenihLopti;
	}

	public void setProsecanBrojUkradenihLopti(double prosecanBrojUkradenihLopti) {
		this.prosecanBrojUkradenihLopti = prosecanBrojUkradenihLopti;
	}

	public int getIzgubljeneLopte() {
		return izgubljeneLopte;
	}

	public void setIzgubljeneLopte(int izgubljeneLopte) {
		this.izgubljeneLopte = izgubljeneLopte;
	}

	public double getProsecanBrojIzgubljenihLopti() {
		return prosecanBrojIzgubljenihLopti;
	}

	public void setProsecanBrojIzgubljenihLopti(double prosecanBrojIzgubljenihLopti) {
		this.prosecanBrojIzgubljenihLopti = prosecanBrojIzgubljenihLopti;
	}

	public double getVreme() {
		return vreme;
	}

	public void setVreme(double vreme) {
		this.vreme = vreme;
	}

	public double getProsecnoVreme() {
		return prosecnoVreme;
	}

	public void setProsecnoVreme(double prosecnoVreme) {
		this.prosecnoVreme = prosecnoVreme;
	}

	public int getBlokade() {
		return blokade;
	}

	public void setBlokade(int blokade) {
		this.blokade = blokade;
	}

	public double getProsecanBrojBlokada() {
		return prosecanBrojBlokada;
	}

	public void setProsecanBrojBlokada(double prosecanBrojBlokada) {
		this.prosecanBrojBlokada = prosecanBrojBlokada;
	}

	public double getIndexForme() {
		return indexForme;
	}

	

	public void setIndexForme(int indexForme) {
		this.indexForme = indexForme;
	}


	public double getIndexUmora() {
		return indexUmora;
	}

	public void setIndexUmora(double indexUmora) {
		this.indexUmora = izracunajIndexUmora();
	}

	private double izracunajIndexUmora() {
		// TODO Auto-generated method stub
		return (vreme*brLicnihGreski*tezina)/(visina);
	}

	public int getBrLicnihGreski() {
		return brLicnihGreski;
	}

	public void setBrLicnihGreski(int brLicnihGreski) {
		this.brLicnihGreski = brLicnihGreski;
	}

	public boolean isPovredjen() {
		return povredjen;
	}

	public void setPovredjen(boolean povredjen) {
		this.povredjen = povredjen;
	}

	public boolean isIskljucen() {
		return iskljucen;
	}

	public void setIskljucen(boolean iskljucen) {
		this.iskljucen = iskljucen;
	}

	public String getKvalitetOdbrambeneIgre() {
		return kvalitetOdbrambeneIgre;
	}

	public void setKvalitetOdbrambeneIgre(String kvalitetOdbrambeneIgre) {
		this.kvalitetOdbrambeneIgre = kvalitetOdbrambeneIgre;
	}

	public int getAsistencije() {
		return asistencije;
	}

	public void setAsistencije(int asistencije) {
		this.asistencije = asistencije;
	}

	public double getProsecanBrojAsistencija() {
		return prosecanBrojAsistencija;
	}

	public void setProsecanBrojAsistencija(double prosecanBrojAsistencija) {
		this.prosecanBrojAsistencija = prosecanBrojAsistencija;
	}
	
	public void iskljuciIgraca(){
		if(brLicnihGreski == 5){
			iskljucen = true;
		}
	}
	
	
	
	
}
