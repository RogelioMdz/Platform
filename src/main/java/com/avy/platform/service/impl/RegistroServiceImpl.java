package com.avy.platform.service.impl;

import com.avy.platform.DAO.RegistroDAO;
import com.avy.platform.entity.User;
import com.avy.platform.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private RegistroDAO registroDAO;

    @Override
    public User registro(User user) {
        return registroDAO.save(user);
    }
}
