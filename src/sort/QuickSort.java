package sort;
public class QuickSort {
    public static void quickSort(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = left;
        int i = left;
        int j = right;
        int temp;
        while (i != j) {
            while (arr[j] >= arr[pivot] && i < j) {
                j--;
            }
            while (arr[i] <= arr[pivot] && i < j) {
                i++;
            }
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;
        quickSort(arr, left, i - 1);
        quickSort(arr, j + 1, right);
    }
    public static void main(String[] args) {
        int array[] = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(array, 0, array.length - 1);
    }
}