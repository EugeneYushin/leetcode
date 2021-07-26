package algo;

public class ZigZagConversion {
    public String prettyMatrix(Character[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                builder.append(matrix[r][c] == null ? '-' : matrix[r][c]);
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public String convert(String s, int numRows) {
        if (numRows < 2 || numRows > s.length()) return s;

//        int numCols = s.length() / numRows * (1 + numRows - 2) + 1;
        int numCols = s.length() - s.length() / numRows;
        Character[][] matrix = new Character[numRows][numCols];
        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{-1, 1}};

        int directionIndex = 1;
        int[] currentDirection = directions[directionIndex];

        int row = 0;
        int col = 0;

        for (int i = 0; i < s.length(); i++) {
//            System.out.println("--------------------");
//            System.out.println("s.charAt(i) = " + s.charAt(i));
//            System.out.println("col = " + col);
//            System.out.println("row = " + row);
//            System.out.println(prettyMatrix(matrix));

            matrix[row][col] = s.charAt(i);

            if (row == 0 || (row + 1) == numRows) {
//                System.out.println("change direction");
                directionIndex++;
                currentDirection = directions[directionIndex % directions.length];
            }

            row += currentDirection[0];
            col += currentDirection[1];
        }

//        System.out.println(prettyMatrix(matrix));

        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] != null) {
                    builder.append(matrix[r][c]);
                }
            }
        }

        return builder.toString();
    }
}
