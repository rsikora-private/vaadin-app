package sikorasoftware.ui;

import com.vaadin.ui.Button;
import mvp.framework.View;

/**
 * Created by robertsikora on 31.10.15.
 */
public interface AddUserView extends View, com.vaadin.navigator.View {

    void registerSaveButtonListener(Button.ClickListener listener);

}
