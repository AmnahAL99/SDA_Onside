package HW.Day07;

public class JavaProgram {

        public static void main(String[] args) {
            // 1. Reverse String Example
            String original = "hello";
            String reversed = reverseString(original);
            System.out.println("Reversed string: " + reversed);

            // 2. Swap Numbers Example
            swapNumbers();

            // 3. Fibonacci Sequence Example
            printFibonacciSequence(10);

            // 4. Check Prime Number Example
            checkPrimeNumber(29);

            // 5. Difference Between Biggest and Smallest Numbers in an Array Example
            findMinMaxDifference();
        }

        public static String reverseString(String str) {
            String reversed = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed += str.charAt(i);
            }
            return reversed;
        }

        public static void swapNumbers() {
            int a = 10;
            int b = 20;
            System.out.println("Before swap: a = " + a + ", b = " + b);
            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println("After swap: a = " + a + ", b = " + b);
        }

        public static void printFibonacciSequence(int n) {
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
            System.out.println(); // Move to the next line after printing the sequence
        }

        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

        public static void checkPrimeNumber(int num) {
            boolean isPrime = isPrime(num);
            if (isPrime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        }

        public static boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static void findMinMaxDifference() {
            int[] arr = {1, 2, 5, 10, 20};
            int difference = maxMinDifference(arr);
            System.out.println("Difference: " + difference);
        }

        public static int maxMinDifference(int[] arr) {
            int max = arr[0], min = arr[0];
            for (int i : arr) {
                if (i > max) max = i;
                if (i < min) min = i;
            }
            return max - min;
        }
    }
