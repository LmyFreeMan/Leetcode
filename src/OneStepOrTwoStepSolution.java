public class OneStepOrTwoStepSolution {
    //假设一个楼梯有10阶，人在0阶，每次可以爬2阶或者1阶，一共有多少种方法可以爬到第十阶？
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
