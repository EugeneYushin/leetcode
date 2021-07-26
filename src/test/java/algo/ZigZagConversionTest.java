package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagConversionTest {

    ZigZagConversion cl = new ZigZagConversion();

    @Test
    void convert() {
        assertEquals("PAHNAPLSIIGYIR", cl.convert("PAYPALISHIRING", 3));
        assertEquals("A", cl.convert("A", 2));
        assertEquals("ACB", cl.convert("ABC", 2));
    }
}