package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void canFinish() {
        CourseSchedule cl = new CourseSchedule();
        assertTrue(cl.canFinish(2, new int[][] {new int[] {0, 1}}));
        assertFalse(cl.canFinish(2, new int[][] {new int[] {0, 1}, new int[] {1, 0}}));
    }
}