import java.util.ArrayList;

public class Jeu{
	private final Combinaison ToFind_Combinaison;
	private Combinaison Guess_Combinaison;
	private ArrayList<Pion> Tab_BCouleur_BPosition;
	private ArrayList<Pion> Tab_BCouleur_MPosition;
	private boolean Gagner;
	private Traitement All_Options; 

	Jeu(Traitement options, Combinaison to_find){
		this.All_Options= options;
		this.Gagner=false;
		this.ToFind_Combinaison = to_find;
		
	}
	
	public void checkCombinaison(Combinaison Guess){


		for(int k=0; k<this.ToFind_Combinaison.getSizeCombinaison(); k++){ 
		}

		this.Guess_Combinaison = Guess;
		for(int k=0; k<this.Guess_Combinaison.getSizeCombinaison(); k++){ 
		}

		this.Tab_BCouleur_BPosition = new ArrayList<Pion>();
		this.Tab_BCouleur_MPosition = new ArrayList<Pion>();

		checkBC_BM();
		checkBC_MP();

	

		if(this.Tab_BCouleur_BPosition.size()==this.ToFind_Combinaison.getSizeCombinaison() && this.Tab_BCouleur_MPosition.isEmpty()){
			this.Gagner=true;
		}
		this.Guess_Combinaison.setAllTag_false();
		this.ToFind_Combinaison.setAllTag_false();

	}

	public int getSizeNbr_BCouleur_BPosition(){
		return this.Tab_BCouleur_BPosition.size();

	}
	public int getSizeNbr_BCouleur_MPosition(){
		return this.Tab_BCouleur_MPosition.size();
	}
	public boolean AGagner(){
		
		return this.Gagner;
		
	}
	public Pion getPion_BC_BP(int index){
		if(index<=this.Tab_BCouleur_BPosition.size()-1){
			return this.Tab_BCouleur_BPosition.get(index);
		}
		return null;
	}


	private void checkBC_BM(){
		for(int i=0; i<this.ToFind_Combinaison.getSizeCombinaison(); i++){
			if(this.ToFind_Combinaison.getCouleurPion(i) == this.Guess_Combinaison.getCouleurPion(i) && this.Guess_Combinaison.getPion(i).getTag() == false &&  this.ToFind_Combinaison.getPion(i).getTag()==false){


				this.Tab_BCouleur_BPosition.add(this.Guess_Combinaison.getPion(i));
				this.Guess_Combinaison.getPion(i).setTag(true);
				this.ToFind_Combinaison.getPion(i).setTag(true);
			}

		}
	}
	private void checkBC_MP(){
		for(int i=0; i<this.ToFind_Combinaison.getSizeCombinaison(); i++){
			for(int j=0; j<this.ToFind_Combinaison.getSizeCombinaison(); j++){
				if(this.Guess_Combinaison.getCouleurPion(i) == this.ToFind_Combinaison.getCouleurPion(j) && i!=j && this.Guess_Combinaison.getPion(i).getTag() == false &&  this.ToFind_Combinaison.getPion(j).getTag()==false){


				this.Tab_BCouleur_MPosition.add(this.Guess_Combinaison.getPion(i));
				this.Guess_Combinaison.getPion(i).setTag(true);
				this.ToFind_Combinaison.getPion(j).setTag(true);

				}
			}
		}

	}
	public ArrayList<Pion> getTab_BC_BP(){

		return this.Tab_BCouleur_BPosition;

	}
	public ArrayList<Pion> getTab_BC_MP(){
		return this.Tab_BCouleur_MPosition;

	}

			
	
	
}
