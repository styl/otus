package com.otus.quizer.otus.utils.impl;

import com.otus.quizer.otus.utils.ConsoleContext;
import org.springframework.stereotype.Service;

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
