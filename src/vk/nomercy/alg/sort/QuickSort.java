package vk.nomercy.alg.sort;

import vk.nomercy.alg.Util;

public class QuickSort implements ISort {

    @Override
    public int[] sort(int[] src) {
        int size = src.length;
        quicksort(src, 0, size - 1);
        return src;
    }

    private void quicksort(int[] src, int left, int right) {
        if (left < right) {
            int p = partition(src, left, right);
            quicksort(src, left, p - 1);
            quicksort(src, p, right);
        }
    }

    private int partition(int[] src, int l, int r) {
        int p = src[r];
        int left = l - 1;
        int right = r + 1;

        for (; ; ) {
            while (src[++left] < p) {
            }

            while (--right > left && src[right] > p) {
            }

            if (left >= right) {
                return left;
            }

            Util.swap(src, left, right);
        }
    }

}

