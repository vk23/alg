package vk.dev.alg.sort.sequences;

public class HibbardSequence extends Sequence {

    public HibbardSequence(int max) {
        super(max);
    }

    /**
     * According to Wikipedia: formula = 2^k - 1 Sequence should be like: 1,3,7,15,31,63,...
     *
     * @return next sequence value
     */
    @Override
    protected Integer calcNext() {
        int i = index + 1;
        double d = Math.pow(2, i) - 1;
        return (int)Math.round(d);
    }

}
