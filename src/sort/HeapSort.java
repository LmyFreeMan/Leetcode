package sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {54, 26, 93, 17, 77, 31, 44, 55, 20};
        heapSort(arr);
        Util.print(arr);
    }

    private static void heapAdjust(int[] arr, int s, int m) {
        // 建立大顶堆
        // 注意如果堆的根节点的索引是从0开始的，那么下标为i的节点，其父节点的下标就是(i-1)/2
        // 第i个节点的左右子节点，它们的下标分别为2i+1和2i+2
        int rc = arr[s];    // 定义当前的根节点
        for (int j = s * 2 + 1; j <= m; j = s * 2 + 1) { // 这里注意是j<=m，当最后只剩2个节点（0号和1号）时，仍然work。j从第一个叶结点开始
            if (j < m && arr[j] < arr[j + 1])    // 比较两个子结点的大小，使指针保持指向子结点中值较大的那个
                j++;
            if (rc >= arr[j])    // 比较当前的根节点和最大的子结点的值的大小，如果根节点较大，那这个局部的子树已经是一个大顶堆了
                break;
            arr[s] = arr[j];   // 如果子结点的值较大，那就将此子结点的值赋给根节点
            s = j;    // 将较大的子结点的索引赋给s，保持s指向较大值的索引值
        }
        arr[s] = rc;   // 出循环之后，将根节点的值回赋给数组中索引值为s的元素
    }

    private static void heapSort(int[] arr) {
        // 建堆(大顶堆)
        for (int i = arr.length / 2 - 1; i >= 0; i--)  // i是最后一个非叶结点，且为arr.length/2-1，从最后一个非叶结点开始向前逐步建堆，直到堆顶的根节点(下标为0)
            heapAdjust(arr, i, arr.length - 1);
        for (int i = arr.length - 1; i > 0; i--) {   // 输出堆顶元素，并在输出后重新调整堆
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapAdjust(arr, 0, i - 1);
        }
    }
}