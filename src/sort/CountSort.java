package sort;

import java.util.Arrays;

public class CountSort {
    public static int[] countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int help[] = new int[max];

        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }

        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[index++] = i + min;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 6, 3, 5, 1};
        int[] des = countSort(arr);
        System.out.println(Arrays.toString(des));
    }
}
