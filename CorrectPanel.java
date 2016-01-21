/* Pet, Alice, and Jacqueline
 * CorrectPanel.java 
 * Correct panel for the TuneIn game. The correct panel 
 * is displayed when the user enters a melody correctly
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CorrectPanel extends JPanel {
  private JLabel youWin;
  private JButton nextLevel;
  private ImageIcon winImg, nextLevelImg;
  
  public CorrectPanel(){
    
    setLayout (new GridLayout(2,1)); 
    setBackground(new Color(255, 222, 156)); 
    
    winImg = new ImageIcon("GUI Pics/youWin.gif");
    youWin = new JLabel(winImg);
    nextLevelImg = new ImageIcon("GUI Pics/nextLevel.gif");
    nextLevel = new JButton(nextLevelImg);
    
    nextLevel.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent arg0) {
        // Shows the game panel at the next level when next level button is clicked 
        TuneInGUI.cl.show(TuneInGUI.cards, "Play Panel"); 
        PlayPanel.setLevel((PlayPanel.getLevel())+1); // go to next Level
      }
    });
    
    // Makes buttons' borders look nicer
    nextLevel.setBorder(null);
    nextLevel.setMargin(new Insets(0, 0, 0, 0)); 
    
    add(youWin);
    add(nextLevel);
   
  } 
}