package vk.nomercy.alg.search;

public class BinarySearch implements ISearch {

    @Override
    public int find(int[] src, int value) {
        return find(src, 0, src.length, value);
    }

    /**
     * {incl}
     * Algorithm:<br>
     * - find middle element in the array<br>
     * - if middle == value return it<br>
     * - if middle > value search in the right half<br>
     * - if middle < value search in the left half<br>
     * - repeat it recursively
     *
     * @param src
     * @param left
     * @param right
     * @param value
     * @return index
     */
    private int find(int[] src, int left, int right, int value) {
        int midIndex = (left + right - 1) / 2;
        int midValue = src[midIndex];

//        System.out.format("left=%d, right=%d, mid=%d, midVal=%d%n", left, right, midIndex, midValue);

        if (value == midValue) {
            return midIndex;
        }
        if (value > midValue) {
            return find(src, midIndex, right, value);
        } else {
            return find(src, left, midIndex, value);
        }
    }

}
