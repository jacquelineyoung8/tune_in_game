/* Pet, Alice, and Jacqueline 
 * MelodyCollection.java
 * A representation of a collection of melodies */

import java.util.PriorityQueue; // Will hold our collection of melodies
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;

public class MelodyCollection { 
  public PriorityQueue<Melody> pq;
  
  // Constructor: Creates empty melody collection
  public MelodyCollection() {
    pq = new PriorityQueue<Melody>();
  }
  
  /* Constructor take in a file name, reads the file,
   * and adds the melodies to the priority queue.
   * */ 
  public MelodyCollection(String inFileName) throws Exception {
    Melody melody = new Melody();
    pq = new PriorityQueue<Melody>();
    
    try {
      Scanner fileScan = new Scanner (new File(inFileName));
      
      while (fileScan.hasNext()) {
        String line = fileScan.nextLine(); 
        // Splits the notes in the line into strings
        String[] stringArray = line.split(" "); 
        
        for (int i = 0; i<stringArray.length; i++) {
          // Adds each note in the line into the melody
          melody.addNote(stringArray[i]); 
        }
        
        // Add melody into priority queue
        pq.add(melody); 
        // Resets melody to get another line from the file
        melody = new Melody();
      }
      fileScan.close();
    } catch (IOException ex) {
      System.out.println(ex);
    }
    
  }
  
  // Adds melody to the priority queue
  public void addMelody(Melody melody) {
    pq.add(melody); 
  }
  
  /* Dequeues a melody. Dequeues what it peeks, 
   * which is the shortest melody in priority queue.
   * */
  public Melody dequeue(){
    Melody firstItem = pq.peek();
    pq.remove(firstItem);
    return firstItem;  
  }
  
  // To string representation of the MelodyCollection
  public String toString(){
    String melodies = "";
    Iterator<Melody> iter = pq.iterator();
    while (iter.hasNext()){
      melodies += iter.next() + "\n";
    }
    return melodies;
  }    
  
  
  public static void main(String[] args) throws Exception {    
    // Testing second constuctor
    MelodyCollection m = new MelodyCollection("Song Collections/songs.txt");
    System.out.println(m);
    m.dequeue().playMelody();
    m.dequeue().playMelody();
    m.dequeue().playMelody();
    
    // Testing first constuctor
    MelodyCollection m2 = new MelodyCollection();
    Melody mel = new Melody();
    mel.addNote("a1Sharp");
    mel.addNote("d1Sharp");
    mel.addNote("c1Sharp");
    mel.addNote("d1Sharp");
    m2.addMelody(mel);
    Melody mel2 = new Melody();
    mel2.addNote("c1Sharp");
    mel2.addNote("g1Sharp");
    m2.addMelody(mel2);
    Melody mel3 = new Melody();
    mel3.addNote("b2");
    mel3.addNote("c2");
    mel3.addNote("d2");
    m2.addMelody(mel3);
    System.out.println(m2);
    m2.dequeue().playMelody();
    m2.dequeue().playMelody();
    m2.dequeue().playMelody();
    
    
  }
}