import java.util.List;
import java.util.ArrayList;

// hand.java represents the cards that the player has in their hand.
public class Hand {

  // Variables

  /**
   * handCards contains all the cards in the Hand.
   */
  private List<Card> handCards;

  /**
  * Determines if the hand belongs to player or dealer.
  */
  private boolean dealer;

  /**
  * Determines if the last card will be hidden.
  */
  private boolean hideLastCard;

  /**
  * Creates a new Hand instance.
  * Default call to 'new Hand()' initializes an empty hand.
  * @param dealer determines if the hand belongs to dealer or player.
  */
  public Hand(boolean dealer, boolean hide){
    this.handCards = new ArrayList<Card>();
    this.dealer = dealer;
    this.hideLastCard = hide;
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
  * Checks to see if dealer or player won. Only call on player hand.
  * @param dealer the dealers set of cards.
  * @return a String with a message saying who won.
  */
  public String checkWinner(Hand dealer) {
    int playerPoints = this.points();
    int dealerPoints = dealer.points();
    if (playerPoints < 21) {
      return "Keep playing!";
    } else if (playerPoints > dealerPoints && playerPoints <= 21) {
      return "You have won!";
    } else if ((dealerPoints > playerPoints && dealerPoints <= 21) || playerPoints > 21) {
      dealer.changeHideLastCard(false);
      return "Dealer has won.";
    } else {
      return "Game broke";
    }
  }

  // Mutator methods

  /**
  * @param hide represents if dealer needs to hide their last card.
  */
  public void changeHideLastCard(boolean hide) {
    this.hideLastCard = hide;
  }

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
   @Override
    public String toString() {
      String handString = "";
      if (dealer && hideLastCard) {
        if (this.handCards.size()==0) {
          handString = "Dealer hand is empty.";
        } else {
          handString += "Dealer is holding the ";
          for(int i = 0; i < this.handCards.size()-1; i++) {
            handString += this.handCards.get(i).rank() + " of " +
            this.handCards.get(i).suit();
            if (i < this.handCards.size() - 2) {
              handString += ", ";
            }
            else {
              handString += ", and a hidden card.";
            }
          }
        }
      } else if (dealer && !hideLastCard) {
        if(this.handCards.size()==0) {
          handString = "Dealer hand is empty.";
        } else {
          handString += "Dealer is holding the ";
          for(int i = 0; i < this.handCards.size(); i++) {
            if(i == this.handCards.size()-1) {handString += "and ";}
            handString += this.handCards.get(i).rank() + " of " +
            this.handCards.get(i).suit();
            if(i < this.handCards.size()-1) {handString += ", ";}
            else {handString += ".";}
          }
        }
      } else {
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
