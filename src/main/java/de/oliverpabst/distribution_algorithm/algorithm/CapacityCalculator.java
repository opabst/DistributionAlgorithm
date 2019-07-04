package de.oliverpabst.distribution_algorithm.algorithm;

import java.util.ArrayList;

/**
 * This class takes the individual group weights (weights can only be integers!) and the size of the input data to
 * calculate the capacity that each bucket will have. The input will be equally distributed with a maximum difference
 * capacity-wise across the buckets of 1.
 */

public class CapacityCalculator {

    private ArrayList<Integer> bucketCapacity;

    public CapacityCalculator(ArrayList<Integer> _weights, Integer _inputSize) {
        bucketCapacity = new ArrayList<>();

        Integer divisor = _weights.stream().mapToInt(Integer::intValue).sum();
        int remainder = _inputSize % (int)Math.floor(_inputSize / _weights.stream().mapToInt(Integer::intValue).sum());

        // initial equal distribution along the buckets considering the weights
        for(int weight: _weights) {
            bucketCapacity.add((_inputSize/divisor) * weight);
        }

        int counter = 0;

        // distribute the remainder equally among the buckets
        while(remainder > 0) {
            int val = bucketCapacity.get(counter) + 1;
            bucketCapacity.set(counter, val);
            remainder--;
            counter++;
        }
    }

    public ArrayList<Integer> getCapacityCalculation() {
        return bucketCapacity;
    }
}
