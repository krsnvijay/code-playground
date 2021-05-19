package playground.core;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class GreatCircle {
    public static String calculateGreatDistance(double x1, double y1, double x2, double y2) {
        double r = 6371.0;
        double firstHalf = Math.pow(Math.sin((x2 - x1) / 2.0), 2);
        double secondHalf = Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2.0), 2);
        double haversine = 2 * r * Math.asin(Math.sqrt(firstHalf + secondHalf));
        return haversine + " kilometers";
    }

    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        System.out.println(calculateGreatDistance(x1, y1, x2, y2));
    }
}
