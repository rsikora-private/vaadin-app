package mvp.framework;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marker for class as View implementing MVP design pattern.
 *
 * Created by robertsikora on 01.11.15.
 */

@Target({ java.lang.annotation.ElementType.TYPE })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface MVPView {

    Class<? extends Presenter> presenter();
}
