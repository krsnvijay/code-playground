package playground.core;

import java.math.BigInteger;
import java.util.Arrays;

public class HelloWorld {
    /* 
    Write a program that reads an integer and prints it in binary, octal, and
    hexadecimal. Print the reciprocal as a hexadecimal floating-point number.
    */
    public static void printInteger(int number) {
        System.out.printf("%s %o %x %d %a\n", Integer.toString(number, 2), number, number, number, 1f / number);
    }

    /*
    Write a program that reads an integer angle (which may be positive or
    negative) and normalizes it to a value between 0 and 359 degrees. Try
    it first with the % operator, then with floorMod .
    */
    public static void angleNormalizer(int angle) {
        int normalizedAngle = ((angle % 360) + 360) % 360;
        int floorNormalizedAngle = Math.floorMod(angle, 360);
        System.out.println(normalizedAngle + " " + floorNormalizedAngle);
    }

    /*
    Using only the conditional operator, write a program that reads three
    integers and prints the largest. Repeat with Math.max 
    */
    public static void findLargest(int a, int b, int c) {
        int firstLargest = a < b ? b : a;
        int largest = firstLargest < c ? c : firstLargest;

        int firstLargestMath = Math.max(a, b);
        int largestMath = Math.max(firstLargestMath, c);
        System.out.println(largest + " " + largestMath);
    }

    /*
    Write a program that prints the smallest and largest positive double values.
    Hint: Look up Math.nextUp in the Java API.
    */
    public static void printLargestAndSmallest() {
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
    }

    /*
    What happens when you cast a double to an int that is larger than the
    largest possible int value? Try it out.
    */
    public static void checkCast(double d) {
        int x = (int) d;
        System.out.println(x);
    }

    /*
    Write a program that computes the factorial n! = 1 × 2 × . . . × n, using
    BigInteger . Compute the factorial of 1000.
    */
    public static void factorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        while (n > 0) {
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(factorial);
    }

    /*
    Write a program that reads in two integers between 0 and 4294967295,
    stores them in int variables, and computes and displays their unsigned
    sum, difference, product, quotient, and remainder. Do not convert them
    to long values.
    */
    public static void unsignedIntOperations(int a, int b) {
        long aLong = a > 0 ? a : 2L * Integer.MAX_VALUE + a + 2;
        long bLong = b > 0 ? b : 2L * Integer.MAX_VALUE + b + 2;
        System.out.printf(
                "%d %d %d %d %d \n",
                aLong + bLong,
                aLong - bLong,
                BigInteger.valueOf(aLong).multiply(BigInteger.valueOf(bLong)),
                aLong / bLong,
                aLong % bLong
        );
    }

    /*
    Write a program that reads a string and prints all of its nonempty
    substrings.
    */
    public static void printEmptySubstrings(String text) {
        System.out.println(Arrays.toString(text.split(" ")));
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        printInteger(19);
        angleNormalizer(-480);
        findLargest(-20, -1, 16);
        printLargestAndSmallest();
        checkCast(Integer.MAX_VALUE + 1);
        factorial(5);
        unsignedIntOperations((int) 4294967290L, (int) 4294917290L);
        printEmptySubstrings("How are you?");

    }
}