package com.otus.quizer.otus.service;

import com.otus.quizer.otus.model.Question;

import java.util.List;

public interface FileReader {
    List<Question> getQuestions(String filename) throws Exception;
}
