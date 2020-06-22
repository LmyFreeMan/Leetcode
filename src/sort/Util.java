package sort;

public class Util {
    /**
     * 生成一个固定容量的数组
     *
     * @param size 数组的容量
     * @return 返回的数组
     */
    public static int[] createArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int num = (int) (Math.random() * 100000);
            arr[i] = num;
        }
        return arr;
    }

    /**
     * 打印数组
     *
     * @param data 数组
     */
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
    }

}
