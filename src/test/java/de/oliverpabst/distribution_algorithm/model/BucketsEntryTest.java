package de.oliverpabst.distribution_algorithm.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BucketsEntryTest {
    public BucketEntry<Integer> createIntBucket() {
        BucketEntry<Integer> be = new BucketEntry<>(1, 234);
        return be;
    }

    public BucketEntry<String> createStringBucket() {
        BucketEntry<String> be = new BucketEntry<>(23, "TestString");
        return be;
    }

    @Test
    public void getKey() {
        BucketEntry<Integer> bei = createIntBucket();
        BucketEntry<String> bes = createStringBucket();

        assertEquals(bei.getKey(), (Integer)1);
        assertEquals(bes.getKey(), (Integer)23);
    }

    @Test
    public void getValue() {
        BucketEntry<Integer> bei = createIntBucket();
        BucketEntry<String> bes = createStringBucket();

        assertEquals((Integer)234, bei.getValue());
        assertEquals("TestString", bes.getValue());
    }
}