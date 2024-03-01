import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: array of integers
        System.out.print("Enter the array of integers (comma-separated): ");
        String[] numsInput = scanner.nextLine().split(",");
        int[] nums = new int[numsInput.length];
        for (int i = 0; i < numsInput.length; i++) {
            nums[i] = Integer.parseInt(numsInput[i].trim());
        }

        // Input: target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Find the indices
        int[] result = twoSum(nums, target);

        // Output the result
        System.out.println("Indices of the two numbers that add up to the target: [" + result[0] + ", " + result[1] + "]");

        scanner.close();
    }
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        static {
            romanMap = new HashMap<>();
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);
        }

        public static int romanToInteger(String roman) {
            int result = 0;
            int prevValue = 0;

            for (int i = roman.length() - 1; i >= 0; i--) {
                char currentChar = roman.charAt(i);
                int currentValue = romanMap.get(currentChar);

                if (currentValue < prevValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }

                prevValue = currentValue;
            }

            return result;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a Roman numeral: ");
            String romanNumeral = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitivity

            int result = romanToInteger(romanNumeral);
            System.out.println("Roman numeral " + romanNumeral + " is equivalent to " + result);

            scanner.close();
        }
        return 0;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        public static void generatePermutations(int[] arr, int start, int end) {
            if (start == end) {
                System.out.println(Arrays.toString(arr));
                return;
            }

            for (int i = start; i <= end; ++i) {
                swap(arr, start, i);
                generatePermutations(arr, start + 1, end);
                swap(arr, start, i);  // Backtrack
            }
        }

        public static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Input array size
            System.out.println("Enter the size of the array: ");
            int n = scanner.nextInt();

            // Input array elements
            int[] array = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Permutations:");
            generatePermutations(array, 0, n - 1);
        }
    }
        return null;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}