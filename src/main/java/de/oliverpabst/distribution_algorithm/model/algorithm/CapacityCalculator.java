package de.oliverpabst.distribution_algorithm.model.algorithm;

import java.util.ArrayList;

// Distribute by weight
// Redistribute the remainder that has not been distributed.

public class CapacityCalculator {

    private ArrayList<Integer> bucketCapacity;

    public CapacityCalculator(ArrayList<Integer> _weights, Integer _inputSize) {
        bucketCapacity = new ArrayList();
        Integer divisor = _weights.stream().mapToInt(Integer::intValue).sum();
        Integer remainder = _inputSize % (int)Math.floor(_inputSize / _weights.stream().mapToInt(Integer::intValue).sum());
        for (int i = 0; i < _weights.size(); i++) {
            bucketCapacity.add((_inputSize/divisor) * _weights.get(i));
        }
        int counter = 0;
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
