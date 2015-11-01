package mvp.framework;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import java.util.Objects;

/**
 * Common interface for all MVP views.
 *
 * Created by robertsikora on 29.10.15.
 */
public interface View extends com.vaadin.navigator.View {

    default void showMessageOnSuccess(final String caption, final String description){
        Notification.show(caption, description, Notification.Type.HUMANIZED_MESSAGE);
    }

    default void showMessageOnError(final String caption, final String description){
        Notification.show(caption, description, Notification.Type.ERROR_MESSAGE);
    }

    default void showMessageOnWarrning(final String caption, final String description){
        Notification.show(caption, description, Notification.Type.WARNING_MESSAGE);
    }

    default void navigateTo(final String viewName){
        Objects.requireNonNull(viewName, "View name is mandatory !");
        UI.getCurrent().getNavigator().navigateTo(viewName);
    }
}
