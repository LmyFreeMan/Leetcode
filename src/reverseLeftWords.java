public class reverseLeftWords {
    private static String reverseLeftWords(String s, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] c = s.toCharArray();
        for (int i = n; i < c.length; i++) {
            stringBuffer.append(String.valueOf(c[i]));
        }
        for (int i = 0; i < n; i++)
            stringBuffer.append(String.valueOf(c[i]));

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String str = reverseLeftWords("lrloseumgh", 6);
        System.out.println(str);
    }
}
