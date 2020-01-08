package basics.learning.java8.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPrimesAndComposites {

    /**
     * <p>
     * You are given an array of integers, you have to put them in an order such that
     * all the prime numbers are in ascending order and the composite ones are in descending order (in-place)
     * to their corresponding position in original array i.e. primes at prime's places and composite at composite's places.
     * </p>
     * Input: 5, 4, 3, 7, 8, 10
     * Output: 3, 10, 5, 7, 8, 4
     */

    public static void main(String[] args) {
        int[] integers = {29, 5, 4, 3, 7, 8, 10, 89, 17, 90};


        for (int elements : integers) {
            System.out.print(elements + " ");
        }

        System.out.println();

        List<Integer> prime = new ArrayList<>();

        int primeIndexCount = 0;
        int compositeIndexCount = 0;

        int[] finalArray = new int[integers.length];
        List<Integer> composite = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            if (isPrime(integers[i])) {
                prime.add(integers[i]);
            } else {
                composite.add(integers[i]);
            }
        }

        Collections.sort(prime);
        Collections.sort(composite, Collections.reverseOrder());

        for (int i = 0; i < integers.length; i++) {
            if (isPrime(integers[i])) {
                finalArray[i] = prime.get(primeIndexCount++);
            } else {
                finalArray[i] = composite.get(compositeIndexCount++);
            }
        }

        for (int elements : finalArray) {
            System.out.print(elements + " ");
        }
    }

    private static boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) { // can be optimised
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    // optimised solution
    public static void main2(String[] args) {
        int[] integers = {29, 5, 4, 3, 7, 8, 10, 89, 17, 90};
        boolean[] isPrime = new boolean[integers.length]; // storing if the numbers is prime or not

        for (int elements : integers) {
            System.out.print(elements + " ");
        }

        System.out.println();

        List<Integer> prime = new ArrayList<>();

        int primeIndexCount = 0;
        int compositeIndexCount = 0;

        int[] finalArray = new int[integers.length];
        List<Integer> composite = new ArrayList<>();

        for (int i = 0; i < integers.length; i++) {
            boolean isPrimeNumber = isPrime(integers[i]);
            isPrime[i] = isPrimeNumber; // storing prime state to the boolean array

            if (isPrimeNumber) {
                prime.add(integers[i]);
            } else {
                composite.add(integers[i]);
            }
        }

        Collections.sort(prime);
        Collections.sort(composite, Collections.reverseOrder());

        for (int i = 0; i < integers.length; i++) {
            if (isPrime[i]) {
                finalArray[i] = prime.get(primeIndexCount++);
            } else {
                finalArray[i] = composite.get(compositeIndexCount++);
            }
        }

        for (int elements : finalArray) {
            System.out.print(elements + " ");
        }
    }


}


