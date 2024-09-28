public class Sorting {

    int comparisonCount;
    int[] sortingArray;

    Sorting(int[] input) {
        sortingArray = input;
        comparisonCount = 0;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums1 = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        Sorting instance = new Sorting(nums1);
        instance.insertionSort();
    }

    public void mergeSort(int p, int r) {
        // TODO
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
        // for (int i = 0; i < size; i++) {
        // System.out.print(sortingArray[i] + " ");
        // }
        // System.out.println("------------------------------" + comparisonCount);
    }

    public void heapSort() {
        // TODO
    }

}
