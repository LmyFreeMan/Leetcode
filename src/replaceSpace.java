import java.util.Arrays;
import java.util.List;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
public class replaceSpace {
    public static void main(String[] args) {
        replaceSpace("We are happy.");
    }

    private static void replaceSpace(String s) {
        List<String> list = Arrays.asList(s.split(""));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(" "))
                list.set(i, "%20");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
