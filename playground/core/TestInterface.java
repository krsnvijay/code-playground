package playground.core;

import java.util.Comparator;

public class TestInterface {
    public interface IntSequence {
        boolean hasNext();

        int next();

    }

    public static class Digit implements IntSequence {
        private int number;

        Digit(int number) {
            this.number = number;
        }

        @Override
        public boolean hasNext() {
            return this.number != 0;
        }

        @Override
        public int next() {
            int lastDigit = this.number % 10;
            this.number /= 10;
            return lastDigit;
        }

        public int rest() {
            return this.number;
        }
    }

    public static void main(String[] args) {
        Digit aNumber = new Digit(890120);
        while (aNumber.hasNext()) {
            System.out.println(aNumber.next());
        }
        System.out.println(aNumber.rest());
        Comparator<String> comp = (first, second) -> first.length() - second.length();

    }
}
