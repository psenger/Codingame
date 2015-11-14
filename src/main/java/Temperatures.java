

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * <p></p>
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 11/14/15
 */
public class Temperatures {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        int min = 0;
        if ( n > 0 ) {
            int[] alltemps = convertToInt( temps.split(" ") );
            min = Integer.MAX_VALUE;
            for (int alltemp : alltemps) {
                int temp = Math.abs(alltemp);
                if (temp <= min) {
                    min = temp;
                }
            }
        }
        System.out.println( min );
    }

    private static int[] convertToInt(String[] split) {
        int[] toInts = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            toInts[i] = Integer.valueOf(split[i]);
        }
        return toInts;
    }
}
