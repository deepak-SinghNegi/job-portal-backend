package com.CareerBridge.CareerBridge.repository;

import com.CareerBridge.CareerBridge.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User , Long> {

    boolean existsByEmail(@NotBlank(message = "Email is required") @Email(message = "Please enter a valid email address") String email);

    Optional<User> findByEmail(@NotBlank(message = "Email is required") @Email(message = "Please enter a valid email address") String email);
}
