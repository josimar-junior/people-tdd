package com.jj.peopletdd.repository.person;

import java.util.List;

import com.jj.peopletdd.model.Person;
import com.jj.peopletdd.repository.filter.PersonFilter;

public interface PersonRepositoryQuery {
	
	List<Person> filter(PersonFilter filter);
}
