package sort;

import java.util.Arrays;

public class InsertSort {
    private static int[] insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {90, 10, 11, 22};
        int[] newarr = insertSort(arr);
        System.out.println(Arrays.toString(newarr));
    }
}
