package maven.cource.project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;


public class Main{

    @Autowired
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
//        Locale locale = Locale.getDefault();
        Locale locale = Locale.US;
        GameExe game = context.getBean(GameExe.class);

        game.launch(locale);
        }

}
