package com.anz.jobapplication.paymentplatform.service;

import com.anz.jobapplication.paymentplatform.domain.User;
import com.anz.jobapplication.paymentplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findById(Long id) {
        return  userRepository.findById(id);
    }
}
