/* Pet, Alice, and Jacqueline 
 * Instructions.java
 * the opening screen for the TuneIn game */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InstructionsPanel extends JPanel {
  private JLabel howToPlay,step1,step2,step3;
  private ImageIcon howToPlayImg,step1Img,step2Img,step3Img,startButton2Img;
  private JButton startButton2;
  
  public InstructionsPanel (){
    setLayout (new GridLayout(5,1)); 
    setBackground(new Color(255, 222, 156)); 
    
    howToPlayImg = new ImageIcon("GUI Pics/howtoplay.gif");
    howToPlay = new JLabel (howToPlayImg);
    
    step1Img = new ImageIcon("GUI Pics/step1.gif");
    step1 = new JLabel(step1Img);
    
    step2Img = new ImageIcon("GUI Pics/step2.gif");
    step2 = new JLabel(step2Img);
    
    step3Img = new ImageIcon("GUI Pics/step3.gif");
    step3 = new JLabel(step3Img);
    
    startButton2Img = new ImageIcon ("GUI Pics/startbutton2.gif");
    startButton2 = new JButton(startButton2Img);
    
    // Show "PlayPanel" panel when start game button is clicked
    startButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        TuneInGUI.cl.show(TuneInGUI.cards, "Play Panel"); 
      }
    });
    
    // Makes buttons' borders look nicer
    startButton2.setBorder(null);
    startButton2.setMargin(new Insets(0, 0, 0, 0)); 
    
    // Adds all the buttons
    add(howToPlay);
    add(step1);
    add(step2);
    add(step3);
    add(startButton2);
    
  }
  
  
}