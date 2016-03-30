package fr.iutvalence.S3.TurtleBot;

public class Application {
	
	private Communication_wifi comWifi;
	private InterfaceEntree interfaceEntree;
	private Mouvement mouvement;
	
	private String donneesLues;
	
	public Application(InterfaceEntree interfaceEntree)
	{
		this.mouvement = new Mouvement();
		this.interfaceEntree = interfaceEntree;
		this.donneesLues = new String();
	}
	
	public void creationCommunication()
	{
		try
		{
			do
			{
				InformationConnexion info = this.interfaceEntree.demandeInformationsConnexion();
				
				if (info == null)
					System.exit(0);
				
				this.comWifi = new Communication_wifi(info.obtenirAdresse(), info.obtenirPort());
			}while(!this.etablirConnexion());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Methode run dans un jeu
	public void fonctionner()
	{
		while (true)
		{
			String choix = this.interfaceEntree.demandeAction();
			if(choix.equals("RECV"))
			{
				choix += '\0';
				this.envoyerDonnees(choix);
				lireDonneesServeur();
			}
			else 
			{
				choix += "\0";
				this.envoyerDonnees(choix);
			}
		}
	}
	
	public String obtenirDonneesLues()
	{
		return this.comWifi.obtenirDonneesLues();
	}
	
	public boolean etablirConnexion()
	{
		return this.comWifi.seConnecter();
	}
	
	public void envoyerDonnees(String str)
	{
		this.comWifi.envoyerDonnees(str);
	}
	
	public void lireDonneesServeur()
	{
		this.comWifi.lireDonneesServeur();
	}
	
	public void montrerCarte(Position p)
	{
		//TODO
	}
	
	public void terminerConnexion()
	{
		this.comWifi.fermerConnexion();
	}
	
	public String deplacement(Sens_deplacement dep, Sens_rotation rot)
	{
		return this.mouvement.obtenirLeDeplacementQuiCorrespondA(dep, rot);
	}
	
	public String obtenirDonneesLuesParLeClient()
	{
		return this.donneesLues;
	}
	
}
