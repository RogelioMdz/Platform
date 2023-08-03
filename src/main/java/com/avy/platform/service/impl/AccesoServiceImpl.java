package com.avy.platform.service.impl;

import com.avy.platform.DAO.AccesoDAO;
import com.avy.platform.entity.Acceso;
import com.avy.platform.service.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccesoServiceImpl implements AccesoService {
    @Autowired
    private AccesoDAO accesoDAO;
    @Override
    public Acceso registroIdStatusCuenta(Acceso acceso) {
        return accesoDAO.save(acceso);
    }
}
