package com.sikorasoftware.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

/**
 * Created by robertsikora on 26.10.15.
 */
@SpringComponent
@UIScope
public class Greater {
    public String sayHello() {
        return "Hello from bean " + toString();
    }
}
