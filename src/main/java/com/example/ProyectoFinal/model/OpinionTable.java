package com.example.ProyectoFinal.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("OPINION")
public class OpinionTable {
    private @Column("OPINION_ID") Long op_id;
    private @Column("TEXTO") String op_text;
}

