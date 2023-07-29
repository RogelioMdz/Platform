package com.avy.platform.converter;

import com.avy.platform.entity.User.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class UsuarioRoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role role) {
        return role.getValue();
    }

    @Override
    public Role convertToEntityAttribute(Integer role) {
        switch (role) {
            case 1:
                return Role.SUPER_ADMIN;
            case 2:
                return Role.ADMIN;
            case 3:
                return Role.USER;
            case 4:
                return Role.MONITOR_QA;
            default:
                throw new IllegalArgumentException("Role de usuario no soportado.");

        }
    }
}
