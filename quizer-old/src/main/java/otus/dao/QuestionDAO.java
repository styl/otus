package otus.dao;

import otus.model.Question;

import java.util.List;
import java.util.Locale;

public interface QuestionDAO {

    List<Question> getQuestions(String s) throws Exception;

}
