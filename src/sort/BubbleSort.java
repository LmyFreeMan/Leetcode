package sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 时间复杂度 N^2
     * 空间复杂度 n
     *
     * @param arr 传递的数组
     * @return arr 排序后的数组
     */
    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 8, 56, 65, 9, 4};
        int[] des = bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}