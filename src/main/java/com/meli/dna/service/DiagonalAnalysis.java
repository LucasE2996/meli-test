package com.meli.dna.service;

public class DiagonalAnalysis implements Analysis {
    @Override
    public int run(String[][] matrix) {
        int n = matrix.length;
        String letter = "";
        int totalGroups = 0;

        // iterates first part of diagonal
        for (int k = 0; k <= n-1; k++) {
            int i=k;
            int j=0;
            int count = 0;
            letter = "";
            while(i >= 0) {
                count = matrix[i][j].equals(letter) ? count += 1 : 1;
                letter = matrix[i][j];
                if (count == 4)
                    totalGroups++;

                i--;
                j++;
            }
        }

        // iterates second part of diagonal
        for (int k = 1; k <= n-1; k++) {
            int i = n - 1;
            int j = k;
            int count = 0;
            letter = "";
            while(j <= n-1) {
                count = matrix[i][j].equals(letter) ? count += 1 : 1;
                letter = matrix[i][j];
                if (count == 4)
                    totalGroups++;

                i--;
                j++;
            }
        }

        // iterates first part of diagonal
        for (int k = n-1; k >= 0; k--) {
            int i=0;
            int j=k;
            int count = 0;
            letter = "";
            while(j <= n-1) {
                count = matrix[i][j].equals(letter) ? count += 1 : 1;
                letter = matrix[i][j];
                if (count == 4)
                    totalGroups++;
                j++;
                i++;
            }
        }

        // iterates second part of diagonal
        for (int k = 1; k <= n-1; k++) {
            int i = k;
            int j = 0;
            int count = 0;
            letter = "";
            while(i <= n-1) {
                count = matrix[i][j].equals(letter) ? count += 1 : 1;
                letter = matrix[i][j];
                if (count == 4)
                    totalGroups++;
                i++;
                j++;
            }
        }

        return totalGroups;
    }
}
