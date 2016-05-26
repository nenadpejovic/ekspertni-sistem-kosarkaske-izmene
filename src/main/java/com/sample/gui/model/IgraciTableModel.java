package com.sample.gui.model;

import javax.swing.table.AbstractTableModel;

import com.sample.domen.Igrac;
import com.sample.domen.Utakmica;

public class IgraciTableModel extends AbstractTableModel{
	
	private Utakmica u;
	private final String[] kolone = new String[]{"Ime","Prezime","Pozicija","Broj poena","Broj skokova","Broj asistencija","Broj izgubljenih lopti","Broj ukradenih lopti","Broj minuta u igri"};

	
	public IgraciTableModel(Utakmica u){
		this.u = u;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(u!=null){
		switch (rowIndex) {
		case 0:
			return vratiVrednost(u.getPlej(),columnIndex);
		case 1:
			return vratiVrednost(u.getBek(), columnIndex);
		case 2:
			return vratiVrednost(u.getKrilo(), columnIndex);
		case 3:
			return vratiVrednost(u.getKrilniCentar(), columnIndex);
		case 4:
			return vratiVrednost(u.getCentar(), columnIndex);
		case 5:
			return vratiVrednost(u.getRezervniPlej(), columnIndex);
		case 6:
			return vratiVrednost(u.getRezervniBek(), columnIndex);
		case 7:
			return vratiVrednost(u.getRezervnoKrilo(), columnIndex);
		case 8:
			return vratiVrednost(u.getRezervniKrilniCentar(), columnIndex);
		case 9:
			return vratiVrednost(u.getRezervniCentar(), columnIndex);
		case 10:
			return vratiVrednost(u.getPlejBek(), columnIndex);
		case 11:
			return vratiVrednost(u.getCentarKrilniCentar(), columnIndex);
		default:
			return "N/A";
		}
		} else {
			return null;
		}
		
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}
	
	private Object vratiVrednost(Igrac i, int kolona){
		switch (kolona) {
		case 0:
			return i.getIme();
		case 1:
			return i.getPrezime();
		case 2:
			return i.getPozicija();
		case 3:
			return i.getBrojPoena();
		case 4:
			return i.getSkokovi();
		case 5:
			return i.getAsistencije();
		case 6:
			return i.getIzgubljeneLopte();
		case 7:
			return i.getUkradeneLopte();
		case 8:
			return i.getVreme();
		default:
			return "N/A";
		}
	}
}
