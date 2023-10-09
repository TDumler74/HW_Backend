package tdhellosql;

import java.sql.SQLException;

public class UserDaoDemo {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO(MyDataSource.getDataSource());
        User user = userDAO.findById(2);
        System.out.println(user);
    }
}
