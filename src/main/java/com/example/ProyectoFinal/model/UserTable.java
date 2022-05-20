package com.example.ProyectoFinal.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("USUARIO")
public class UserTable {
    private @Column("NOMBRE_USUARIO") String u_username;
    private @Column("CONTRASENYA") String u_password;
    private @Column("CORREO") String u_email;
    private @Column("ADMIN") Boolean u_admin;
    
}
