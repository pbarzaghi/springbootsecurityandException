package com.example.security.springbootSecurity.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {

    T save(T t);
    T update( T t);
    List<T> findAll();

    Optional<T> findById(ID id);
    void deleteAll();
    void deleteById(ID id);

}
