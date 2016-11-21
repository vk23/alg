package vk.nomercy.alg;

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
}
