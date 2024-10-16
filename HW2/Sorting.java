public class Sorting {

    int comparisonCount;
    int[] sortingArray;

    Sorting(int[] input) {
        sortingArray = input;
        comparisonCount = 0;
    }

    public static void main(String[] args) {

    }

    public void merge(int p, int q, int r) {
        int lt = q - p + 1;
        int rt = r - q;
        int[] ltArr = new int[lt];
        int[] rtArr = new int[rt];

        for (int i = 0; i < lt; i++) {
            ltArr[i] = sortingArray[p + i];
        }

        for (int i = 0; i < rt; i++) {
            rtArr[i] = sortingArray[q + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = p;
        while (i < lt && j < rt) {
            if (ltArr[i] <= rtArr[j]) {
                sortingArray[k] = ltArr[i];
                comparisonCount++;
                i++;
            } else {
                sortingArray[k] = rtArr[j];
                comparisonCount++;
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < lt) {
            sortingArray[k] = ltArr[i];
            i++;
            k++;
        }
        while (j < rt) {
            sortingArray[k] = rtArr[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (int) Math.floor((p + r) / 2);
        mergeSort(p, q);
        mergeSort(q + 1, r);
        merge(p, q, r);
    }

    public void insertionSort() {
        for (int i = 1; i < sortingArray.length; i++) {
            int key = sortingArray[i];
            int j = i - 1;
            while (j >= 0 && sortingArray[j] > key) {
                sortingArray[j + 1] = sortingArray[j];
                j = j - 1;
                comparisonCount++;
            }
            if (j >= 0) {
                comparisonCount++;
            }
            sortingArray[j + 1] = key;
        }
    }

    public void maxHeapify(int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n) {
            comparisonCount++;
            if (sortingArray[l] > sortingArray[i]) {
                largest = l;
            }
        } else {
            largest = i;
        }

        if (r < n) {
            comparisonCount++;
            if (sortingArray[r] > sortingArray[largest]) {
                largest = r;
            }
        }

        if (largest != i) {
            int tmp = sortingArray[i];
            sortingArray[i] = sortingArray[largest];
            sortingArray[largest] = tmp;

            maxHeapify(largest, n);
        }
    }

    public void buildMaxHeap() {
        int i = (int) Math.floor(sortingArray.length / 2);
        for (; i >= 0; i--) {
            maxHeapify(i, sortingArray.length);
        }
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = sortingArray.length - 1; i >= 1; i--) {
            int tmp = sortingArray[i];
            sortingArray[i] = sortingArray[0];
            sortingArray[0] = tmp;
            maxHeapify(0, i);
        }
    }

}