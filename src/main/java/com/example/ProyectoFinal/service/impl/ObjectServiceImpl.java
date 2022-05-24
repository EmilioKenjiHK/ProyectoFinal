package com.example.ProyectoFinal.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.example.ProyectoFinal.model.ObjectDescTable;
import com.example.ProyectoFinal.model.ObjectTable;
import com.example.ProyectoFinal.repository.ObjectRepository;
import com.example.ProyectoFinal.service.ObjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ObjectRepository objectRepository;


    @Override
    public Iterable<ObjectTable> getObjects() {
        return objectRepository.findAll();
    }

    // inner-join
	@Override
	public List<ObjectDescTable> getObjectDesc() {

		String query=
        "SELECT OBJETO.NOMBRE_OBJETO, OBJETO.DESCRIPCION, TIENDA.PRECIO , TIENDA.CANTIDAD FROM OBJETO INNER JOIN TIENDA ON OBJETO.NOMBRE_OBJETO=TIENDA.NOMBRE_OBJETO;";

		List<ObjectDescTable> infoList = jdbcTemplate.query(
				query,
				(rs, rowNum) ->
						new ObjectDescTable(
                            rs.getString("NOMBRE_OBJETO"),
                            rs.getString("DESCRIPCION"),
                            BigDecimal.valueOf(Double.valueOf(rs.getString("PRECIO"))),
                            Long.parseLong(rs.getString("CANTIDAD"))
                        )
		);
		return infoList;
	}

}
