package algo;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(new LinkedList<Integer>() {{
            add(1);
        }});

        int row = 2;
        while (row <= numRows) {
            List<Integer> currentRow = new LinkedList<>();
            currentRow.add(1);

            List<Integer> previousRow = triangle.get(row - 2);
            for (int i = 1; i < row - 1; i++) {
                currentRow.add(previousRow.get(i - 1) + previousRow.get(i));
            }

            currentRow.add(1);
            triangle.add(currentRow);
            row++;
        }

        return triangle;
    }
}
