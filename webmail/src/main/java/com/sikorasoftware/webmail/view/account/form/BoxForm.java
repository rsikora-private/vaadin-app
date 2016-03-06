package com.sikorasoftware.webmail.view.account.form;

import com.sikorasoftware.webmail.account.Box;
import com.sikorasoftware.webmail.common.component.textfield.LengthVisitator;
import com.sikorasoftware.webmail.common.component.textfield.NullRepresentationVisitator;
import com.sikorasoftware.webmail.common.component.textfield.TextFieldVisitatorEngine;
import com.sikorasoftware.webmail.common.component.textfield.ValidationVisibleVisitator;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robertsikora on 12.01.2016.
 */
public class BoxForm extends HorizontalLayout implements Serializable {

    private final static int FIELD_LENGTH = 20;

    private final List<Box> boxList;

    private final ListSelect boxes = new ListSelect("Available boxes");

    {
        boxes.setRows(5);
        boxes.setWidth(90, Unit.PERCENTAGE);
        boxes.setNullSelectionAllowed(false);
        boxes.setImmediate(true);

    }

    private final TextField boxNameTextField = new TextField();
    private final Button addButton = new Button("Add");

    {
        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
    }

    public BoxForm(final List<Box> boxList) {
        this.boxList = boxList;
        boxes.addItems(boxList);
        TextFieldVisitatorEngine.visit(this,
                new NullRepresentationVisitator(),
                new ValidationVisibleVisitator(false),
                new LengthVisitator(FIELD_LENGTH));
        CssLayout group = new CssLayout(boxNameTextField, addButton);
        group.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        addComponents(boxes, group);
        setSizeFull();
        setMargin(true);
        addButton.addClickListener(getButtonListener());
    }

    private Button.ClickListener getButtonListener() {
        return event -> {
            final String value = boxNameTextField.getValue();
            if (!StringUtils.isEmpty(value)) {
                final Box newBox = new Box(value);
                boxList.add(newBox);
                boxes.addItems(boxList);
                boxNameTextField.clear();
            }
        };
    }
}
