package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix01Test {
    @Test
    void updateMatrix() {
        Matrix01 cl = new Matrix01();
        assertArrayEquals(
                new int[][]{
                        new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 2}
                },
                cl.updateMatrix(new int[][]{
                        new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 1}
                })
        );

        assertArrayEquals(
                new int[][]{
                        new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 2, 1}
                },
                cl.updateMatrix(new int[][]{
                        new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 1}
                })
        );

        assertArrayEquals(
                new int[][]{
                        new int[]{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        new int[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        new int[]{1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
                        new int[]{2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                        new int[]{3, 2, 2, 1, 0, 1, 0, 0, 1, 1}
                },
                cl.updateMatrix(new int[][]{
                        new int[]{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        new int[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        new int[]{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        new int[]{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
                })
        );
    }

    @Test
    void updateMatrix_bfs() {
        Matrix01 cl = new Matrix01();
        assertArrayEquals(
                new int[][]{
                        new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 2}
                },
                cl.updateMatrix_bfs(new int[][]{
                        new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 1}
                })
        );

        assertArrayEquals(
                new int[][]{
                        new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 2, 1}
                },
                cl.updateMatrix_bfs(new int[][]{
                        new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 1}
                })
        );

        assertArrayEquals(
                new int[][]{
                        new int[]{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        new int[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        new int[]{1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
                        new int[]{2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                        new int[]{3, 2, 2, 1, 0, 1, 0, 0, 1, 1}
                },
                cl.updateMatrix_bfs(new int[][]{
                        new int[]{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                        new int[]{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[]{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                        new int[]{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                        new int[]{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                        new int[]{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                        new int[]{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        new int[]{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
                })
        );
    }
}