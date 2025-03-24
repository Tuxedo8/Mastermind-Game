import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.ArrayList;

public class Play extends GUIComponent{
	private Traitement Options;
	private Combinaison ToFind_Combinaison;
	

	Play(GUI gui, Traitement options){
		super(gui);
		this.Options=options;
		resetToFind();


	}
	@Override
	public void setupUI(){
		

				
		Jeu Party = new Jeu(Options, this.ToFind_Combinaison);
		
		JLabel Label_Game_nbr_try = new JLabel("ESSAIS RESTANTS : "+this.Options.getActual_Nbr_try());

		//Label_Game_nbr_try.setHorizontalAlignment(JLabel.CENTER);
		Label_Game_nbr_try.setVerticalAlignment(JLabel.TOP);
		Label_Game_nbr_try.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_Game_nbr_try.setFont(new Font("Arial", Font.BOLD, 20));

		JLabel Label_ID = new JLabel("JOUEUR "+(this.Options.getID_Joueur()));

		//Label_ID.setHorizontalAlignment(JLabel.CENTER);
		Label_ID.setVerticalAlignment(JLabel.TOP);
		Label_ID.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_ID.setFont(new Font("SansSerif", Font.BOLD, 35));
		Label_ID.setForeground(Color.BLUE);

		JPanel Panel_Title = new JPanel();
		Panel_Title.setLayout(new BoxLayout(Panel_Title, BoxLayout.Y_AXIS));
		
		Panel_Title.add(Label_ID);
		Panel_Title.add(Label_Game_nbr_try);

		
		JLayeredPane LayeredPanel_Plateau = new JLayeredPane();
        	LayeredPanel_Plateau.setLayout(new BoxLayout(LayeredPanel_Plateau, BoxLayout.Y_AXIS));


		JPanel Plateau = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

		JLabel[] Tab_Label = new JLabel[this.Options.getTaille_combinaison()];
		for(int i=0; i<Tab_Label.length; i++){
			Tab_Label[i] = new JLabel();
			Tab_Label[i].setPreferredSize(new Dimension(85,85));
			Tab_Label[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			Plateau.add(Tab_Label[i]);

		}

		JPanel Panel_Help = new JPanel();
		Panel_Help.setLayout(new BoxLayout(Panel_Help, BoxLayout.Y_AXIS));
		JLabel Label_BC_BP = new JLabel();

		//if difficulty = true alors on met tout
		////sinon on met un peu
		Label_BC_BP.setVerticalAlignment(JLabel.CENTER);
		Label_BC_BP.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_BC_BP.setFont(new Font("Arial", Font.PLAIN, 35));
		Label_BC_BP.setForeground(Color.GREEN);

		JLabel Label_BC_MP = new JLabel();

		//Label_ID.setHorizontalAlignment(JLabel.CENTER);
		Label_BC_MP.setVerticalAlignment(JLabel.CENTER);
		Label_BC_MP.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		Label_BC_MP.setFont(new Font("Arial", Font.PLAIN, 35));
		Label_BC_MP.setForeground(Color.RED);

		Panel_Help.add(Label_BC_BP);
		Panel_Help.add(Label_BC_MP);



		LayeredPanel_Plateau.add(Plateau);
		LayeredPanel_Plateau.add(Panel_Help);

		JLayeredPane LayeredPanel_Button = new JLayeredPane();
        	LayeredPanel_Button.setLayout(new BoxLayout(LayeredPanel_Button, BoxLayout.Y_AXIS));
		
		JPanel Panel_Game_South = new JPanel(new FlowLayout());

		Pion[] Tab_Pion = new Pion[this.Options.getTaille_combinaison()];
	
		ImageIcon[] ColorPng_Button = generateColorButtons(20);

		JButton SaveGame = new JButton("SAUVEGARDER");
		SaveGame.addActionListener((event) -> {
				this.Options.resetActual_Nbr_try();
				this.Options.setCurrent_position(0);

				gui.showSave();
				resetToFind();
				
						});
		SaveGame.setMargin(new Insets(5, 10, 5, 10));



		JButton Validate = new JButton("VALIDER");
		Panel_Game_South.add(Validate);
		Validate.setMargin(new Insets(5, 10, 5, 10));

		
	
		Validate.addActionListener((event) -> {

			
			if(Tab_Pion[this.Options.getTaille_combinaison()-1] != null){
				Party.checkCombinaison(new Combinaison(this.Options.getTaille_combinaison(), Tab_Pion));
				if(Party.AGagner() == true || this.Options.getActual_Nbr_try() == 1){
					Label_BC_BP.setText(Help_BC_BP(Party));
					Label_BC_MP.setText(Help_BC_MP(Party));

					this.Options.setAGagner(Party.AGagner());
					this.Options.IncScore();
					Validate.setEnabled(false);
					SaveGame.setEnabled(false);
					try {
                    				Thread.sleep(1000);
                			} catch (InterruptedException ex) {
                    				ex.printStackTrace();
                			}

					NextScreen();
				
				}
				else{
					
					this.Options.DecActual_Nbr_try();
					Label_Game_nbr_try.setText("ESSAIS RESTANTS : "+this.Options.getActual_Nbr_try());
					Label_BC_BP.setText(Help_BC_BP(Party));
					Label_BC_MP.setText(Help_BC_MP(Party));
				}
			}
			
		});
				


		Panel_Game_South.add(Box.createRigidArea(new Dimension(20, 0)));

		ImageIcon[] ColorPng_Label = generateColorButtons(85);

		Couleur[] Tab_Couleur = this.Tab_Couleur_Possible;
		
		JButton[] Tab_Button_Couleur = new JButton[this.Nbr_Couleur];
		int j;
		for(j=0; j<Tab_Button_Couleur.length; j++){
			Tab_Button_Couleur[j] = new JButton();
			Tab_Button_Couleur[j].setIcon(ColorPng_Button[j]);
			final Couleur tmp_couleur = Tab_Couleur[j];
			final ImageIcon tmp_png = ColorPng_Label[j];

			Tab_Button_Couleur[j].addActionListener((event) -> {
				if(this.Options.getCurrent_position() < this.Options.getTaille_combinaison()){
					Tab_Pion[this.Options.getCurrent_position()] = new Pion(this.Options.getCurrent_position(), tmp_couleur);
					Tab_Label[this.Options.getCurrent_position()].setIcon(tmp_png);
					this.Options.IncCurrent_position();
				}
			});
			Panel_Game_South.add(Tab_Button_Couleur[j]);
		}


		Panel_Game_South.add(Box.createRigidArea(new Dimension(20, 0)));
		JButton DeleteEntry = new JButton("EFFACER");
		DeleteEntry.setMargin(new Insets(5, 10, 5, 10));
		DeleteEntry.addActionListener((event) -> {

			this.Options.DecCurrent_position();
			Tab_Label[this.Options.getCurrent_position()].setIcon(null);
			Tab_Pion[this.Options.getCurrent_position()] = null;

		});


		Panel_Game_South.add(DeleteEntry);

		JPanel Panel_Other = new JPanel(new FlowLayout());
		
		Panel_Other.add(SaveGame);

		Panel_Other.add(Box.createRigidArea(new Dimension(30, 0)));
		JButton QuitGame = new JButton("ABANDONNER");
		QuitGame.setMargin(new Insets(5, 10, 5, 10));
		QuitGame.addActionListener((event) -> {
				this.Options.resetActual_Nbr_try();
				this.Options.setCurrent_position(0);
				resetToFind();
				NextScreen();		
		});
		Panel_Other.add(QuitGame);

		
		LayeredPanel_Button.add(Panel_Game_South);
		LayeredPanel_Button.add(Panel_Other);

		gui.getContentPane().removeAll();

		gui.getContentPane().add(Panel_Title, BorderLayout.NORTH);
		gui.getContentPane().add(LayeredPanel_Plateau, BorderLayout.CENTER);
		gui.getContentPane().add(LayeredPanel_Button, BorderLayout.SOUTH);
		gui.setVisible(true);

	}

	private ImageIcon[] generateColorButtons(int size) {
			Couleur[] displayCouleurs = this.Tab_Couleur_Possible;
			ImageIcon[] colorIcons = new ImageIcon[displayCouleurs.length]; 
			for (int i = 0; i < displayCouleurs.length; i++) {
				String imagePath = "media/" + displayCouleurs[i].toString() + ".png"; 
				ImageIcon icon = new ImageIcon(imagePath); 
				Image image = icon.getImage();
				
				Image scaledImage = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
			
				colorIcons[i] = new ImageIcon(scaledImage);
			}

			return colorIcons;
	}

	private String Help_BC_BP(Jeu Party){
		ArrayList<Pion> BC_BP = Party.getTab_BC_BP();
		

		if(this.Options.getDifficulty() == true){
			String result = "";
			for(int i=0; i<BC_BP.size();i++){
				result = result+" "+(BC_BP.get(i).getPosition()+1);	
			}
			if (BC_BP.size()==0){
				result = result+" 0";
			}

			return String.format("Pion Bien Placé :%s",result);
		}

		return String.format("Nombre Bonne Couleur Bien Placé : %d",BC_BP.size());
	}
	private String Help_BC_MP(Jeu Party){
		ArrayList<Pion> BC_MP = Party.getTab_BC_MP();
		

		if(this.Options.getDifficulty() == true){
			String result = "";
			for(int i=0; i<BC_MP.size();i++){
				result = result+" "+(BC_MP.get(i).getPosition()+1);	
			}
			if (BC_MP.size()==0){
				result = result+" 0";
			}
			return String.format("Pion Mal Placé :%s",result);
		}
		return String.format("Nombre Bonne Couleur Mal Placé : %d",BC_MP.size());

		
	}
	private void NextScreen(){

		resetToFind();
		updateOptions(this.Options.getID_Joueur()-1, this.Options);
			if(this.Options.getID_Joueur() < this.Nbr_Joueur){
									
				IncActual_Joueur();
				gui.DisplayG(this.Options.getID_Joueur());
					
			}
			else if(this.Actual_Partie < this.Nbr_Partie){
				resetActual_Joueur();
				IncActual_Partie();
				gui.DisplayG(0);

			}
			else{
				resetActual_Partie();
				gui.showScore();
			}
	}

	private void resetToFind(){
		this.ToFind_Combinaison = new Combinaison(this.Options.getTaille_combinaison(), this.Nbr_Couleur);
	}


}
