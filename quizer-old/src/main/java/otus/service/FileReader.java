package otus.service;

import otus.model.Question;

import java.io.InputStream;
import java.util.List;

public interface FileReader {
    List<Question> getQuestions(InputStream inputStream) throws Exception;
}
