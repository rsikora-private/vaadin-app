package com.sikorasoftware.webmail.common.component.textarea;

import com.sikorasoftware.webmail.inbox.MailContent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Created by robertsikora on 08.01.2016.
 */
public class MailTextarea extends VerticalLayout {

    public MailTextarea(){

        setSizeUndefined();
        setImmediate(true);
    }

    public void setContent(final List<MailContent> content){

        removeAllComponents();
        content.forEach(t -> {

                final Label label = new Label();
                label.setValue(t.getContent());
                if(MailContent.ContentType.TEXT == t.getContentType()){
                    label.setContentMode(ContentMode.TEXT);
                } else {
                    label.setContentMode(ContentMode.HTML);
                }

                addComponent(label);
            }
        );
    }
}
