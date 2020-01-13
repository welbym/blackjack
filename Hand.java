import java.util.List;
import java.util.ArrayList;

// hand.java represents the cards that the player has in their hand.
public class Hand {

  // Variables

  /**
   * cards contains all the cards in the Hand.
   */
  private List<Card> handCards;

  /**
  * Creates a new Hand instance.
  * Default call to 'new Hand()' initializes an empty hand.
  */
  public Hand(){
    this.handCards = new ArrayList<Card>();
  }

  // Accessor methods

  /**
  * Counts the point value of all the cards in the Hand.
  * @return an int with the combined point values of all cards in Hand.
  */
  public int points(){
    int handPointValue = 0;
    for(int i = 0; i < this.handCards.size(); i++){
      handPointValue += this.handCards.get(i).pointValue();
    }
    return handPointValue;
  }

  /**
  * Checks to see if dealer or player won.
  * @param dealer the dealers set of cards.
  * @return a String with a message saying who won.
  */
  public String checkWinner(Hand dealer) {
    int playerPoints = this.points();
    int dealerPoints = dealer.points();
    if((playerPoints>dealerPoints || dealerPoints>21) && playerPoints<=21) {
      return "You have won!";
    } else if((dealerPoints>playerPoints || playerPoints>21) && dealerPoints<=21){
      return "Dealer has won.";
    } else if(playerPoints>21 && dealerPoints>21){
      return "No winner.";
    } else {
      return "Restart game.";
    }
  }

  // Mutator methods

   /**
   * Adds a card to the end of the Hand.
   * @param card the card that is being add to the Hand.
   */
   public void add(Card card) {
     this.handCards.add(card);
   }

   /**
   * Removes all cards from the Hand.
   */
   public void clear() {
     this.handCards.clear();
   }

   // toString method

   /**
   * Converts the entire Hand into a string value.
   * @return a String containing every card in Hand.
   */
    public String toString(boolean dealer) {
      String handString = "";
      if(dealer) {
        if(this.handCards.size()==0) {
          handString = "Dealer hand is empty.";
        } else {
          handString += "Dealer is holding the ";
          for(int i = 0; i < this.handCards.size()-1; i++) {
            handString += this.handCards.get(i).rank() + " of " +
            this.handCards.get(i).suit();
            if(i < this.handCards.size()-2) {handString += ", ";}
            else {handString += ", and a hidden card.";}
          }
        }
      }
      else {
        if(this.handCards.size()==0) {
          handString = "Hand is empty.";
        } else {
          handString += "You are holding the ";
          for(int i = 0; i < this.handCards.size(); i++) {
            if(i == this.handCards.size()-1) {handString += "and ";}
            handString += this.handCards.get(i).rank() + " of " +
            this.handCards.get(i).suit();
            if(i < this.handCards.size()-1) {handString += ", ";}
            else {handString += ".";}
          }
        }
      }
      return handString;
    }
}
