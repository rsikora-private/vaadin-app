package com.sikorasoftware.example1.ui.all_users;

import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import mvp.framework.View;

/**
 * Created by robertsikora on 02.11.15.
 */
public interface AllUserView extends View {

    String REFRESH_BTN = "ALL-User.refresh";

    TextField getFilter();

    Grid getGrid();
}
