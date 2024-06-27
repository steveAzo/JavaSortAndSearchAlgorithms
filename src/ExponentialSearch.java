public class ExponentialSearch implements SearchAlgorithm {
    @Override
    public int search(int[] array, int target) {
        int n = array.length;
        if (array[0] == target) {
            return 0;
        }

        int i = 1;
        while (i < n && array[i] <= target) {
            i *= 2;
        }

        return binarySearch(array, target, i / 2, Math.min(i, n - 1));
    }

    private int binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}