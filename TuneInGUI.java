/* Pet, Alice, and Jacqueline
 * TuneInGUI.java
 * application will run the game with the accompanying GUIS
 * December 9, 2015 */

import java.awt.*;
import javax.swing.*;

public class TuneInGUI {
  private static JFrame frame = new JFrame("Tune In GUI");
  static JPanel cards = new JPanel(); // Panel where all the "cards" will be added
  static PlayGame game = new PlayGame(); 
  public static CardLayout cl = new CardLayout(); // Card GUI layout for switching between panels
  // Panels of the game
  JPanel instructions;
  JPanel playPanel;
  JPanel openingScreen;
  JPanel incorrect;
  JPanel correct;
  JPanel winGame;
  
  public TuneInGUI () {
    // Initializing all the panels in the game
    instructions = new InstructionsPanel();
    playPanel = new PlayPanel(game);
    openingScreen = new OpeningScreenPanel();
    incorrect = new IncorrectPanel();
    correct = new CorrectPanel();
    winGame = new WinGamePanel();
    
    // Setting layout to card layout
    cards.setLayout(cl); 
    
    // Adding cards
    cards.add(openingScreen, "Opening Screen");
    cards.add(instructions, "Instructions");
    cards.add(playPanel, "Play Panel");
    cards.add(incorrect, "Incorrect Screen");
    cards.add(correct, "Correct Screen");
    cards.add(winGame, "Win Game Screen");
    
    // Shows the Opening Screen for the initial screen
    cl.show(cards, "Opening Screen");
    
    frame.setPreferredSize(new Dimension(950, 450));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(cards);
    frame.pack();
    frame.setVisible(true);
    
  }
 
  // Runs the game
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        TuneInGUI game = new TuneInGUI();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setVisible(true);
      }
    });
  }  
}