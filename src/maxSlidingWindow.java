import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxSlidingWindow {

    public static void main(String[] args) {
        int[] name = {1, -1};
        int[] des = maxSlidingWindow(name, 1);
        System.out.println(des);

    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        List list = new ArrayList();
        int i = 0;
        int[] name = new int[k];
        while (i + k <= nums.length) {
            System.arraycopy(nums, i, name, 0, k);
            Arrays.sort(name);
            list.add(name[k - 1]);
            i = i + 1;
        }
        int[] des = new int[list.size()];
        for (int j = 0; j < (int) list.size(); j++) {
            des[j] = (int) list.get(j);
        }
        return des;

    }
}
