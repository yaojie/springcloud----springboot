package com.southwind.repository;

import com.southwind.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserRepository {
    public List<User> findAll(int index, int limit);

    public User findById(long id);

    public int count();

    public void save(User user);

    public void deleteById(long id);

    public void update(User user);
}
