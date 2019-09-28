package otus.service;


import otus.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FileReaderImpl implements FileReader{

    private static final String SEPAR = ";";
    private String path;
    private static final HashSet<String> answer = new HashSet<String>(){{add("true"); add("false");}};


    private String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Question> getQuestions() {
        List<Question> list = new ArrayList<Question>();

        String question;
        String answer;

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(getPath());
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while(reader.ready()) {
                String [] strArr = reader.readLine().split(SEPAR);
                question = strArr[0];
                answer = strArr[1];
                if(answer.contains(answer) && !question.isEmpty()) {
                    list.add(new Question(strArr[0], Boolean.parseBoolean(strArr[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
