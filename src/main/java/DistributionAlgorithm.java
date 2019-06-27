import de.oliverpabst.distribution_algorithm.model.Bucket;
import de.oliverpabst.distribution_algorithm.model.BucketEntry;
import de.oliverpabst.distribution_algorithm.model.algorithm.CapacityCalculator;

import java.util.ArrayList;

/**
 * Input: - list of bucket entries (each assigned to one or none bucket)
 *        - weights for each bucket
 *        - number of buckets
 *
 * Output: a set of buckets, where the entries are equally distributed, honoring the weights and group affiliations
 *
 * Explanation: - entries should preferably be assigned to the groups of a bucket
 *              - only assign entries to other buckets if the groups bucket is full
 *
 *
 */

// TODO: 2 algorithm phases (1. run over inputList and assign to matching buckets, as long as they have remaining capacity. 2. distribute the remaining entries over the buckets honoring the capacity)

public class DistributionAlgorithm<E> {

    private Bucket<E> buckets;

    private Integer bucketCnt;

    private ArrayList<BucketEntry<E>> inputList;

    private ArrayList<Integer> weights;

    private Integer distributionAverage;

    private ArrayList<Integer> bucketCaps;

    public DistributionAlgorithm(Integer _bucketCnt, ArrayList<BucketEntry<E>> _entryList, ArrayList<Integer> _bucketWeights) throws Exception {
        bucketCnt = _bucketCnt;
        buckets = new Bucket<>(bucketCnt);

        inputList = _entryList;

        weights = _bucketWeights;

        if(_bucketWeights.size() != bucketCnt) {
            throw new Exception("Size mismatch! Number of weights must match number of buckets!");
        }

        CapacityCalculator cc = new CapacityCalculator(weights, inputList.size());

        bucketCaps = cc.getCapacityCalculation();

    }





}
