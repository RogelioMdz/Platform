package com.avy.platform.entity;


import com.avy.platform.converter.UsuarioRoleConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull(message = "Campo requerido")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}$", message = "Nombre de usuario incorrecto, favor de verificarlo.")
    @Column(name = "usuario", unique = true)
    private String usuario;
    @NotNull(message = "Campo requerido")
    @Pattern(regexp = "^^[A-Za-zÁÉÍÓÚñáéíóúÑ]{3,15}$", message = "Formato incorrecto, favor de verificarlo.")
    private String nombre;
    @NotNull(message = "Campo requerido")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚñáéíóúÑ]{3,15}$", message = "Formato incorrecto, favor de verificarlo.")
    private String apellido;
    @NotNull(message = "Campo requerido")
    @Pattern(regexp = "^[0-9]{8,10}$", message = "Formato numero de recuperacion incorrecto, favor de verificarlo.")
    private String celular;
    @NotNull(message = "Campo requerido")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Formato correo incorrecto, favor de verificarlo.")
    private String correo;
    @NotNull(message = "Campo requerido")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Formato password incorrecto, favor de verificarlo.")
    private String password;
    private Role role;

    @Column(name = "role", nullable = false)
    @Convert(converter = UsuarioRoleConverter.class)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static enum Role {
        SUPER_ADMIN(1, "Super Admistrados"),
        ADMIN(2, "Administrador"),
        USER(3, "Usuario"),
        MONITOR_QA(4, "Monitor QA");

        private final String label;
        private final int value;

        private Role(int value, String label) {
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
