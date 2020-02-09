// This is a class that tests the Hand class.
public class handTester {

// The main method in this class checks the Hand operations for consistency.
  public static void main(String[] args) {
   Card one = new Card("seven", "diamonds", 7);
   Card two = new Card("nine", "hearts", 9);
   Card three = new Card("five", "hearts", 5);
   Card four = new Card("six", "spades", 6);
   Card five = new Card("two", "diamonds", 2);
   Card six = new Card("king", "clubs", 12);

   Hand player = new Hand(false, false);
   Hand dealer = new Hand(true, true);

   player.add(one);
   player.add(two);
   player.add(three);

   dealer.add(four);
   dealer.add(five);
   dealer.add(six);

   System.out.println(player.toString());
   System.out.println(player.points());

   System.out.println(dealer.toString());

   System.out.println(player.checkWinner(dealer));

   player.clear();
   System.out.println(player.toString());

  }
}
