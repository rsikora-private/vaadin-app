package com.sikorasoftware.webmail.inbox;

import com.sikorasoftware.webmail.account.Account;
import com.sikorasoftware.webmail.account.AccountService;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by robertsikora on 06.01.2016.
 *
 * How to trust ssl certificate?
 *
 * openssl x509 -in <(openssl s_client -connect poczta.interia.pl:993 -prexit 2>/dev/null) -out ~/example.crt
 * sudo keytool -importcert -file ~/example.crt -alias example -keystore $(/usr/libexec/java_home)/jre/lib/security/cacerts -storepass changeit
 *
 */

public class EmailReceiveRoute extends SpringRouteBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailReceiveRoute.class);

    private final static String RECEIVE_PROTOCOL = "imaps";
    private final static int    RECEIVE_DELAY_IN_MINS    = 1 * 60_000;

    private AccountService accountService;
    private MailProcessor mailProcessor;

    @Override
    public void configure() throws Exception {

        final Optional<Account> accountOptional = accountService.getDefaultAccount();
        if(accountOptional.isPresent()) {

            configureSslForImapProtocol();

            final Account account = accountOptional.get();
            final String uri = buildImapUri(account);

            LOGGER.info("Email uri: {}", uri);

            from(uri)
                    .routeId("email-receive-route")
                    .process(mailProcessor);

        } else {

            LOGGER.warn("The email receive route cannot be configured. There is not any defined account.");
        }
    }

    private String buildImapUri(final Account account){
       return  RECEIVE_PROTOCOL + "://"
               + account.getImapHost()
               + ":" + account.getImapPort()
               + "?password=" + account.getPassword()
               + "&username=" + account.getEmail()
               + "&consumer.delay=" + RECEIVE_DELAY_IN_MINS
               + "&mapMailMessage=false";
            //   + "&delete=false"
            //   + "&unseen=true";
    }

    private void configureSslForImapProtocol(){
    }

    public void setAccountService(final AccountService accountService) {
        this.accountService = accountService;
    }

    public void setMailProcessor(final MailProcessor mailProcessor) {
        this.mailProcessor = mailProcessor;
    }
}
