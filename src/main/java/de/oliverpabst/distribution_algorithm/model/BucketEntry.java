package de.oliverpabst.distribution_algorithm.model;

/**
 * Entry for a bucket. Note that the key is not necessarily a unique key; instead it determines the group affiliation.
 */

public class BucketEntry<E> {
    private Integer key;
    private E value;
    public BucketEntry(Integer _key, E _value) {
        key = _key;
        value = _value;
    }

    public Integer getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}
