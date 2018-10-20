package com.jj.peopletdd.service;

import com.jj.peopletdd.model.Person;
import com.jj.peopletdd.service.exception.ExistingCPFException;
import com.jj.peopletdd.service.exception.PersonNotFoundException;

public interface PersonService {

	Person save(Person person) throws ExistingCPFException;
	Person findById(Long id) throws PersonNotFoundException;
}
