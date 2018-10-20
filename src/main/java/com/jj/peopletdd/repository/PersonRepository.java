package com.jj.peopletdd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.peopletdd.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByCpf(String cpf);

}
