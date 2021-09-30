package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PartitionToKEqualSumSubsetsTest {

    @Test
    void canPartitionKSubsets() {
        PartitionToKEqualSumSubsets cl = new PartitionToKEqualSumSubsets();
        assertTrue(cl.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        assertFalse(cl.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
    }
}