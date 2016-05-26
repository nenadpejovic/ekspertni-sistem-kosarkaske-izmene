package com.sample.ucitavanje;

import com.sample.domen.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebScraper {

	private WebDriver driver = new FirefoxDriver();

	
	public void opetTestSite(String url){
		driver.navigate().to(url);
	}
	
	JSONArray igraci = new JSONArray();
	JSONObject obj = new JSONObject();
	
	public Igrac setStatistikaIgracaNaUtakmici(String id,Igrac igrac){
		String text = driver.findElement(By.id(id)).getText();
		System.out.println(text);
		String[] podaci = text.split(" ");

		igrac.setIme(podaci[2]);
		igrac.setPrezime(podaci[1].substring(0,podaci[1].length()-1));
		igraci.add("ime: "+igrac.getIme());
		igraci.add("prezime: "+igrac.getPrezime());
			try {
				igrac.setVreme(izracunajVreme(podaci[3]));
				igraci.add("vreme: "+ izracunajVreme(podaci[3]));
			} catch (Exception e) {

			}
			try {
				igrac.setBrojPoena(Integer.parseInt(podaci[4]));
				igraci.add("broj poena: "+ Integer.parseInt(podaci[4]));
			} catch (Exception e) {
			
			}
			try {
				igrac.setProcenatSuta2(izracunajProcenatSuta(podaci[5]));
				igraci.add("procenat suta 2: "+ izracunajProcenatSuta(podaci[5]));
			} catch (Exception e) {

			}
			try {
				igrac.setProcenatSuta3(izracunajProcenatSuta(podaci[6]));
				igraci.add("procenat suta 3: "+ izracunajProcenatSuta(podaci[6]));
			} catch (Exception e) {

			}
			try {
				igrac.setProcenatSuta1(izracunajProcenatSuta(podaci[7]));
				igraci.add("procenat suta 1: "+ izracunajProcenatSuta(podaci[7]));
			} catch (Exception e) {

			}
			try {
				igrac.setSkokovi(Integer.parseInt(podaci[11]));
				igraci.add("skokovi: "+ Integer.parseInt(podaci[11]));
			} catch (Exception e) {

			}
			try {
				igrac.setAsistencije(Integer.parseInt(podaci[12]));
				igraci.add("asistencije: "+ Integer.parseInt(podaci[12]));
			} catch (Exception e) {

			}
			try {
				igrac.setUkradeneLopte(Integer.parseInt(podaci[13]));
				igraci.add("ukradene lopte: "+ Integer.parseInt(podaci[13]));
			} catch (Exception e) {

			}
			try {
				igrac.setIzgubljeneLopte(Integer.parseInt(podaci[14]));
				igraci.add("izgubljene lopte: "+ Integer.parseInt(podaci[14]));
			} catch (Exception e) {

			}
			try {
				igrac.setBlokade(Integer.parseInt(podaci[16]));
				igraci.add("blokade: "+ Integer.parseInt(podaci[16]));
			} catch (Exception e) {

			}
			try {
				igrac.setBrLicnihGreski(Integer.parseInt(podaci[17]));
				igraci.add("broj licnih greski: "+ Integer.parseInt(podaci[17]));
			} catch (Exception e) {

			}
			try {
				igrac.setIndexForme(Integer.parseInt(podaci[18]));
				igraci.add("index forme: "+ Integer.parseInt(podaci[18]));
			} catch (Exception e) {
			}
		return igrac;
	}

	public void upisiJson() throws IOException{
		obj.put("igraci", igraci);
		FileWriter writer = new FileWriter("c:\\Users\\Predrag-Nenad\\Desktop\\test.json");
		writer.write(obj.toJSONString());
		writer.flush();
		writer.close();
	}
	private double izracunajVreme(String string) throws Exception{
		try{
		String[] podaci = string.split(":");
		double min = Integer.parseInt(podaci[0]);
		String sek = "0."+podaci[1];
		return min+(Double.parseDouble(sek));
		} catch(Exception ex){
			throw ex;
		}
	}
	
	private double izracunajProcenatSuta(String string){
		try{
		String[] podaci = string.split("/");
		int brojUbacenih = Integer.parseInt(podaci[0]);
		int brojPokusaja = Integer.parseInt(podaci[1]);
		double procenat = brojUbacenih/brojPokusaja;
		return procenat;
		} catch(Exception ex){
			throw ex;
		}
	}


	public Utakmica postaviUtakmicu(Utakmica u){
		List<WebElement> lw = driver.findElements(By.className("score"));
		WebElement first = lw.get(0);
		WebElement second = lw.get(1);
		int domacin = Integer.parseInt(first.getText());
		int gost = Integer.parseInt(second.getText());
		int rez = domacin-gost;
		u.setRezultat(rez);
		u.setDomacin(true);
		u.setPosed(true);
		u.setLicneGreskeDoBonusa(1);
		u.setMinut(39.7);
        u.setKvalitetProtivnickeEkipe("dobar");
		return u;
	}

	public void close(){
		driver.close();
	}
	
	public Igrac ucitajDokument(String url,Igrac igrac) throws IOException{
		

		System.setProperty("http.proxyHost", "proxy.rcub.bg.ac.rs");
		System.setProperty("http.proxyPort", "8080");
		
		Document dok = Jsoup.connect(url).userAgent("Mozzila").get();
		Elements el = dok.select("table[id=per_game]");
		System.out.println(el.size());
		Element e = el.first();
		String tekst = e.text();
		String[] podaci = tekst.split(" ");
		igrac.setProsecnoVreme(Double.parseDouble(podaci[28]));
		igrac.setProsecanProcenatSuta3(Double.parseDouble(podaci[34]));
		igrac.setProsecanProcenatSuta2(Double.parseDouble(podaci[37]));
		igrac.setProsecanProcenatSuta1(Double.parseDouble(podaci[41]));
		igrac.setProsecanBrojSkokova(Double.parseDouble(podaci[44]));
		igrac.setProsecanBrojAsistencija(Double.parseDouble(podaci[45]));
		igrac.setProsecanBrojUkradenihLopti(Double.parseDouble(podaci[46]));
		igrac.setProsecanBrojBlokada(Double.parseDouble(podaci[47]));
		igrac.setProsecanBrojIzgubljenihLopti(Double.parseDouble(podaci[48]));
		igrac.setProsecanBrojPoena(Double.parseDouble(podaci[49]));		
		return igrac;
		
		
	}
}
	
