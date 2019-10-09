package com.otus.quizer.otus.dao;

import com.otus.quizer.otus.model.Question;

import java.util.List;

public interface QuestionDAO {

    List<Question> getQuestions(String s) throws Exception;

}
