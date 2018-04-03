package com.brasajava.repository;

import org.springframework.data.repository.CrudRepository;

import com.brasajava.bean.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
