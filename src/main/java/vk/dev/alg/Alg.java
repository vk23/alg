package vk.dev.alg;

import org.apache.commons.cli.*;
import org.apache.commons.lang3.time.StopWatch;
import vk.dev.alg.search.*;
import vk.dev.alg.sort.*;
import vk.dev.alg.sort.sequences.HibbardSequence;
import vk.dev.alg.sort.sequences.TokudaSequence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Alg {

    private static int max;
    private static int num;

    public static void main(String... args) {
        Options options = options();
        DefaultParser defaultParser = new DefaultParser();
        CommandLine appArgs;
        try {
            appArgs = defaultParser.parse(options, args);
            execute(appArgs);
        } catch (Exception e) {
            e.printStackTrace();
            printHelp(options);
            System.exit(1);
        }
    }

    private static void execute(CommandLine appArgs) throws Exception {
        max = Integer.parseInt(appArgs.getOptionValue("max", "1000"));
        num = Integer.parseInt(appArgs.getOptionValue("num", "1000"));

        if (appArgs.hasOption("all")) {
            testSort();
            testSearch();
        } else if (appArgs.hasOption("sort")) {
            testSort();
        } else if (appArgs.hasOption("search")) {
            testSearch();
        } else {
            throw new IllegalAccessException("Unknown mode");
        }
    }

    private static void printHelp(Options options) {
        new HelpFormatter().printHelp("Alg", options);
    }

    private static Options options() {
        Options options = new Options();

        OptionGroup modes = new OptionGroup();
        modes.addOption(new Option("sort", false, "Run all sorting algorithms"));
        modes.addOption(new Option("search", false, "Run all searching algorithms"));
        modes.addOption(new Option("all", false, "Run all algorithms"));

        options.addOptionGroup(modes);
        options.addOption("max", true, "Generate values from 0 to max");
        options.addOption("num", true, "Size of array");
        return options;
    }

    private static void testSort() {
        int[] unsorted = Util.generate(num, max);
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
        int[] arr = Util.generate(num, max);
        assert arr.length > 2;
        Arrays.sort(arr);
        System.out.format("%n///////////////////////////%nSEARCHING%nSorted array = %s%n", Arrays.toString(arr));

        List<ISearch> searchList = new LinkedList<>();
        searchList.add(new LinearSearch());
        searchList.add(new BinarySearch());
        searchList.add(new InterpolationSearch());
        searchList.add(new ExponentialSearch());

        for (ISearch search : searchList) {
            System.out.println("\n///////////////////////////");
            System.out.format("Started searching: %s%n", search.getClass().getSimpleName());
            int[] copy = Arrays.copyOf(arr, arr.length);

            StopWatch sw = new StopWatch();
            sw.start();

            // let's search for the second item from the end
            int itemToFind = copy[copy.length - 2];
            int found = search.find(copy, itemToFind);

            sw.stop();

            System.out.format("Finished searching in %d ms%n", sw.getTime());
            System.out.format("Found element=%d at index = %d%n", itemToFind, found);
        }
    }

}
