package com.sample.test;
import java.util.ArrayList;
import java.util.List;



import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.DeclarativeAgendaOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.domen.*;

public class DroolsTester {
	
	Utakmica u;
	List<Igrac> lnasi;
	List<Igrac> lprotivnicki;

	Igrac i1;
	Igrac i2;
	Igrac i3;
	Igrac i4;
	Igrac i5;
	Igrac i6;
	Igrac i7;
	Igrac i8;
	Igrac i9;
	Igrac i10;
	Igrac i11;
	Igrac i12;
	Igrac i13;
	Igrac i14;
	Igrac i15;
	Igrac i16;
	Igrac i17;
	
	KieSession kSession;

	
	public void postaviDroolsPostavke(){
	    KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
		kSession = kContainer.newKieSession("ksession-rules");
		
		KieBaseConfiguration config = ks.newKieBaseConfiguration();
		config.setOption(DeclarativeAgendaOption.ENABLED);
	}
	
	public DroolsTester(){
		lnasi = new ArrayList<>();
		lprotivnicki = new ArrayList<>();
	}
	
	//public void inicijalizujUtakmicu(){
	//	u = new Utakmica();
	//}

	public Utakmica vratiUtakmicu(){
		return u;
	}
	
	public List<Igrac> vratiNase(){
		return lnasi;
	}
	
	public List<Igrac> vratiProtivnicke(){
		return lprotivnicki;
	}
	
	public void inicijalizuj(){
    	u = new Utakmica();
    	i1 = new Igrac();
    	i2 = new Igrac();
    	i3 = new Igrac();
    	i4 = new Igrac();
    	i5 = new Igrac();
    	i6 = new Igrac();
    	i7 = new Igrac();
    	i8 = new Igrac();
    	i9 = new Igrac();
    	i10 = new Igrac();
    	i11 = new Igrac();
    	i12 = new Igrac();
    	i13 = new Igrac();
    	i14 = new Igrac();
    	i15 = new Igrac();
    	i16 = new Igrac();
    	i17 = new Igrac();
    	
    	lnasi.add(i1);
    	lnasi.add(i2);
    	lnasi.add(i3);
    	lnasi.add(i4);
    	lnasi.add(i5);
    	lnasi.add(i6);
    	lnasi.add(i7);
    	lnasi.add(i8);
    	lnasi.add(i9);
    	lnasi.add(i10);
    	lnasi.add(i11);
    	lnasi.add(i12);
    	
    	lprotivnicki.add(i13);
    	lprotivnicki.add(i14);
    	lprotivnicki.add(i15);
    	lprotivnicki.add(i16);
    	lprotivnicki.add(i17);
	}
	
	public void postaviIgrace(){
		 u.setPlej(lnasi.get(8));
         u.setBek(lnasi.get(0));
         u.setKrilo(lnasi.get(7));
         u.setKrilniCentar(lnasi.get(9));
         u.setCentar(lnasi.get(10));
         u.setRezervniPlej(lnasi.get(5));
         u.setRezervniBek(lnasi.get(2));
         u.setRezervnoKrilo(lnasi.get(6));
         u.setRezervniKrilniCentar(lnasi.get(3));
         u.setRezervniCentar(lnasi.get(11));
         u.setPlejBek(lnasi.get(4));
         u.setCentarKrilniCentar(lnasi.get(1));
         u.setProtivnickiPlej(lprotivnicki.get(0));
         u.setProtivnickiBek(lprotivnicki.get(1));
         u.setProtivnickoKrilo(lprotivnicki.get(2));
         u.setProtivnickiKrilniCentar(lprotivnicki.get(3));
         u.setProtivnickiCentar(lprotivnicki.get(4));
	}
	
	public void izvrsiPravila(){
		for(Igrac i:lnasi){
			kSession.insert(i);
		}
		for(Igrac i:lprotivnicki){
			kSession.insert(i);
		}   
		kSession.insert(u);
		kSession.fireAllRules();
	}
	

}
