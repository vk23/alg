package vk.nomercy.alg.sort;

import vk.nomercy.alg.Util;

public class BubbleSort implements ISort {

    @Override
    public int[] sort(int[] src) {
        int size = src.length;

        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 1; j < size; j++) {
                if (src[j] < src[j - 1]) {
                    Util.swap(src, j - 1, j);
                    swapped = true;
                }
            }
//            System.out.format("After %d pass: %s%n", i + 1, Arrays.toString(src));
            if (!swapped) break;
        }
        return src;
    }

}
