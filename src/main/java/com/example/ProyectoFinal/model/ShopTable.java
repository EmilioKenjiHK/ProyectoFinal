package com.example.ProyectoFinal.model;

import java.math.BigDecimal;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("TIENDA")
public class ShopTable {
    private @Column("OBJETO_ID") Long t_id;
    private @Column("NOMBRE_OBJETO") String t_object;
    private @Column("PRECIO") BigDecimal t_price;
    private @Column("CANTIDAD") Long t_quantity;
    
}
