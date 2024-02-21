package com.fredd.users_api.domain.port;

import com.fredd.users_api.domain.model.User;

import java.util.List;

public interface UserPersistantePort {

    User create(User user);
    User getById(Long id);
    List<User> getAll();
    void deleteById(Long id);
    User update(User user);
}
