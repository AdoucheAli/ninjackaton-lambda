package com.octo.parallel;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author Henri Tremblay
 */
public class MatrixComputationTest {

    double[][] matA = new double[][] {
            {0,1,2},
            {3,4,5}
    };
    double[][] matB = new double[][] {
            {0,1},
            {2,3},
            {4,5}
    };
    double[][] expected = new double[][] {
            {10, 13},
            {28, 40}
    };

    /**
     * [[0,1,2],[3,4,5]]*[[0,1],[2,3],[4,5]]
     * @throws Exception
     */
    @Test
    public void testMatrixMultiplication() throws Exception {
        double[][] actual = MatrixComputation.matrixMultiplication(matA, matB);
        checkResult(actual);
    }

    @Test
    public void testParallelMatrixMultiplication() throws Exception {
        double[][] actual = MatrixComputation.parallelMatrixMultiplication(matA, matB);
        checkResult(actual);
    }

    private void checkResult(double[][] actual) {
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i], actual[i], 0.1);
        }
    }
}
