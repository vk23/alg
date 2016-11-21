package vk.nomercy.alg.sort;

public class MergeSort implements ISort {

    @Override
    public int[] sort(int[] src) {
        int size = src.length;
        int[] tmp = new int[size];

        // bottom-up sorting
        for (int step = 1; step < size; step = 2 * step) {

//            System.out.format("%nStep=%d:%n array=%s%n", step, Arrays.toString(src));
            for (int left = 0; left < size; left += 2 * step) {

                int middle = Math.min(left + step, size);
                int right = Math.min(middle + step, size);
//                System.out.format("left=%d, middle=%d, right=%d%n", left, middle, right);
                merge(src, tmp, left, middle, right);
//                System.out.format("tmp=%s%n", Arrays.toString(tmp));
            }

            // TODO: swap roles instead of copying?
            System.arraycopy(tmp, 0, src, 0, size);
        }

        return src;
    }

    private void merge(int[] src, int tmp[], int left, int middle, int right) {
        int i = left, j = middle;

        for (int k = left; k < right; k++) {
            if (i < middle && (j >= right || src[i] < src[j])) {
                tmp[k] = src[i];
                i++;
            } else {
                tmp[k] = src[j];
                j++;
            }
        }
    }
}
