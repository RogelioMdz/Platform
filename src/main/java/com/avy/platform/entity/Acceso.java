package com.avy.platform.entity;


import com.avy.platform.converter.StatusCuentaConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acceso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Date ultimoLogin;
    private Date intent1;
    private Date intento2;
    private Date intento3;
    private Estatus statusCuenta;
    private UUID usuario_id;

    @Column(name = "status_cuenta", nullable = false)
    @Convert(converter = StatusCuentaConverter.class)
    public Estatus getStatusCuenta() {
        return statusCuenta;
    }

    public void setStatusCuenta(Estatus statusCuenta) {
        this.statusCuenta = statusCuenta;
    }

    public static enum Estatus {
        HABILITADA(0, "Habilitada"),
        DESACTIVADA(1, "Desactivada"),
        BLOQUEADA(2, "Bloqueada");

        private final String label;
        private final int value;

        private Estatus(int value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public int getValue() {
            return value;
        }
    }
}
