package playground.core;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static boolean isRightTriangle(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return false;
        }
        return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        System.out.println(isRightTriangle(a, b, c));
    }
}
