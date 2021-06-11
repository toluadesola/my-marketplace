package com.toluAdesola.myMarketPlace.repository;

import com.toluAdesola.myMarketPlace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByEmail(String email);
}
