import java.util.Random;
import java.io.*;
//import java.io.Serializable;


public class Pion{
	private Couleur couleur;
	private int position;
	private boolean Tag;
	

	Pion(int position, int nbr_couleur){
		this.position=position;
		this.couleur=setRandomCouleur(nbr_couleur);
		this.Tag=false;

	}
	Pion(int position, Couleur couleur){
		this.position = position;
		this.couleur=couleur;
		this.Tag=false;
	}


	private Couleur setRandomCouleur(int nbr_couleur){
		
		Couleur[] couleurs = Couleur.values();
		Couleur[] couleursNotFull = new Couleur[nbr_couleur];

        	Random random = new Random();

		for(int i=0; i<nbr_couleur; i++){
			couleursNotFull[i] = couleurs[i];
		}
		
		int index = random.nextInt(nbr_couleur);
		return couleursNotFull[index];


	}


	public Couleur getCouleur(){
		return this.couleur;
	}
	public int getPosition(){
		return this.position;
	}

	public boolean getTag(){
		return this.Tag;
	}
	public void setTag(boolean tag){
		this.Tag=tag;
	}

}
