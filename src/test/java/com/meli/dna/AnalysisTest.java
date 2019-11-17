package com.meli.dna;

import com.meli.dna.service.Analysis;
import com.meli.dna.service.DiagonalAnalysis;
import com.meli.dna.service.VerticalHorizontalAnalysis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnalysisTest {

    @Test
    public void verticalSimianTest() {
        String[][] matrix = {{"T","T","G","T"}, {"C","T","G","G"}, {"C","T","G","G"}, {"C","T","G","G"}};

        Assertions.assertTrue(runTest(new VerticalHorizontalAnalysis(), matrix, 2));
    }

    @Test
    public void horizontalSimianTest() {
        String[][] matrix = {{"T","T","T","T"}, {"C","G","G","G"}, {"C","T","G","G"}, {"A","A","A","A"}};

        Assertions.assertTrue(runTest(new VerticalHorizontalAnalysis(), matrix, 2));
    }

    @Test
    public void mainDiagonalSimianTest() {
        String[][] matrix = {{"T","T","T","G"}, {"C","T","G","T"}, {"C","G","T","G"}, {"G","T","G","T"}};

        Assertions.assertTrue(runTest(new DiagonalAnalysis(), matrix, 2));
    }

    @Test
    public void secondaryDiagonalSimianTest() {
        String[][] matrix = {{"T","G","T","G", "T"}, {"G","T","G","T","G"}, {"C","G","C","G","C"}, {"G","T","G","T","G"}, {"G","G","C","G","C"}};

        Assertions.assertTrue(runTest(new DiagonalAnalysis(), matrix, 4));
    }

    private boolean runTest(Analysis analysis, String[][] matrix, int expectedResult) {
        int result = analysis.run(matrix);
        return result == expectedResult;
    }
}
