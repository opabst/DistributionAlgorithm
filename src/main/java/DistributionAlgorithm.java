import de.oliverpabst.distribution_algorithm.model.Bucket;
import de.oliverpabst.distribution_algorithm.model.BucketEntry;
import de.oliverpabst.distribution_algorithm.algorithm.CapacityCalculator;

import java.util.ArrayList;
import java.util.HashMap;

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

        // First run: assign entries with a key >= 0 and as long as the buckets cap is not exceeded
        //     -> buckets without a assigned group key have the key -1
        for(BucketEntry e: inputList) {
            if(e.getKey() > -1) {
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

        int currentBucket = 0;
        boolean matchFound = false;
        for(BucketEntry e: remainingEntries) {
            matchFound = false;

            while(!matchFound) {
                if (buckets.getBucket(currentBucket).size() < bucketCaps.get(currentBucket)) {
                    buckets.getBucket(currentBucket).add(e);
                    matchFound = true;
                } else {
                    currentBucket++;
                }
            }
        }
    }

    public HashMap<Integer, ArrayList<BucketEntry<E>>> getResultMapping() {
        HashMap<Integer, ArrayList<BucketEntry<E>>> resultMap = new HashMap<>();
        for(int i = 0; i < bucketCnt; i++) {
            resultMap.put(i, new ArrayList<>());
            for(int j = 0; j < buckets.getBucket(i).size(); j++) {
                resultMap.get(i).add(buckets.getBucket(i).get(j));
            }
        }
        return resultMap;
    }
}
