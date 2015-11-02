package mvp.framework.core;

import com.vaadin.spring.annotation.SpringComponent;
import mvp.framework.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 * Class take into account all beans having {@link MVPView} annotation
 * and autowire given Presenter {@link Presenter}.
 *
 * Created by robertsikora on 01.11.15.
 */

@SpringComponent
public class BindPostProcessor implements BeanPostProcessor {

    @Autowired
    private ViewBinder viewBinder;

    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        final Class clazz = bean.getClass();
        if(clazz.isAnnotationPresent(MVPView.class)){
            final MVPView annotation = (MVPView)clazz.getAnnotation(MVPView.class);
            final Class<? extends Presenter> presenter = annotation.presenter();
            viewBinder.bindToPresenter((View)bean, presenter);
        }
        return bean;
    }
}
