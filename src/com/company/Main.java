package com.company;

public class Main {

    private static int[] Weight = {5, 40, 8, 4, 10, 10, 23};
    private int[][] A = new int[7][7];

    public Main() {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++)
                this.A[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        Main m = new Main();

        int s = 0;
        while (s < Weight.length) {
            int i = 0;
            while (i < Weight.length && i + s < Weight.length) {
                int minA = 0;
                for (int r  = i; r <= i + s; r++) {
                    int resultByR = getSumWeigth(i, i + s) + m.getAValue(i, r - 1) + m.getAValue(r + 1, i + s);
                    if (minA == 0)
                        minA = resultByR;
                    if (minA > resultByR)
                        minA = resultByR;
                }
                m.setAValue(i, i + s, minA);
                i++;
            }
            s++;
        }

        for (int x = 0; x < Weight.length; x++) {
            for (int y = 0; y < Weight.length; y++)
                System.out.println("A[" + x + "][" + y + "] = " + m.getAValue(x, y));
        }

    }

    static int getSumWeigth(int fromIndex, int toIndex) {
        int result = 0;
        for(int j = fromIndex; j <= toIndex; j++) {
            result += Weight[j];
        }
        return result;
    }

    int getAValue(int x, int y) {
        try {
            return this.A[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }

    void setAValue(int x, int y, int value) {
        this.A[x][y] = value;
    }
}
