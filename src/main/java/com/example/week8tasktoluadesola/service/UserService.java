package com.example.week8tasktoluadesola.service;

import com.example.week8tasktoluadesola.model.User;
import com.example.week8tasktoluadesola.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(User user);
    User logUserIn(String emailOrPassword, String password);
    User findByEmail(String email);

}
