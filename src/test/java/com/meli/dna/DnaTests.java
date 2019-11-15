package com.meli.dna;

import com.meli.dna.Model.Dna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DnaTests {

	private final String[] stringDnaMock = {"TTTT", "GGGG", "AAAA"};

	@Test
	void isValidDnaTest() {
		Dna dna = new Dna(stringDnaMock);

		boolean result = dna.isDnaValid();
		Assertions.assertTrue(result);
	}

	@Test
	void buildDnaMatrixTest() {
		Dna dna = new Dna(stringDnaMock);
		int expectedColumnSize = 3;
		int expectedLineSize = 4;

		String[][] matrix = dna.buildDnaMatrix();

		Assertions.assertEquals(matrix.length, expectedColumnSize);
		Assertions.assertEquals(matrix[0].length, expectedLineSize);
	}

	@Test
	void isValidMatrix() {
		String[][] matrixMock = {{"A","A"}, {"T","T"}};
		Dna dna = new Dna(stringDnaMock);

		boolean result = dna.isMatrixSquare(matrixMock);

		Assertions.assertTrue(result);
	}

}
