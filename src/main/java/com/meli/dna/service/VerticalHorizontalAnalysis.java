package com.meli.dna.service;

public class VerticalHorizontalAnalysis implements Analysis {
    @Override
    public int run(String[][] matrix) {
        String lineChar = "";
        String columnChar = "";
        int lineCount = 0;
        int columnCount = 0;
        int totalGroups = 0;

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                String currentLineChar = matrix[i][j];
                String currentColumnChar = matrix[j][i];

                lineCount = currentLineChar.equals(lineChar) ? lineCount += 1 : 1;
                columnCount = currentColumnChar.equals(columnChar) ? columnCount += 1 : 1;

                if (lineCount == 4) {
                    totalGroups++;
                }
                if (columnCount == 4) {
                    totalGroups++;
                }

                lineChar = currentLineChar;
                columnChar = currentColumnChar;
            }

            lineChar = "";
            columnChar = "";
            lineCount = 0;
            columnCount = 0;
        }

        return totalGroups;
    }
}
