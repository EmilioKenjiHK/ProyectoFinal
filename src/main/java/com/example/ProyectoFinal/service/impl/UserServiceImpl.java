package com.example.ProyectoFinal.service.impl;

import java.util.List;

import com.example.ProyectoFinal.model.UserTable;
import com.example.ProyectoFinal.repository.UserRepository;
import com.example.ProyectoFinal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    public static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Iterable<UserTable> getUsers() {
        return userRepository.findAll();
    }

	@Override
	public List<UserTable> checkUser(String u, String p) {

		String query=
        "SELECT * FROM USUARIO WHERE NOMBRE_USUARIO = '" + u + "' AND CONTRASENYA = '" + p + "'";

		List<UserTable> user = jdbcTemplate.query(
				query,
				(rs, rowNum) ->
						new UserTable(
                            rs.getString("NOMBRE_USUARIO"),
                            rs.getString("CONTRASENYA"),
                            rs.getString("CORREO"),
                            Boolean.parseBoolean(rs.getString("ADMIN"))
                        )
		);
		return user;
	}

    @Override
	public List<String> getPassword(String u) {

		String query=
        "SELECT CONTRASENYA FROM USUARIO WHERE NOMBRE_USUARIO = '" + u + "';";

		List<String> pass = jdbcTemplate.query(
				query,
				(rs, rowNum) ->
						rs.getString("CONTRASENYA")
		);
        logger.info(pass.toString());
		return pass;
	}

    @Override
    public void updateFeature(String header, String old_f , String new_f)
    {
        //jdbcTemplate.update("UPDATE USUARIO SET ? = ? WHERE ? = ?;", header,new_f,header,old_f); 
        jdbcTemplate.update("UPDATE USUARIO SET " + header + " = '" + new_f + "' WHERE " + header + " = '" + old_f + "';"); 
    }

}
