package com.toluAdesola.myMarketPlace.service;

import com.toluAdesola.myMarketPlace.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(User user);
    User logUserIn(String emailOrPassword, String password);
    User findByEmail(String email);

}
