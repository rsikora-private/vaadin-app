package com.sikorasoftware.webmail.view.outbox;

import com.sikorasoftware.webmail.mvp.ViewManager;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by robertsikora on 07.01.2016.
 */

@SpringView(name = OutboxView.NAME)
public class OutboxView extends Panel implements View, Serializable {
    public final static String NAME = "outbox";

    @Autowired
    private ViewManager viewManager;

    @PostConstruct
    public void init() {
        viewManager.configure(this);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        System.out.print("");
    }

    public OutboxView(){
        buildLayout();
    }

    private void buildLayout(){
        final FormLayout sample = new FormLayout();
        sample.addStyleName("outlined");
        sample.setSizeFull();
        sample.setSpacing(true);

        final Component child1 = new PopupDateField("Child 1");
        child1.setWidth(100.0f, Unit.PERCENTAGE);
        sample.addComponent(child1);

        final TextField child2 = new TextField("Child 2", "");
        child2.setWidth(100.0f, Unit.PERCENTAGE);
        sample.addComponent(child2);

        sample.addComponent(new CheckBox("Child 3"));
        sample.addComponent(new Button("Child 4"));
        setSizeFull();
        setContent(sample);
    }
}
