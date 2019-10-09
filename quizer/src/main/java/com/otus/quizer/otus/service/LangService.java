package com.otus.quizer.otus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
public class LangService {

    private final MessageSource messageSource;
    private final String filename;
    private final HashMap<String, String> langMap = new HashMap<>();
    private Locale locale;

    public LangService(MessageSource messageSource,
                       @Value("${pattern}") String filename,
                       @Value("${lang}") String langStr) {
        this.messageSource = messageSource;
        this.filename = filename;
        String[] split;
        for (String lang : langStr.split(",")) {
            split = lang.split("-");
            this.langMap.put(split[0], split[1]);
        }
    }

    String getLangMessage(String s) {
        return messageSource.getMessage(s, null, locale);
    }

    void defineLanguage(String s) throws Exception {
        if (langMap.containsKey(s)) {
            locale = new Locale(s, langMap.get(s));
        } else {
            throw new Exception("Unknown language!");
        }
    }

    String getFilename() {
        return String.format(filename, locale.getLanguage());
    }
}