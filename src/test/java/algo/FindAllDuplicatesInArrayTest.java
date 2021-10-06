package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllDuplicatesInArrayTest {

    @Test
    void findDuplicates() {
        FindAllDuplicatesInArray cl = new FindAllDuplicatesInArray();
        assertEquals(Arrays.asList(2, 3), cl.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        assertEquals(Collections.emptyList(), cl.findDuplicates(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void findDuplicates_swaps() {
        FindAllDuplicatesInArray cl = new FindAllDuplicatesInArray();
        assertEquals(Arrays.asList(3, 2), cl.findDuplicates_swaps(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        assertEquals(Collections.emptyList(), cl.findDuplicates_swaps(new int[]{1, 2, 3, 4, 5}));
    }
}