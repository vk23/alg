package vk.dev.alg.sort;

import vk.dev.alg.Util;

public class InsertionSort implements ISort {

    @Override
    public int[] sort(int[] src) {
        int size = src.length;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0 && src[j] < src[j - 1]; j--) {
                Util.swap(src, j - 1, j);
            }
        }

        return src;
    }

}
