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
        final FormLayout sendForm = new FormLayout();
        sendForm.addStyleName("outlined");
        sendForm.setSizeFull();
        sendForm.setSpacing(true);

        final TextField toTextField = new TextField("Do:", "");
        toTextField.setWidth(90.0f, Unit.PERCENTAGE);
        sendForm.addComponent(toTextField);

        final TextField copyTextField = new TextField("Kopia do:", "");
        copyTextField.setWidth(90.0f, Unit.PERCENTAGE);
        sendForm.addComponent(copyTextField);

        sendForm.addComponent(new CheckBox("Zachowaj w wyslanych"));

        final RichTextArea richTextArea = new RichTextArea();
        richTextArea.setImmediate(true);
        richTextArea.setSizeFull();
        sendForm.addComponent(richTextArea);

        sendForm.addComponent(new Button("Wyslij"));

        setSizeFull();
        setContent(sendForm);
    }
}
