package vk.nomercy.alg.search;

public class InterpolationSearch extends BinarySearch {

    @Override
    protected int midIndex(int[] src, int left, int right, int value) {
        int i = left + ((right - 1 - left) / (src[right - 1] - src[left])) * (value - src[left]);
        return i == left ? i + 1 : i;
    }
}
