public class sumNums {
    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }

    public static void main(String[] args) {
        sumNums sumNums = new sumNums();
        System.out.println(sumNums.sumNums(5));
    }
}
