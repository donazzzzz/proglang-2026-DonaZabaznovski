public class Exercises {
    // Task 1 (warm up). true when n is even.
    public static boolean isEven(int n) {

        if (n % 2 == 0) {
            return true;
        }
        return false; // TODO
    }

    // Task 2. The largest of three numbers.
    public static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max; // TODO
    }

    // Task 3. 1 to 5 gives "working day", 6 and 7 give "weekend",
    // everything else gives "invalid". Use a switch expression.
    public static String dayType(int day) {
        return switch (day) {
            case 1, 2, 3, 4, 5 -> "working day";
            case 6, 7 -> "weekend";
            default -> "invalid";
        }
                ; // TODO
    }

    // Task 4. The sum 1 + 2 + ... + n. For n smaller than 1 the result is 0.
    public static int sumTo(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum; // TODO
    }

    // Task 5. How many digits the number has. n is never negative. countDigits(0) is 1.
    public static int countDigits(int n) {
        int digits = 1;
        while (n >= 10) {
            n = n / 10;
            digits++;
        }
        return digits; // TODO
    }

    // Task 6. The sum of all elements. An empty array gives 0.
    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    // Task 7. The largest element. The array has at least one element.
    public static int max(int[] values) {
        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max; // TODO
    }

    // Task 8. How many elements are even.
    public static int countEvens(int[] values) {
        int count = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                count++;
            }
        }
        return count; // TODO
    }


    // Task 9. A NEW array with the same elements in reverse order.
    // The array that was passed in must stay unchanged.
    public static int[] reverse(int[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[values.length - 1 - i];
        }
        return result;
    }

    // Task 10. true when the text reads the same from both ends, like "level".
    // Use text.length() and text.charAt(index).
    public static boolean isPalindrome(String text) {
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true; // TODO
    }

    // Stretch A. The second largest value. The array holds at least two different values.
    // Example: {4, 9, 9, 7} gives 7.
    public static int secondLargest(int[] values) {
        int largest = values[0];
        Integer second = null;
        for (int i = 1; i < values.length; i++) {
            int v = values[i];
            if (v > largest) {
                second = largest;
                largest = v;
            } else if (v < largest && (second == null || v > second)) {
                second = v;
            }
        }
        return second;
    }

    // Stretch B. The first n rows of Pascal's triangle as a jagged array.
    // Row 0 is {1}, row 1 is {1, 1}, row 2 is {1, 2, 1}, row 3 is {1, 3, 3, 1}.
    // Each inner number is the sum of the two numbers above it.
    public static int[][] pascal(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }
}