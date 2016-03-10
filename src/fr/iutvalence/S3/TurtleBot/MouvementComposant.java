package fr.iutvalence.S3.TurtleBot;

import javax.swing.JButton;
import javax.swing.JTextField;

public class MouvementComposant 
{	
	private final double vitesseMax;
	private final double vitesseMin;
	private double vitesseActuelle;
	private final double pas;
	
	private final String carUp;
	private final String carDown;
	
	public MouvementComposant(double vitesseMax, double vitesseMin, double pas, double vitesseActuelle, String up, String down) 
	{
		this.vitesseMax = vitesseMax;
		this.vitesseMin = vitesseMin;
		this.vitesseActuelle = vitesseActuelle;
		this.carDown = down;
		this.carUp = up;
		this.pas = pas;
	}
	
	public int progression()
	{
		return (int)((this.vitesseActuelle - this.vitesseMin)/(this.vitesseMax - this.vitesseMin) * 100);
	} 
	
	public String augmenterVitesse()
	{
		String chaine = "";
		this.vitesseActuelle += this.pas;
		this.vitesseActuelle = ((double)((int)(vitesseActuelle * 100))/100);
		if (this.vitesseActuelle <= this.vitesseMax)
		{
			chaine = this.carUp;
		}
		else 
		{
			this.vitesseActuelle -= this.pas;
		}
		this.vitesseActuelle = ((double)((int)(vitesseActuelle * 100))/100);
		return chaine;
	}
	
	public String diminuerVitesse()
	{
		String chaine = "";
		this.vitesseActuelle -= this.pas;
		this.vitesseActuelle = ((double)((int)(vitesseActuelle * 100))/100);
		if (this.vitesseActuelle >= this.vitesseMin)
		{
			chaine = this.carDown;	
		}
		else 
		{
			this.vitesseActuelle += this.pas;
		}
		this.vitesseActuelle = ((double)((int)(vitesseActuelle * 100))/100);
		return chaine;
	}
	
	public double obtenirVitesseActuelle()
	{
		return this.vitesseActuelle;
	}
	
	public String convertirPourcentageVitesse(JTextField pourcentageVitesse)
	{
		String texteBouton = pourcentageVitesse.getText();
		Double vitesse;
		int pourcentage = Integer.parseInt(texteBouton);
		if (pourcentage < 0 || pourcentage > 100)
			return "";
		else
		{
			vitesse = (double)((pourcentage * (this.vitesseMax - this.vitesseMin) / 100) + this.vitesseMin);
			this.vitesseActuelle = vitesse;
			return Double.toString(vitesse);
		}	
	}
}