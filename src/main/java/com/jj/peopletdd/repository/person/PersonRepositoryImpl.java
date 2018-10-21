package com.jj.peopletdd.repository.person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.StringUtils;

import com.jj.peopletdd.model.Person;
import com.jj.peopletdd.repository.filter.PersonFilter;

public class PersonRepositoryImpl implements PersonRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> filter(PersonFilter filter) {

		StringBuilder jpql = new StringBuilder("select p from Person p where 1=1 ");
		Map<String, Object> parameters = new HashMap<>();
		
		setParametersIfRequired(filter, jpql, parameters);
		
		Query query = manager.createQuery(jpql.toString(), Person.class);
		
		setParametersQuery(parameters, query);
		
		return query.getResultList();
	}

	private void setParametersQuery(Map<String, Object> parameters, Query query) {
		parameters.forEach((k, v) -> {
			query.setParameter(k, v);
		});
	}

	private void setParametersIfRequired(PersonFilter filter, StringBuilder jpql, Map<String, Object> parameters) {
		if(StringUtils.hasText(filter.getName())) {
			jpql.append("and p.name like :name ");
			parameters.put("name", "%" + filter.getName() + "%");
		}
		
		if(StringUtils.hasText(filter.getCpf())) {
			jpql.append("and p.cpf = :cpf");
			parameters.put("cpf", filter.getCpf());
		}
	}

}
