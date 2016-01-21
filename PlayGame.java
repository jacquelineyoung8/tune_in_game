/* Pet, Alice, and Jacqueline
 * Driver class for our Tune In game. Backend 
 * for the entire gameplay. (Not the GUI)
 * */

public class PlayGame {
  Melody userMelody; // The melody user inputs
  Melody ourMelody; // Our melody, the correct answer
  MelodyCollection collection; // All the melodies for each level
  
  
  /* Constructor that creates a new MelodyCollection with the songs
   * found in the text file. It also sets userMelody and ourMelody
   * to start the beginning of the game/first level
   */
  public PlayGame(){
    try{
      collection = new MelodyCollection("Song Collections/songs.txt");
      userMelody = new Melody(); // empty melody, to start out. User will enter in notes.  
      ourMelody = collection.dequeue(); // Dequeues from the collection to get the melody for the level
      
    } catch(Exception e){
      System.out.println(e); 
    }
  }
  
  // Gets the number of songs in the priority queue
  public int getCollectionSize(){
    if (collection.pq.size() == 1 ) return 0;
    return collection.pq.size()+1;
  }
  
  /* Resets and starts a new game, using a new MelodyCollection,
   * new userMelody, and sets ourMelody to be the first dequeued
   * melody
   * */
  public void reset() throws Exception{
    setCollection(new MelodyCollection("Song Collections/songs.txt"));
    setUserMelody(new Melody());
    setOurMelody(collection.dequeue()); 
  }
  
  /* Sets collection to be whatever the inputted 
   * MelodyCollection is
   * */
  public void setCollection(MelodyCollection inputMelodyCollection){
    collection = inputMelodyCollection;
  }  
  
  /* Sets userMelody to be whatever the inputted 
   * userMelody is
   * */
  public void setUserMelody(Melody inputUserMelody){
    userMelody = inputUserMelody; 
  }
  
  /* Sets ourMelody to be whatever the inputted 
   * ourMelody is
   * */
  public void setOurMelody(Melody inputOurMelody){
    ourMelody = inputOurMelody; 
  }
  
  
  // -----------------------------------------
  /* getDequeued()
   * @return Type: a melody object
   * returns the next melody for the next level of the game */
  // -----------------------------------------  
  public Melody getDequeued(){
    return ourMelody; 
  }
  
  // -----------------------------------------
  /* updateUserMelody()
   * @return Type: void
   * @param: a note object 
   * adds the note the user inputs into the Melody object that
   * belongs to the User*/
  // -----------------------------------------
  public void updateUserMelody(Note n) throws Exception{
    userMelody.addNote(n);    
  }
  
  // -----------------------------------------
  /* updateUserMelody() (2nd version) 
   * @return Type: void
   * @param: a String representation of the note
   * adds the note the user inputs into the Melody object that
   * belongs to the User*/
  // -----------------------------------------
  public void updateUserMelody(String strNote) throws Exception{
    userMelody.addNote(strNote);    
  }
  
  // -----------------------------------------
  /* checkTwoMelodies()
   * @return Type: boolean
   * @param: none
   * checks to the see if the User's Melody and the current
   * game melody contains the same notes 
   * 
   * if it does, return true, the user wins
   * if not, return false, the user has loses */
  // -----------------------------------------
  public boolean checkTwoMelodies(){    
    return userMelody.compareNotes(ourMelody);
  }
  
  /* Game is over when collection is empty
   * */
  public boolean gameOver(){
    return (getCollectionSize() == 0);
  }
  
  // Testing
  public static void main(String[] args) throws Exception {
    PlayGame game = new PlayGame();
    game.updateUserMelody("e1"); game.updateUserMelody("d1"); game.updateUserMelody("c1"); 
    System.out.println("User's melody is: " + game.userMelody);
    System.out.println("Is our melody and the user's melody the same? " + game.checkTwoMelodies());
    
    game.updateUserMelody("c1"); game.updateUserMelody("d1"); game.updateUserMelody("e1"); game.updateUserMelody("f1"); 
    game.updateUserMelody("g1"); game.updateUserMelody("a1"); game.updateUserMelody("b1"); game.updateUserMelody("c2"); 
    System.out.println("Is our melody and the user's melody the same? " + game.checkTwoMelodies());
  }
}