package vk.nomercy.alg.sort;

import vk.nomercy.alg.Util;

public class HeapSort implements ISort {

    @Override
    public int[] sort(int[] src) {
        int size = src.length;

        // build a binary heap having max at src[0]
        heapify(src, size - 1);

        for (int i = size - 1; i > 0; i--) {
            // swap max and last
            Util.swap(src, 0, i);
            // restore heap property
            siftDown(src, 0, i);
//            System.out.format("i=%d, arr=%s%n", i, Arrays.toString(src));
        }

        return src;
    }

    private void heapify(int[] src, int size) {
        for (int i = size - 1; i > 0; i--) {
            siftDown(src, parentIndex(i), size - 1);
//            System.out.format("heapify: i=%d, arr=%s%n", i, Arrays.toString(src));
        }
    }

    private void siftDown(int[] src, int start, int end) {
        int parent = start;

        while (parent <= end) {

            // compare parent and left child
            int left = leftIndex(parent);
            int swap = (left >= end || src[left] < src[parent]) ? parent : left;

            // compare bigger one from previous with right child (if any)
            int right = rightIndex(parent);
            swap = (right >= end || src[right] < src[swap]) ? swap : right;

            // if nothing to swap then we are done
            if (swap == parent) {
                break;
            }

            Util.swap(src, parent, swap);
            parent = swap;
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightIndex(int parentIndex) {
        return leftIndex(parentIndex) + 1;
    }
}
