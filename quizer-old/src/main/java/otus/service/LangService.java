package otus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

@Service
@PropertySource("classpath:main.properties")
public class LangService {

    private final MessageSource messageSource;
    private final String filename;
    private final HashMap<String, String> langs;
    private Locale locale;

    public LangService(MessageSource messageSource,
                       @Value("${pattern}") String filename,
                       @Value("${lang}") String langsStr,
                       HashMap<String, String> langs) {
        this.messageSource = messageSource;
        this.filename = filename;
        this.langs = langs;
        String[] split;
        for (String lang : langsStr.split(",")) {
            split = lang.split("-");
            assert false;
            this.langs.put(split[0], split[1]);
        }
    }

    String getLangMessage(String s) {
        return messageSource.getMessage(s, null, locale);
    }

    void defineLanguage(String s) throws Exception {
        if (langs.containsKey(s)) {
            locale = new Locale(s, langs.get(s));
        } else {
            throw new Exception("Unknown language!");
        }
    }

    String getFilename() {
        return String.format(filename, locale.getLanguage());
    }
}