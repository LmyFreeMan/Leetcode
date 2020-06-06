public class lastRemaining {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 1));
    }

    private static int lastRemaining(int n, int m) {
        // 存活的最后一个人的位置
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
