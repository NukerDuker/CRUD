package com.example.userAPI.repository;

import com.example.userAPI.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcUserRepo implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public String reg(User user) {
        jdbcTemplate.update("INSERT INTO userauth.user_tab(name, login, password, phone, birth_date, tg, email) VALUES(?, ?, ?, ?, ?, ?, ?)", new Object[]{user.getName(), user.getLogin(), user.getPassword(), user.getPhone(), user.getBirthDate(), user.getTg(), user.getEmail()});
        user.setId(getUserId(user));
        Gson gson = new Gson();
        User idUser = new User(user.getId());
        return gson.toJson(idUser);
    }

    @Override
    public String login(String login, String password) {
        User user = jdbcTemplate.queryForObject("SELECT * from userauth.user_tab where login = ? and password = ?", BeanPropertyRowMapper.newInstance(User.class), login, password);
        Gson gson = new Gson();
        User idUser = new User(user.getId());
        return gson.toJson(idUser);
    }

    @Override
    public User findById(int id) {
        User user = jdbcTemplate.queryForObject("SELECT * from userauth.user_tab where id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
        return user;
    }


    @Override
    public Integer getUserId(User user) {
        String sql = String.format("SELECT id from userauth.user_tab where name = '%s' and login = '%s' and password = '%s' and phone = '%s' and birth_date = '%s'", user.getName(), user.getLogin(), user.getPassword(), user.getPhone(), user.getBirthDate(), user.getTg(), user.getEmail());
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
