import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Defibrillators {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner(new File("/Users/philipsenger/Documents/Dev/Codingame/sample/defibrillators/test.txt"));
        String LON = in.next();
        in.nextLine();
        String LAT = in.next();
        in.nextLine();
        int N = in.nextInt();
        in.nextLine();

        double longitudeLocation = Double.parseDouble(LON.replace(",", "."));
        double latitudeLocation = Double.parseDouble(LAT.replace(",", "."));

        double smallest = Double.MAX_VALUE;
        String smallestName = "";

        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] split = DEFIB.split(";");

            //  int id = Integer.parseInt(split[0]);
            String name = split[1];
            // String address = split[2];
            // String phonenumber = split[3];
            double longitude = Double.parseDouble(split[4].replace(",", "."));
            double latitude = Double.parseDouble( split[5].replace(",", "."));

            double k = distance(latitudeLocation, longitudeLocation, latitude, longitude, "K");
            if ( smallest >= k ) {
                smallestName = name;
                smallest = k;
            }
        }

        System.out.println(smallestName);
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
