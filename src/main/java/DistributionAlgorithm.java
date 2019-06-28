import de.oliverpabst.distribution_algorithm.model.Bucket;
import de.oliverpabst.distribution_algorithm.model.BucketEntry;
import de.oliverpabst.distribution_algorithm.algorithm.CapacityCalculator;

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

public class DistributionAlgorithm<E> {

    private Bucket<E> buckets;

    private Integer bucketCnt;

    private ArrayList<BucketEntry<E>> inputList;

    private ArrayList<Integer> weights;

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

        ArrayList<BucketEntry<E>> remainingEntries = new ArrayList<>();

        // First run: assign entries with a key > 0 and as long as the buckets cap is not exceeded
        for(BucketEntry e: inputList) {
            if(e.getKey() > 0) {
                // Bucket as remaining space => add entry to the bucket
                if (buckets.getBucket(e.getKey()).size() < bucketCaps.get(e.getKey())) {
                    buckets.getBucket(e.getKey()).add(e);
                } else {
                    // Buckets capacity is exceeded => add to remaning entry list for later allocation
                    remainingEntries.add(e);
                }
            } else {
                remainingEntries.add(e);
            }
        }

        // Second run: distribute remaining items on the buckets with available space
        for(BucketEntry e: remainingEntries) {
            for(int i = 0; i < bucketCnt; i++) {
                while(buckets.getBucket(i).size() < bucketCaps.get(i)) {
                    buckets.getBucket(i).add(e);
                }
            }
        }
    }
}
