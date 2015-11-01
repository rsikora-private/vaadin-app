package mvp.framework;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marker for class as Presenter implementing MVP design pattern.
 * Set prototype scope as default.
 *
 * Created by robertsikora on 01.11.15.
 */

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@SpringComponent
@Scope(value = "prototype")
public @interface MVPPresenter {
}
