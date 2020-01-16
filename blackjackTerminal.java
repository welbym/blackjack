import java.util.Scanner;

// A game of Blackjack that is played in the Terminal
public class blackjackTerminal {
  public static void main(String [] args) {
      Hand player = new Hand(false);
      Hand dealer = new Hand(true);
      Deck blackjack = new Deck();
      Scanner scanIn = new Scanner(System.in);

      System.out.println("Press enter to start game.");
      scanIn.nextLine();

      player.add(blackjack.deal());
      player.add(blackjack.deal());
      dealer.add(blackjack.deal());
      dealer.add(blackjack.deal());

      System.out.println(player.toString());
      System.out.println(dealer.toString());

      System.out.println("Would you like to hit? Y or N.");


  }
}
