// Card.java represents a single playing card.
public class Card {

// Variables

/* String value that holds the rank value of the card.
 * String version of cardPointValue.
 * Options include:
 * ace
 * two
 * three
 * four
 * five
 * six
 * seven
 * eight
 * nine
 * jack
 * queen
 * king
 */
private String cardRank;

/* int value that holds the point value of the card.
 * Numeric version of cardRank.
 */
private int cardPointValue;

/* String value that holds the suit of the card.
 * Options include:
 * hearts
 * spades
 * clubs
 * diamonds
 */
private String cardSuit;

/* int value that determines where the card falls
* in the card Deck
*/
private int cardPlace;

/**
* Creates a new Card instance.
* @param cardRank a String value containing the rank of the card.
* @param cardSuit a String value containing the suit of the card.
* @param cardPointValue an int value containing the point value of the card.
*/
public Card(String cardRank, String cardSuit, int cardPointValue) {
  this.cardRank = cardRank;
  this.cardPointValue = cardPointValue;
  this.cardSuit = cardSuit;
  this.cardPlace = -1;
}

// Accessor methods

/**
* Accesses this Card's rank.
* @return this Card's rank.
*/
public String rank(){
  return this.cardRank;
}

/**
* Accesses this Card's suit.
* @return this Card's suit.
*/
public String suit(){
  return this.cardSuit;
}

/**
* Accesses this Card's point value.
* @return this Card's point value.
*/
public int pointValue(){
  return this.cardPointValue;
}

/**
* Accesses this Card's place.
* @return this Card's place.
*/
public int place(){
  return this.cardPlace;
}

/**
* Compare this card with the argument.
* @param otherCard the other card to compare to this.
* @return true if the rank, suit, and point value of this card
* are equal to those of the argument; false otherwise.
*/
public boolean matches(Card otherCard) {
  if(this.cardPointValue == otherCard.pointValue() &&
      this.cardRank.equals(otherCard.rank()) &&
      this.cardSuit.equals(otherCard.suit()))
    return true;
  else
    return false;
 }

 // Mutator methods

 /**
 * Changes the variable cardPlace
 * @param cardPlace the place value the card is to assume.
 */
 public void place(int cardPlace) {
   this.cardPlace = cardPlace;
 }

 // toString method

/**
* Converts the rank, suit, and point value into a string in the format
*     "[Rank] of [Suit] (point value = [PointValue])".
* This provides a useful way of printing the contents of a Deck
* in an easily readable format or performing other similar functions.
* @return a String containing the rank, suit, and point value of the card.
*/
@Override
 public String toString() {
return this.cardRank + " of " + this.cardSuit + " (point value = " + this.cardPointValue + ")";
 }

}
