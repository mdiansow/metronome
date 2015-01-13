package view.ihmImpl.moletteImpl;

import command.ICommand;
import view.iIhm.iHorloge.IHorloge;
import view.iIhm.iMolette.ISpanner;
import view.iIhm.iMolette.ISpannerAdapter;

/**
 * Created by mds on 08/01/15.
 */
public class SpannerImpl implements ISpanner {

    private int position;
    private ICommand cmd;
    private IHorloge horloge;
    private ISpannerAdapter spannerAdapter;
    private int sliderValue;

    private static final int PERIODE_IN_MILLISECOND = 50;

    public SpannerImpl(ISpannerAdapter spannerAdapter, IHorloge h) {
        this.spannerAdapter = spannerAdapter;
        this.horloge = h;
        horloge.activatePeriodically(() -> {
            poll();
        }, PERIODE_IN_MILLISECOND);
    }

    private void poll() {
        int currentValue = spannerAdapter.position();
        System.out.println("spanner value " + currentValue);

        if (sliderValue != currentValue) {
            position = currentValue;
            this.cmd.execute();
        }
    }

    @Override
    public Integer getValue() {
        return position;
    }

    @Override
    public void setMoletteCmd(ICommand cmd) {
        this.cmd = cmd;
    }
}
