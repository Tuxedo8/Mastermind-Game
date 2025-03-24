import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.*;
import java.util.Collection;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class Load extends GUIComponent{

	

	public Load(GUI gui){
		super(gui);

	}

	@Override
	public void setupUI(){

		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showSaveDialog(gui);
		if (returnValue == JFileChooser.APPROVE_OPTION) { 
			File selectedFile = fileChooser.getSelectedFile();
			JSONObject LoadFile = readFromFile(selectedFile);
			Process(LoadFile);

		}
		else{
			gui.showHome();
		}
	}
	private static JSONObject readFromFile(File file) {
		JSONObject jsonObject = null;
		try (FileReader fileReader = new FileReader(file)) {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(fileReader);
			jsonObject = (JSONObject) obj;

			ArrayList<Couleur> couleurs = new ArrayList<Couleur>();
			
			ArrayList<Couleur> tabCouleurPossible = (ArrayList<Couleur>) jsonObject.get("Tab_Couleur_Possible");
			
			
			for (Object couleur : tabCouleurPossible) {
				String couleurStr = (String) couleur;
			
				
				try {
					Couleur couleurEnum = Couleur.valueOf(couleurStr);
					couleurs.add(couleurEnum);
				} catch (IllegalArgumentException e) {
				System.out.println("La chaîne '" + couleurStr + "' ne correspond à aucune valeur de l'énumération Couleur");
				}
			}
		
			tabCouleurPossible.clear();
			tabCouleurPossible.addAll(couleurs);
			jsonObject.put("Tab_Couleur_Possible", tabCouleurPossible);
			//System.out.println(tabCouleurPossible);
			
		


		} catch (IOException | ParseException e) {
		    System.out.println("Une erreur s'est produite lors de la lecture de l'objet JSON depuis le fichier " + file.getName());
		    e.printStackTrace();
		}
		
		return jsonObject;
	}
	private void Process(JSONObject file){


		gui.clearScreens();
		this.OptionsByJoueur.clear();
		ArrayList<Traitement> newoption = new ArrayList<>();
		JSONArray optionbyjoueur = (JSONArray) file.get("OptionsByJoueur");

		Long value;
		for (Object objt : optionbyjoueur) {
			JSONObject obj = (JSONObject) objt;
			value = (Long) obj.get("Score");
			int score = (int) value.intValue();
    			value = (Long) obj.get("Nbr_Try");
			int nbr_try = value.intValue();
			value = (Long) obj.get("ID_Joueur");
			int id_joueur = value.intValue();
			value = (Long) obj.get("Taille_combinaison");
			int taille_combinaison = value.intValue();
		
			Object bool = obj.get("AGagner");
			boolean agagner = (boolean) bool;
			bool = obj.get("Difficulty");
			boolean difficulty = (boolean) bool;
			Traitement options = new Traitement(nbr_try, taille_combinaison, difficulty, id_joueur);
			options.setScore(score);
			options.setAGagner(agagner);
			
			newoption.add(options);
    		}

		this.OptionsByJoueur.addAll(newoption);	
		
		value = (Long) file.get("Nbr_Joueur");
		this.Nbr_Joueur = (int) value.intValue();
		value = (Long) file.get("Nbr_Partie");
		this.Nbr_Partie = (int) value.intValue();
		value = (Long) file.get("Nbr_Couleur");
		this.Nbr_Couleur = (int) value.intValue();
		value = (Long) file.get("Actual_Partie");
		this.Actual_Partie = (int) value.intValue();
		value = (Long) file.get("Actual_Joueur");
		this.Actual_Joueur = (int) value.intValue();

		ArrayList<Couleur> newtabcouleur = (ArrayList<Couleur>) file.get("Tab_Couleur_Possible");



		Couleur[] tabcouleur = new Couleur[this.Nbr_Couleur];

		//System.out.println("\n\nThis.NBR COULEUR = "+this.Nbr_Couleur);
		for (int i = 0; i < this.Nbr_Couleur; i++) {
    			tabcouleur[i] = newtabcouleur.get(i); 
		}
		this.Tab_Couleur_Possible = tabcouleur;

		for(int j= 0; j<this.Nbr_Joueur; j++){

			gui.addScreen(this.OptionsByJoueur.get(j));
		}

		//System.out.println("\n\nLes options des joueurs charger = "+this.OptionsByJoueur);
		gui.getContentPane().removeAll();
		gui.DisplayG(this.Actual_Joueur -1);

	} 
}



