public class JumpSearch implements SearchAlgorithm {
    @Override
    public int search(int[] array, int target) {
        int n = array.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;

        while (array[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
