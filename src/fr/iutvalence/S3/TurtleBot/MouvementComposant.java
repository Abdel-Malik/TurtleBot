package fr.iutvalence.S3.TurtleBot;

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
		return (int)((this.vitesseActuelle - vitesseMin)/(vitesseMax - vitesseMin) * 100);
	} 
	
	public String augmenterVitesse()
	{
		String chaine = "";
		if (this.vitesseActuelle+pas <= vitesseMax)
		{
			this.vitesseActuelle += pas;
			chaine = this.carUp;	
		}
		else 
		{
			this.vitesseActuelle = vitesseMax;
		}
		return chaine;
	}
	
	public String diminuerVitesse()
	{
		String chaine = "";
		if (this.vitesseActuelle-pas >= vitesseMin)
		{
			this.vitesseActuelle -= pas;
			chaine = this.carDown;	
		}
		else 
		{
			this.vitesseActuelle = vitesseMin;
		}
		return chaine;
	}
}
