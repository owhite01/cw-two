
package Classes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.SystemEnvironmentPropertySource;


public class MastermindDriver {
    // Example - change as you need to...
    public static void main(String[] args) {
        Game g = Factory.getInstance(Game.class, false);
        g.runGames();

        //g = Factory.getInstance(Game.class, false);
        //g.runGames();
    }

    public static BeanFactory getBeanFactory() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        // create a bean factory from beans.xml
        return new ClassPathXmlApplicationContext("file:beans.xml");
    }

}
