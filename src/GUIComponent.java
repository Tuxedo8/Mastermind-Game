import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


abstract class GUIComponent{
	protected GUI gui;
	protected static ArrayList<Traitement> OptionsByJoueur;
	protected static int Nbr_Joueur;
	protected static int Nbr_Partie;
	protected static int Actual_Joueur;
	protected static int Actual_Partie;
	protected static int Nbr_Couleur;
	protected static Couleur[] Tab_Couleur_Possible;


       public GUIComponent(GUI gui){
		this.gui = gui;

       }
       abstract void setupUI();

       protected void InitNbr_Joueur(){
		if(this.Nbr_Joueur<=0 || this.Nbr_Joueur>=5){
			this.Nbr_Joueur=1;
			this.Actual_Joueur=1;
		}

       }
       protected void InitNbr_Couleur(){
		if(this.Nbr_Couleur<6 || this.Nbr_Couleur>8){
			this.Nbr_Couleur=6;
		}
       }
       protected void InitNbr_Partie(){
	       if(this.Nbr_Partie<=0 || this.Nbr_Partie>=5){
			this.Nbr_Partie=1;
			this.Actual_Partie=1;
		}


       }
       protected void InitOptionsbyJoueur(){
	       if(this.OptionsByJoueur == null){
			this.OptionsByJoueur=new ArrayList<Traitement>();

	       }


       }
	protected void resetActual_Partie(){
		this.Actual_Partie=1;
	}
	protected void IncActual_Partie(){
		this.Actual_Partie++;
	}
	protected void resetActual_Joueur(){
		this.Actual_Joueur=1;
	}
	protected void IncActual_Joueur(){
		this.Actual_Joueur++;
	}

       protected void updateOptions(int index, Traitement Update){
	       if(index>=0 && index <=3){
			this.OptionsByJoueur.set(index, Update);
			this.OptionsByJoueur.get(index).setAGagner(false);
			this.OptionsByJoueur.get(index).resetActual_Nbr_try();
			this.OptionsByJoueur.get(index).setCurrent_position(0);
	       }
       }
       protected int getScoreFinal(int index){
		if(index < this.OptionsByJoueur.size()){
			return this.OptionsByJoueur.get(index).getScore();
		}
		return -1;
       }

       protected void resetAllScore(){
		for(int i=0; i<this.OptionsByJoueur.size(); i++){
			this.OptionsByJoueur.get(i).resetScore();
		} 
       }
      	protected void CouleurPossible(){
		Couleur[] couleurs = Couleur.values();
		this.Tab_Couleur_Possible = new Couleur[this.Nbr_Couleur];

		for(int i=0; i<this.Nbr_Couleur; i++){
			this.Tab_Couleur_Possible[i] = couleurs[i];
		}

	}
	protected Couleur getCouleur(int index){
		return this.Tab_Couleur_Possible[index];
	}



 
 
 }
