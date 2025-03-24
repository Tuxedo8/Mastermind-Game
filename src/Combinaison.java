import java.io.*;
//import java.io.Serializable;


public class Combinaison{
	private Pion[] List_pion;
	private int taille;
	private int Nbr_Couleur;

	Combinaison(int taille, Pion[] combinaison){
		this.taille=taille;
		this.List_pion=combinaison;
	}

	Combinaison(int taille, int nbr_couleur){
		this.taille=taille;
		this.Nbr_Couleur=nbr_couleur;
		this.List_pion=setRandomCombinaison();
	}


	private Pion[] setRandomCombinaison(){
		
		Pion[] RandomCombinaison = new Pion[this.taille];

		
		for(int i=0; i<this.taille; i++){ 
			Pion pion = new Pion(i, this.Nbr_Couleur);
			RandomCombinaison[i] = pion;	

		}
		return RandomCombinaison;
	}

	private Pion[] setCombinaison(Couleur[] couleur){
		
		Pion[] NewCombinaison = new Pion[this.taille];
		for(int i=0; i<this.taille; i++){
			Pion pion = new Pion(i, couleur[i]);
			NewCombinaison[i] = pion;	

		}
		return NewCombinaison;
	}



	public int getSizeCombinaison(){
		return this.taille;
	}

	public Couleur getCouleurPion(int index){
		return this.List_pion[index].getCouleur();	
	}
	public Pion getPion(int index){
		return this.List_pion[index];
	}

	public void setAllTag_false(){
		for(int i=0; i<this.taille; i++){
			this.List_pion[i].setTag(false);
		}
	}




}
