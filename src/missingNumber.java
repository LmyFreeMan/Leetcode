import java.util.ArrayList;
import java.util.List;

public class missingNumber {
    private static int missingNumber(int[] nums) {
        int len = nums.length;
        int misnum = 0;
        List list = new ArrayList();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i <= len; i++) {
            if (!list.contains(i))
                misnum = i;
        }
        return misnum;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int num = missingNumber(nums);
        System.out.println(num);
    }
}
