package com.dinesh.algo.homework;

public class RotateMatrix {
    public static void main(String[] args) {
        RotateMatrix matrix = new RotateMatrix();
        int[][] numMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        matrix.rotate(numMatrix);
    }

    public void rotate(int[][] matrix) {

        int len = matrix.length;
        /* matrix =
            1 2 3
            4 5 6
            7 8 9
         */
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                result[j][i] = matrix[i][j];
            }
        }
        /* result =
            1 4 7
            2 5 8
            3 6 9
         */
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][matrix[i].length - 1-j] = result[i][j];
            }
        }
        /*
          7 4 1
          8 5 2
          9 6 3
         */



    }
}
