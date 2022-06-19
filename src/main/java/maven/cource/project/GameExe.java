package maven.cource.project;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;
import java.util.Scanner;

public class GameExe implements ApplicationContextAware {

    private final Nigma nigma;
    private ApplicationContext context;
    public GameExe(Nigma nigma) {
        this.nigma = nigma;
    }

    public void launch(Locale locale) {
        System.out.println(context.getMessage("greeting", null, locale));
        GameEventPublisher publisher = context.getBean(GameEventPublisher.class);
        boolean winCondition = true;
        while (winCondition) {

            System.out.println(context.getMessage("try", null, locale));
            Scanner scanner = new Scanner(System.in);
            int guess = scanner.nextInt();

            publisher.publishEvent(guess, locale);
            if (nigma.getNigma() == guess) {
                winCondition = false;
            }

        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
