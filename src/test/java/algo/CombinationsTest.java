package algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationsTest {
    @Test
    void combine() {
        Combinations cl = new Combinations();
        assertEquals(new ArrayList<List<Integer>>() {{
            add(Arrays.asList(1, 2, 3));
            add(Arrays.asList(1, 2, 4));
            add(Arrays.asList(1, 2, 5));
            add(Arrays.asList(1, 3, 4));
            add(Arrays.asList(1, 3, 5));
            add(Arrays.asList(1, 4, 5));
            add(Arrays.asList(2, 3, 4));
            add(Arrays.asList(2, 3, 5));
            add(Arrays.asList(2, 4, 5));
            add(Arrays.asList(3, 4, 5));
        }}, cl.combine(5, 3));
    }
}
