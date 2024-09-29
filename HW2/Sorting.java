public class Sorting {

    int comparisonCount;
    int[] sortingArray;

    Sorting(int[] input) {
        sortingArray = input;
        comparisonCount = 0;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums1 = new int[] { 512, 0, -9, 23, 65 };
        Sorting instance = new Sorting(nums1);
        // instance.insertionSort();
        instance.mergeSort(0, nums1.length - 1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }

    private void merge(int p, int q, int r) {
        int nL = q - p + 1;
        int nR = r - q;
        int[] L = new int[nL];
        int[] R = new int[nR];
        // copy elements from p to q into L
        // q+1 to r into R
        for (int i = 0; i < nL; i++) {
            L[i] = sortingArray[p + i];
        }
        for (int i = 0; i < nR; i++) {
            R[i] = sortingArray[q + 1 + i];
        }

        int i = 0;// points left array
        int j = 0;// points right array
        int index = p;// points original array
        while (i < nL && j < nR) {
            if (L[i] < R[j]) {
                sortingArray[index] = L[i];
                i++;
            } else {
                sortingArray[index] = R[j];
                j++;
            }
            index++;
        }

        // copying remaining elements
        while (i < nL) {
            sortingArray[index] = L[i];
            i++;
            index++;
        }
        while (j < nR) {
            sortingArray[index] = R[j];
            j++;
            index++;
        }
    }

    public void mergeSort(int p, int r) {
        // TODO
        if (p >= r)
            return;
        int q = (int) Math.floor((p + r) / 2);
        mergeSort(p, q);
        mergeSort(q + 1, r);
        merge(p, q, r);
    }

    public void insertionSort() {
        // TODO
        // lets sort the array first
        int size = sortingArray.length;
        for (int i = 1; i < size; i++) {
            int key = sortingArray[i];
            int j = i - 1;

            comparisonCount += i;// worst case compares
            while (j >= 0 && key < sortingArray[j]) {
                sortingArray[j + 1] = sortingArray[j];
                j--;
            }
            sortingArray[j + 1] = key;
            if (j > 0)
                comparisonCount -= j;// subtracting current position of j to get proper compares
        }
    }

    public void heapSort() {
        // TODO
    }

}
