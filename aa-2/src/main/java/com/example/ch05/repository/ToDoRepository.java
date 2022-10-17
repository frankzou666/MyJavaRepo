package com.example.ch05.repository;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.ch05.domain.ToDo;


@Component
public class ToDoRepository {
	private NamedParameterJdbcTemplate jdbcTemplate;
	private static final String SQL_QUERY_FIND_ALL = "select id,description, created, modified, completed from todo";
	public ToDoRepository(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Iterable<ToDo> findAll() {
		return this.jdbcTemplate.query(SQL_QUERY_FIND_ALL, toDoRowMapper);
		}
	private RowMapper<ToDo> toDoRowMapper = (ResultSet rs, int rowNum) -> {
		ToDo toDo = new ToDo();
		toDo.setId(rs.getString("id"));
		toDo.setDescription(rs.getString("description"));
		toDo.setModified(rs.getTimestamp("modified").toLocalDateTime());
		toDo.setCreated(rs.getTimestamp("created").toLocalDateTime());
		toDo.setCompleted(rs.getBoolean("completed"));
		return toDo;
		};

}
