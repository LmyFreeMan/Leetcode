public class isPalindrome {
    public boolean isPalindrome(int x) {
        char[] c = String.valueOf(x).toCharArray();
        int len = String.valueOf(x).toCharArray().length;
        for (int i = 0; i < len / 2; i++) {
            if (c[i] != c[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome isPalindrome = new isPalindrome();
        System.out.println(isPalindrome.isPalindrome(121));
    }
}