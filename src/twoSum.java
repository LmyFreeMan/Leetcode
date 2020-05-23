import java.util.Arrays;

public class twoSum {
    private static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        int i, j;
        i = 0;
        j = nums.length - 1;
        while (nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] < target)
                i++;
            else if ((nums[i] + nums[j] > target))
                j--;
            else
                return array;
        }
        array[0] = nums[i];
        array[1] = nums[j];
        return array;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] a = twoSum(array, 9);
        System.out.println(Arrays.toString(a));
    }
}
