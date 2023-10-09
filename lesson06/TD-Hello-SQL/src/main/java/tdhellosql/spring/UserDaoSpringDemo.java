package tdhellosql.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tdhellosql.User;
import tdhellosql.UserDAO;

import java.sql.SQLException;

public class UserDaoSpringDemo {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
       User user = userDAO.findById(4);
       //System.out.println(user);
        user = userDAO.add(new User(5,"Peter","123456"));
        System.out.println(user);




    }

}
