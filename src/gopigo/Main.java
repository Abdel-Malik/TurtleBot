package gopigo;
import interfaceControle.PageChoix;
import interfaceControle.PageControle;
import interfaceControle.PageVisualisation;

import java.io.IOException;

import javax.swing.SwingUtilities;


public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Application application;
		PageChoix choix = new PageChoix();
		SwingUtilities.invokeLater(choix);
		
		while(choix.getChoix().equals("")){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		switch(choix.getChoix()){
			case "libre":
				PageControle pageControle = new PageControle();
				SwingUtilities.invokeLater(pageControle);
				
				application = new Application(pageControle);
				pageControle.setApplication(application);
				application.creationCommunication();
				application.envoyerDonnees("la connexion avec un client est etablie\n");
				application.lireDonneesServeur();
				application.fonctionner();
			break;
			
			case "simulation":
				PageVisualisation visualisation = new PageVisualisation();
				SwingUtilities.invokeLater(visualisation);
				application = new Application(visualisation);
				visualisation.setApplication(application);
				application.creationCommunicationSimu();
				application.fonctionnementAutonome();
			break;
		}

	}
}