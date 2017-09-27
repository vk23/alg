package vk.nomercy.alg.sort.sequences;

import java.util.Iterator;

public abstract class Sequence implements Iterable<Integer> {
    protected Integer max = 0;
    protected Integer current = 0;
    protected Integer index = 0;

    public Sequence(Integer max) {
        this.max = max;
        System.out.format("New gap sequence: %s%n", getClass().getSimpleName());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return calcNext() < max;
            }

            @Override
            public Integer next() {
                current = calcNext();
                index++;
                return current;
            }
        };
    }

    protected abstract Integer calcNext();
}
