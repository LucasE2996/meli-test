package com.meli.dna.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;

    @Column(unique = true)
    @Getter
    private String[] dna;

    @Getter @Setter
    private boolean isSimian;

    public Dna(String[] dna) {
        this.dna = dna;
    }

    /**
     * Constructs a DNA matrix based on current DNA
     * @return Matrix
     */
    public String[][] buildDnaMatrix() {
        int size = dna.length;

        if (size <= 0) {
            return new String[0][0];
        }

        String[][] splitDna = new String[size][size];

        for (int i = 0; i < dna.length; i++) {
            splitDna[i] = dna[i].split("");
        }

        return splitDna;
    }

    /**
     * Verify if matrix is symmetric
     * @param matrix Matrix to be analysed
     * @return true = symmetric; false = not symmetric
     */
    public boolean isMatrixSquare(String[][] matrix) {
        int columnSize = matrix.length;
        boolean result = true;

        for (String[] line : matrix) {
            if (line.length != columnSize) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Verify if DNA has the right letters. Should be only (A, T, C, G)
     * @return true = valid; false = not valid
     */
    public boolean isDnaValid() {
        Pattern pattern = Pattern.compile("([^ACGT])");
        StringBuilder dnaReduce = new StringBuilder();

        for (String s : dna) {
            dnaReduce.append(s);
        }

        Matcher dnaList = pattern.matcher(dnaReduce.toString());

        return !dnaList.find();
    }


}
