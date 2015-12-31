package com.sikorasoftware.webmail.event;

/*
 * Event bus events used in Dashboard are listed here as inner classes.
 */
public abstract class WebmailEvent {

    public static final class UserLoginRequestedEvent {
        private final String userName, password;

        public UserLoginRequestedEvent(final String userName,
                final String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }
}
