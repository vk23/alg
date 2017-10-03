package vk.dev.alg.search;

/**
 * According to wiki:
 * <p>Exponential search allows for searching through a sorted, unbounded list for a specified input
 * value (the search "key"). The algorithm consists of two stages. The first stage determines a range in which the
 * search key would reside if it were in the list. In the second stage, a binary search is performed on this range. In
 * the first stage, assuming that the list is sorted in ascending order, the algorithm looks for the first exponent, j,
 * where the value 2j is greater than the search key. This value, 2j becomes the upper bound for the binary search with
 * the previous power of 2, 2j - 1, being the lower bound for the binary search.</p>
 */
public class ExponentialSearch extends BinarySearch {

    @Override
    public int find(int[] src, int value) {
        int bound = 1;
        int size = src.length;

        while (bound < size) {
            if (src[bound] == value) {
                return bound;
            }
            if (src[bound] > value) {
                break;
            }
            bound *= 2;
        }
        return find(src, bound / 2, Math.min(bound, size), value);
    }
}
