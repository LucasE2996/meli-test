package com.meli.dna;

import com.meli.dna.service.DnaAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.meli.dna.TestUtil.generateDnaList;

@SpringBootTest
public class AnalyzerTest {

    @Test
    public void isSimianTest() {
        String[][] dna = {{"C","T","G","A","G","A"}, {"C","T","A","T","G","C"}, {"T","A","T","T","G","T"}, {"A","G","A","G","G","G"}, {"C","C","C","C","T","A"}, {"T","C","A","C","T","G"}};
        DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

        Assertions.assertTrue(dnaAnalyzer.isSimian(dna));
    }

    @Test
    public void calcRatioTest() {
        DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

        Assertions.assertEquals(0.5, dnaAnalyzer.calcRatio(generateDnaList()), 0);
    }

    @Test
    public void getNumberOfSimiansTest() {
        DnaAnalyzer dnaAnalyzer = new DnaAnalyzer();

        Assertions.assertEquals(1, dnaAnalyzer.getNumberOfSimians(generateDnaList()));
    }
}
