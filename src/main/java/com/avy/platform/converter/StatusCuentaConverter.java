package com.avy.platform.converter;

import com.avy.platform.entity.Acceso.Estatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class StatusCuentaConverter implements AttributeConverter<Estatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Estatus estatus) {
        return estatus.getValue();
    }

    @Override
    public Estatus convertToEntityAttribute(Integer integer) {
        switch (integer){
            case 1:
                return Estatus.HABILITADA;
            case 2:
                return Estatus.DESACTIVADA;
            case 3:
                return Estatus.BLOQUEADA;
            default:
                throw new IllegalArgumentException("Estatus de cuenta desconocido.");
        }
    }
}
