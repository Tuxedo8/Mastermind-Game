import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.reflect.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
//import java.io.FileReader;
//import java.io.IOException;
//import com.google.appengine.repackaged.org.json.JSONObject; 

public class Save extends GUIComponent{

	

	public Save(GUI gui){
		super(gui);

	}

	@Override
	public void setupUI(){
		
		JSONObject savegame = new JSONObject();
		JSONArray options = new JSONArray();
		
		for(Traitement opt : this.OptionsByJoueur){
			JSONObject obj = new JSONObject();
			obj.put("Nbr_Try", opt.getNbr_try());
			obj.put("Difficulty", opt.getDifficulty());
			obj.put("Taille_combinaison", opt.getTaille_combinaison());
			obj.put("ID_Joueur", opt.getID_Joueur());
			obj.put("AGagner", opt.getAGagner());
			obj.put("Score", opt.getScore());
			
			options.add(obj);	
		}

		savegame.put("OptionsByJoueur", options);
		savegame.put("Nbr_Partie", this.Nbr_Partie);
		savegame.put("Actual_Joueur", this.Actual_Joueur);
		savegame.put("Actual_Partie", this.Actual_Partie);
		savegame.put("Nbr_Joueur", this.Nbr_Joueur);
		savegame.put("Nbr_Couleur", this.Nbr_Couleur);

		JSONArray color = new JSONArray();
			for(int i =0; i<this.Nbr_Couleur; i++){
				color.add(getCouleur(i).toString());
				
			}
		
		savegame.put("Tab_Couleur_Possible", color);

		//System.out.print(savegame);


		
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showSaveDialog(gui); 
		if (returnValue == JFileChooser.APPROVE_OPTION) { 
			File selectedFile = fileChooser.getSelectedFile();	
			WriteInFile(savegame, selectedFile);

			gui.showHome();
		}
	}
	private void WriteInFile(JSONObject save, File file){
		try (FileWriter fileWriter = new FileWriter(file)) {
            	fileWriter.write(save.toJSONString());
            	System.out.println("\n\nL'objet JSON a été écrit avec succès dans le fichier " + file);
        	} catch (IOException e) {
            	System.out.println("\n\nUne erreur s'est produite lors de l'écriture de l'objet JSON dans le fichier " + file);
            	e.printStackTrace();
        	}

	}
}

