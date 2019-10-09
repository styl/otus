package com.otus.quizer.otus.utils;

import java.io.InputStream;
import java.io.PrintStream;

public interface ConsoleContext {
    InputStream getInSourse();

    PrintStream getOutSourse();
}
