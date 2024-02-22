package com.sql_crud.sql_crud.repo;

import com.sql_crud.sql_crud.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface PerssonRepo extends JpaRepository<Person,Long> {

}
