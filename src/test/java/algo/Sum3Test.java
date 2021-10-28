package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class Sum3Test {

    @Test
    void threeSum() {
        Sum3 cl = new Sum3();
        assertEquals(Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)),
                cl.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertEquals(Collections.singletonList(Arrays.asList(0, 0, 0)), cl.threeSum(new int[]{0, 0, 0}));
    }
}