package algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountCompleteTreeNodesTest {

    @Test
    void countNodes() {
        CountCompleteTreeNodes cl = new CountCompleteTreeNodes();

        assertEquals(15, cl.countNodes(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)
                        ),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                new TreeNode(13)
                        ),
                        new TreeNode(7,
                                new TreeNode(14),
                                new TreeNode(15)
                        )
                )
        )));

        assertEquals(14, cl.countNodes(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)
                        ),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                new TreeNode(13)
                        ),
                        new TreeNode(7,
                                new TreeNode(14),
                                null
                        )
                )
        )));

        assertEquals(13, cl.countNodes(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)
                        ),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6,
                                new TreeNode(12),
                                new TreeNode(13)
                        ),
                        new TreeNode(7,
                                null,
                                null
                        )
                )
        )));

        assertEquals(11, cl.countNodes(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)
                        ),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)
                        )
                ),
                new TreeNode(3,
                        new TreeNode(6,
                                null,
                                null
                        ),
                        new TreeNode(7,
                                null,
                                null
                        )
                )
        )));
    }
}