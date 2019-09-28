package otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import otus.service.Questionare;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        Questionare questionare = context.getBean(Questionare.class);
        questionare.quizing();
    }
}
