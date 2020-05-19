import java.util.Arrays;
import java.util.HashMap;

public class majorityElement {

    public static void main(String[] args) {
    }

    /*
     * 次数超过一半，排在中间的就是所需的数字
     * */
    private static int method1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //摩尔投票法
    private static int method2(int[] nums) {
        int count = 0;
        int ret = 0;
        for (int num : nums) {
            if (count == 0) {
                ret = num;
            }
            if (num != ret) {
                count--;
            } else
                count++;
        }
        return ret;
    }

    //HashMap方法：不是双百解法，但是容易理解，且普适性强，并考虑了数组中不存在满足条件的众数和数组为空的情况
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                //这里不能直接map.get(nums[i])++;
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            //注意：这里if不能放在第一个if中，否则会在数组长度为1时出错，无法返回正确的nums[i]的值
            //这里i>=length，之所以带等号，也是为了满足长度为1的情况，因为i从0开始
            //按照题目要求，必须众数次数超过长度的一半，则有第一个判断条件，相当于剪枝，当然下面的第一个判断条件也可以不加
            if (i >= length && map.get(nums[i]) > length) return nums[i];
        }
        return 0;//当不存在满足要求的数字或者数组长度为0时
    }


}
