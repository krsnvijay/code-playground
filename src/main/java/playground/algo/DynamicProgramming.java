package playground.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProgramming {
    public static boolean canSum(int[] nums, int target, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return true;
        if (target < 0) return false;
        for (int num : nums) {
            if (canSum(nums, target - num, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static List<Integer> howSum(int[] nums, int target, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        for (int num : nums) {
            List<Integer> result = howSum(nums, target - num, memo);
            if (result != null) {
                result.add(num);
                memo.put(target, result);
                return result;
            }
        }
        memo.put(target, null);
        return null;
    }

    public static List<Integer> bestSum(int[] nums, int target, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        List<Integer> bestResult = null;
        for (int num : nums) {
            List<Integer> result = bestSum(nums, target - num, memo);
            if (result != null) {
                List<Integer> combination = new ArrayList<>(result);
                combination.add(num);
                if (bestResult == null || bestResult.size() > combination.size()) {
                    bestResult = combination;
                }
            }
        }
        memo.put(target, bestResult);
        return bestResult;
    }

    public static int moveGrid(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m < 1 || n < 1) return 0;
        memo.put(key, moveGrid(m - 1, n, memo) + moveGrid(m, n - 1, memo));
        return memo.get(key);
    }

    public static Long fib(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2)
            return 1L;
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        HashMap<Integer, Boolean> memoSum = new HashMap<>();
        System.out.println(canSum(new int[]{7, 14}, 10000, memoSum));
        HashMap<String, Integer> memoGrid = new HashMap<>();
        System.out.println(moveGrid(2, 2, memoGrid));
        HashMap<Integer, Long> memoFib = new HashMap<>();
        System.out.println(fib(500, memoFib));
        HashMap<Integer, List<Integer>> memoHow = new HashMap<>();
        System.out.println(howSum(new int[]{8, 5, 2, 3}, 51, memoHow));
        HashMap<Integer, List<Integer>> memoBest = new HashMap<>();
        System.out.println(bestSum(new int[]{  5, 15, 25}, 100, memoBest));
    }
}

