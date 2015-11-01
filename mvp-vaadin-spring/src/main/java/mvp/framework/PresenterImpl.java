package mvp.framework;


/**
 * Each presenter should extend this class. Should be used
 * in conjunction with {@link MVPPresenter}.
 *
 * Example of using:
 *
 * <pre>
 * &#064;MVPPresenter
 * public class MyPresenter extends PresenterImpl {
 *     // ...
 * }
 * </pre>
 *
 * Created by robertsikora on 31.10.15.
 */

public abstract class PresenterImpl<T extends View> implements Presenter<T>{

    private T view;

    public void bindView(final T view){
        this.view = view;
    }

    public T view(){
        return view;
    }
}
