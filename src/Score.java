import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.ArrayList;

class Score extends GUIComponent{

	Score(GUI gui){
		super(gui);
	}

	@Override
	public void setupUI(){

		JPanel Final_Panel_Score = new JPanel();
		Final_Panel_Score.setLayout(new BoxLayout(Final_Panel_Score, BoxLayout.Y_AXIS));

		JLabel Score_Title = new JLabel("TABLEAU DES SCORES");
		Score_Title.setAlignmentX(Component.CENTER_ALIGNMENT);
		Score_Title.setFont(new Font("Arial", Font.BOLD, 50));
		Score_Title.setForeground(Color.RED);
		Final_Panel_Score.add(Score_Title);

		Final_Panel_Score.add(Box.createVerticalGlue());

		JLabel[] Tab_Score_Label_Joueur = new JLabel[this.Nbr_Joueur];
		JLabel[] Tab_Score_Label_Point = new JLabel[this.Nbr_Joueur];

		for(int i = 0; i < this.Nbr_Joueur; i++) {
			Tab_Score_Label_Joueur[i] = new JLabel("JOUEUR " + (i+1));
			Tab_Score_Label_Joueur[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			Tab_Score_Label_Joueur[i].setFont(new Font("Mv Boli", Font.BOLD, 40));
			Tab_Score_Label_Joueur[i].setForeground(Color.BLUE);

			Tab_Score_Label_Point[i] = new JLabel("Score : " + getScoreFinal(i));
			Tab_Score_Label_Point[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			Tab_Score_Label_Point[i].setFont(new Font("Arial", Font.PLAIN, 35)); 

			Final_Panel_Score.add(Tab_Score_Label_Joueur[i]);
			Final_Panel_Score.add(Tab_Score_Label_Point[i]);

			Final_Panel_Score.add(Box.createVerticalGlue());
		}
		JPanel Panel_Other = new JPanel(new FlowLayout());


		JButton Retry= new JButton("RECOMMENCER");
		Retry.addActionListener((event) -> {
				resetAllScore();
				gui.showPlay();
						});
		Retry.setMargin(new Insets(5, 10, 5, 10));

		Panel_Other.add(Retry);



		Panel_Other.add(Box.createRigidArea(new Dimension(30, 0)));

		JButton Quit_Score = new JButton("QUITTER");
		Quit_Score.setMargin(new Insets(5, 10, 5, 10));
		Quit_Score.addActionListener((event) -> {
				
				resetAllScore();
				gui.showHome();

		});
		Panel_Other.add(Quit_Score);

		gui.getContentPane().add(Final_Panel_Score, BorderLayout.CENTER);
		gui.getContentPane().add(Panel_Other, BorderLayout.SOUTH);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
			
	}

}
