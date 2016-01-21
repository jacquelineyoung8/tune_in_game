/* Pet, Jackie, and Alice
 Note.java
 The representation of a single note in a melody */

import java.io.*; // Used for files
import javax.sound.sampled.*; // Used to get sound into Java

public class Note {
  // Initialize instance variables
  private String pic, sound, name;
  File noteFile;  
  AudioInputStream stream, audio2;
  AudioFormat format;
  DataLine.Info info;
  Clip clip;
  
  public Note (String name) throws Exception{
    this.name = name;
    // Stores names of image and sound files in variables
   // pic = name + ".gif";
    sound = "Note Sounds/" + name + ".wav";
    // Creates a new File with the sound file
    noteFile = new File(sound);
    
    try {  
      // Opens new audio stream from the sound file
      stream = AudioSystem.getAudioInputStream(noteFile);
      // Gets the format of the sound stream and stores in variable
      format = stream.getFormat();
      info = new DataLine.Info(Clip.class, format);
      // Sets Clip to the appropriate sound information 
      clip = (Clip) AudioSystem.getLine(info);
      
      // Created buffered stream in order to be able to reset the sound file
      BufferedInputStream myStream = new BufferedInputStream(getClass().getResourceAsStream(sound)); 
      audio2 = AudioSystem.getAudioInputStream(myStream);
      
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
  
  // Gets name of the note
  public String getName(){
    return name; 
  }
  
  // Gets the name of the image file
  public String getPic(){
    return pic; 
  }
  
  // Gets the name of the sound file
  public String getSound(){
    return sound; 
  }
  
  //Plays the note
  public void play() throws Exception{
    // Opens the audio stream to play the sound file
    clip.open(stream);
    clip.start();
    // Resets the audio file after it is played
    audio2.reset();
    
  }
  
  // CompareTo method comparing Notes
  public int compareTo(Note other){
    return (this.name.compareTo(other.getName())); 
  }
  
  // Testing
  public static void main(String[] args) throws Exception  {
    Note a = new Note("a1");
    Note b = new Note("b1");
    Note c = new Note("c1");
    Note d = new Note("d1");
    Note e = new Note("e1");
    Note f = new Note("f1");
    Note g = new Note("g1");
    a.play();
    b.play();
    f.play();
    g.play();
    e.play();
    Thread.sleep(500);
    e.play();
    Thread.sleep(500);
    d.play();
    Thread.sleep(500);
    c.play();
    Thread.sleep(500);
    
    e.play();
    Thread.sleep(500);
    d.play();
    Thread.sleep(500);
    c.play();
    Thread.sleep(500);
    
    c.play();
    Thread.sleep(200);
    c.play();
    Thread.sleep(200);
    c.play();
    Thread.sleep(200);
    c.play();
    Thread.sleep(200);
    
    d.play();
    Thread.sleep(200);
    d.play();
    Thread.sleep(200);
    d.play();
    Thread.sleep(200);
    d.play();
    Thread.sleep(200);
    
    e.play();
    Thread.sleep(500);
    d.play();
    Thread.sleep(500);
    c.play();
    Thread.sleep(500);
    
  }  
}