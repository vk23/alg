package vk.nomercy.alg.search;

/**
 * According to wiki:
 * <p>Interpolation search is an algorithm for searching for a given key in an indexed array that has been ordered by
 * numerical values assigned to the keys (key values). It parallels how humans search through a telephone book for a
 * particular name, the key value by which the book's entries are ordered. In each search step it calculates where in
 * the remaining search space the sought item might be, based on the key values at the bounds of the search space and
 * the value of the sought key, usually via a linear interpolation. The key value actually found at this estimated
 * position is then compared to the key value being sought. If it is not equal, then depending on the comparison, the
 * remaining search space is reduced to the part before or after the estimated position. This method will only work if
 * calculations on the size of differences between key values are sensible.</p>
 *
 * <p>By comparison, the binary search always chooses the middle of the remaining search space, discarding one half or the
 * other, depending on the comparison between the key found at the estimated position and the key sought — it does not
 * require numerical values for the keys, just a total order on them. The remaining search space is reduced to the part
 * before or after the estimated position. The linear search uses equality only as it compares elements one-by-one from
 * the start, ignoring any sorting.</p>
 */
public class InterpolationSearch extends BinarySearch {

    @Override
    protected int midIndex(int[] src, int left, int right, int value) {
        int i = left + ((right - left) / (src[right] - src[left])) * (value - src[left]);
        return i == left ? i + 1 : i;
    }
}
