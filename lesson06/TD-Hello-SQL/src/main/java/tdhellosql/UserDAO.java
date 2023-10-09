package tdhellosql;


import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.*;



public class UserDAO {
    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findById(Integer id) throws SQLException {
        //2. get data from database
        User user = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("select * from users where id = ?");
            ps.setInt(1,id );
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3) );
            }
        }
        return user;
    }
    public User findByName(String name){
        //TODO
        return null;
    }
    public User add(User user) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, password) VALUES (?, ?) RETURNING id");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return findById(rs.getInt(1));
            }else{
                return null;
            }
        }
    }

    public User update(User user) {
        // TODO home work #6
        // UPDATE users SET name = 'newName', password = 'newPasswd' WHERE id = ?
        return null;
    }

    public User delete(Integer id) {
        // TODO home work #6
        // DELETE FROM user WHERE id = ?
        return null;
    }
}