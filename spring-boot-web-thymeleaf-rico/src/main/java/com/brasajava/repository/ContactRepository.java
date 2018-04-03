package com.brasajava.repository;

import org.springframework.data.repository.CrudRepository;

import com.brasajava.bean.Contact;

public interface ContactRepository extends CrudRepository<Contact,Long>{

}
