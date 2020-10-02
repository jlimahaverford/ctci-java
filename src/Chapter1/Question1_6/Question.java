package Chapter1.Question1_6;

import java.util.Arrays;

public class Question {

    public static void rotate(int[][] image) {
        int n = image.length;
        if (n == 0) {
            throw new RuntimeException();
        }
        int m = image[0].length;
        if (n != m) {
            throw new RuntimeException();
        }

        int nOverTwoCeil = (int) Math.ceil(n / 2.0);
        int nOverTwoFloor = (int) Math.floor(n / 2.0);

        int hold;
        for (int i = 0; i < nOverTwoCeil; i++) {
            for (int j = 0; j < nOverTwoFloor; j++) {
                hold = image[i][j];
                image[i][j] = image[n-j-1][i];
                image[n-j-1][i] = image[n-i-1][n-j-1];
                image[n-i-1][n-j-1] = image[j][n-i-1];
                image[j][n-i-1] = hold;
            }
        }
    }

    public static void main(String[] args) {
        int[][] image1 = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        System.out.println("Original Image 1:");
        for (int[] ints : image1) {
            System.out.println(Arrays.toString(ints));
        }
        Question.rotate(image1);
        System.out.println("Rotated Image 1:");
        for (int[] ints : image1) {
            System.out.println(Arrays.toString(ints));
        }

        int[][] image2 = new int[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        System.out.println("Original Image 2:");
        for (int[] ints : image2) {
            System.out.println(Arrays.toString(ints));
        }
        Question.rotate(image2);
        System.out.println("Rotated Image 2:");
        for (int[] ints : image2) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("Complete");
    }
}

// Compilation Errors
// 1) System.out.println()
// 2) Must import java.util.Arrays
// 3) Simplified array iteration notation "for (int x : intArray) {}"