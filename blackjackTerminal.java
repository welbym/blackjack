import java.util.Scanner;

// A game of Blackjack that is played in the Terminal
public final class blackjackTerminal {
    public static void main (String[] args) {
      // Variable initialization.
      Hand player = new Hand(false, false);
      Hand dealer = new Hand(true, true);
      Deck blackjack = new Deck();
      Scanner scanIn = new Scanner(System.in);
      boolean win = false;
      boolean exit = false;
      int n = 0;
      // Prompts player to start the game.
      System.out.println("Press enter to start game.");
      scanIn.nextLine();
      // Deals out the player's card and dealer's cards.
      player.add(blackjack.deal());
      player.add(blackjack.deal());
      dealer.add(blackjack.deal());
      dealer.add(blackjack.deal());
      // Prints the cards that were dealt.
      System.out.println(player.toString());
      System.out.println(dealer.toString());

      while (!win) {
        System.out.println("Would you like to hit? Y or N.       Enter 'exit' to leave.");
        String in = scanIn.nextLine().toLowerCase();
        if (in.equals("y")) {
          player.add(blackjack.deal());
        } else if (in.equals("n")) {
          n++;
          if (n > 1) {
            break;
          }
        }
        else if (in.equals("exit")) {
          exit = true;
          break;
        }
        if (dealer.points() < 17) {
          dealer.add(blackjack.deal());
        }
        if (!player.checkWinner(dealer).equals("Keep playing.")) {
          win = true;
          dealer.changeHideLastCard(false);
        }
        System.out.println(player.toString());
        System.out.println(dealer.toString());
      }
      if (!exit) {
        System.out.println(player.checkWinner(dealer));
      }
    }
  }
