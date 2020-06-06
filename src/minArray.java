import java.util.Arrays;

public class minArray {
    private static int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public static void main(String[] args) {

    }
}
