package playground.core;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class CMYKtoRGB {
    public static String convertCMYKToRGB(double c, double m, double y, double k) {
        double white = 1 - k;
        int red = (int) (255 * white * (1 - c));
        int green = (int) (255 * white * (1 - m));
        int blue = (int) (255 * white * (1 - y));
        return String.format("red = %d\ngreen = %d\nblue = %d", red, green, blue);
    }

    public static void main(String[] args) {
        double c = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double k = Double.parseDouble(args[3]);
        System.out.println(convertCMYKToRGB(c, m, y, k));
    }
}
