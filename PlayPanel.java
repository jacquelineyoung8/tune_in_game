/* Pet, Alice, and Jacqueline
 * Level panel for the TuneIn game
 * LevelPanel.java */

import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayPanel extends JPanel{
  private Map<String, JButton> buttonMap = new HashMap <String, JButton>(); // HashMap for mapping JButtons to key names
  private static JLabel levelTitle; // Level title will change based on the level 
  private JButton imReady; 
  private ImageIcon imReadyImg;
  private static ImageIcon titleImg;
  private static int level;
  private int imReadyPressed;
  private String [] keyNames = {"c1","c1Sharp","d1","d1Sharp","e1","f1","f1Sharp","g1","g1Sharp","a1","a1Sharp",
    "b1","c2","c2Sharp","d2","d2Sharp","e2","f2","f2Sharp","g2","g2Sharp","a2","a2Sharp","b2"};
  private PlayGame game;
  
  
  /************************************
    * class cosntructor
    * @param: the current level of the game
    * this will allow the panel to use the correct image for the title label
    * ******************************* */
  public PlayPanel(PlayGame g) {
    game = g;
    setBackground(new Color(255, 222, 156));    
    level = 1; // Starts on first level
    imReadyPressed = 0; // User has not pressed anything yet
    
    // Set the layout for this panel
    setLayout (new BorderLayout()); 
    
    // Add the various panels 
    add(makeNorthPanel(), BorderLayout.NORTH);
    add(makeCenterPanel(), BorderLayout.CENTER);
    add(makeSouthPanel(), BorderLayout.SOUTH); 
  }
  
  
  /************************************
    * flashKey()
    * @param: the keyboard button that is to be flashed
    * this method will change the image associated with the button to be a
    * coloredbutton,indicating that it was played 
    * ******************************* */
  private void flashKey (JButton button) throws Exception {
    // new image icon of the colored button
    ImageIcon flash = new ImageIcon("Note Pics/" + getKeyFromValue(button) + "flash.gif");
    button.setIcon(flash);
    button.setBorder(null);
  }
  
  /************************************
    * setLevel()
    * @param: int, representing the level that the game is on
    * this method sets the level title image to its correct image
    * this way, the user will know what level they are on
    * ********************************* */
  public static void setLevel(int l){
    level =l;
    titleImg = new ImageIcon("GUI Pics/" + l + "level.gif");
    levelTitle.setIcon(titleImg);  
  }
  
  /************************************
    * getLevel()
    *@return: int, representing what level the game is
    * currently on
    **********************************/
  public static int getLevel(){
    return level;  
  }
  
  /************************************
    * deflashKey()
    * @param: the keyboard button that is to be unflashed
    * this method will change the image associated with the button
    * back to it's original image (no color)
    * ******************************* */ 
  
  private void deflashKey (JButton button) throws Exception{
    ImageIcon original = new ImageIcon("Note Pics/" + getKeyFromValue(button) + ".gif");
    button.setIcon(original);
    button.setFocusable(false);
    button.setBorder(null);
  }
  
  /************************************
    * makeNorthPanel() 
    * create a north panel with the images
    * ********************************* */
  private JPanel makeNorthPanel() {
    JPanel northPanel = new JPanel();
    northPanel.setBackground(new Color(255, 222, 156));
    
    titleImg = new ImageIcon ("GUI Pics/" + level + "level.gif");
    levelTitle = new JLabel(titleImg);
    
    northPanel.add(levelTitle);
    
    return northPanel;
    
  }
  
  
  /************************************
    * makeCenterPanel()
    * make instantiate the keys and place them on the playPanel
    *  ******************************** */
  private JPanel makeCenterPanel() {
    JPanel centerPanel = new JPanel();
    centerPanel.setBackground(new Color(255, 222, 156));
    
    // use forloop to create an instantiate the keyboard buttons
    for (int i = 0 ; i < keyNames.length; i ++) {
      String name = keyNames[i];
      ImageIcon nameImage = new ImageIcon ("Note Pics/" + name + ".gif");
      JButton nameKey = new JButton(nameImage);
      nameKey.addActionListener(new KeyButtonListener());
      nameKey.setBorder(null);
      nameKey.setMargin(new Insets(0, 0, 0, 0));
      nameKey.setFocusable(false);
      nameKey.setBorderPainted(false);
      nameKey.setContentAreaFilled(false);
      // Add the name of the key and the actual key button into the
      // Hashmap, the name associated with the buttons will be important later
      buttonMap.put(name,nameKey);
      centerPanel.add(nameKey);
      
    }
    return centerPanel;
  }
  
  
  /************************************
    * makeSouthPanel()
    * create the imready/imdone buttons
    * ********************************* */
  private JPanel makeSouthPanel() {
    
    JPanel southPanel = new JPanel();
    southPanel.setBackground(new Color(255, 222, 156));
    imReadyImg  = new ImageIcon("GUI Pics/imready.gif");
    imReady = new JButton(imReadyImg);
    imReady.addActionListener(new ImReadyButtonListener());
    imReady.setBorder(null);
    imReady.setFocusable(false);
    imReady.setBorderPainted(false);
    imReady.setContentAreaFilled(false);
    
    southPanel.add(imReady);
    
    return southPanel;
    
  }
  
  /* Retrieves the key (a string) from value from our hashmap of
   * JButtons and string note names
   * */
  private String getKeyFromValue(JButton button) {
    String key = "";
    // For each hashmap entry in the hashmap set
    for (Map.Entry<String, JButton> entry : buttonMap.entrySet()) {
      // If the button value equals the inputted button 
      if (entry.getValue().equals(button)) {
        // Get the key of that button 
        key = entry.getKey();
      }
      
    } 
    return key;
  }
  
  /************************************
    * internal call ImReadyButtonListener()
    * outlines the functionalityofthe i'm ready button/ i'm done button
    * most of the functionality of the GUI in relation to the game is 
    * done here
    * ******************************** */
  private class ImReadyButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event){
      // System.out.println(game.getCollectionSize()); //testing
      
      try{
        // Update the counter, when the try is executed the button is already clicked
        imReadyPressed ++;
        if (imReadyPressed == 1) {
          game.setUserMelody(new Melody()); // Create empty Melody object that will take in user input
          
          // System.out.println("The correct answer is: " + game.ourMelody);// testing
          
          // Play the melody for thsi level and flash the keys so that the user can hear what they
          // Need to replicate
          for (Note currentNote: game.ourMelody.notesCollection) {
            String buttonName = currentNote.getName();
            flashKey(buttonMap.get(buttonName)); // Flash the button
            currentNote.play(); // play the note
            Thread.sleep(500); // Puts spaces inbetween the notes
          }
          
          // After the button has been pressed once, change the button image to imdone
          imReadyImg = new ImageIcon("GUI Pics/imDone.gif");
          imReady.setIcon(imReadyImg);
        }
        
        // This executes when the user done and is ready to move on
        if (imReadyPressed == 2){
          
          // Deflash the buttons 
          for (Note currentNote: game.ourMelody.notesCollection) {
            String buttonName = currentNote.getName();
            deflashKey(buttonMap.get(buttonName));
            
          }
          
          boolean isCorrect = game.checkTwoMelodies();
          
          if (!isCorrect) {// If the user gets it wrong
            imReadyImg = new ImageIcon("GUI Pics/imready.gif"); // Change button images back
            imReady.setIcon(imReadyImg);
            // System.out.println("YOU LOSE"); //testing
            // Show the incorrectscreen, the user is WRONG
            TuneInGUI.cl.show(TuneInGUI.cards, "Incorrect Screen"); 
            game.reset(); // Resetting the game reinitializes all instances in the game instance
            setLevel(1); // The user goes back to the firstlevel, change img 
            imReadyPressed = 0;
          }
          
          // Check to see if the user has already won
          else if (game.collection.pq.size() == 0){
            // If so, take them tothe winner screen because they are winner
            TuneInGUI.cl.show(TuneInGUI.cards, "Win Game Screen"); 
            game.reset(); // Resetting the game reinitializes all instances in the game instance
            setLevel(1); // The user goes back to the firstlevel, change img 
            imReadyPressed = 0;
            
          }
          else {
            // The user hasnt won yet but has answered for this level correctly
            TuneInGUI.cl.show(TuneInGUI.cards, "Correct Screen"); // Go to correct answr screen
            
            // Fix the button images
            imReadyPressed = 0;
            imReadyImg = new ImageIcon("GUI Pics/imready.gif");
            imReady.setIcon(imReadyImg);
            game.ourMelody = game.collection.dequeue();
            game.userMelody = new Melody(); // Create a new empty Melody object for the user
            
          }      
        }
      }
      
      catch (Exception e) {
        System.out.println("Cannot play");
        
      } 
    }
  }
  
  
  
  /*******************************
    * internal class KeyButtonLister
    * 
    * creates a listener that all of the key buttons share
    * adds the clicked note to the user's empty melody object
    * deflashesthe keys accordingly
    ****************************** */
  private class KeyButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event) { 
      try {
        
        // Get the button clicked and its name
        JButton buttonClicked = (JButton)event.getSource();
        buttonClicked.setSelected(false);
        String buttonName = getKeyFromValue(buttonClicked);
        
        // Create a note object from the button text so it can be played
        Note note = new Note(buttonName);
        
        // Deflash the notes the user clicks
        flashKey(buttonClicked);
        note.play(); //play the note the userclicks
        deflashKey(buttonClicked);
        
        // Add the note to the users melody object
        game.updateUserMelody(buttonName);
        // System.out.println("Your answer is: " + game.userMelody); //testing
      }
      
      catch (Exception e) {
        System.out.println("Something went wrong");
      }
    }
    
  }
  
}

