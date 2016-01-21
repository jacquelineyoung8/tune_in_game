/* Pet, Alice, and Jacqueline
 * IncorrectPanel.java 
 * Incorrect panel for the TuneIn game. The incorrect panel 
 * is displayed when the user enters a melody incorrectly
 * */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class IncorrectPanel extends JPanel {
  private JLabel youLose;
  private JButton tryAgain;
  private ImageIcon loseImg, againImg;
  
  public IncorrectPanel(){
    setLayout (new GridLayout(2,1)); 
    setBackground(new Color(255, 222, 156)); 
    
    loseImg = new ImageIcon("GUI Pics/youLose.gif");
    youLose = new JLabel(loseImg);
    againImg = new ImageIcon("GUI Pics/tryAgain.gif");
    tryAgain = new JButton(againImg);
    
    // Show "PlayPanel at Level 1" panel when button is clicked
    tryAgain.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        TuneInGUI.cl.show(TuneInGUI.cards, "Play Panel"); 
      }
    });
    
    // Makes buttons' borders look nicer
    tryAgain.setBorder(null);
    tryAgain.setMargin(new Insets(0, 0, 0, 0)); 
    
    add(youLose);
    add(tryAgain);
    
  }   
}