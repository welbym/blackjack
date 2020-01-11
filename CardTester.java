// This is a class that tests the Card class.
public class cardTester {

// The main method in this class checks the Card operations for consistency.
 public static void main(String[] args) {
   Card one = new Card("seven", "diamonds", 7);
   Card two = new Card("two", "hearts", 2);
   Card three = new Card("two", "hearts", 2);

   System.out.println("Card one: " + one.suit() + " " + one.rank() + " " + one.pointValue());
   System.out.println(one.toString());

   System.out.println("one matches two: " + one.matches(two));
   System.out.println("two matches three: " + two.matches(three));
 }
}

/*
 * Expected Output:
 * Card one: diamonds seven 7
 * seven of diamonds (point value = 7)
 * one matches two: false
 * two matches three: true
 */
