package mvp.framework;


/**
 * Common interface for all presenters.
 *
 * Created by robertsikora on 31.10.15.
 */

public interface Presenter<T extends View> {

    /**
     *  Apply it to bind given view to presenter. After it
     *  presenter has reference to view.
     */

    void bindView(T view);

    /**
     * Apply it to initialize presenter after view binding.
     * It the best place to register listeners to view and etc.
     */
    void init();
}
