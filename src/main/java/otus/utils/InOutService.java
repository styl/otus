package otus.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOutService {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public String askQuestion(String question) {
        System.out.println(question);
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public void show(String s) {
        System.out.println(s);
    }
}
