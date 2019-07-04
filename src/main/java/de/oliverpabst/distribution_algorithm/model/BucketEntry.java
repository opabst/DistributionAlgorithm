package de.oliverpabst.distribution_algorithm.model;

/**
 * This class represents entries for buckets. Note that the key is not necessarily a unique key; instead it determines
 * the group affiliation. -1 stands for no group, groups start from 0 on.
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
