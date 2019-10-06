package otus.dao.impl;

import org.springframework.stereotype.Repository;
import otus.dao.QuestionDAO;
import otus.model.Question;
import otus.service.FileReader;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    private final FileReader fileReader;

    public QuestionDAOImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Question> getQuestions(String filename) throws Exception {
        return fileReader.getQuestions(getClass().getClassLoader().getResourceAsStream(filename));
    }
}
