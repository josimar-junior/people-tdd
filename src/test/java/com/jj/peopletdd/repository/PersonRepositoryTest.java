package com.jj.peopletdd.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.jj.peopletdd.model.Person;

@Sql(value = "/inserts.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void mustSeekPersonByCPF() throws Exception {
		Optional<Person> personOptional = personRepository.findByCpf("123.456.789-12");
		
		assertThat(personOptional.isPresent()).isTrue();
		
		Person person = personOptional.get();
		assertThat(person.getId()).isEqualTo(1L);
		assertThat(person.getName()).isEqualTo("Josimar");
		assertThat(person.getEmail()).isEqualTo("josimar@gmail.com");
	}
}
