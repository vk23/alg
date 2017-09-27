package vk.nomercy.alg.sort;

import java.util.List;
import vk.nomercy.alg.Util;

public class ShellSort implements ISort {

    private List<Integer> gapSequence;
    private int[] array;

    public ShellSort(List<Integer> gapSequence) {
        this.gapSequence = gapSequence;
    }

    @Override
    public int[] sort(int[] src) {
        array = src;
        gapSequence.forEach(this::sortWithGap);
        return array;
    }

    /**
     * Insertion sort on sub lists with step = gap<br>
     * if gap == 1, then it's just ordinary InsertionSort
     */
    private void sortWithGap(int gap) {
        int size = array.length;
        for (int i = gap; i < size; i++) {
            for (int j = i; j >= gap && array[j] < array[j - gap]; j -= gap) {
                Util.swap(array, j - gap, j);
            }
        }
    }
}
