package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by robertsikora on 06.01.2016.
 * <p>
 * How to trust ssl certificate?
 * <p>
 * openssl x509 -in <(openssl s_client -connect poczta.interia.pl:993 -prexit 2>/dev/null) -out ~/example.crt
 * sudo keytool -importcert -file ~/example.crt -alias example -keystore $(/usr/libexec/java_home)/jre/lib/security/cacerts -storepass changeit
 */
@Component
public class EmailReceiveRoute extends SpringRouteBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailReceiveRoute.class);

    private final static String     RECEIVE_PROTOCOL        = "imaps";
    private final static int        RECEIVE_DELAY_IN_MIN   = 1 * 60_000;

    @Autowired
    private AccountService  accountService;
    @Autowired
    private EmailProcessor  emailProcessor;

    @Override
    public void configure() throws Exception {
        final Optional<Account> accountOptional = accountService.getDefaultAccount();
        if (accountOptional.isPresent()) {
            final Account account = accountOptional.get();
            final String uri = buildImapUri(account);
            LOGGER.info("Email uri: {}", uri);
            from(uri)
                    .routeId("email-receive-route")
                    .process(emailProcessor);

        } else {
            LOGGER.warn("The email receive route cannot be configured. There is not any defined account.");
        }
    }

    private String buildImapUri(final Account account) {
        return RECEIVE_PROTOCOL + "://"
                + account.getImapHost()
                + ":" + account.getImapPort()
                + "?password=" + account.getPassword()
                + "&username=" + account.getEmail()
                + "&consumer.delay=" + RECEIVE_DELAY_IN_MIN
                + "&mapMailMessage=false";
        //   + "&delete=false"
        //   + "&unseen=true";
    }

    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }

    public void setEmailProcessor(final EmailProcessor emailProcessor) {
        this.emailProcessor = emailProcessor;
    }
}