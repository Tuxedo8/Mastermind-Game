import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.io.*;

class Home extends GUIComponent{

	public Home(GUI gui){
		super(gui);
	}

	@Override
	public void setupUI(){
		InitNbr_Joueur();
		InitNbr_Partie();
		InitNbr_Couleur();
		InitOptionsbyJoueur();

		ImageIcon HomeLogo = new ImageIcon("media/home_logo.png");
		JLabel HomeLabel = new JLabel();
		HomeLabel.setIcon(HomeLogo);
		HomeLabel.setHorizontalAlignment(JLabel.CENTER); 
		HomeLabel.setVerticalAlignment(JLabel.CENTER);

		JButton HomeButton_play = new JButton("JOUER");
		JButton HomeButton_loadGame = new JButton("CHARGER UNE PARTIE");
		JButton HomeButton_option = new JButton("OPTION");
		JButton HomeButton_quit = new JButton("QUITTER LE JEU");
		HomeButton_quit.addActionListener((event) -> System.exit(0));
		HomeButton_loadGame.addActionListener((event) -> { gui.showLoad();
				    });
		HomeButton_option.addActionListener((event) -> gui.showSetOptions());
		HomeButton_play.addActionListener((event) -> {
								if(this.OptionsByJoueur.isEmpty()){
									gui.showSetOptions();
								}
								else{
									gui.showPlay();
								}
		});


		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		buttonPanel.add(HomeButton_play);
		buttonPanel.add(HomeButton_option);
		buttonPanel.add(HomeButton_loadGame);
		buttonPanel.add(HomeButton_quit);
	
		gui.getContentPane().add(HomeLabel, BorderLayout.CENTER);
		gui.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}	

}
