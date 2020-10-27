package com.anz.jobapplication.paymentplatform.repository;

import com.anz.jobapplication.paymentplatform.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
