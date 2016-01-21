/* Pet, Alice, and Jacqueline
 * WinGamePanel.java 
 * Win panel for the TuneIn game. The win panel 
 * is displayed when the user wins the game
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WinGamePanel extends JPanel {
  private JLabel congrats,winGame;
  private JButton homeButton;
  private ImageIcon congratsImg,winGameImg,homeButtonImg;
  
  public WinGamePanel(){
    
    
    setLayout (new GridLayout(3,1)); 
    setBackground(new Color(255, 222, 156)); 
    
    winGameImg = new ImageIcon("GUI Pics/wonGame.gif");
    winGame = new JLabel(winGameImg);
    congratsImg = new ImageIcon("GUI Pics/congrats.gif");
    congrats = new JLabel(congratsImg);
    homeButtonImg = new ImageIcon("GUI Pics/home.gif");
    homeButton = new JButton(homeButtonImg);
    homeButton.setBorder(null);
    homeButton.setMargin(new Insets(0, 0, 0, 0));
    
    // Show opening screen panel when home button is clicked
    homeButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent arg0) {
        TuneInGUI.cl.show(TuneInGUI.cards, "Opening Screen"); 
      }
    });
    
    
    // Add JButtons
    add(congrats);
    add(winGame);
    add(homeButton);
    
  }
  
}