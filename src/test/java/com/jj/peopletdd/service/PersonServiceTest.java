package com.jj.peopletdd.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.peopletdd.model.Person;
import com.jj.peopletdd.repository.PersonRepository;
import com.jj.peopletdd.service.exception.ExistingCPFException;
import com.jj.peopletdd.service.exception.PersonNotFoundException;
import com.jj.peopletdd.service.impl.PersonServiceImpl;

@RunWith(SpringRunner.class)
public class PersonServiceTest {
	
	private static final String NAME = "Josimar Junior";
	private static final String CPF = "111.222.333-44";
	private static final String EMAIL = "josimar@gmail.com";

	@MockBean
	private PersonRepository personRepository;
	
	private PersonService personService;
	
	private Person person;
	
	@Before
	public void setUp() {
		personService = new PersonServiceImpl(personRepository);
		person = new Person(NAME, CPF, EMAIL);
		when(personRepository.findByCpf(CPF)).thenReturn(Optional.empty());
	}
	
	@Test
	public void shouldSavePerson() throws Exception {
		personService.save(person);
		
		verify(personRepository).save(person);
	}
	
	@Test(expected = ExistingCPFException.class)
	public void mustThrowExceptionWhenSavingPeopleWithTheSameCPF() throws Exception {
		when(personRepository.findByCpf(CPF)).thenReturn(Optional.of(person));
		
		personService.save(person);
	}
	
	@Test(expected = PersonNotFoundException.class)
	public void mustThrowPersonNotFoundException() throws Exception {
		personService.findById(1L);
	}
}
