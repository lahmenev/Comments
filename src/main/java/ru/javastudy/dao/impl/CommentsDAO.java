package ru.javastudy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.javastudy.dao.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentsDAO {
    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<User> getComments() {
        String sql = "select * from alex";
        List<User> listOfUsers = template.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int row) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setDescr(rs.getString("descr"));
                return user;
            }
        });
        return listOfUsers;
    }

    public int save(User user) {
        String sql = "insert into alex(name, descr) values('"+user.getName()+"','"+user.getDescr()+"')";
        return template.update(sql);
    }
}
