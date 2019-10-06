package otus.utils.impl;

import org.springframework.stereotype.Service;
import otus.utils.ConsoleContext;

import java.io.InputStream;
import java.io.PrintStream;

@Service
public class ConsoleContextImpl implements ConsoleContext {

    @Override
    public InputStream getInSourse() {
        return System.in;
    }

    @Override
    public PrintStream getOutSourse() {
        return System.out;
    }
}
