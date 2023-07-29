package com.avy.platform.entity;


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
    private UUID id;
    private Date ultimoLogin;
    private Date intent1;
    private Date intento2;
    private Date intento3;
    private boolean cuantaHabilitada;
    private boolean cuentaBloqueada;
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
