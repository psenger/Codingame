import java.util.*;

public class HorseRacingDuals {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> greatestStrength = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            greatestStrength.add(pi);
        }
        Collections.sort(greatestStrength);

        int diff = Integer.MAX_VALUE;

        Integer[] integers = greatestStrength.toArray(new Integer[greatestStrength.size()]);
        for (int i = 1; i < integers.length; i++) {
            Integer next1 = integers[i-1];
            Integer next2 = integers[i];
            if (  ( next2 - next1 ) <= diff  ) {
                diff = ( next2 - next1 );
            }
        }

        System.out.println(diff);
    }

}
