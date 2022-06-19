package maven.cource.project;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

public class GameEventListener implements ApplicationListener<GameEvent>, ApplicationContextAware {
    @Autowired
    private final Nigma nigma;
    private ApplicationContext context;

    public GameEventListener(Nigma nigma) {
        this.nigma = nigma;
    }

    @Override
    public void onApplicationEvent(GameEvent event) {

        if (event.getGuess() > 1000 || event.getGuess() < 0) {
            System.out.println(context.getMessage("wrongInput", null, event.getLocale()));
        } else if (nigma.getNigma() > event.getGuess()) {
            System.out.println(context.getMessage("bigger", null, event.getLocale()));
        } else if (nigma.getNigma() < event.getGuess()) {
            System.out.println(context.getMessage("less", null, event.getLocale()));
        } else {
            System.out.println(context.getMessage("match", null, event.getLocale()) + " " + event.getGuess());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
