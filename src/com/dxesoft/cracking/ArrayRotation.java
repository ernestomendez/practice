package com.dxesoft.cracking;

import java.util.Scanner;

public class ArrayRotation {

    public void arrayLeftRotation() {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();
    }

    private int[] arrayLeftRotation(int[] a, int n, int k) {
        if (k < n) {
            rotate(a, n, k);
        } else if (k > n) {
            int i = k % n;
            rotate(a, n, i);
        }

        return a;
    }

    private int[] rotate(int[] array, int size, int rotation) {

        reverse(array, 0, rotation - 1);
        reverse(array, rotation, size - 1);
        reverse(array, 0, size -1);

        return array;

    }

    private void reverse(int[] array, int start, int end) {

        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start ++;
            end --;
        }
    }
}
