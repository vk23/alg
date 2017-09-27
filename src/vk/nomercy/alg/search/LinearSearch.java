package vk.nomercy.alg.search;

import java.util.stream.IntStream;

public class LinearSearch implements ISearch {

    @Override
    public int find(int[] src, int value) {
        return IntStream.range(0, src.length)
            .filter(i -> src[i] == value)
            .findFirst()
            .orElse(-1);

    }
}
