package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {
    @Test
    void reverseBits_constant() {
        ReverseBits cl = new ReverseBits();
        assertEquals(
                -1073741825,                    // 10111111111111111111111111111111
                cl.reverseBits_constant(-3)     // 11111111111111111111111111111101
        );
        assertEquals(
                Integer.parseUnsignedInt("00111001011110000010100101000000", 2),
                cl.reverseBits_constant(Integer.parseUnsignedInt("00000010100101000001111010011100", 2))
        );
    }

    @Test
    void reverseBits_linear() {
        ReverseBits cl = new ReverseBits();
        assertEquals(
                -1073741825,           // 10111111111111111111111111111111
                cl.reverseBits_linear(-3)     // 11111111111111111111111111111101
        );
        assertEquals(
                Integer.parseUnsignedInt("00111001011110000010100101000000", 2),
                cl.reverseBits_linear(Integer.parseUnsignedInt("00000010100101000001111010011100", 2))
        );
    }
}