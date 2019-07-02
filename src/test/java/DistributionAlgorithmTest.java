import de.oliverpabst.distribution_algorithm.model.BucketEntry;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DistributionAlgorithmTest {

    @Test
    public void simpleTest() {
        int bucketCount = 3;
        ArrayList<BucketEntry<String>> entries = new ArrayList<>();
        BucketEntry<String> e1 = new BucketEntry<>(-1, "Entry 1");
        BucketEntry<String> e2 = new BucketEntry<>(0, "Entry 2");
        BucketEntry<String> e3 = new BucketEntry<>(2, "Entry 3");
        BucketEntry<String> e4 = new BucketEntry<>(0, "Entry 4");
        BucketEntry<String> e5 = new BucketEntry<>(1, "Entry 5");
        BucketEntry<String> e6 = new BucketEntry<>(0, "Entry 6");
        BucketEntry<String> e7 = new BucketEntry<>(0, "Entry 7");

        entries.add(e1);
        entries.add(e2);
        entries.add(e3);
        entries.add(e4);
        entries.add(e5);
        entries.add(e6);
        entries.add(e7);

        ArrayList<Integer> weights = new ArrayList<>();
        weights.add(1);
        weights.add(1);
        weights.add(1);
        DistributionAlgorithm<String> da = null;
        try {
            da = new DistributionAlgorithm<>(bucketCount, entries, weights);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert da != null;
        HashMap<Integer, ArrayList<BucketEntry<String>>> result = da.getResultMapping();

        // Mapping evaluation

        // buckets run from 0 to 2
        ArrayList<BucketEntry<String>> bucket0 = result.get(0);
        assertEquals(bucket0.get(0).getValue(), "Entry 2");
        assertEquals(bucket0.get(1).getValue(), "Entry 4");
        assertEquals(bucket0.get(2).getValue(), "Entry 6");

        ArrayList<BucketEntry<String>> bucket1 = result.get(1);
        assertEquals(bucket1.get(0).getValue(), "Entry 5");
        assertEquals(bucket1.get(1).getValue(), "Entry 1");

        ArrayList<BucketEntry<String>> bucket2 = result.get(2);
        assertEquals(bucket2.get(0).getValue(), "Entry 3");
        assertEquals(bucket2.get(1).getValue(), "Entry 7");
    }


    @Test(expected = Exception.class)
    public void sizeMismatchTest() throws Exception {
        int bucketCount = 5;
        ArrayList<Integer> weights = new ArrayList<>();
        weights.add(1);
        weights.add(1);
        weights.add(2);
        weights.add(1);
        ArrayList<BucketEntry<String>> entries = new ArrayList<>();
        BucketEntry<String> e1 = new BucketEntry<>(0, "Entry");
        entries.add(e1);

        DistributionAlgorithm<String> da = new DistributionAlgorithm<>(bucketCount, entries, weights);
    }
}