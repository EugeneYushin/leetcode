package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CherryPickupTest {

    @Test
    void cherryPickup() {
        CherryPickup cl = new CherryPickup();
        assertEquals(5, cl.cherryPickup(new int[][] {
                new int[] {0, 1, -1},
                new int[] {1, 0, -1},
                new int[] {1, 1, 1}
        }));
    }

    @Test
    void cherryPickup_noPath() {
        CherryPickup cl = new CherryPickup();
        assertEquals(0, cl.cherryPickup(new int[][] {
                new int[] {0, 1, -1},
                new int[] {1, -1, 1},
                new int[] {-1, 1, 1}
        }));
    }

    @Test
    void cherryPickup_noPathFromStart() {
        CherryPickup cl = new CherryPickup();
        assertEquals(0, cl.cherryPickup(new int[][] {
                new int[] {-1, 1, 1},
                new int[] {1, 1, 1},
                new int[] {1, 1, 1}
        }));
    }

    @Test
    void cherryPickup_emptyBackPath() {
        CherryPickup cl = new CherryPickup();
        assertEquals(4, cl.cherryPickup(new int[][] {
                new int[] {0, 0, -1},
                new int[] {1, 0, -1},
                new int[] {1, 1, 1}
        }));
    }

    @Test
    void cherryPickup_startsWithOne() {
        CherryPickup cl = new CherryPickup();
        assertEquals(6, cl.cherryPickup(new int[][] {
                new int[] {1, 1, -1},
                new int[] {1, 0, -1},
                new int[] {1, 1, 1}
        }));
    }
}