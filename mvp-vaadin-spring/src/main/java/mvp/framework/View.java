package mvp.framework;

import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import java.util.Objects;

/**
 * Common interface for all MVP views.
 *
 * Created by robertsikora on 29.10.15.
 */
public interface View extends com.vaadin.navigator.View {

    int SEC = 2;

    default void showMessageOnSuccess(final String caption, final String description){
        final Notification notification = new Notification(caption, description, Notification.Type.HUMANIZED_MESSAGE);
        notification.setPosition(Position.TOP_CENTER);
        notification.setDelayMsec(SEC * 1000);
        notification.show(Page.getCurrent());
    }

    default void showMessageOnError(final String caption, final String description){
        final Notification notification = new Notification(caption, description, Notification.Type.ERROR_MESSAGE);
        notification.setPosition(Position.TOP_CENTER);
        notification.setDelayMsec(SEC * 1000);
        notification.show(Page.getCurrent());
    }

    default void showMessageOnWarrning(final String caption, final String description){
        final Notification notification = new Notification(caption, description, Notification.Type.WARNING_MESSAGE);
        notification.setPosition(Position.TOP_CENTER);
        notification.setDelayMsec(SEC * 1000);
        notification.show(Page.getCurrent());
    }

    default void navigateTo(final String viewName){
        Objects.requireNonNull(viewName, "View name is mandatory !");
        UI.getCurrent().getNavigator().navigateTo(viewName);
    }
}
