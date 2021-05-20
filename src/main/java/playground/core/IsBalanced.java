package playground.core;

import playground.ds.Stack;

public class IsBalanced {
    public static boolean areBracketsBalanced(char[] expression) {
        Stack stack = new Stack();
        for (char bracket : expression) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
                System.out.println(stack);
            } else {
                if (stack.isEmpty())
                    return false;
                char poppedValue = stack.pop();
                if ((bracket == '(' && poppedValue != ')')
                        || (bracket == '[' && poppedValue != ']')
                        || (bracket == '{' && poppedValue != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(areBracketsBalanced("(({[]()}))".toCharArray()));
    }
}
