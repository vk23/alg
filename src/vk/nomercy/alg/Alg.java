package vk.nomercy.alg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.time.StopWatch;
import vk.nomercy.alg.search.BinarySearch;
import vk.nomercy.alg.search.ISearch;
import vk.nomercy.alg.search.InterpolationSearch;
import vk.nomercy.alg.search.LinearSearch;
import vk.nomercy.alg.sort.BubbleSort;
import vk.nomercy.alg.sort.HeapSort;
import vk.nomercy.alg.sort.ISort;
import vk.nomercy.alg.sort.InsertionSort;
import vk.nomercy.alg.sort.MergeSort;
import vk.nomercy.alg.sort.QuickSort;
import vk.nomercy.alg.sort.SelectionSort;
import vk.nomercy.alg.sort.ShellSort;
import vk.nomercy.alg.sort.sequences.HibbardSequence;
import vk.nomercy.alg.sort.sequences.TokudaSequence;

public class Alg {

    private static final int MAX = 1000;
    private static final int NUM = 1000;

    public static void main(String... args) {
        testSort();
        testSearch();
    }

    private static void testSort() {
        int[] unsorted = Util.generate(NUM, MAX);
        System.out.format("%n///////////////////////////%nSORTING%nUnsorted = %s%n", Arrays.toString(unsorted));

        List<ISort> sortList = new LinkedList<>();
        sortList.add(new BubbleSort());
        sortList.add(new SelectionSort());
        sortList.add(new InsertionSort());
        sortList.add(new ShellSort(Util.reverseSequence(new HibbardSequence(unsorted.length))));
        sortList.add(new ShellSort(Util.reverseSequence(new TokudaSequence(unsorted.length))));
        sortList.add(new MergeSort());
        sortList.add(new HeapSort());
        sortList.add(new QuickSort());

        for (ISort sort : sortList) {
            System.out.println("\n///////////////////////////");
            System.out.format("Started sorting: %s%n", sort.getClass().getSimpleName());
            int[] unsortedCopy = Arrays.copyOf(unsorted, unsorted.length);

            StopWatch sw = new StopWatch();
            sw.start();
            int[] sorted = sort.sort(unsortedCopy);
            sw.stop();

            System.out.format("Finished sorting in %d ms%n", sw.getTime());
            System.out.format("Result = %s%n", Arrays.toString(sorted));
        }
    }

    private static void testSearch() {
        int[] arr = Util.generate(NUM, MAX);
        assert arr.length > 2;
        Arrays.sort(arr);
        System.out.format("%n///////////////////////////%nSEARCHING%nSorted array = %s%n", Arrays.toString(arr));

        List<ISearch> searchList = new LinkedList<>();
        searchList.add(new LinearSearch());
        searchList.add(new BinarySearch());
        searchList.add(new InterpolationSearch());

        for (ISearch search : searchList) {
            System.out.println("\n///////////////////////////");
            System.out.format("Started searching: %s%n", search.getClass().getSimpleName());
            int[] copy = Arrays.copyOf(arr, arr.length);

            StopWatch sw = new StopWatch();
            sw.start();

            // let's find the second item from the end
            int itemToFind = copy[copy.length - 2];
            int found = search.find(copy, itemToFind);

            sw.stop();

            System.out.format("Finished searching in %d ms%n", sw.getTime());
            System.out.format("Found element=%d at index = %d%n", itemToFind, found);
        }
    }

}
