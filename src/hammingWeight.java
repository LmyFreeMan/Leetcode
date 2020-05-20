public class hammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(31));
    }

    private static int hammingWeight(int n) {
        String result = Integer.toBinaryString(n);
        int count = 0;
        char[] strArr = result.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == '1')
                count++;
        }
        return count;
    }
}
