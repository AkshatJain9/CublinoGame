 /*
  * AUTHORSHIP: Justin Tieu
  * Other Works/Members Cited: N/A
  */

package comp1140.ass2.gui.players;

 /**
  * Wrapper for any entity that interacts with the game state
  */
 public interface PlayerType {
    enum Ref {
        LOCAL,
        REMOTE,
        AI,
        NONE
    }

    /**
     * Name of the player
     * @return player name
     */
    String getName();

     /**
      * set the name of the player
      * @param value player name
      */
    void setName(String value);

    /**
     * whether the player is local, remote or an AI
     * @return
     */
    Ref getType();
}
