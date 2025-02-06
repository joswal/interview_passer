package array_challenges.string_in_array;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MatrixSubstringSearch {

    private static final Logger logger = Logger.getLogger(MatrixSubstringSearch.class.getName());
    public static boolean existsInMatrix(char[][] matrix, String target) {
        
        // Check rows (horizontal search)
        for (char[] row : matrix) {
            String rowStr = new String(row);  // Convert row to string
            if (rowStr.contains(target)) {
                logger.log(Level.INFO, "Found {0} in row: {1}", new Object[]{target, rowStr});
                return true;
            }
        }

        int cols = matrix[0].length;
        // Check columns (vertical search)
        for (int col = 0; col < cols; col++) {
            StringBuilder vertical = new StringBuilder();
            for (char[] chars : matrix) {
                vertical.append(chars[col]);  // Build column string
            }
            String verticalStr = vertical.toString();
            if (verticalStr.contains(target)) {
                logger.log(Level.INFO, "Found {0} in column: {1}", new Object[]{target, verticalStr});
                return true;
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'a', 'b', 'c', 'd', 'e', 'f'},
            {'g', 'h', 'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x'}
        };

        logger.info(() -> String.valueOf(existsInMatrix(matrix, "bcd")));
        logger.info(() -> String.valueOf(existsInMatrix(matrix, "gmp")));
        logger.info(() -> String.valueOf(existsInMatrix(matrix, "gms")));
        logger.info(() -> String.valueOf(existsInMatrix(matrix, "xyz")));
    }
}
