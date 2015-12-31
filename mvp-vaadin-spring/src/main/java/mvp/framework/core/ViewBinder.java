package mvp.framework.core;

import mvp.framework.Presenter;
import mvp.framework.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Class helps bind loosely view - presenter.
 *
 * Created by robertsikora on 01.11.15.
 */

@Component
public class ViewBinder {

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
            final Presenter presenter = (Presenter)applicationContext.getBean(presenterClazz);
            presenter.bindView(mvpView);
            presenter.init();
        }catch (Exception ex){
            throw new MVPInitializeException(String.format("Cannot create a presenter %s and bind it for view %s",
                    presenterClazz.getSimpleName(), mvpView.getClass().getSimpleName()), ex);
        }
    }
}
