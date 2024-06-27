public class InterpolationSearch implements SearchAlgorithm {
    @Override
    public int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && target >= array[low] && target <= array[high]) {
            if (low == high) {
                if (array[low] == target) return low;
                return -1;
            }

            int pos = low + (((target - array[low]) * (high - low)) / (array[high] - array[low]));

            if (array[pos] == target) {
                return pos;
            }

            if (array[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }
}
