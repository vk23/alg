package vk.nomercy.alg.sort.sequences;

public class TokudaSequence extends Sequence {

    public TokudaSequence(int max) {
        super(max);
    }

    /**
     * According to Wikipedia: formula = (9^k-4^k)/(5*4^{k-1}) Sequence should be like: 1,4,9,20,46,103,... but here I
     * get slightly different numbers like: 1,3,8,20,45,103,... It might be due to the precision and rounding issues.
     * But in the end who really cares?
     *
     * @return next sequence value
     */
    @Override
    protected Integer calcNext() {
        int i = index + 1;
        double d = (Math.pow(9, i) - Math.pow(4, i)) / (5 * Math.pow(4, index));
        return (int)Math.round(d);
    }

}