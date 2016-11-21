package vk.nomercy.alg.search;

public interface ISearch {
    /**
     * Search for the specified value in an array
     * @param src array to search in
     * @param value value to find
     * @return index of the specified value or -1 if not found
     */
    int find(int[] src, int value);
}
