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

    public static Map<String, Integer> buildValidCharToPositionMap(String validLetters) {
        Map<String, Integer> map = new HashMap<>();
        String[] letters = validLetters.split("");
        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            map.put(letter, i);
        }
        return map;
    }

    private static List<Integer> translateCharToPositions(String lettersToMap, Map<String, Integer> validLettersToPositionMap, int maxLengthOfAChars) {
        List<Integer> positions = new ArrayList();
        String[] splits = (lettersToMap == null) ? new String[]{} : lettersToMap.split("");
        for (String split : splits) {
            Integer position;
            if (validLettersToPositionMap.containsKey(split.toUpperCase())) {
                position = validLettersToPositionMap.get(split.toUpperCase());
            } else {
                List<String> strings = new ArrayList<>(validLettersToPositionMap.keySet());
                String lastString = strings.get(strings.size() - 1);
                position = validLettersToPositionMap.get(lastString);
            }
            positions.add(position * maxLengthOfAChars);
        }
        return positions;
    }

    private static String[] loadBlockChars(int maxHeightOfALetter, Scanner in) {
        String[] ROW = new String[maxHeightOfALetter];
        for (int i = 0; i < maxHeightOfALetter; i++) {
            ROW[i] = in.nextLine();
        }
        return ROW;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner(new File("/Users/philipsenger/Documents/Dev/Codingame/asciiart.txt"));
        int L = in.nextInt();
        in.nextLine();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();

        Map<String, Integer> validCharToPositionMap = buildValidCharToPositionMap("ABCDEFGHIJKLMNOPQRSTUVWXYZ?");

        // load the block characters.
        String[] ROW = loadBlockChars(H, in);

        /**
         * get all the valid positions in the Letter.
         * eg 0=A, 1=B, 2=C
         */
        List<Integer> positions = translateCharToPositions(T, validCharToPositionMap, L);
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            sbs.add(new StringBuilder());
        }
        for (Integer position : positions) {
            for (int j = 0; j < ROW.length; j++) {
                sbs.get(j).append(ROW[j].substring(position, position + L));
            }
        }

        for (StringBuilder next : sbs) {
            System.out.println(next.toString());
        }

    }

}
