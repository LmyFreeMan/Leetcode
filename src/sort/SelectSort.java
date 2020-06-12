package sort;

import java.util.Arrays;

public class SelectSort {
    private static int[] selectSort(int[] arr) {
        int temp, min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    //记录下标
                    min = j;
                }
            }
            //交换位置
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 8, 56, 65, 9, 4};
        int[] arr = selectSort(numbers);
        System.out.println(Arrays.toString(args));
    }
}