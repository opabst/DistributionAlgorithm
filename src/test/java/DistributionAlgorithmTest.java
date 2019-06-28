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

        HashMap<Integer, ArrayList<BucketEntry<String>>> result = da.getResultMapping();

        // TODO: evaluate mapping
    }

}