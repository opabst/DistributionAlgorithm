package de.oliverpabst.distribution_algorithm.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BucketTest {
    public Bucket<Integer> createTestBucket() {
        Bucket<Integer> bucket = new Bucket<>(3);

        return bucket;
    }

    @Test
    public void addToBucket() {
        Bucket<Integer> bucket = createTestBucket();
        BucketEntry<Integer> entry = new BucketEntry<>(1, 234);
        bucket.addToBucket(1, entry);

        ArrayList<BucketEntry<Integer>> singleBucket = bucket.getBucket(1);
        BucketEntry<Integer> retrievedEntry = singleBucket.get(0);

        assertEquals(entry.getKey(), retrievedEntry.getKey());
        assertEquals(entry.getValue(), retrievedEntry.getValue());
    }

    @Test
    public void getBucketSize() {
        Bucket<Integer> bucket = createTestBucket();
        BucketEntry<Integer> entry = new BucketEntry<>(1, 234);
        bucket.addToBucket(1, entry);

        assertEquals(bucket.getBucketSize(0), (Integer)0);
        assertEquals(bucket.getBucketSize(1), (Integer)1);
        assertEquals(bucket.getBucketSize(2), (Integer)0);
    }
}