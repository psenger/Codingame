import java.util.Scanner;

/**
 * <p></p>
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 11/14/15
 */
public class TheDescent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            //int spaceX = in.nextInt();
            //int spaceY = in.nextInt();
            //for (int i = 0; i < 8; i++) {
            //    int mountainH = in.nextInt(); // represents the height of one mountain, from 9 to 0. Mountain heights are provided from left to right.
            //}
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            //System.out.println("HOLD"); // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).

            int spaceX = in.nextInt();
            int spaceY = in.nextInt();

            int mountainX = 0;
            int maxMountainH = 0;

            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt();
                if ( mountainH > maxMountainH ) {
                    mountainX = i;
                    maxMountainH = mountainH;
                }
            }

            if ( mountainX == spaceX ) {
                System.out.println("FIRE");
            } else {
                // Write an action using System.ut.println()
                // To debug: System.err.println("Debug messages...");
                System.out.println("HOLD"); // either:  FIRE (ship is firing its phase cannons) or HOLD (ship is not firing).
            }
        }
    }
}
