package com.example.models.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.models.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    @Override
    List<User> findAll();
    UserDetails findByUsername(String username);

    User findById(int id);
    void deleteById(int id);
}
