package com.example.todo.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.todo.domain.ToDo;

public class ToDoRepository implements CommonRepository<ToDo> {
	private Map<String,ToDo> toDos = new HashMap<>();

	@Override
	public ToDo save(ToDo domain){
		// TODO Auto-generated method stub
		ToDo result = toDos.get(domain.getId());
		if(result != null) {
		result.setModified(LocalDateTime.now());
		result.setDescription(domain.getDescription());
		result.setCompleted(domain.isCompleted());
		domain = result;
		}
		toDos.put(domain.getId(), domain);
		return toDos.get(domain.getId());
	}

	@Override
	public Iterable<ToDo> save(Collection<ToDo> domains) {
		// TODO Auto-generated method stub
		domains.forEach(this::save);
		return findAll();
	}

	@Override
	public void delete(ToDo domain) {
		// TODO Auto-generated method stub
		toDos.remove(domain.getId());
		
	}

	@Override
	public ToDo findById(String id) {
		// TODO Auto-generated method stub
	   ToDo result = toDos.get(id);
	   return result;
	}

	@Override
	public Iterable<ToDo> findAll() {
		// TODO Auto-generated method stub
		return toDos.entrySet().stream().sorted(entryComparator).
				map(Map.Entry::getValue).collect(Collectors.toList());
	}
	private Comparator<Map.Entry<String,ToDo>> entryComparator = (Map.
			Entry<String, ToDo> o1, Map.Entry<String, ToDo> o2) -> {
			return o1.getValue().getCreated().compareTo(o2.getValue().
			getCreated());
	};
	


}
