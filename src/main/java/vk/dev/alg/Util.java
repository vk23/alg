package vk.dev.alg;

import vk.dev.alg.sort.sequences.Sequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Util {

    public static int[] generate(int size, int maxValue) {
        Random random = new Random();

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(maxValue);
        }
        return result;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static List<Integer> reverseSequence(Sequence sequence) {
        List<Integer> result = new ArrayList<>();
        sequence.forEach(result::add);
        Collections.reverse(result);
        return result;
    }
}
