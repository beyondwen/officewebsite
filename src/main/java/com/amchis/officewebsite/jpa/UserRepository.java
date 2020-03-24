package com.amchis.officewebsite.jpa;

import com.amchis.officewebsite.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username,String password);

    User findByUsername(String username);
}