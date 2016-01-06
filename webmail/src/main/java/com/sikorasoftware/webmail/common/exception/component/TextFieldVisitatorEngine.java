package com.sikorasoftware.webmail.common.exception.component;

import com.sikorasoftware.webmail.common.exception.exception.InitializationException;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.AbstractTextField;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 06.01.2016.
 */
public class TextFieldVisitatorEngine {

    public static void visit(final AbstractComponent component, TextFieldVisitator ... decorators){
        Assert.notNull(component);

        for(java.lang.reflect.Field memberField : component.getClass().getDeclaredFields()){
            if(memberField.getType().getSuperclass() == AbstractTextField.class){
                try {
                    memberField.setAccessible(true);
                    AbstractTextField abstractTextField = (AbstractTextField)memberField.get(component);
                    for(final TextFieldVisitator decorator : decorators){
                        decorator.decorate(abstractTextField);
                    }
                } catch (IllegalAccessException e) {
                    throw new InitializationException("", e);
                }
            }
        }
    }
}
