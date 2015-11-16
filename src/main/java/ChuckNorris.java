
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ChuckNorris {

    private static final Charset chatset = Charset.forName("US-ASCII");

    private static String cal(char binary) {
        if (binary == '0') {
            return "00 ";
        } else {
            return "0 ";
        }
    }

    private static char[] buildBinaryString(byte[] bytes) {
        StringBuilder binary = new StringBuilder(); // "0000000"
        for (byte b : bytes) {
            String filledNum = "0000000" + Integer.toBinaryString(Byte.toUnsignedInt(b));
            binary.append( filledNum.substring( filledNum.length()-7, filledNum.length()) );
        }
        return binary.toString().toCharArray();
    }

    public static void main(String args[]) throws FileNotFoundException {
//        Scanner in = new Scanner(new File("/Users/philipsenger/Documents/Dev/Codingame/sample/chucknorris/test.txt"));
//        while (in.hasNext()) {
        Scanner in = new Scanner(System.in);

//            System.err.println("--------------");
            String MESSAGE = in.nextLine();
//            String EXPECTED = in.nextLine();

            byte[] bytes;
            char[] chars;
            StringBuilder chucknary = new StringBuilder();

            /**
             * First turn the message into Bytes.
             */
            bytes = MESSAGE.trim().getBytes(chatset);

            /**%
             * Convert the newly created bytes of 0/1 to an array of Characters.
             */
            chars = buildBinaryString(bytes);

//            System.err.println("    bytes = " + Arrays.toString(bytes) + " " + Arrays.toString(chars).replace("[","").replace("]","").replace(", ",""));
            // System.err.println("chars = " + Arrays.toString(chars));
            String glue = "";
            for (int i = 0; i < chars.length; i++) {
                char a = chars[i];
                // System.out.println("a = " + a);
                chucknary.append(glue).append(cal(a));
                for (int j = i; j < chars.length; j++) {
                    char b = chars[j];
                    if (a == b) {
                        i = j;
                        chucknary.append('0');
                    } else {
                        break;
                    }
                }
                glue = " ";
            }

//            System.err.println("  MESSAGE = " + MESSAGE);
//            System.err.println(" EXPECTED = " + EXPECTED);
//            System.err.println("CHUCKNARY = " + chucknary);
//            System.err.println("     " + ((EXPECTED.equals(chucknary.toString())) ? "PASS" : "FAIL"));
        System.out.println(chucknary.toString());
//        }
    }

}
