package algo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {
        DailyTemperatures cl = new DailyTemperatures();
        assertArrayEquals(new int[]{0}, cl.dailyTemperatures(new int[]{7}));
        assertArrayEquals(new int[]{0, 3, 2, 1, 0}, cl.dailyTemperatures(new int[]{76, 68, 65, 60, 71}));
        assertArrayEquals(new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0},
                cl.dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
        assertArrayEquals(new int[]{1, 0, 0, 2, 1, 0, 0, 0, 0, 0},
                cl.dailyTemperatures(new int[]{34, 80, 80, 34, 34, 80, 80, 80, 80, 34}));
    }

    @Test
    void dailyTemperatures_stack() {
        DailyTemperatures cl = new DailyTemperatures();
        assertArrayEquals(new int[]{0}, cl.dailyTemperatures_stack(new int[]{7}));
        assertArrayEquals(new int[]{0, 3, 2, 1, 0}, cl.dailyTemperatures_stack(new int[]{76, 68, 65, 60, 71}));
        assertArrayEquals(new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0},
                cl.dailyTemperatures_stack(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
        assertArrayEquals(new int[]{1, 0, 0, 2, 1, 0, 0, 0, 0, 0},
                cl.dailyTemperatures_stack(new int[]{34, 80, 80, 34, 34, 80, 80, 80, 80, 34}));
    }
}