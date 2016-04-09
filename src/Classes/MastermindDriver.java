
package Classes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MastermindDriver {
    public static void main(String[] args) {
        try{
            Game g = (Game)getBeanFactory().getBean("game");
            g.runGames();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static BeanFactory beanFactory = new ClassPathXmlApplicationContext("file:beans.xml");

    public static BeanFactory getBeanFactory() throws Exception {
        // create a bean factory from beans.xml
        return beanFactory;
    }

}
