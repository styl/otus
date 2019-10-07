package otus.utils.impl;

import org.springframework.stereotype.Service;
import otus.utils.ConsoleContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class InOutServiceImpl implements otus.utils.InOutService {

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
