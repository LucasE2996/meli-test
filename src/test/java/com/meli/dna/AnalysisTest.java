package com.meli.dna;

import com.meli.dna.service.Analysis;
import com.meli.dna.service.VerticalHorizontalAnalysis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnalysisTest {

    String[][] matrix = {{"T","T","T","T"}, {"C","T","G","G"}, {"C","T","G","G"}, {"C","T","G","G"}};

    @Test
    public void VerticalSimianTest() {
        final int expectedResult = 2;
        final Analysis verticalHorizontal = new VerticalHorizontalAnalysis();

        Assertions.assertEquals(expectedResult, verticalHorizontal.run(matrix));
    }
}
