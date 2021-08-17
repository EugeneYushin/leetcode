package algo;

public class QuickSort {
    public void sortLomuto(int[] a, int lo, int hi) {
        if (lo >= 0 && hi >=0) {
            if (lo < hi) {
                int pivotPosition = partitionLomuto(a, lo, hi);
                sortLomuto(a, lo, pivotPosition - 1);
                sortLomuto(a, pivotPosition + 1, hi);
            }
        }
    }

    public int partitionLomuto(int[] a, int lo, int hi) {
        int i = lo - 1;
        int pivot = a[hi];
        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, ++i, hi);
        return i;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
