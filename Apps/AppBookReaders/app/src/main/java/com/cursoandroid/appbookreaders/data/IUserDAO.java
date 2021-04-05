package com.cursoandroid.appbookreaders.data;

import com.cursoandroid.appbookreaders.model.User;

import java.util.List;

public interface IUserDAO {
    public boolean save(User user);
    public boolean update(User user);
    public boolean delete(User user);
    public List<User> listUser();
}
