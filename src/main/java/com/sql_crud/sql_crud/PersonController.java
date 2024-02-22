package com.sql_crud.sql_crud;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sql_crud.sql_crud.model.Person;
import com.sql_crud.sql_crud.repo.PerssonRepo;
import com.sql_crud.sql_crud.responseHandlers.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SuppressWarnings("null")

@RestController
public class PersonController {

    @Autowired
    PerssonRepo repo;

    @PostMapping("/add")
    public ResponseHandler addPerson(@RequestBody Person person) {
        try {
            Person data = repo.save(person);
            List<Person> allUserList = new ArrayList<>();
            allUserList.add(data);
            ResponseHandler responseData = new ResponseHandler(true, allUserList);
            return responseData;
        } catch (Exception error) {
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }

    }

    @GetMapping("/all")
    public ResponseHandler getAllStudents() {
        try {
            List<Person> allUserList = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
            ResponseHandler responseData = new ResponseHandler(true, allUserList);
            return responseData;
        } catch (Exception error) {
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseHandler UpdateStudentById(@PathVariable Long id, @RequestBody Person entity) {
        try {
            entity.setId(id);
            Person data = repo.save(entity);
            List<Person> allUserList = new ArrayList<>();
            allUserList.add(data);
            ResponseHandler responseData = new ResponseHandler(true, allUserList);
            return responseData;
        } catch (Exception error) {
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }
    }

    @GetMapping("/student/{id}")
    public ResponseHandler getStudentById(@PathVariable Long id) {
        try {
            Person updatedUsr = repo.findById(id).orElse(null);
            List<Person> userList = new ArrayList<>();
            if (updatedUsr != null) {
                userList.add(updatedUsr);
            }
            ResponseHandler responseData = new ResponseHandler(true, userList);
            return responseData;
        } catch (Exception error) {
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseHandler deleteStudentById(@PathVariable Long id) {
        try {
            repo.deleteById(id);
            ResponseHandler responseData = new ResponseHandler(true);
            return responseData;
        } catch (Exception error) {
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }
    }

}
