import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;

class SetOptions extends GUIComponent{

	//private int Nbr_Joueur;

	public SetOptions(GUI gui){
		super(gui);

	}

	@Override
	public void setupUI(){

		Font mediumFont = new Font(Font.SANS_SERIF, Font.BOLD, 22);

		JLabel Label_option = new JLabel("OPTION");
		//Label_option.setHorizontalTextPosition(JLabel.CENTER);
		//Label_option.setVerticalTextPosition(JLabel.TOP);
		Label_option.setHorizontalAlignment(JLabel.CENTER); 
		Label_option.setVerticalAlignment(JLabel.TOP);
		Label_option.setFont(new Font("MV Boli", Font.BOLD, 40));
	

		JLabel Label_nbr_try = new JLabel("Nombre de tentatives");
		Label_nbr_try.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_nbr_try.setFont(new Font("Arial", Font.BOLD, 25));

		JPanel Panel_Nbr_Try = new JPanel();
		Panel_Nbr_Try.setLayout(new BoxLayout(Panel_Nbr_Try, BoxLayout.X_AXIS));
		ButtonGroup Group_Nbr_Try = new ButtonGroup();
		
		JRadioButton Nbr_Try10 = new JRadioButton("10");
		JRadioButton Nbr_Try12 = new JRadioButton("12");

		Nbr_Try10.setFont(mediumFont);
		Nbr_Try12.setFont(mediumFont);
		

		if(!this.OptionsByJoueur.isEmpty()){
			//System.out.println(OptionsByJoueur.get(0).getNbr_try());
			if(OptionsByJoueur.get(0).getNbr_try() == 10){
				Nbr_Try10.setSelected(true);
			}
			else{
				Nbr_Try12.setSelected(true);
			}
		}
		else{
			Nbr_Try10.setSelected(true);

		}

		Group_Nbr_Try.add(Nbr_Try10);
		Group_Nbr_Try.add(Nbr_Try12);

		Panel_Nbr_Try.add(Nbr_Try10);
		Panel_Nbr_Try.add(Nbr_Try12);
		//Nbr_try12.setBounds(100, 100, 500, 50);


		JLabel Label_taille_combinaison = new JLabel("Nombre de pions à deviner");
			
		Label_taille_combinaison.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_taille_combinaison.setFont(new Font("Arial", Font.BOLD, 25));
		

		JPanel Panel_taille_combinaison = new JPanel();
		Panel_taille_combinaison.setLayout(new BoxLayout(Panel_taille_combinaison, BoxLayout.X_AXIS));
		ButtonGroup Group_taille = new ButtonGroup();
		JRadioButton taille4 = new JRadioButton("4");
		JRadioButton taille5 = new JRadioButton("5");

		taille4.setFont(mediumFont);
		taille5.setFont(mediumFont);

	
		if(!this.OptionsByJoueur.isEmpty()){
			if(OptionsByJoueur.get(0).getTaille_combinaison() == 4){
				taille4.setSelected(true);
			}
			else{
				taille5.setSelected(true);
			}
		}
		else{
			taille4.setSelected(true);

		}

		Group_taille.add(taille4);
		Group_taille.add(taille5);

		Panel_taille_combinaison.add(taille4);
		Panel_taille_combinaison.add(taille5);


		JLabel Label_nbr_couleur = new JLabel("Nombre de couleurs possibles");
	
		Label_nbr_couleur.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_nbr_couleur.setFont(new Font("Arial", Font.BOLD, 25));

		JPanel Panel_Nbr_Couleur = new JPanel();
		Panel_Nbr_Couleur.setLayout(new BoxLayout(Panel_Nbr_Couleur, BoxLayout.X_AXIS));
		ButtonGroup Group_Nbr_couleur = new ButtonGroup();
		JRadioButton Nbr_couleur6 = new JRadioButton("6");
		JRadioButton Nbr_couleur7 = new JRadioButton("7");
		JRadioButton Nbr_couleur8 = new JRadioButton("8");

		Nbr_couleur6.setFont(mediumFont);
		Nbr_couleur7.setFont(mediumFont);
		Nbr_couleur8.setFont(mediumFont);

		if(!this.OptionsByJoueur.isEmpty()){
			if(this.Nbr_Couleur == 6){
				Nbr_couleur6.setSelected(true);
			}
			if(this.Nbr_Couleur == 7){
				Nbr_couleur7.setSelected(true);
			}
			else{
				Nbr_couleur8.setSelected(true);
			}
		}
		else{
			Nbr_couleur6.setSelected(true);

		}
		

		Group_Nbr_couleur.add(Nbr_couleur6);
		Group_Nbr_couleur.add(Nbr_couleur7);
		Group_Nbr_couleur.add(Nbr_couleur8);

		Panel_Nbr_Couleur.add(Nbr_couleur6);
		Panel_Nbr_Couleur.add(Nbr_couleur7);
		Panel_Nbr_Couleur.add(Nbr_couleur8);
		
		JLabel Label_difficulty = new JLabel("Niveau de difficulté (L'aide varie selon le niveau choisi)");
		Label_difficulty.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_difficulty.setFont(new Font("Arial", Font.BOLD, 25));	

		JPanel Panel_difficulty = new JPanel();
		Panel_difficulty.setLayout(new BoxLayout(Panel_difficulty, BoxLayout.X_AXIS));

		ButtonGroup Group_difficulty = new ButtonGroup();

		JRadioButton difficulty_easy = new JRadioButton("Facile");
		JRadioButton difficulty_hard = new JRadioButton("Difficile");

		difficulty_easy.setFont(mediumFont);
		difficulty_hard.setFont(mediumFont);

		if(!this.OptionsByJoueur.isEmpty()){
			if(OptionsByJoueur.get(0).getDifficulty() == true){
				difficulty_easy.setSelected(true);
			}
			else{
				difficulty_hard.setSelected(true);
			}
		}
		else{
			difficulty_easy.setSelected(true);

		}


		Group_difficulty.add(difficulty_easy);
		Group_difficulty.add(difficulty_hard);

		Panel_difficulty.add(difficulty_easy);
		Panel_difficulty.add(difficulty_hard);
		

		JLabel Label_Nbr_Joueur = new JLabel("Nombre de joueurs");
		Label_Nbr_Joueur.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_Nbr_Joueur.setFont(new Font("Arial", Font.BOLD, 25));	

		JPanel Panel_Nbr_Joueur = new JPanel();
		Panel_Nbr_Joueur.setLayout(new BoxLayout(Panel_Nbr_Joueur, BoxLayout.X_AXIS));

		ButtonGroup Group_Nbr_Joueur = new ButtonGroup();

		JRadioButton Nbr_J1 = new JRadioButton("1");
		JRadioButton Nbr_J2 = new JRadioButton("2");
		JRadioButton Nbr_J3 = new JRadioButton("3");
		JRadioButton Nbr_J4 = new JRadioButton("4");
		

		Nbr_J1.setFont(mediumFont);
		Nbr_J2.setFont(mediumFont);
		Nbr_J3.setFont(mediumFont);
		Nbr_J4.setFont(mediumFont);

		if(this.Nbr_Joueur != 0){
			if(this.Nbr_Joueur == 2){
				Nbr_J2.setSelected(true);
			}
			else if(this.Nbr_Joueur == 3){
				Nbr_J3.setSelected(true);
			}
			else if(this.Nbr_Joueur == 4){
				Nbr_J4.setSelected(true);
			}
			else{Nbr_J1.setSelected(true);}
		}
		else{
			Nbr_J1.setSelected(true); // Au cas où

		}


		Group_Nbr_Joueur.add(Nbr_J1);
		Group_Nbr_Joueur.add(Nbr_J2);
		Group_Nbr_Joueur.add(Nbr_J3);
		Group_Nbr_Joueur.add(Nbr_J4);

		Panel_Nbr_Joueur.add(Nbr_J1);
		Panel_Nbr_Joueur.add(Nbr_J2);
		Panel_Nbr_Joueur.add(Nbr_J3);
		Panel_Nbr_Joueur.add(Nbr_J4);

		
		JLabel Label_Nbr_Partie = new JLabel("Nombre de Partie");
		Label_Nbr_Partie.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_Nbr_Partie.setFont(new Font("Arial", Font.BOLD, 25));	

		JPanel Panel_Nbr_Partie = new JPanel();
		Panel_Nbr_Partie.setLayout(new BoxLayout(Panel_Nbr_Partie, BoxLayout.X_AXIS));

		ButtonGroup Group_Nbr_Partie = new ButtonGroup();

		JRadioButton Nbr_P1 = new JRadioButton("1");
		JRadioButton Nbr_P2 = new JRadioButton("2");
		JRadioButton Nbr_P3 = new JRadioButton("3");
		JRadioButton Nbr_P4 = new JRadioButton("4");
		

		Nbr_P1.setFont(mediumFont);
		Nbr_P2.setFont(mediumFont);
		Nbr_P3.setFont(mediumFont);
		Nbr_P4.setFont(mediumFont);

		if(this.Nbr_Partie != 0){
			if(this.Nbr_Partie == 2){
				Nbr_P2.setSelected(true);
			}
			else if(this.Nbr_Partie == 3){
				Nbr_P3.setSelected(true);
			}
			else if(this.Nbr_Partie == 4){
				Nbr_P4.setSelected(true);
			}
			else{Nbr_P1.setSelected(true);}
		}
		else{
			Nbr_P1.setSelected(true); // Au cas où

		}


		Group_Nbr_Partie.add(Nbr_P1);
		Group_Nbr_Partie.add(Nbr_P2);
		Group_Nbr_Partie.add(Nbr_P3);
		Group_Nbr_Partie.add(Nbr_P4);

		Panel_Nbr_Partie.add(Nbr_P1);
		Panel_Nbr_Partie.add(Nbr_P2);
		Panel_Nbr_Partie.add(Nbr_P3);
		Panel_Nbr_Partie.add(Nbr_P4);

		
		JPanel Option_Panel = new JPanel();
		Option_Panel.setLayout(new BoxLayout(Option_Panel, BoxLayout.Y_AXIS));
		Option_Panel.add(Label_nbr_try);
		Option_Panel.add(Panel_Nbr_Try);
		Option_Panel.add(Label_taille_combinaison);
		Option_Panel.add(Panel_taille_combinaison);
		Option_Panel.add(Label_nbr_couleur);
		Option_Panel.add(Panel_Nbr_Couleur);
		Option_Panel.add(Label_difficulty);
		Option_Panel.add(Panel_difficulty);
		Option_Panel.add(Label_Nbr_Joueur);
		Option_Panel.add(Panel_Nbr_Joueur);
		Option_Panel.add(Label_Nbr_Partie);
		Option_Panel.add(Panel_Nbr_Partie);



		JButton ReturnButton = new JButton("VALIDER");
		ReturnButton.addActionListener((event) -> {
		    
			// AU CAS Où

			int val_nbr_try=10;
			int val_taille_combinaison=4;
			int val_nbr_couleur=6;
			int val_nbr_joueur=1;
			int val_nbr_partie=1;
			boolean val_difficulty=true;

			// AU CAS Où

			val_nbr_try = Integer.parseInt(checkButton(Group_Nbr_Try));
			val_taille_combinaison = Integer.parseInt(checkButton(Group_taille));
			val_nbr_couleur = Integer.parseInt(checkButton(Group_Nbr_couleur));
			this.Nbr_Couleur=val_nbr_couleur;
			//System.out.println("\n\nSetOptions "+this.Nbr_Couleur);
			val_nbr_joueur = Integer.parseInt(checkButton(Group_Nbr_Joueur));
			val_nbr_partie = Integer.parseInt(checkButton(Group_Nbr_Partie));
			this.Nbr_Joueur=val_nbr_joueur;
			this.Nbr_Partie=val_nbr_partie;
			if(checkButton(Group_difficulty) == "Facile"){
				val_difficulty = true;
			}
			else{ val_difficulty = false;}
			CouleurPossible();

			this.OptionsByJoueur.clear();
			gui.clearScreens();
			for(int i=0; i<this.Nbr_Joueur; i++){

				Traitement New_Options= new Traitement(val_nbr_try, val_taille_combinaison, val_difficulty, i+1);
				this.OptionsByJoueur.add(New_Options);
				gui.addScreen(New_Options);
			}
			gui.getContentPane().removeAll();
			gui.showHome();
		});

		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(ReturnButton);

		gui.getContentPane().add(Label_option, BorderLayout.NORTH);
		gui.getContentPane().add(Option_Panel, BorderLayout.CENTER);
		gui.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	
		gui.setVisible(true);
			

	}
	private String checkButton(ButtonGroup Group_button){

		Enumeration<AbstractButton> radio_button = Group_button.getElements();
			while (radio_button.hasMoreElements()) {
				AbstractButton button = radio_button.nextElement();
				if (button.isSelected()) {
					return button.getText();
				}
			}
			return null;
	}
	public void DisplayGame(){

		gui.DisplayG(0);
			

	}
}
