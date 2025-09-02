package com.happysat.whatsapp_clone.repository;

import com.happysat.whatsapp_clone.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    @Query("Select u FROM User u WHERE u.full_name LIKE %:name%")
    List<User> searchUsers(@Param("name") String name);
}
