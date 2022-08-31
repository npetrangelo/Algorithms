package com.company;

import java.util.Scanner;

public class SmallestTwo {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        arr = new int[size];

        for (int i = 0; (i < size && scanner.hasNextInt()); i++) {
            arr[i] = scanner.nextInt();
        }

        int smallest = size;
        int secondSmallest = size;

        for (int n : arr) {
            if (n < smallest) {
                secondSmallest = smallest;
                smallest = n;
            }
        }

        System.out.println(smallest);
        System.out.println(secondSmallest);
    }
}
