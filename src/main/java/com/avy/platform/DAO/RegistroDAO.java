package com.avy.platform.DAO;

import com.avy.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroDAO extends JpaRepository<User, Long> {
}
