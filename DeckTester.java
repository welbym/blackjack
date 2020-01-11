import java.util.List;
import java.util.ArrayList;

// This is a class that tests the Deck class.
public class deckTester {

// The main method in this class checks the Deck operations for consistency.
 public static void main(String[] args) {


   Deck deck = new Deck(new ArrayList<Card>(List.of(
   new Card("ten", "diamonds", 10),
   new Card("two", "hearts", 2),
   new Card("three", "clubs", 3),
   new Card("four", "spades", 4))));
   Deck fullDeck = new Deck();

   deck.add(new Card("king", "hearts", 12));

   ArrayList<Card> noCards = new ArrayList<Card>();
   Deck none = new Deck(noCards);

   System.out.println("The deck has " + deck.size() + " cards");
   System.out.println("The deck is empty: " + none.isEmpty());

   System.out.println("Dealing specific card: " + deck.deal(0).toString());

   System.out.println("Dealing last card added: " + deck.deal(deck.size()-1).toString());

   deck.remove(3);

   System.out.println(deck.toString());

   System.out.println("Dealing card: " + fullDeck.deal());

   System.out.println("\n" + fullDeck.toString());
  }
 }

 /*
  * Expected Output:
  * The deck has 5 cards
  * The deck is empty: true
  * Dealing specific card: ten of diamonds (point value = 10)
  * Dealing last card added: king of hearts (point value = 12)
  * ten of diamonds (point value = 10)
  * two of hearts (point value = 2)
  * three of clubs (point value = 3)
  * king of hearts (point value = 12)
  *
  * Dealing card: *random card*
  *
  * Dealing Deck: *full deck*
  */
