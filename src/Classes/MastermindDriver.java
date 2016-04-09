
package Classes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MastermindDriver {
    public static void main(String[] args) {
        Game g = Factory.getInstance(Game.class, false);
        g.runGames();

        //g = Factory.getInstance(Game.class, false);
        //g.runGames();
    }

    private static BeanFactory beanFactory = new ClassPathXmlApplicationContext("file:beans.xml");

    public static BeanFactory getBeanFactory() throws Exception {
        // create a bean factory from beans.xml
        return beanFactory;
    }

}
