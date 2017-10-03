package vk.dev.alg.search;

/**
 * Algorithm:<br>
 * - find middle element in the array<br>
 * - if middle == value return it<br>
 * - if middle > value search in the right half<br>
 * - if middle < value search in the left half<br>
 * - repeat it recursively
 */
public class BinarySearch implements ISearch {

    @Override
    public int find(int[] src, int value) {
        return find(src, 0, src.length - 1, value);
    }

    protected int find(int[] src, int left, int right, int value) {
        int midIndex = midIndex(src, left, right, value);
        int midValue = src[midIndex];

        if (value == midValue) {
            return midIndex;
        }

        // nothing found
        if (midIndex == right) {
            return -1;
        }

        return (value > midValue) ?
            find(src, midIndex, right, value) :
            find(src, left, midIndex, value);
    }

    protected int midIndex(int[] src, int left, int right, int value) {
        return (left + right + 1) / 2;
    }
}
