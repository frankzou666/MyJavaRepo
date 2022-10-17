package com.aa.repository;

import com.aa.domain.ToDo;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository implements CommonRepository<ToDo> {

    
    private final NamedParameterJdbcTemplate jdbcTemplate;
    
    private static final String SQL_INSERT = "insert into todo (id, description, created, modified, completed) values (:id,:description, :created,:modified,:completed)";
    public ToDoRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public ToDo save(final ToDo toDo) {
    	
    	/*
    	 *  in memory
        ToDo result = toDos.get(domain.getId());
        if(result != null) {
            result.setModified(LocalDateTime.now());
            result.setDescription(domain.getDescription());
            result.setCompleted(domain.isCompleted());
            domain = result;
        }
        toDos.put(domain.getId(), domain);
        return toDos.get(domain.getId());
        
        */
    	
    	Map<String, Object> namedParameters = new HashMap<>();
    	namedParameters.put("id", System.currentTimeMillis()/1000);
    	namedParameters.put("description",toDo.getDescription());
    	namedParameters.put("created",java.sql.Timestamp.valueOf(toDo.
    	getCreated()));
    	namedParameters.put("modified",java.sql.Timestamp.valueOf(toDo.
    	getModified()));
    	namedParameters.put("completed",toDo.isCompleted());
    	this.jdbcTemplate.update(SQL_INSERT,namedParameters);
    	return toDo;

    }

	@Override
	public Iterable<ToDo> save(Collection<ToDo> domains) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ToDo domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ToDo findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ToDo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
     /*
    @Override
    public Iterable<ToDo> save(Collection<ToDo> domains) {
        domains.forEach(this::save);
        return findAll();
    }

    @Override
    public void delete(ToDo domain) {
        toDos.remove(domain.getId());
    }

    @Override
    public ToDo findById(String id) {
        return toDos.get(id);
    }

    @Override
    public Iterable<ToDo> findAll() {
        return toDos.entrySet().stream().sorted(entryComparator).map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private Comparator<Map.Entry<String,ToDo>> entryComparator = (Map.Entry<String, ToDo> o1, Map.Entry<String, ToDo> o2) -> {
        return o1.getValue().getCreated().compareTo(o2.getValue().getCreated());
    };
    */
}