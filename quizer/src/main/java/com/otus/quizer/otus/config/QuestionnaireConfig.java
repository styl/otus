package com.otus.quizer.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
public class QuestionnaireConfig {

    @Value("${config.basename}")
    private String basename;

    @Value("${config.encoding}")
    private String encoding;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setDefaultEncoding(encoding);
        ms.setBasename(basename);
        return ms;
    }
}
