import java.util.Scanner;

/**
 * CodinGame planet is being attacked by slimy insectoid aliens.
 * <---
 * Hint:To protect the planet, you can implement the pseudo-code provided in the statement, below the player.
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 11/14/15
 */
public class OnBoarding {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // game loop
        while (true) {
            String enemy1 = in.next(); // name of enemy 1
            int dist1 = in.nextInt(); // distance to enemy 1
            String enemy2 = in.next(); // name of enemy 2
            int dist2 = in.nextInt(); // distance to enemy 2

            // Write an action using System.out.println()
            if ( dist1 >= dist2 ) {
                System.out.println(enemy2);
            } else if (dist2 > dist1 ){
                System.out.println(enemy1);
            } else {
                System.out.println(enemy1);
            }
        }
    }
}
