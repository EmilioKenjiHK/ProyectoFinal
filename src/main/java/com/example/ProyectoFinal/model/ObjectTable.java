package com.example.ProyectoFinal.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("OBJETO")
public class ObjectTable {
    private @Column("NOMBRE_OBJETO") String obj_name;
    private @Column("DESCRIPCION") String obj_desc;

    public String getObjName() {
        return obj_name;
    }

    public String getObjDesc() {
        return obj_desc;
    }
    
}

