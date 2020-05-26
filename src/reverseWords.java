public class reverseWords {
    private static String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == " ")
                continue;
            else
                stringBuffer.append(arr[i] + " ");
        }
        return stringBuffer.toString().trim();
    }

    public static void main(String[] args) {
        String s = reverseWords("the sky is blue");
        System.out.println(s);
    }
}
