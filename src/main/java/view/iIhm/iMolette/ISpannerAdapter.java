package view.iIhm.iMolette;

/**
 * Spanner interface
 * Created by mds on 17/11/14.
 */
public interface ISpannerAdapter {
    /**
     * Return the spanner value, it's between 0.0 to 1.0
     *
     * @return int
     */
    int position();

    void setSpannerValue(int i);
}
