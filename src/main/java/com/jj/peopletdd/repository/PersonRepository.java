package com.jj.peopletdd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.peopletdd.model.Person;
import com.jj.peopletdd.repository.person.PersonRepositoryQuery;

public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryQuery {

	Optional<Person> findByCpf(String cpf);

}
