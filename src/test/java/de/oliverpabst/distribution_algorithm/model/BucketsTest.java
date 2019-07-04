package de.oliverpabst.distribution_algorithm.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BucketsTest {
    public Buckets<Integer> createTestBucket() {
        Buckets<Integer> buckets = new Buckets<>(3);

        return buckets;
    }

    @Test
    public void addToBucket() {
        Buckets<Integer> buckets = createTestBucket();
        BucketEntry<Integer> entry = new BucketEntry<>(1, 234);
        buckets.addToBucket(1, entry);

        ArrayList<BucketEntry<Integer>> singleBucket = buckets.getBucket(1);
        BucketEntry<Integer> retrievedEntry = singleBucket.get(0);

        assertEquals(entry.getKey(), retrievedEntry.getKey());
        assertEquals(entry.getValue(), retrievedEntry.getValue());
    }

    @Test
    public void getBucketSize() {
        Buckets<Integer> buckets = createTestBucket();
        BucketEntry<Integer> entry = new BucketEntry<>(1, 234);
        buckets.addToBucket(1, entry);

        assertEquals(buckets.getBucketSize(0), (Integer)0);
        assertEquals(buckets.getBucketSize(1), (Integer)1);
        assertEquals(buckets.getBucketSize(2), (Integer)0);
    }
}