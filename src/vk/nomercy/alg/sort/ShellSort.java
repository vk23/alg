package vk.nomercy.alg.sort;

import vk.nomercy.alg.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShellSort implements ISort {

    private List<Integer> gapSequence;

    public ShellSort(List<Integer> gapSequence) {
        this.gapSequence = gapSequence;
    }

    @Override
    public int[] sort(int[] src) {
        int size = src.length;

        for (int gap : gapSequence) {
            // Insertion sort on sub lists with step = gap
            // if gap == 1, then it's an ordinary InsertionSort
            for (int i = gap; i < size; i++) {
                for (int j = i; j >= gap && src[j] < src[j - gap]; j -= gap) {
                    Util.swap(src, j - gap, j);
                }
//                System.out.format("%s%n", Arrays.toString(src));
            }
//            System.out.format("Sequence element: %d%n", gap);
        }

        return src;
    }


    //////////////////////////////////////////////////////////////////////
    // Sequences
    //////////////////////////////////////////////////////////////////////

    //TODO: compute sequences outside of the sort coz it affects it greatly

    public static abstract class Sequence implements Iterable<java.lang.Integer> {
        protected Integer max = 0;
        protected Integer current = 0;
        protected Integer index = 0;

        Sequence(Integer max) {
            this.max = max;
            System.out.format("New gap sequence: %s%n", getClass().getSimpleName());
        }

        public List<Integer> toList() {
            List<Integer> result = new ArrayList<>();
            this.forEach(result::add);
            return result;
        }

        /**
         * ShellSort requires a list of gaps in the descending order
         *
         * @return reversed list
         */
        public List<Integer> toReversedList() {
            List<Integer> result = toList();
            Collections.reverse(result);
            return result;
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

    public static class HibbardSequence extends Sequence {

        public HibbardSequence(int max) {
            super(max);
        }

        /**
         * According to Wikipedia:
         * formula = 2^k - 1
         * Sequence should be like: 1,3,7,15,31,63,...
         *
         * @return next sequence value
         */
        @Override
        protected Integer calcNext() {
            int i = index + 1;
            double d = Math.pow(2, i) - 1;
            return (int) Math.round(d);
        }


    }

    public static class TokudaSequence extends Sequence {

        public TokudaSequence(int max) {
            super(max);
        }

        /**
         * According to Wikipedia:
         * formula = (9^k-4^k)/(5*4^{k-1})
         * Sequence should be like: 1,4,9,20,46,103,...
         * but here I get slightly different numbers like: 1,3,8,20,45,103,...
         * It might be due to precision and rounding issues.
         * But in the end who really cares?
         *
         * @return next sequence value
         */
        @Override
        protected Integer calcNext() {
            int i = index + 1;
            double d = (Math.pow(9, i) - Math.pow(4, i)) / (5 * Math.pow(4, index));
            return (int) Math.round(d);
        }

    }
}
