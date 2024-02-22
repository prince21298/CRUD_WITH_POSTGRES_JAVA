package com.sql_crud.sql_crud;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sql_crud.sql_crud.model.Person;
import com.sql_crud.sql_crud.model.ResponseHandler;
import com.sql_crud.sql_crud.repo.PerssonRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PersonController {

    @Autowired
    PerssonRepo repo;

    @PostMapping("/add")
    public ResponseHandler addPerson(@RequestBody Person person) {
        try{
            repo.save(person);
            List<Person> allUserList = repo.findAll();
            ResponseHandler responseData = new ResponseHandler(true, allUserList);
            return responseData;
        }
        catch(Exception error){
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }
       
    }

    @GetMapping("/all")
    public ResponseHandler getMethodName() {
        try {
            List<Person> allUserList = repo.findAll();
            ResponseHandler responseData = new ResponseHandler(true, allUserList);
            return responseData;
        } catch (Exception error) {
            ResponseHandler responseData = new ResponseHandler(false);
            return responseData;
        }
    }

}
