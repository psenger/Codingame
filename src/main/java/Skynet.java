import java.util.Scanner;

/**
 * <p></p>
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 11/14/15
 */
public class Skynet {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int road = in.nextInt(); // the length of the road before the gap.
        int gap = in.nextInt(); // the length of the gap.
        int platform = in.nextInt(); // the length of the landing platform.

        //System.err.println("road = " + road);
        //System.err.println("gap = " + gap);
        //System.err.println("platform = " + platform);

        int targetJumpSpeed = calculateOptimalJumpSpeedNeededToJumpTheGap(gap);
        // System.err.println("targetJumpSpeed = " + targetJumpSpeed);
        boolean weHaveJumped = false;

        // game loop
        while (true) {
            int speed = in.nextInt(); // the motorbike's speed.
            int coordX = in.nextInt(); // the position on the road of the motorbike.

            //System.err.println("speed = " + speed);
            //System.err.println("coordX = " + coordX);

            if ( weHaveJumped ) {
                if ( speed != 0 ) {
                    System.out.println("SLOW");
                }
            } else {
                if ( (road -1) == coordX ) {
                    System.out.println("JUMP");
                    weHaveJumped = true;
                } else {
                    if (speed == targetJumpSpeed) {
                        System.out.println("WAIT");
                    } else if (speed > targetJumpSpeed) {
                        System.out.println("SLOW");
                    } else if (speed < targetJumpSpeed) {
                        System.out.println("SPEED");
                    }
                }
            }
        }
    }
    public static int calculateOptimalJumpSpeedNeededToJumpTheGap( int gap ) {
        return gap + 1;
    }
}
