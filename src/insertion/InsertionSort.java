package insertion;

public class InsertionSort {
    private int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public void shift(int start, int end) throws ArrayIndexOutOfBoundsException {
        // Shifts all elements from start to end index (exclusively) to the right by 1
        // Throws error if trying to shift the last element
        for (int i = end - 1; i >= start; i--) {
            arr[i + 1] = arr[i];
        }
    }

    public int[] insertionSort(int split) {
        // Supply a split for lists that are already partially sorted
        split = (split == 0) ? 1 : split;
        for (int i = split; i < arr.length; i++) {
            for (int j = 0; j < split; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    shift(j, split);
                    arr[j] = temp;
                    split++;
                    break;
                } else if (j == split - 1) {
                    split++;
                    break;
                }
            }
        }
        return arr;
    }

    public int[] insertionSort() {
        return insertionSort(1);
    }
}