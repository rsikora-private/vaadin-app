package mvp.framework;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

/**
 * Class helps bind loosely view - presenter.
 *
 * Created by robertsikora on 01.11.15.
 */

@SpringComponent
public final class ViewBinder {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Method injects MVP view to MVP presenter.
     * After it presenter has reference to view whilst the view
     * doesn't have any knowledge about presenter.
     * @param mvpView
     * @param presenterClazz
     */

    public void bindToPresenter(final View mvpView, final Class presenterClazz){
        Objects.requireNonNull(mvpView, "View is mandatory !");
        Objects.requireNonNull(presenterClazz, "Presenter is mandatory !");
        try {
            final PresenterImpl presenter = (PresenterImpl)applicationContext.getBean(presenterClazz);
            presenter.bindView(mvpView);
            presenter.init();
        }catch (Exception ex){
            throw new MVPInitializeException(String.format("Cannot create presenter %s for view %s",
                    presenterClazz.getSimpleName(), mvpView.getClass().getSimpleName()), ex);
        }
    }
}
