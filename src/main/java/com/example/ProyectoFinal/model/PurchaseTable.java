package com.example.ProyectoFinal.model;


import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("COMPRA")
public class PurchaseTable {
    private @Column("COMPRA_ID") Long pur_id;
    private @Column("NOMBRE_USUARIO") String pur_username;
    private @Column("NOMBRE_OBJETO") String pur_object;
    
}

