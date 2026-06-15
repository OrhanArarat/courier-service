package com.orhanararat.courier.tracking.distance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

@RequiredArgsConstructor
public class MessageSourceService {

    private final MessageSource messageSource;

    public String getMessage(String message, String... dynamicValues) {
        return messageSource.getMessage(message, dynamicValues, LocaleContextHolder.getLocale());
    }

}
