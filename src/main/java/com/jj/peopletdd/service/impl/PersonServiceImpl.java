package com.jj.peopletdd.service.impl;

import java.util.Optional;

import com.jj.peopletdd.model.Person;
import com.jj.peopletdd.repository.PersonRepository;
import com.jj.peopletdd.service.PersonService;
import com.jj.peopletdd.service.exception.ExistingCPFException;
import com.jj.peopletdd.service.exception.PersonNotFoundException;

public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person save(Person person) throws ExistingCPFException {
		
		Optional<Person> personOption = findByCpf(person.getCpf());
		
		if(personOption.isPresent()) {
			throw new ExistingCPFException("Existing CPF");
		}
		
		return personRepository.save(person);
	}

	@Override
	public Person findById(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person not found"));
	}
	
	public Optional<Person> findByCpf(String cpf) {
		return personRepository.findByCpf(cpf);
	}

}
