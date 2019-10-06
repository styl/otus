package otus.service.impl;

import org.springframework.stereotype.Service;
import otus.model.Question;
import otus.service.FileReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileReaderImpl implements FileReader {

    private static final String SEPAR = ";";

    @Override
    public List<Question> getQuestions(InputStream inputStream) throws Exception {
        List<Question> list = new ArrayList<Question>();

        String question;
        String answer;
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while(reader.ready()) {
                String [] strArr = reader.readLine().split(SEPAR);
                question = strArr[0];
                answer = strArr[1];
                if(!answer.isEmpty() && !question.isEmpty()) {
                    list.add(new Question(strArr[0], Boolean.parseBoolean(strArr[1])));
                }
            }
        } catch (Exception e) {
           throw new Exception("File with questions is broken!/Файл некорректно заполнен!");
        }
        return list;
    }
}
