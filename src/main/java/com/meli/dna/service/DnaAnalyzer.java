package com.meli.dna.service;

import com.meli.dna.Model.Dna;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DnaAnalyzer {

    private List<Analysis> analyses;

    public DnaAnalyzer() {
        analyses = new ArrayList<>();

        analyses.add(new VerticalHorizontalAnalysis());
    }

    public boolean isSimian(String[][] dnaMatrix) {
        long total = analyses.stream().mapToInt(analysis -> analysis.run(dnaMatrix)).sum();

        return total >= 2;
    }

    public float calcRatio(List<Dna> dnaList) {
        float totalRecords = dnaList.size();
        float totalSimian = (float) getNumberOfSimians(dnaList);
        float totalHuman = totalRecords - totalSimian;

        return totalSimian / totalHuman;
    }

    public int getNumberOfSimians(List<Dna> dnaList) {
        return (int) dnaList.stream().filter(Dna::isSimian).count();
    }
}
