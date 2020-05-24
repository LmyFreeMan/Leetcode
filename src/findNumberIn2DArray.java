import java.util.Arrays;

public class findNumberIn2DArray {
    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int colums = matrix.length;
        for (int i = 0; i < colums; i++) {
            if (Arrays.binarySearch(matrix[i], target) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1}};
        findNumberIn2DArray(matrix, 0);
    }
}
