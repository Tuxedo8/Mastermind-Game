import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.util.ArrayList;


public class GUI extends JFrame{
   
        private Home HomePage;
	private SetOptions OptionsPage;
	private ArrayList<Play> PlayScreens;
	private Score ScorePage;
	private Save SavePage;
	private Load LoadPage;
	
	public GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MASTER-MIND GAME");
		pack();
		setSize(1000, 600); 
		setLocationRelativeTo(null);
		setVisible(true);
        	this.HomePage = new Home(this);
		this.OptionsPage = new SetOptions(this);
		this.PlayScreens = new ArrayList<Play>();
		this.ScorePage = new Score(this);
		this.SavePage = new Save(this);
		this.LoadPage = new Load(this);

	}	

	public void showHome(){

		getContentPane().removeAll();
        	HomePage.setupUI();
	}
	public void showSave(){
		getContentPane().removeAll();
		SavePage.setupUI();
	}
	public void showLoad(){
		getContentPane().removeAll();
		LoadPage.setupUI();
	}
	public void showSetOptions(){
		getContentPane().removeAll();
        	this.OptionsPage.setupUI();

	}
	public void showPlay(){
        	this.OptionsPage.DisplayGame();

	}
	public void showScore(){
		getContentPane().removeAll();
		ScorePage.setupUI();
	}
	public void DisplayG(int index){
		getContentPane().removeAll();
		this.PlayScreens.get(index).setupUI();
		
	}
	public void addScreen(Traitement Options){
		Play newplay = new Play(this, Options);
		this.PlayScreens.add(newplay);
	}
	public Play getScreen(int index){
		if(index<this.PlayScreens.size() && index>=0){
			return this.PlayScreens.get(index);
		}
		return null;
	}
	public boolean estVide(){
		if(this.PlayScreens.size()>0){
			return false;
		}
		return true;
	}
	public void clearScreens(){
		this.PlayScreens.clear();
	}
	public SetOptions getOptions(){
		return OptionsPage;
	}

	

	public static void main(String[] args) {

		new GUI().showHome();
	}
	
}
