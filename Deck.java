import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

// Deck.java represents a single deck of cards. /////////////////////////
public class Deck {

// Variables ///////////////////////////////////////////////////////////

/**
 * cards contains all the cards in the deck.
 */
private List<Card> cards;

////////////////////////////////////////////////////////////////////////

 // Create new Deck /////////////////////////////////////////////////////

/**
* Creates a new Deck instance.
* Default call to 'new Deck()' initializes a full deck of 52 cards with 2 jokers.
* Modified call to 'new Deck(List<Card> cards)' creates a deck.
* with a specific list of cards.
* @param cards is an array containing Card objects.
*/
public Deck(){
  this.cards = new ArrayList<Card>();
  String[] suits = {"hearts","clubs","spades","diamonds"};
  String[] ranks = {"ace","two","three","four","five",
  "six","seven","eight","nine","jack","queen","king"};
  this.cards = new ArrayList<Card>();
  for(int s = 0; s < 4; s++){
    for(int r = 0; r < 12; r++) {
      this.cards.add(new Card(ranks[r],suits[s],r + 1));
    }
  }
  this.cards.add(new Card("joker","white",13));
  this.cards.add(new Card("joker","black",13));
}

public Deck(List<Card> cards){
  this.cards = new ArrayList<Card>();
  for (int i=0; i<cards.size(); i++){
    this.cards.add(cards.get(i));
    cards.get(i).place(i);
  }
}

////////////////////////////////////////////////////////////////////////

// Accessor methods ////////////////////////////////////////////////////

/**
* Accesses the number of cards in this deck.
* @return the number of cards in this deck.
*/
public int size() {
return this.cards.size();
}

/**
* Determines if this deck is empty (no undealt cards).
* @return true if this deck is empty, false otherwise.
*/
public boolean isEmpty() {
if(this.cards.size() == 0)
 return true;
else
 return false;
}

/**
* Deals a card from the deck.
* Default call to 'deal()' selects a random card to deal.
* Modified call to 'deck(Card specificCard)' selects a specified card.
* Modified call to 'deck(int place)' selects
* a specific card using its place variable.
* @param specificCard the card that is selected to be dealt.
* @return a Card from the deck.
*/
  public Card deal() {
    return this.cards.get((int)(Math.random() * (this.cards.size() - 1)));
  }

  public Card deal(int place) {
    return this.cards.get(place);
  }

////////////////////////////////////////////////////////////////////////

// Mutator methods /////////////////////////////////////////////////////

 /**
 * Adds a card to the end of the Deck.
 * @param card the card that is being add to the Deck.
 */
 public void add(Card card) {
   this.cards.add(card);
 }

 /**
 * Removes a card from the Deck based on the place number.
 * @param place the cardPlace that represents the card being removed.
 */
 public void remove(int place) {
   this.cards.remove(place);
 }

  ////////////////////////////////////////////////////////////////////////

  // toString method /////////////////////////////////////////////////////

 /**
 * Converts the entire deck into a string value.
 *     "[Rank] of [Suit] (point value = [PointValue])".
 * This provides a useful way of printing the contents of a Deck
 * in an easily readable format or performing other similar functions.
 * @return a String containing the rank, suit, and point value of every card.
 */
 @Override
  public String toString() {
    String deckString = "";
    for(int i = 0; i < this.cards.size(); i++){

      deckString += this.cards.get(i).toString() + "\n";
      if(this.cards.get(i).pointValue()==12) deckString += "\n";
    }
    return deckString;
  }
}
