package fr.iutvalence.S3.TurtleBot.Interface;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


import fr.iutvalence.S3.TurtleBot.InformationConnexion;
import fr.iutvalence.S3.TurtleBot.InterfaceEntree;
import fr.iutvalence.S3.TurtleBot.Mouvement;
import fr.iutvalence.S3.TurtleBot.Sens_deplacement;
import fr.iutvalence.S3.TurtleBot.Sens_rotation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageControle extends JFrame implements ActionListener, InterfaceEntree, Runnable
{

	private Mouvement mouvement;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Déclaration des boutons
	//private JButton carte;
	private JButton avGauche;
	private JButton avancer;
	private JButton avDroite;
	private JButton gauche;
	private JButton stop;
	private JButton droite;
	private JButton recGauche;
	private JButton reculer;
	private JButton recDroite;
	private JButton buttonMinusDep;
	private JButton buttonPlusDep;
	private JButton buttonMinusRot;
	private JButton buttonPlusRot;
	private JButton deconnexion;
	
	private volatile boolean leChoixEstFait;
	private String choixUtilisateur;
	
	//Création de l'application
	public PageControle() 
	{
		super("Contrôle du robot");
		this.mouvement = new Mouvement();

		initialize();
	}

	//Initalisation des composants de la fenêtre
	private void initialize()
	{		

		this.setResizable(false);
		this.setBounds(100, 100, 700, 500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(null);
		
		//Création des JPanels
		JPanel panelGauche = new JPanel();
		panelGauche.setBounds(0, 61, 341, 410);
		this.getContentPane().add(panelGauche);
		panelGauche.setLayout(null);
		
		JPanel panelDroit = new JPanel();
		panelDroit.setBounds(365, 61, 329, 410);
		this.getContentPane().add(panelDroit);
		panelDroit.setLayout(null);
		
		/*this.carte = new JButton("");		
		this.carte.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/Sans titre-2.png")));
		this.carte.setBounds(10, 385, 75, 75);
		this.getContentPane().add(this.carte);
		this.carte.addActionListener(this);*/
		
		this.avGauche = new JButton("");
		this.avGauche.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/hautGauche.png")));
		this.avGauche.setBounds(82, 70, 50, 50);
		panelGauche.add(this.avGauche);
		this.avGauche.addActionListener(this);
		
		this.avancer = new JButton("");
		this.avancer.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/haut.png")));
		this.avancer.setBounds(142, 70, 50, 50);
		panelGauche.add(this.avancer);
		this.avancer.addActionListener(this);
		
		this.avDroite = new JButton("");
		this.avDroite.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/hautDroit.png")));
		this.avDroite.setBounds(202, 70, 50, 50);
		panelGauche.add(this.avDroite);
		this.avDroite.addActionListener(this);
		
		this.gauche = new JButton("");
		this.gauche.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/gauche.png")));
		this.gauche.setBounds(82, 131, 50, 50);
		panelGauche.add(this.gauche);
		this.gauche.addActionListener(this);
		
		this.stop = new JButton("");
		this.stop.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/stop.png")));
		this.stop.setBounds(142, 131, 50, 50);
		panelGauche.add(this.stop);
		this.stop.addActionListener(this);
		
		this.droite = new JButton("");
		this.droite.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/droite.png")));
		this.droite.setBounds(202, 131, 50, 50);
		panelGauche.add(this.droite);
		this.droite.addActionListener(this);
		
		this.recGauche = new JButton("");
		this.recGauche.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/basGauche.png")));
		this.recGauche.setBounds(82, 192, 50, 50);
		panelGauche.add(this.recGauche);
		this.recGauche.addActionListener(this);
		
		this.reculer = new JButton("");
		this.reculer.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/bas.png")));
		this.reculer.setBounds(142, 192, 50, 50);
		panelGauche.add(this.reculer);
		this.reculer.addActionListener(this);
		
		this.recDroite = new JButton("");
		this.recDroite.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/basDroite.png")));
		this.recDroite.setBounds(202, 192, 50, 50);
		panelGauche.add(this.recDroite);
		this.recDroite.addActionListener(this);
		
		//Création des boutons
		this.deconnexion = new JButton("");
		deconnexion.setBounds(269, 349, 50, 50);
		panelDroit.add(deconnexion);
		this.deconnexion.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/deconnexion.png")));
		this.deconnexion.addActionListener(this);
		
		this.buttonMinusDep = new JButton("");
		this.buttonMinusDep.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/moins4.png")));
		this.buttonMinusDep.setBounds(10, 80, 50, 50);
		panelDroit.add(buttonMinusDep);
		this.buttonMinusDep.addActionListener(this);
		
		this.buttonPlusDep = new JButton("");
		buttonPlusDep.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/plus2.png")));
		buttonPlusDep.setBounds(245, 80, 50, 50);
		panelDroit.add(buttonPlusDep);
		buttonPlusDep.addActionListener(this);
		
		this.buttonMinusRot = new JButton("");
		this.buttonMinusRot.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/moins4.png")));
		this.buttonMinusRot.setBounds(10, 258, 50, 50);
		panelDroit.add(this.buttonMinusRot);
		this.buttonMinusRot.addActionListener(this);
		
		this.buttonPlusRot = new JButton("");
		this.buttonPlusRot.setIcon(new ImageIcon(PageControle.class.getResource("/fr/iutvalence/S3/TurtleBot/Icones/plus2.png")));
		this.buttonPlusRot.setBounds(245, 258, 50, 50);
		panelDroit.add(this.buttonPlusRot);
		this.buttonPlusRot.addActionListener(this);
		
		//Création des JProgressBars
		JProgressBar progressBarVitDep = new JProgressBar();
		progressBarVitDep.setBounds(70, 99, 165, 14);
		panelDroit.add(progressBarVitDep);
		
		JProgressBar progressBarVitRot = new JProgressBar();
		progressBarVitRot.setBounds(70, 277, 165, 14);
		panelDroit.add(progressBarVitRot);
		
		
		//Création des labels
		JLabel lblDplacementDu = new JLabel("- Contr\u00F4le du Robot -");
		lblDplacementDu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDplacementDu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDplacementDu.setBounds(0, 11, 694, 39);
		this.getContentPane().add(lblDplacementDu);
		
		JLabel lblDplacement = new JLabel("D\u00E9placement");
		lblDplacement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDplacement.setHorizontalAlignment(SwingConstants.CENTER);
		lblDplacement.setBounds(0, 31, 341, 28);
		panelGauche.add(lblDplacement);
		
		
		JLabel lblVitesseDplacement = new JLabel("Vitesse de D\u00E9placement");
		lblVitesseDplacement.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitesseDplacement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVitesseDplacement.setBounds(68, 30, 167, 39);
		panelDroit.add(lblVitesseDplacement);
		
		JLabel lblVitesseRotation = new JLabel(" Vitesse de Rotation");
		lblVitesseRotation.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitesseRotation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVitesseRotation.setBounds(70, 208, 165, 39);
		panelDroit.add(lblVitesseRotation);
		
		//Rendre visible les fenêtres et les JPanels
		panelGauche.setVisible(true);
		panelDroit.setVisible(true);
	}
	
	@Override
	public void run()
	{
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == this.avGauche)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.AVANT, Sens_rotation.GAUCHE);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.avancer)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.AVANT, Sens_rotation.RIEN);
			this.leChoixEstFait = true;
		}
		else if(e.getSource()== this.avDroite)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.AVANT, Sens_rotation.DROITE);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.gauche)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.RIEN, Sens_rotation.GAUCHE);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.stop)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.RIEN, Sens_rotation.RIEN);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.droite)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.RIEN, Sens_rotation.DROITE);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.recGauche)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.ARRIERE, Sens_rotation.GAUCHE);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.reculer)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.ARRIERE, Sens_rotation.RIEN);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.recDroite)
		{
			this.choixUtilisateur = mouvement.obtenirLeDeplacementQuiCorrespondA(Sens_deplacement.ARRIERE, Sens_rotation.DROITE);
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.buttonMinusDep)
		{
			this.choixUtilisateur = mouvement.getDeplacement().diminuerVitesse();
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.buttonPlusDep)
		{
			this.choixUtilisateur = mouvement.getDeplacement().augmenterVitesse();
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.buttonMinusRot)
		{
			this.choixUtilisateur = mouvement.getRotation().diminuerVitesse();
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.buttonMinusRot)
		{
			this.choixUtilisateur = mouvement.getRotation().augmenterVitesse();
			this.leChoixEstFait = true;
		}
		else if(e.getSource() == this.deconnexion)
		{
			this.choixUtilisateur = "STOP";
			this.leChoixEstFait = true;
			System.exit(0);
		}
	}

	@Override
	public InformationConnexion demandeInformationsConnexion()
	{
		PageConnexion p = new PageConnexion(this);
		InformationConnexion info = p.lanceDialogue();
		
		return info;
	}

	@Override
	public String demandeAction()
	{
		this.leChoixEstFait = false;
		
		while (!leChoixEstFait) {};
		
		
		return this.choixUtilisateur;
	}


}
