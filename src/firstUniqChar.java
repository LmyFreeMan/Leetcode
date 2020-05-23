import java.util.HashMap;
import java.util.LinkedHashMap;

public class firstUniqChar {
    //在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    public static void main(String[] args) {
        firstUniqChar("abaccdeff");
    }

    private static char firstUniqChar(String s) {
        char value = ' ';
        if (s == " ")
            return value;
        HashMap map = new LinkedHashMap();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!map.containsKey(charArr[i])) {
                int count = 1;
                map.put(charArr[i], count);
            } else {
                map.put(charArr[i], (int) map.get(charArr[i]) + 1);
            }
        }
        for (Object key : map.keySet()) {
            if ((int) map.get(key) == 1) {
                value = (char) key;
                break;
            }
        }
        return value;
    }
}
