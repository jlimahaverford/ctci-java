package Chapter1.Question1_7;

import java.util.Arrays;

public class Question {

    public static void zeroOut(int[][] matrix, int m, int n) {
        boolean[] shouldZeroRow = new boolean[m];
        boolean[] shouldZeroColumn = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    shouldZeroRow[i] = true;
                    shouldZeroColumn[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (shouldZeroRow[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (shouldZeroColumn[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 0}, {6, 7, 8}, {0, 9, 10}};
        int[][] matrix2 = new int[][]{{1, 2, 3}, {0, 0, 0}, {6, 7, 8}, {1, 9, 10}};
        int[][] matrix3 = new int[][]{{0, 2, 3}, {0, 5, 4}, {0, 7, 8}, {0, 9, 10}};
        int[][] matrix4 = new int[][]{{12, 2, 3}, {15, 5, 4}, {0, 7, 8}, {17, 9, 10}};

        System.out.println("Original Matrix 1:");
        print(matrix1);
        zeroOut(matrix1, 4, 3);
        System.out.println("Modified Matrix 1:");
        print(matrix1);

        System.out.println("Original Matrix 2:");
        print(matrix2);
        zeroOut(matrix2, 4, 3);
        System.out.println("Modified Matrix 2:");
        print(matrix2);

        System.out.println("Original Matrix 3:");
        print(matrix3);
        zeroOut(matrix3, 4, 3);
        System.out.println("Modified Matrix 3:");
        print(matrix3);

        System.out.println("Original Matrix 4:");
        print(matrix4);
        zeroOut(matrix4, 4, 3);
        System.out.println("Modified Matrix 4:");
        print(matrix4);
    }
}

// Compilation Errors
// 1) Don't forget "new"