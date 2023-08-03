package com.avy.platform.DAO;

import com.avy.platform.entity.Acceso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoDAO extends JpaRepository<Acceso, Long> {
}
