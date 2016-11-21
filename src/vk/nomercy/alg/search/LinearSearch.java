package vk.nomercy.alg.search;

public class LinearSearch implements ISearch {

    @Override
    public int find(int[] src, int value) {
        int result = -1;

        for (int i = 0; i < src.length; i++) {
            if (src[i] == value) {
                result = i;
                break;
            }
        }

        return result;
    }
}
