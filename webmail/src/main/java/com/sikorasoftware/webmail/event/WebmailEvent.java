package com.sikorasoftware.webmail.event;

import com.sikorasoftware.webmail.view.ViewType;

/*
 * Event bus events used in Dashboard are listed here as inner classes.
 */
public abstract class WebmailEvent {

    public static final class SuccessLoginEvent {
    }

    public static final class PostViewChangeEvent {
        private final ViewType view;

        public PostViewChangeEvent(final ViewType view) {
            this.view = view;
        }

        public ViewType getView() {
            return view;
        }
    }
}
