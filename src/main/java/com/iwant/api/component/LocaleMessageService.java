package com.iwant.api.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Component
public class LocaleMessageService implements MessageSourceAware {

    @Autowired
    private MessageSource messageSource;
    public static String INVALID_WANT_ID = "error.invalid.want.id";
    public static String UNKNOWN_USER = "error.unkown.user";
    public static String INTERNAL_ERROR = "error.internal";
    public static String INVALID_USER_ID = "error.invalid.user.id";
    public static String INVALID_USER_NAME = "error.invalid.name";
    public static String INVALID_USER_EMAIL = "error.invalid.email";

    public void setMessageSource(MessageSource messageSource) {
            this.messageSource = messageSource;
        }

    public String getMessage(String id) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, null, locale);
    }

    public String getMessage(String id, String... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(id, args, locale);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.ENGLISH);
        return slr;
    }
}