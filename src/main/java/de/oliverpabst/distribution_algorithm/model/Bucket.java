package de.oliverpabst.distribution_algorithm.model;

import java.util.ArrayList;

/**
 * Buckets are represented by array lists in an super array list.
 * Basic assumption: buckets will be numerated from 1 to bucketSize.
 * Remember counting in array lists starts at zero. E.g. bucket 3 is stored at position 2
 * in the super list.
 */

public class Bucket<E> {
    private ArrayList<ArrayList> superList = new ArrayList<>();

    public Bucket(int _bucketSize) {
        for(int i = 0; i < _bucketSize; i++) {
             superList.add(new ArrayList<BucketEntry<E>>());
        }
    }

    public void addToBucket(Integer _bucket, BucketEntry<E> _entry) {
        superList.get(_bucket).add(_entry);
    }

    public ArrayList<BucketEntry<E>> getBucket(Integer _bucket) {
        return superList.get(_bucket);
    }

    public Integer getBucketSize(Integer _bucket) {
        return superList.get(_bucket).size();
    }
}
