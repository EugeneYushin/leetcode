package algo;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class LargestComponentSizeByCommonFactorTest {

    @Test
    void largestComponentSize() throws IOException {
        LargestComponentSizeByCommonFactor cl = new LargestComponentSizeByCommonFactor();
        assertEquals(1, cl.largestComponentSize(new int[]{1}));
        assertEquals(1, cl.largestComponentSize(new int[]{2}));
        assertEquals(1, cl.largestComponentSize(new int[]{1, 2}));
        assertEquals(1, cl.largestComponentSize(new int[]{1, 2, 3}));
        assertEquals(3, cl.largestComponentSize(new int[]{1, 2, 3, 6}));
        assertEquals(4, cl.largestComponentSize(new int[]{4, 21, 6, 70, 11}));
        assertEquals(6, cl.largestComponentSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));

        FileInputStream fstream = new FileInputStream("src/test/java/algo/LargestComponentSizeByCommonFactorTest.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String[] str = br.readLine().split(",");
        int[] input = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            input[i] = Integer.parseInt(str[i]);
        }

        assertEquals(17156, cl.largestComponentSize(input));
    }
}