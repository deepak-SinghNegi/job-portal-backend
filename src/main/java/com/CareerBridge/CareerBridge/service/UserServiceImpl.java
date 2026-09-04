package com.CareerBridge.CareerBridge.service;

import com.CareerBridge.CareerBridge.dto.user.LoginRequest;
import com.CareerBridge.CareerBridge.dto.user.RegisterRequest;
import com.CareerBridge.CareerBridge.dto.user.UserResponse;
import com.CareerBridge.CareerBridge.entity.User;
import com.CareerBridge.CareerBridge.exception.InvalidEmailOrPasswordException;
import com.CareerBridge.CareerBridge.exception.UserAlreadyExistException;
import com.CareerBridge.CareerBridge.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse registerUser(RegisterRequest request) {
        // 1. Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistException("Email is already registered!");
        }

        // 2. Map DTO to User Entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Storing directly for now until BCrypt is wired up
        user.setAccountType(request.getAccountType());

        // 3. Save to database
        User savedUser = userRepository.save(user);

        // 4. Map saved entity back to UserResponse DTO
        return mapToResponse(savedUser);
    }

    @Override
    public UserResponse loginUser(LoginRequest request) {
        // 1. Verify user exists
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidEmailOrPasswordException("Invalid email or password"));

        // 2. Verify password
        if (!user.getPassword().equals(request.getPassword())) {
            throw new InvalidEmailOrPasswordException("Invalid email or password");
        }

        // 3. Return user profile
        return mapToResponse(user);
    }

    // Helper method for entity-to-DTO conversion
    private UserResponse mapToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAccountType(),
                user.getCreatedAt()
        );
    }
}