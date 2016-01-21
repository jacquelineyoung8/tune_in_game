/* Pet, Alice, and Jacqueline 
 * OpeningScreenPanel.java
 * The opening screen for the TuneIn game */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OpeningScreenPanel extends JPanel {
  private JLabel gameTitle;
  // Title button, instuctions, and start game button
  private ImageIcon titleImg, howToImg, startImg; 
  private JButton howTo,start;
  
  public OpeningScreenPanel() {   
    setBackground(new Color(255, 222, 156));
    
    // Set the layout for this panel
    setLayout(new GridLayout(4,1));
    
    // Create the title image
    titleImg = new ImageIcon("GUI Pics/TuneInTitle.gif");
    gameTitle = new JLabel(titleImg);
    
    // Instructions button 
    howToImg = new ImageIcon("GUI Pics/howtobutton.gif");
    howTo = new JButton(howToImg);
    howTo.setBorder(null);
    howTo.setMargin(new Insets(0, 0, 0, 0)); 
    howTo.addActionListener(new ActionListener() { // Show "Instructions" panel when button is clicked
      public void actionPerformed(ActionEvent arg0) {
        TuneInGUI.cl.show(TuneInGUI.cards, "Instructions"); 
      }
    });
    
    // Start button
    startImg = new ImageIcon("GUI Pics/startbutton.gif");
    start = new JButton(startImg);
    start.setBorder(null);
    start.setMargin(new Insets(0, 0, 0, 0));    
    start.addActionListener(new ActionListener() { // Show "Start" panel when button is clicked
      public void actionPerformed(ActionEvent arg0) {
        TuneInGUI.cl.show(TuneInGUI.cards, "Play Panel");
      }
    });    
    
    
    add(gameTitle);
    add(howTo);
    add(start);
  }
  
}
