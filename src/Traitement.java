import java.io.*;
//import java.io.Serializable;

public class Traitement{

	private int Nbr_try;
	private int Actual_Nbr_try;
	private int Current_position;
	private int Taille_combinaison;
	private boolean Difficulty; // "Facile" = true ou "Difficile" == false
	private int ID_Joueur; //Joueur1 = 0
	private boolean AGagner;
	private int Score;

	Traitement(int nbr_try, int taille_combinaison, boolean difficulty, int id_joueur){
		this.Nbr_try=nbr_try;
		this.Actual_Nbr_try=this.Nbr_try;
		this.Taille_combinaison=taille_combinaison;
		this.Difficulty= difficulty;
		this.ID_Joueur=id_joueur;
		this.Current_position = 0;
		this.AGagner=false;
		this.Score=0;
	}

	public int getNbr_try(){
		return this.Nbr_try;
	}	
	public int getActual_Nbr_try(){
		return this.Actual_Nbr_try;	
	}
	public void DecActual_Nbr_try(){
		if(this.Actual_Nbr_try > 0){
			this.Actual_Nbr_try--;	
		}
	}
	public void resetActual_Nbr_try(){
		this.Actual_Nbr_try=this.Nbr_try;
	}
	public void setActual_Nbr_try(int NewNbr){
		this.Actual_Nbr_try=NewNbr;
	}
	public int getTaille_combinaison(){
		return this.Taille_combinaison;
	}
	public boolean getDifficulty(){
		return this.Difficulty;
	}
	public int getCurrent_position(){
		return this.Current_position;
	}
	public void setCurrent_position(int new_position){
		this.Current_position=new_position;
	}
	public void DecCurrent_position(){
		if(this.Current_position > 0){
			this.Current_position--;
		}
	}
	public void IncCurrent_position(){
		if(this.Current_position < this.Taille_combinaison){
			this.Current_position++;
		}
	}
	public int getID_Joueur(){
		return this.ID_Joueur;
	}
	public void setAGagner(boolean flag){
		this.AGagner=flag;	

	}
	public void IncScore(){
	if(this.AGagner){
			this.Score=this.Score+this.Actual_Nbr_try;
			resetActual_Nbr_try();
		}

	}
	public boolean getAGagner(){
		return this.AGagner;
	}
	public int getScore(){
		return this.Score;
	}
	public void resetScore(){
		this.Score=0;
	}
	public void setScore(int score){
		this.Score=score;
	}
		


}
