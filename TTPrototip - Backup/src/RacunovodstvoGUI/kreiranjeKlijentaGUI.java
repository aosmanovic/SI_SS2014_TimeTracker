package RacunovodstvoGUI;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import UtilityClasses.validacija;

public class kreiranjeKlijentaGUI extends JFrame {
	private JFrame frmKreiranjeKlijenta;

	public kreiranjeKlijentaGUI() {
		initialize();
	}

	private void initialize() {
		
		setTitle("Kreiranje novog klijenta");
		frmKreiranjeKlijenta = new JFrame();
		frmKreiranjeKlijenta.setTitle("Kreiranje novog korisnika");
		frmKreiranjeKlijenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		
		JMenu mojRacunMenu = new JMenu("Moj ra\u010Dun");
		menuBar.add(mojRacunMenu);
		JMenuItem promijeniSifruItem = new JMenuItem("Promijeni \u0161ifru");
		mojRacunMenu.add(promijeniSifruItem);		
		JMenuItem odjaviSeItem = new JMenuItem("Odjavi se");
		odjaviSeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() 
				{
					public void run() 
					{
						odjaviSeGUI ex = new odjaviSeGUI();
			             ex.setSize(600, 150);
			             ex.setLocationRelativeTo(null);
			             ex.setVisible(true);
					}
				});
			}
		});
		mojRacunMenu.add(odjaviSeItem);
		
		JMenu alatiMenu = new JMenu("Alati");
		menuBar.add(alatiMenu);		
		JMenuItem sistemObavjetavanjaItem = new JMenuItem("Sistem obavje\u0161tavanja");
		alatiMenu.add(sistemObavjetavanjaItem);
		
		JMenu oNamaMenu = new JMenu("Pomo\u0107");
		menuBar.add(oNamaMenu);		
		JMenuItem korisnikoUputstvoItem = new JMenuItem("Korisni\u010Dko upustvo");
		korisnikoUputstvoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Opcija �e ponuditi preuzimanje .pdf dokumenta sa korisni�km uputstvom", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		oNamaMenu.add(korisnikoUputstvoItem);		
		JMenuItem oNamaItem = new JMenuItem("O nama");
		oNamaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                oNamaGUI ex = new oNamaGUI();
		                ex.setSize(300, 150);
		                ex.setLocationRelativeTo(null);
		                ex.setVisible(true);
		            }
		        });
			}
		});
		oNamaMenu.add(oNamaItem);
		
		JPanel centralniPanel = new JPanel();
		centralniPanel.setLayout(new GridLayout(4,2,2,2));
		
		JLabel nazivLbl = new JLabel("Naziv klijenta*:");
		nazivLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField nazivTxt = new JTextField();
		centralniPanel.add(nazivLbl);
		centralniPanel.add(nazivTxt);
		
		JLabel adresaLbl = new JLabel("Adresa:");
		adresaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField adresaTxt = new JTextField();
		centralniPanel.add(adresaLbl);
		centralniPanel.add(adresaTxt);
				
		JLabel emailLbl = new JLabel("E-mail*:");
		emailLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField emailTxt = new JTextField();
		centralniPanel.add(emailLbl);
		centralniPanel.add(emailTxt);
		
		JLabel brojTelefonaLbl = new JLabel("Broj telefona:");
		brojTelefonaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		final JTextField brojTelefonaTxt = new JTextField();
		centralniPanel.add(brojTelefonaLbl);
		centralniPanel.add(brojTelefonaTxt);		
		
		JPanel juzniPanel = new JPanel();
		juzniPanel.setBorder(BorderFactory.createEmptyBorder(2, 1, 2, 1));
		juzniPanel.setLayout(new GridLayout(1,2,1,1));
		JButton kreirajBtn = new JButton("Kreiraj");
		kreirajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validacija v = new validacija();
				Boolean uslov1 = v.praznoPolje(nazivTxt);
				Boolean uslov2 = v.emailAdresa(emailTxt);
				
				if(uslov1 && uslov2) {
					nazivTxt.setText("");
					emailTxt.setText("");
					adresaTxt.setText("");
					brojTelefonaTxt.setText("");
					
					JOptionPane.showMessageDialog(frmKreiranjeKlijenta,
						    "Novi klijent je uspje�no dodan.",
						    "Dodavanje klijenta",
						    JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		JButton odustaniBtn = new JButton("Odustani");
		juzniPanel.add(odustaniBtn);
		juzniPanel.add(kreirajBtn);
		
		
		getContentPane().add(centralniPanel, BorderLayout.CENTER);
		getContentPane().add(juzniPanel, BorderLayout.SOUTH);
	}

}