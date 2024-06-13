public class InterpolationSearch implements SearchAlgorithm {
    @Override
    public int search(int[] array, int target) {
        return interpolationSearch(array, 0, array.length - 1, target);
    }

    private int interpolationSearch(int[] array, int left, int right, int target) {
        if (left <= right && target >= array[left] && target <= array[right]) {
            int pos = left + ((right - left) * (target - array[left])) / (array[right] - array[left]);
            if (array[pos] == target) {
                return pos;
            }
            if (array[pos] < target) {
                return interpolationSearch(array, pos + 1, right, target);
            } else {
                return interpolationSearch(array, left, pos - 1, target);
            }
        }
        return -1; // Target not found
    }
}