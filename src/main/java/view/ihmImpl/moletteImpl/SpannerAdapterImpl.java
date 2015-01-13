package view.ihmImpl.moletteImpl;

import view.iIhm.iMolette.ISpannerAdapter;

/**
 * Implement the S
 * <p>
 * Created by mds on 08/01/15.
 */
public class SpannerAdapterImpl implements ISpannerAdapter {

    private int position;

    public SpannerAdapterImpl() {
        position = 0;
    }

    /**
     *
     * @return
     */
    @Override
    public int position() {
        return position;
    }

    /**
     *
     * @param i
     */
    @Override
    public void setSpannerValue(int i) {
        this.position = i;
    }
}
