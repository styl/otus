package com.otus.quizer.otus.service.impl;

import com.otus.quizer.otus.model.Question;
import com.otus.quizer.otus.service.FileReader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileReaderImpl implements FileReader {

    private static final String SEPAR = ";";

    @Override
    public List<Question> getQuestions(String filename) throws Exception {
        List<Question> list = new ArrayList<Question>();

        String question;
        String answer;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getStream(filename)));
            while (reader.ready()) {
                String[] strArr = reader.readLine().split(SEPAR);
                question = strArr[0];
                answer = strArr[1];
                if (!answer.isEmpty() && !question.isEmpty()) {
                    list.add(new Question(strArr[0], Boolean.parseBoolean(strArr[1])));
                }
            }
        } catch (Exception e) {
            throw new Exception("File with questions is broken!/Файл некорректно заполнен!");
        }
        return list;
    }

    private InputStream getStream(String filename) {
        return getClass().getClassLoader().getResourceAsStream(filename);
    }
}
