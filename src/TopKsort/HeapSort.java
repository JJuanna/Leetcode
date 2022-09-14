package TopKsort;

public class HeapSort {
    // 大根堆：从小到大排序
    // 堆排序思路:(1)建堆(=n/2次调整);(2)调整
    // 索引0可以空下或者作为哨兵
    // 建堆：从最后一个非叶子结点开始向上调整
    // 调整：从第一个结点开始向下调整
    private static void HeapAdjust(int[] arr, int s, int m) {
        int rc = arr[s];
        // 向下调整
        for (int k = 2 * s; k <= m; k *= 2) {
            // 找key较大的下标
            if (k < m && arr[k] < arr[k + 1]) k++;
            // rc应该插在位置s上
            if (rc > arr[k]) break;
            arr[s] = arr[k];
            s = k;
        }
        arr[s] = rc;
    }

    private static void HeapSort(int[] arr) {
        // 建堆
        for (int i = arr.length / 2; i > 0; i--) {
            HeapAdjust(arr, i, arr.length - 1);
        }
        // 调整n次
        for (int i = arr.length - 1; i > 1; i--) {
            // 交换
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            // 调整
            HeapAdjust(arr, 1, i - 1);
        }
    }

    // 小根堆
    private static void SmallHeapSort(int[] arr) {
        // 建堆
        for (int i = arr.length / 2; i > 0; i--) {
            SmallHeapAdjust(arr, i, arr.length - 1);
        }
        // 调整n次
        for (int i = arr.length - 1; i > 1; i--) {
            // 交换
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            // 调整
            SmallHeapAdjust(arr, 1, i - 1);
        }
    }

    private static void SmallHeapAdjust(int[] arr, int s, int m) {
        int rc = arr[s];
        // 向下调整
        for (int k = 2 * s; k <= m; k *= 2) {
            // 找key较小的下标
            if (k < m && arr[k] > arr[k + 1]) k++;
            // rc应该插在位置s上
            if (rc < arr[k]) break;
            arr[s] = arr[k];
            s = k;
        }
        arr[s] = rc;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 4, 5, 3, 7, 5, 0};
        SmallHeapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
