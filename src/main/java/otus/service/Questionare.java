package otus.service;

import otus.model.Question;
import otus.utils.InOutService;

import java.util.List;

public class Questionare {

    private FileReader fileReader;
    private InOutService inOutService;

    public Questionare(FileReaderImpl fileReader, InOutService inOutService) {
        this.fileReader = fileReader;
        this.inOutService = inOutService;
    }

    public void quizing() {
        int score = 0;
        String userAnswer;
        String userName;
        List<Question> questions = fileReader.getQuestions();

        userName = inOutService.askQuestion("Privet!\nKak tebya zovut?");
        System.out.println("Opros!\n" + userName + ", vvodite svoi otvet(y/n).\n ");
        for (Question q : questions) {
            userAnswer = inOutService.askQuestion(q.getQuestion());
            if (!"y".equals(userAnswer) && !"n".equals(userAnswer)) {
                inOutService.show("Vash otvet ne raspoznan - pust' budet oshibkoy. Bedesh znat'!\n");
                score = score - 1;
                continue;
            }
            if (("y".equals(userAnswer) && q.getAnswer()) || ("n".equals(userAnswer) && !q.getAnswer())) {
                score++;
            }
        }
        inOutService.show("\n" + userName + ", vash s4et: " + score + "/" + questions.size() + "!");
    }
}
