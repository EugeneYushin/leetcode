package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {
    AddBinary cl = new AddBinary();

    @Test
    void addBinary() {
        assertEquals("1", cl.addBinary("1", "0"));
        assertEquals("11", cl.addBinary("10", "1"));
        assertEquals("1000", cl.addBinary("111", "1"));
    }
}