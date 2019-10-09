package com.otus.quizer.otus.utils.impl;

import com.otus.quizer.otus.utils.ConsoleContext;
import com.otus.quizer.otus.utils.InOutService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class InOutServiceImpl implements InOutService {

    private ConsoleContext consoleContext;

    public InOutServiceImpl(ConsoleContext consoleContext) {
        this.consoleContext = consoleContext;
    }

    @Override
    public String askQuestion(String question) {
        show(question);
        try {
            return new BufferedReader(new InputStreamReader(consoleContext.getInSourse())).readLine();
        } catch (IOException e) {
            return "";
        }
    }

    @Override
    public void show(String s) {
        consoleContext.getOutSourse().println(s);
    }
}
