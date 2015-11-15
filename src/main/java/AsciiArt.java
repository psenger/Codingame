import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * <p></p>
 *
 * @author psenger
 * @version 1.0
 * @see
 * @since 11/15/15
 */
public class AsciiArt {

    public static class letter {
        String name;
        String ascii;
    }

    public static Map<String,Integer> letterMap(){
        Map<String,Integer> map = new HashMap<>();
        String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?".split("");
        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            map.put( letter, i );
        }
        return map;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/psenger/Documents/Dev/Codingame/src/main/java/asciiart.txt"));
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();

        System.out.println("L = " + L);
        System.out.println("H = " + H);
        System.out.println("T = " + T);

        Map<String, Integer> stringIntegerMap = letterMap();

        // load the block characters.
        String[] ROW = new String[H];//[(L*27)];
        for (int i = 0; i < H; i++) {
             ROW[i] = in.nextLine();
        }

        List<Integer> positions = new ArrayList();
        String[] splits = T.split("");
        for (String split : splits) {
            positions.add(stringIntegerMap.get(split) * L);
        }

        for (int i = 0; i < H; i++) {

            for (Integer next : positions) {
                for (String aROW : ROW) {
                    String s = aROW.substring(next, next + L);
                    System.out.print(s);
                }
            }

        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

//        System.out.println("answer");
    }

}
