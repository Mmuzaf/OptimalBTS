package com.company;

public class Main {

    private static int[] Weigth = {5, 40, 8, 4, 10, 10, 23};

    public static void main(String[] args) {
        // initialize array
	    int A[][] = new int[7][7];
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++)
                A[x][y] = 0;
        }

        int i = 1;
        int j = 1;
        int s = j - i;

        while (s < 7) {
            while (i <= 7) {
                int minA = 0;
                for (int r  = i; r <= i + s; r++) {
                    int resultByR = getSumWeigth(i, i + s) + A[i][r - 1] + A[r + 1][i + s];
                    if (minA == 0)
                        minA = resultByR;
                    if (minA > resultByR)
                        minA = resultByR;
                }
                A[i][i + s] = minA;
                i++;
            }
            j++;
            s = j - i;
        }
    }

    static int getSumWeigth(int fromIndex, int toIndex) {
        int result = 0;
        for(int j = fromIndex; j <= toIndex; j++) {
            result += Weigth[j];
        }
        return result;
    }
}
