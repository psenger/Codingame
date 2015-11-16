import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MIMEType {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner in = new Scanner(new File("/Users/philipsenger/Documents/Dev/Codingame/sample/MIMEtypes/test3.txt"));
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        in.nextLine();
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            map.put(EXT.toLowerCase(),MT);
            in.nextLine();
        }
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            String extension = "";
            int j = FNAME.lastIndexOf('.');
            if (j >= 0) {
                extension = (FNAME.substring(j + 1)).toLowerCase();
            }
            System.out.println( ( (map.get(extension) == null) ? "UNKNOWN" : map.get(extension)));
        }
    }
}
