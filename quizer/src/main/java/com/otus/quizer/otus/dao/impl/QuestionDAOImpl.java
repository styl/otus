package com.otus.quizer.otus.dao.impl;

import com.otus.quizer.otus.dao.QuestionDAO;
import com.otus.quizer.otus.model.Question;
import com.otus.quizer.otus.service.FileReader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    private final FileReader fileReader;

    public QuestionDAOImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Question> getQuestions(String filename) throws Exception {
        return fileReader.getQuestions(filename);
    }
}
