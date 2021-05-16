package com.example.week8tasktoluadesola.serviceImplementation;

import com.example.week8tasktoluadesola.model.User;
import com.example.week8tasktoluadesola.repository.UserRepository;
import com.example.week8tasktoluadesola.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User logUserIn(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void setUserSession(User authUser, HttpServletRequest request){
//        request.getSession().invalidate();
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(7000);
        session.setAttribute("user_session", authUser);
        session.setAttribute("name", authUser.getName());
    }
}
