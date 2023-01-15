package com.hoaxify.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users, Long> {
}
