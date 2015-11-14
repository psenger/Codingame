import java.util.Scanner;

/**
 * <p></p>
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 11/14/15
 */
public class PowerOfThor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        int thorX = initialTX;
        int thorY = initialTY;
        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            String directionX = "";
            String directionY = "";

            if (thorX > lightX) {
                directionX = "W";
                thorX--;
            } else if (thorX < lightX) {
                directionX = "E";
                thorX++;
            }

            if (thorY > lightY) {
                directionY = "N";
                thorY--;
            } else if (thorY < lightY) {
                directionY = "S";
                thorY++;
            }

            // To debug: System.err.println("Debug messages...");

            System.out.println(directionY + directionX); // A single line providing the move to be made: N NE E SE S SW W or NW
        }
    }
}
