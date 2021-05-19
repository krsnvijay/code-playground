package playground.leetcode;

import java.util.Arrays;
import java.util.HashMap;

class LeetCodeArrays {
    public static int trailingZeroes(int N) {
        // Write your code here
        int k = (int) Math.floor(Math.log(N) / Math.log(5)) + 1;
        int trailingZeros = 0;
        for (int i = 1; i < k; i++) {
            trailingZeros += (N / Math.pow(5, i));
        }
        return trailingZeros;
    }

    public static int recursionTrailingZeroes(int N) {
        // Write your code here
        if (N < 5)
            return 0;
        return (N / 5) + trailingZeroes(N / 5);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        // code here

        HashMap<Integer, Integer> table = new HashMap<>();
        StringBuilder result = new StringBuilder();
        float ans = numerator / (float) denominator;
        int rem = numerator % denominator;
        while (rem != 0 && !table.containsKey(rem)) {
            table.put(rem, result.length());
            rem *= 10;
            result.append(rem / denominator);
            rem %= denominator;
        }
        if (rem == 0)
            return String.format("%d.%s", (int) ans, result);
        else return String.format("%d.(%s)", (int) ans, result.substring(table.get(rem)));
    }

    public static void shiftRightInPlaceAndInsert(int[] nums1, int pos, int newElement) {
        for (int i = nums1.length - 1; i > pos; i--) {
            nums1[i] = nums1[i - 1];
        }
        nums1[pos] = newElement;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0, r = 0;
        while (l < m + r && r < n) {
            if (nums1[l] > nums2[r]) {
                shiftRightInPlaceAndInsert(nums1, l++, nums2[r++]);
            } else {
                l++;
            }
        }
        while (l < m + n && r < nums2.length) {
            nums1[l++] = nums2[r++];
        }
    }

    public static void deleteAt(int[] nums, int pos) {
        for (int i = pos + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = -1;
    }

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i != nums.length) {
            if (val == nums[i]) {
                deleteAt(nums, i);
                len--;
            } else {
                i++;
            }
        }
        return len;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = nums.length;
        int i = 1;
        int prev = nums[0];
        while (i != len) {
            if (nums[i] == prev) {
                deleteAt(nums, i);
                len--;
            } else {
                prev = nums[i];
                i++;
            }
        }
        return len;
    }

    public static int removeDuplicatesBetter(int[] nums) {
        if (nums.length == 0)
            return 0;
        int uniqueElement = nums[0];
        int uniqueIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != uniqueElement) {
                uniqueIdx++;
                uniqueElement = nums[i];
                nums[uniqueIdx] = nums[i];
            }
        }
        return uniqueIdx + 1;
    }

    public static boolean binarySearch(int[] arr, int element) {
        if (arr.length == 0) {
            return false;
        }
        int beg = 0;
        int end = arr.length;
        while (beg < end) {
            int mid = (beg + end) / 2;
            if (element == arr[mid]) {
                return true;
            }
            if (element < arr[mid]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return false;
    }

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && ((arr[i] == arr[j] * 2) || (arr[j] == arr[i] * 2)))
                    return true;
            }
        }
        return false;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;
        int i;
        // Traverse uphill
        for (i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                return false;
            if (arr[i] < arr[i - 1]) {
                break;
            }
        }
        // Only Downhill or only only Uphill not a mountain
        if (i == 1 || i == arr.length) {
            return false;
        }

        // Traverse downhill
        for (; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
                return false;
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }
        return i == arr.length;
    }

    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int currentMax = 0;
            if (i == arr.length - 1) {
                currentMax = -1;
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > currentMax) {
                    currentMax = arr[j];
                }
            }
            arr[i] = currentMax;
        }
        return arr;
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;
        int writePointer = 0;
        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != 0) {
                nums[writePointer++] = nums[readPointer];
            }
        }
        while (writePointer < nums.length) {
            nums[writePointer++] = 0;
        }
    }

    public static int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1)
            return nums;
        int writePointer = 0;
        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] % 2 == 0) {
                int tempValue = nums[writePointer];
                nums[writePointer++] = nums[readPointer];
                nums[readPointer] = tempValue;
            }
        }
        return nums;

    }


    public static void main(String[] args) {
        // TODO: replace these with unit tests
        System.out.println(trailingZeroes(60));
        System.out.println(fractionToDecimal(2, 33));
        int[] a = {4, 0, 0, 0, 0, 0};
        int[] b = {1, 2, 3, 5, 6};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        merge(a, 1, b, 5);
        System.out.println(Arrays.toString(a));

        int[] c = {4, 4, 0, 1, 0, 2};
        System.out.println(removeElement(c, 0));
        System.out.println(Arrays.toString(c));

        int[] d = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(d));
        System.out.println(Arrays.toString(d));

        System.out.println(binarySearch(b, 6));

        int[] e = {-2, 0, 10, -19, 4, 6, -8};
        System.out.println(checkIfExist(e));

        int[] f = {2, 0, 2};
        int[] g = {0, 3, 2, 1};
        int[] h = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        System.out.println(validMountainArray(f));

        int[] i = {1, 1, 2};
        d = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicatesBetter(i));
        System.out.println(Arrays.toString(i));
        System.out.println(removeDuplicatesBetter(d));
        System.out.println(Arrays.toString(d));

        int[] j = {2, 1};
        int[] k = {0, 1, 0, 3, 12};
        moveZeroes(j);
        System.out.println(Arrays.toString(j));

        int[] l = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(l)));
    }
}