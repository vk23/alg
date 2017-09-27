package vk.nomercy.alg.sort;

import vk.nomercy.alg.Util;

public class SelectionSort implements ISort {

    @Override
    public int[] sort(int[] src) {
        int size = src.length;

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (src[j] < src[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Util.swap(src, i, minIndex);
            }
        }

        return src;
    }
}
