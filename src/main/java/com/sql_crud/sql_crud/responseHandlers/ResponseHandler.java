package com.sql_crud.sql_crud.responseHandlers;

import java.util.List;

import com.sql_crud.sql_crud.model.Person;

public class ResponseHandler {
    private boolean success;
    private List<Person> data;

    public ResponseHandler(boolean success, List<Person> data) {
        this.success = success;
        this.data = data;
    }

    public ResponseHandler(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Person> getData() {
        return data;
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

}
