package com.sikorasoftware.webmail.view.inbox;

import com.sikorasoftware.webmail.inbox.MailMessage;
import com.vaadin.data.util.BeanItemContainer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by robertsikora on 08.01.2016.
 */

@Component
public class TableDataSetSupplier {

    private final static String ENDS = " ...";

    public BeanItemContainer<MailMessage> getDataSet(final List<MailMessage> content){

        final BeanItemContainer<MailMessage> container = new BeanItemContainer<>(MailMessage.class);
        content.forEach(mail -> {

            formatEntity(mail);
            container.addItem(mail);
        });

        return container;
    }

    private void formatEntity(final MailMessage entity){

        entity.setFrom(substringIfPossible(entity.getFrom(), 40));
        entity.setSubject(substringIfPossible(entity.getSubject(), 90));
    }

    private String substringIfPossible(final String str, final int count){
        if(str.length() > count){
            return str.substring(0, count).concat(ENDS);
        }
        return str;
    }
}
