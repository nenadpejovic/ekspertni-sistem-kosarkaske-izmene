package com.sample.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

import com.sample.domen.Utakmica;
import com.sample.gui.model.IgraciTableModel;
import com.sample.poslovnalogika.Kontroler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class FrmPrikaz extends JFrame {

	private JPanel contentPane;
	private JPanel startna;
	private JPanel predlozena;
	private JPanel objasnjenje;
	private JButton dugmeIzmeni;
	private JButton dugmePokreni;
	private JLabel plej;
	private JLabel bek;
	private JLabel krilo;
	private JLabel krilniCentar;
	private JLabel centar;
	private JLabel pPlej;
	private JLabel pBek;
	private JLabel pKrilo;
	private JLabel pKrilniCentar;
	private JLabel pCentar;
	private Utakmica u;
	private JTextPane tekst;
	private JTable table;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrikaz frame = new FrmPrikaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrikaz() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPokreniProgram = new JButton("Pokreni program");
		dugmePokreni = btnPokreniProgram;
		btnPokreniProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dugmePokreni.setVisible(false);;
				objasnjenje.setVisible(false);
				startna.setVisible(true);
				predlozena.setVisible(false);
				dugmeIzmeni.setVisible(true);
				plej.setText("");
				bek.setText("");
				krilo.setText("");
				krilniCentar.setText("");
				centar.setText("");

				Kontroler.getInstance().inicijalizuj();
				Kontroler.getInstance().postaviDroolsPostavke();
				Kontroler.getInstance().otvoriPregledac("http://www.euroleague.net/main/results/showgame?gamecode=243&seasoncode=E2015");
				try {
					Kontroler.getInstance().vratiNaseIgrace(Kontroler.getInstance().vratiNaseIgrace());
					Kontroler.getInstance().vratiProtivnickeIgrace(Kontroler.getInstance().vratiProtivnickeIgrace());
					u = Kontroler.getInstance().vratiUtakmicu();
					Kontroler.getInstance().postaviIgrace();
					u = Kontroler.getInstance().postaviUtakmicu(u);
					//System.out.println(u.getProtivnickiPlej().getIme()+" hell yea");
					System.out.println(u.getKrilo().getBrLicnihGreski());
					plej.setText(u.getPlej().getIme()+" "+u.getPlej().getPrezime());
					bek.setText(u.getBek().getIme()+" "+u.getBek().getPrezime());
					krilo.setText(u.getKrilo().getIme()+" "+u.getKrilo().getPrezime());
					krilniCentar.setText(u.getKrilniCentar().getIme()+" "+u.getKrilniCentar().getPrezime());
					centar.setText(u.getCentar().getIme()+" "+u.getCentar().getPrezime());
					table.setModel(new IgraciTableModel(u));
					
					IgraciTableModel itm = (IgraciTableModel) table.getModel();
					itm.fireTableDataChanged();
					
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Kontroler.getInstance().zatvoriPregledac();
			}
		});
		btnPokreniProgram.setBounds(59, 238, 178, 23);
		contentPane.add(btnPokreniProgram);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Trenutna petorka", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(52, 109, 232, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		startna = panel;
		
		JLabel lblLabelplej = new JLabel("labelPlej");
		lblLabelplej.setBounds(10, 31, 171, 14);
		panel.add(lblLabelplej);
		plej = lblLabelplej;

		
		JLabel lblLabelbek = new JLabel("labelBek");
		lblLabelbek.setBounds(10, 43, 152, 14);
		panel.add(lblLabelbek);
		bek = lblLabelbek;
		
		JLabel lblLabelkrilo = new JLabel("labelKrilo");
		lblLabelkrilo.setBounds(10, 56, 152, 14);
		panel.add(lblLabelkrilo);
		krilo = lblLabelkrilo;
	
		JLabel lblNewLabel = new JLabel("labelKrilniCentar");
		lblNewLabel.setBounds(10, 68, 171, 16);
		panel.add(lblNewLabel);
		krilniCentar = lblNewLabel;

		
		JLabel lblLabelcentar = new JLabel("labelCentar");
		lblLabelcentar.setBounds(10, 81, 83, 14);
		panel.add(lblLabelcentar);

		centar = lblLabelcentar;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Predlo\u017Eena petroka", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(293, 109, 241, 118);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		predlozena = panel_1;
		
		JLabel lblPredlozeniPlej = new JLabel("predlozeniPlej");
		lblPredlozeniPlej.setBounds(10, 31, 151, 14);
		panel_1.add(lblPredlozeniPlej);
		pPlej = lblPredlozeniPlej;

		
		JLabel lblPredlozeniBek = new JLabel("predlozeniBek");
		lblPredlozeniBek.setBounds(10, 42, 151, 14);
		panel_1.add(lblPredlozeniBek);
		pBek = lblPredlozeniBek;

		
		JLabel lblPredlozenoKrilo = new JLabel("predlozneiKrilo");
		lblPredlozenoKrilo.setBounds(10, 52, 151, 14);
		panel_1.add(lblPredlozenoKrilo);
		pKrilo = lblPredlozenoKrilo;
		
		JLabel lblPredlozeniKrilniCentar = new JLabel("predlozeniKrilniCentar");
		lblPredlozeniKrilniCentar.setBounds(10, 65, 151, 14);
		panel_1.add(lblPredlozeniKrilniCentar);
		pKrilniCentar = lblPredlozeniKrilniCentar;

		
		JLabel lblPredlozeniCentar = new JLabel("predlozeniCentar");
		lblPredlozeniCentar.setBounds(10, 77, 151, 14);
		panel_1.add(lblPredlozeniCentar);
		pCentar = lblPredlozeniCentar;


		JButton btnNewButton = new JButton("Izvrsi izmenu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				predlozena.setVisible(true);
				dugmePokreni.setVisible(false);
				pPlej.setText("");
				pBek.setText("");
				pKrilo.setText("");
				pKrilniCentar.setText("");
				pCentar.setText("");
				Kontroler.getInstance().izvrsiPravila();
				pPlej.setText(u.getPlej().getIme()+" "+u.getPlej().getPrezime());
				pBek.setText(u.getBek().getIme()+" "+u.getBek().getPrezime());
				pKrilo.setText(u.getKrilo().getIme()+" "+u.getKrilo().getPrezime());
				pKrilniCentar.setText(u.getKrilniCentar().getIme()+" "+u.getKrilniCentar().getPrezime());
				pCentar.setText(u.getCentar().getIme()+" "+u.getCentar().getPrezime());
				objasnjenje.setVisible(true);
				tekst.setText(u.getObjasnjenje());
				
			}
		});
		btnNewButton.setBounds(356, 238, 178, 23);
		contentPane.add(btnNewButton);
		dugmeIzmeni = btnNewButton;
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Obja\u0161njenje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(57, 272, 478, 156);
		contentPane.add(panel_2);
		objasnjenje = panel_2;
		objasnjenje.setVisible(false);;
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextPane textPane = new JTextPane();
		panel_2.add(textPane);
		tekst = textPane;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 572, 98);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new IgraciTableModel(null));
		
		startna.setVisible(false);
		predlozena.setVisible(false);
		btnNewButton.setVisible(false);
	}
}
