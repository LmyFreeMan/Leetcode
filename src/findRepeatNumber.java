import java.util.HashSet;
import java.util.Set;

//在java数组中找到相同的元素
public class findRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 2, 5, 3};
        int m=findRepeatNumber(nums);
        System.out.println(m);
    }

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}