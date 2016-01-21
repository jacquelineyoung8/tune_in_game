/* Pet, Jackie, and Alice
 Melody.java
 The representation of a melody, a list of notes */

import java.util.LinkedList;

public class Melody implements Comparable<Melody> {
  // A melody is a linked list of notes
  public LinkedList<Note> notesCollection;
  private int size;
  
  public Melody() {
    notesCollection  = new LinkedList<Note>();
    size = 0;
  }
  
  // Returns the melody
  public LinkedList<Note> getMelody(){   
    return notesCollection; 
  }
  
  // Gets the size of the melody
  public int getSize(){
    return size; 
  }
  
  // Adds note to the melody list using the string representation
  public void addNote(String noteStr) throws Exception{
    notesCollection.add(new Note(noteStr));
    size++;
  }
  
  // Adds the note object to the melody list
  public void addNote(Note note) throws Exception{
    notesCollection.add(note);
    size++;
  }
  
  // Plays each note in the melody and pauses for .3 seconds in-between each note
  public void playMelody() throws Exception{
    for(int i = 0; i < size; i++){
      notesCollection.get(i).play(); 
      Thread.sleep(300);
    }
  }
  
  // Prints out a string representation of the notes
  public String toString(){
    String notes = "";
    for(int i = 0; i < notesCollection.size(); i++){
      notes += notesCollection.get(i).getName() + " "; 
    }
    return notes;
  }
  
  // Compares the sizes of the two melodies
  public int compareTo(Melody otherMelody) {
    Integer l = (Integer)notesCollection.size(); 
    Integer otherL = (Integer)otherMelody.notesCollection.size();
    return l.compareTo(otherL);
  }
  
  // Returns true if the two melodies are the same, false if they aren't
  public boolean compareNotes(Melody otherMelody) {
    // If the size of the two melodies are different, return false immediately 
    if (size != otherMelody.getSize()) return false;
    else{
      // Else, check note by note in the linked lists to see if they are the same
      for (int i = 0; i < size; i++){
        // If the two notes being compared are different, return false
        if (notesCollection.get(i).compareTo(otherMelody.getMelody().get(i)) != 0) return false;
      }
      return true;
    }
  } 
  
  // Testing
  public static void main(String[] args) throws Exception {
    Melody m = new Melody();
    m.addNote("e1");
    m.addNote("d1");
    m.addNote("c1");
    m.addNote("a1Sharp");
    m.playMelody();
    System.out.println(m);
    System.out.println("Size of m: " + m.getSize());
    System.out.println();
        
    Melody m2 = new Melody();
    m2.addNote("a1Sharp");
    m2.addNote("a1");
    m2.addNote("d1");
    m2.addNote("e1");
    m2.addNote("c1");
    m2.playMelody();
    System.out.println(m2);
    System.out.println("Size of m2: " + m2.getSize());
    
    System.out.println("Are the two melodies the same? (false) " + m.compareNotes(m2));
    System.out.println();
    
    Melody m3 = new Melody();
    m3.addNote("a1Sharp");
    m3.addNote("a1");
    m3.addNote("d1");
    m3.addNote("e1");
    m3.addNote("c1");
    m3.playMelody();
    System.out.println(m3);
    System.out.println("Size of m3: " + m3.getSize());
    System.out.println("Are the two melodies the same? (true) " + m2.compareNotes(m3));
  }
  
}