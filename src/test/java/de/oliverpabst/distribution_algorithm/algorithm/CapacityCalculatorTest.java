package de.oliverpabst.distribution_algorithm.algorithm;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CapacityCalculatorTest {

    @Test
    public void getCapacityCalculation() {
        // distAvg: 0.75
        // weights: 1, 2, 1
        // objects: 8
        // expected capacity: 2, 4, 2
        ArrayList<Integer> weights1 = new ArrayList<>();
        weights1.add(1);
        weights1.add(2);
        weights1.add(1);
        CapacityCalculator cc1 = new CapacityCalculator(weights1, 8);
        assertEquals((Integer)2, cc1.getCapacityCalculation().get(0));
        assertEquals((Integer)4, cc1.getCapacityCalculation().get(1));
        assertEquals((Integer)2, cc1.getCapacityCalculation().get(2));
        assertEquals((Integer)8, (Integer)cc1.getCapacityCalculation().stream().mapToInt(Integer::intValue).sum());


        ArrayList<Integer> weights2 = new ArrayList<>();
        weights2.add(1);
        weights2.add(1);
        weights2.add(1);
        CapacityCalculator cc2 = new CapacityCalculator(weights2, 10);
        assertEquals((Integer)4, cc2.getCapacityCalculation().get(0));
        assertEquals((Integer)3, cc2.getCapacityCalculation().get(1));
        assertEquals((Integer)3, cc2.getCapacityCalculation().get(2));
        assertEquals((Integer)10, (Integer)cc2.getCapacityCalculation().stream().mapToInt(Integer::intValue).sum());
    }
}